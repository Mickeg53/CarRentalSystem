package com.mx.edu.j2se.GarciaSantamaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.List;


@Component
public class CarDaoImpl implements CarDaoInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CarPOJO> getAllCarsAvailable(LocalDateTime start_date, LocalDateTime return_date, String classs) {

        String sql = "SELECT * FROM car c LEFT JOIN reservation r USING(License_plate) WHERE (Id_reservation IS NULL OR (r.Start_date > '"+start_date+"' OR r.Return_date < '"+return_date+"'))AND c.Class = '"+classs+"'";
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

