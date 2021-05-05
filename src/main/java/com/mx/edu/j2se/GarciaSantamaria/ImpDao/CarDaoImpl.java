package com.mx.edu.j2se.GarciaSantamaria.ImpDao;

import com.mx.edu.j2se.GarciaSantamaria.ApiDao.CarDao;
import com.mx.edu.j2se.GarciaSantamaria.RowMappers.CarMap;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.google.common.base.Joiner;


import java.time.LocalDateTime;
import java.util.List;
import java.util.StringJoiner;


@Repository("CarDao")
public class CarDaoImpl implements CarDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Car> getAllCarsAvailable(LocalDateTime ffrom, LocalDateTime tto, String Class) {

        String sql = "";
        //Conditional to return all available cars or available cars of a specific class
        if(Class == null || Class.equals("")){
            sql = String.format("SELECT c.Brand, c.Sub_brand, c.Class, c.Year_model, c.License_plate, c.Price FROM car c LEFT JOIN reservation r USING(License_plate) WHERE (Id_reservation IS NULL OR (r.Start_date > %s OR r.Return_date < %s))", tto, ffrom);
        }else{
            sql = String.format("SELECT c.Brand, c.Sub_brand, c.Class, c.Year_model, c.License_plate, c.Price FROM car c LEFT JOIN reservation r USING(License_plate) WHERE (Id_reservation IS NULL OR (r.Start_date > %s OR r.Return_date < %s))AND c.Class = %s", tto, ffrom, Class);
        }
        return jdbcTemplate.query(sql, new CarMap());
    }

    @Override
    public void save(Car car) {
        String sql = Joiner.on(',').join("INSERT INTO car (License_plate, Brand, Sub_brand, Class, Year_model, Price) VALUES (",
                car.getLicense_plate(),",", car.getBrand(), ",", car.getSub_brand(), ",",
                car.getClasss(), ",",car.getYear_model(), ",", car.getPrice(),")");

        jdbcTemplate.update(sql);
    }

    @Override
    public void delete(int carLicensePlate) {
        String sql = String.format("DELETE FROM car WHERE License_plate = %s", carLicensePlate);
        jdbcTemplate.update(sql);
    }

    @Override
    public void update(Car car) {
        String sql = String.format("UPDATE car SET License_plate=%s, Price=%f WHERE License_plate=%s", car.getLicense_plate(), car.getPrice(), car.getLicense_plate());
        jdbcTemplate.update(sql);
    }
}

