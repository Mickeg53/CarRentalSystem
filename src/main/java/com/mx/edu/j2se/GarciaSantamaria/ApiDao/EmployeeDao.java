package com.mx.edu.j2se.GarciaSantamaria.ApiDao;

import com.mx.edu.j2se.GarciaSantamaria.Objects.Employee;

public interface EmployeeDao {
    Employee getEmployee(int employeeId);
    void save(Employee employeePOJO);
    void delete(int employeeId);
    void update(Employee employeePOJO);
}
