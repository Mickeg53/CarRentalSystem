package com.mx.edu.j2se.GarciaSantamaria.Implementations;

import com.mx.edu.j2se.GarciaSantamaria.Interfaces.EmployeeDaoInterface;
import com.mx.edu.j2se.GarciaSantamaria.Mappers.ClientRowMapper;
import com.mx.edu.j2se.GarciaSantamaria.Mappers.EmployeeRowMapper;
import com.mx.edu.j2se.GarciaSantamaria.POJOs.EmployeePOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("EmployeeDao")
public class EmployeeDaoImpl implements EmployeeDaoInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public EmployeePOJO getEmployee(int employeeId) {
        String sql = "SELECT * FROM employee WHERE Id_employee = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {employeeId}, new EmployeeRowMapper());
    }

    @Override
    public boolean save(EmployeePOJO employeePOJO) {
        String sql = "INSERT INTO employee (Name, Last_name, Mothers_last_name, Phone_Number, Email, Id_address) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, employeePOJO.getName(), employeePOJO.getLastName(), employeePOJO.getMothersLastName(), employeePOJO.getPhoneNumber(), employeePOJO.getEmail(), employeePOJO.getId_address());
        return true;
    }

    @Override
    public boolean delete(EmployeePOJO employeePOJO) {
        String sql = "DELETE FROM employee WHERE Id_employee=?";
        jdbcTemplate.update(sql, employeePOJO.getId_employee());
        return true;
    }

    @Override
    public boolean update(EmployeePOJO employeePOJO) {
        String sql = "UPDATE employee SET Phone_number=?, Email=?, Id_address=? WHERE Id_employee=?";
        jdbcTemplate.update(sql, employeePOJO.getPhoneNumber(), employeePOJO.getEmail(), employeePOJO.getId_address(), employeePOJO.getId_employee());
        return true;
    }
}
