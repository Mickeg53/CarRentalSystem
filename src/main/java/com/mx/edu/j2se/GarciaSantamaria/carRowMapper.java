package com.mx.edu.j2se.GarciaSantamaria;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class carRowMapper implements RowMapper<CarPOJO> {
    @Override
    public CarPOJO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        CarPOJO carPOJO = new CarPOJO();

        carPOJO.setLicense_plate(resultSet.getString("License_plate"));
        carPOJO.setBrand(resultSet.getString("Brand"));
        carPOJO.setSub_brand(resultSet.getString("Sub_brand"));
        carPOJO.setClass(resultSet.getString("Class"));
        carPOJO.setYear_model(resultSet.getInt("Year_model"));
        carPOJO.setPrice(resultSet.getDouble("Price"));

        return carPOJO;
    }
}
