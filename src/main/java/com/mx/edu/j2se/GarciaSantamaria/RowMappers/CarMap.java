package com.mx.edu.j2se.GarciaSantamaria.RowMappers;

import com.mx.edu.j2se.GarciaSantamaria.Objects.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMap implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Car car = new Car();

        car.setLicensePlate(resultSet.getString("License_plate"));
        car.setBrand(resultSet.getString("Brand"));
        car.setSubBrand(resultSet.getString("Sub_brand"));
        car.setClass(resultSet.getString("Class"));
        car.setYearModel(resultSet.getInt("Year_model"));
        car.setPrice(resultSet.getDouble("Price"));

        return car;
    }
}
