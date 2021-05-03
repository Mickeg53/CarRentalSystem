package com.mx.edu.j2se.GarciaSantamaria.Mappers;

import com.mx.edu.j2se.GarciaSantamaria.POJOs.CarPOJO;
import com.mx.edu.j2se.GarciaSantamaria.POJOs.EmployeePOJO;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<EmployeePOJO> {
    @Override
    public EmployeePOJO mapRow(ResultSet resultSet, int i) throws SQLException {
        EmployeePOJO employeePOJO = new EmployeePOJO();

        employeePOJO.setId_employee(resultSet.getInt("Id_employee"));
        employeePOJO.setName(resultSet.getString("Name"));
        employeePOJO.setMothersLastName(resultSet.getString("Mothers_last_name"));
        employeePOJO.setLastName(resultSet.getString("Last_name"));
        employeePOJO.setPhoneNumber(resultSet.getBigDecimal("Phone_number"));
        employeePOJO.setEmail(resultSet.getString("Email"));
        employeePOJO.setId_address(resultSet.getInt("Id_address"));

        return employeePOJO;
    }
}
