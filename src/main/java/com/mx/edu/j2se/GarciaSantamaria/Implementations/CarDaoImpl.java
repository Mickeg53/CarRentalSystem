package com.mx.edu.j2se.GarciaSantamaria.Implementations;

import com.mx.edu.j2se.GarciaSantamaria.Interfaces.CarDaoInterface;
import com.mx.edu.j2se.GarciaSantamaria.Mappers.carRowMapper;
import com.mx.edu.j2se.GarciaSantamaria.POJOs.CarPOJO;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;


@Repository("CarDao")
public class CarDaoImpl implements CarDaoInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CarPOJO> getAllCarsAvailable(LocalDateTime ffrom, LocalDateTime tto, String classs) {
        /*LocalDateTime ffrom = LocalDateTime.parse("2021-04-22T13:00:00");
        LocalDateTime tto = LocalDateTime.parse("2021-04-23T13:00:00");
        String classs = "";*/

        String sql = "";
        //Conditional to return all available cars or available cars of a specific class
        if(classs == null || classs == ""){
            sql = "SELECT c.Brand, c.Sub_brand, c.Class, c.Year_model, c.License_plate, c.Price FROM car c LEFT JOIN reservation r USING(License_plate) WHERE (Id_reservation IS NULL OR (r.Start_date > '"+tto+"' OR r.Return_date < '"+ffrom+"'))";
        }else{
            sql = "SELECT c.Brand, c.Sub_brand, c.Class, c.Year_model, c.License_plate, c.Price FROM car c LEFT JOIN reservation r USING(License_plate) WHERE (Id_reservation IS NULL OR (r.Start_date > '"+tto+"' OR r.Return_date < '"+ffrom+"'))AND c.Class = '"+classs+"'";
        }
        return jdbcTemplate.query(sql, new carRowMapper());
    }

    @Override
    public boolean save(CarPOJO carPOJO) {
        String sql = "INSERT INTO car (License_plate, Brand, Sub_brand, Class, Year_model, Price) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, carPOJO.getLicense_plate(), carPOJO.getBrand(), carPOJO.getSub_brand(), carPOJO.getClasss(), carPOJO.getYear_model(), carPOJO.getPrice());
        return true;
    }

    @Override
    public boolean delete(CarPOJO carPOJO) {
        String sql = "DELETE FROM car WHERE License_plate=?";
        jdbcTemplate.update(sql, carPOJO.getLicense_plate());
        return true;
    }

    @Override
    public boolean update(CarPOJO carPOJO) {
        String sql = "UPDATE car SET License_plate=?, Price=? WHERE License_plate=?";
        jdbcTemplate.update(sql, carPOJO.getLicense_plate(), carPOJO.getPrice(), carPOJO.getLicense_plate());
        return true;
    }
}

