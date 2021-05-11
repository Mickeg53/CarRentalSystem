package com.mx.edu.j2se.GarciaSantamaria.ImpDao;

import com.mx.edu.j2se.GarciaSantamaria.ApiDao.CarDao;
import com.mx.edu.j2se.GarciaSantamaria.RowMappers.AddressMap;
import com.mx.edu.j2se.GarciaSantamaria.RowMappers.CarMap;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Car;
import com.mx.edu.j2se.GarciaSantamaria.RowMappers.ClientMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.google.common.base.Joiner;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Repository("CarDao")
public class CarDaoImpl implements CarDao {
    private static final Logger logger = LoggerFactory.getLogger(CarDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Car getCar(String licensePlate){
        String sql = String.format("SELECT * FROM car WHERE License_plate = '%s'", licensePlate);

        try{
            return jdbcTemplate.queryForObject(sql, new Object[] {}, new CarMap());
        }catch(Exception e){
            logger.info("THERE ARE NO EXISTING CAR FOR THE LICENSE PLATE ENTERED, HANDLING EXCEPTION IN CarDaoImpl(getCar)");
        }
        return null;
    }

    @Override
    public List<Car> getAllCarsAvailable(LocalDateTime ffrom, LocalDateTime tto, String carClass) {

        String sql = "";
        List<Car> carsAvailable;

        //Conditional to return all available cars or available cars of a specific class
        if(carClass == null || carClass.equals("....")){
            sql = String.format("SELECT c.Brand, c.Sub_brand, c.Class, c.Year_model, c.License_plate, c.Price FROM car c LEFT JOIN reservation r USING(License_plate) WHERE (Id_reservation IS NULL OR (r.Start_date > '%s' OR r.Return_date < '%s'))", tto, ffrom);
        }else{
            sql = String.format("SELECT c.Brand, c.Sub_brand, c.Class, c.Year_model, c.License_plate, c.Price FROM car c LEFT JOIN reservation r USING(License_plate) WHERE (Id_reservation IS NULL OR (r.Start_date > '%s' OR r.Return_date < '%s'))AND c.Class = '%s'", tto, ffrom, carClass);
        }

        try{
            carsAvailable = jdbcTemplate.query(sql, new CarMap());
        }catch(Exception e){
            logger.info("THERE WAS AN ERROR DURING THE CONSULT OF CARS, HANDLING EXCEPTION IN CarDaoImpl(getAllCarsAvailable)");
            return null;
        }

        Duration duration = Duration.between(ffrom, tto);
        long diffHours = Math.abs(duration.toHours());
        long diffDays = Math.abs(duration.toDays());
        double completeDays = diffHours/24.00;

        for(Car x : carsAvailable){
            if(completeDays - diffDays > 0){
                x.setOverallPrice((diffDays+1)*(x.getPrice()));
            }else{
                x.setOverallPrice(diffDays*(x.getPrice()));
            }
        }
        return carsAvailable;
    }

    @Override
    public void save(Car car) {
        String sql = Joiner.on(',').join("INSERT INTO car (License_plate, Brand, Sub_brand, Class, Year_model, Price) VALUES (",
                car.getLicensePlate(),",", car.getBrand(), ",", car.getSubBrand(), ",",
                car.getClassOfCar(), ",",car.getYearModel(), ",", car.getPrice(),")");
        try{
            jdbcTemplate.update(sql);
        }catch (Exception e){
            logger.info("THERE WAS AN ERROR DURING THE SAVE OF CAR, HANDLING EXCEPTION IN CarDaoImpl(save)");
        }
    }

    @Override
    public void delete(int carLicensePlate) {
        String sql = String.format("DELETE FROM car WHERE License_plate = '%s'", carLicensePlate);
        try{
            jdbcTemplate.update(sql);
        }catch (Exception e){
            logger.info("THERE WAS AN ERROR DURING THE DELETE OF CAR, HANDLING EXCEPTION IN CarDaoImpl(delete)");
        }
    }

    @Override
    public void update(Car car) {
        String sql = String.format("UPDATE car SET License_plate='%s', Price=%f WHERE License_plate='%s'", car.getLicensePlate(), car.getPrice(), car.getLicensePlate());
        try{
            jdbcTemplate.update(sql);
        }catch (Exception e){
            logger.info("THERE WAS AN ERROR DURING THE UPDATE OF CAR, HANDLING EXCEPTION IN CarDaoImpl(update)");
        }
    }
}

