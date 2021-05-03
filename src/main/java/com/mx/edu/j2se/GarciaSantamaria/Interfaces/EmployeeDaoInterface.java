package com.mx.edu.j2se.GarciaSantamaria.Interfaces;

import com.mx.edu.j2se.GarciaSantamaria.POJOs.EmployeePOJO;

public interface EmployeeDaoInterface {
    public EmployeePOJO getEmployee(int employeeId);
    boolean save(EmployeePOJO employeePOJO);
    boolean delete(EmployeePOJO employeePOJO);
    boolean update(EmployeePOJO employeePOJO);
}
