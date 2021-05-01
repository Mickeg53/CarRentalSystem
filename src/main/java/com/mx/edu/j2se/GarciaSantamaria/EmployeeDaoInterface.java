package com.mx.edu.j2se.GarciaSantamaria;

public interface EmployeeDaoInterface {
    public EmployeePOJO getEmployee(int employeeId);
    void save(EmployeePOJO employeePOJO);
    void delete(EmployeePOJO employeePOJO);
    void update(EmployeePOJO employeePOJO);
}
