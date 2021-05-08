package com.mx.edu.j2se.GarciaSantamaria.RowMappers;

import com.mx.edu.j2se.GarciaSantamaria.Objects.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMap implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employeePOJO = new Employee();

        employeePOJO.setIdEmployee(resultSet.getInt("Id_employee"));
        employeePOJO.setName(resultSet.getString("Name"));
        employeePOJO.setMothersLastName(resultSet.getString("Mothers_last_name"));
        employeePOJO.setLastName(resultSet.getString("Last_name"));
        employeePOJO.setPhoneNumber(resultSet.getBigDecimal("Phone_number"));
        employeePOJO.setEmail(resultSet.getString("Email"));
        employeePOJO.setIdAddress(resultSet.getInt("Id_address"));

        return employeePOJO;
    }
}
