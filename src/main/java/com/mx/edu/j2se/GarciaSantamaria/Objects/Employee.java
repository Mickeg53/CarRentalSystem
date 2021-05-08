package com.mx.edu.j2se.GarciaSantamaria.Objects;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {
    private int idEmployee;
    private String name;
    private String mothersLastName;
    private String lastName;
    private BigDecimal phoneNumber;
    private String email;
    private int idAddress;

    public Employee(String name, String mothersLastName, String lastName, BigDecimal phoneNumber, String email, int idAddress) {
        this.name = name;
        this.mothersLastName = mothersLastName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idAddress = idAddress;
    }

    public Employee() {

    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMothersLastName() {
        return mothersLastName;
    }

    public void setMothersLastName(String mothersLastName) {
        this.mothersLastName = mothersLastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(BigDecimal phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + idEmployee +
                ", name='" + name + '\'' +
                ", mothersLastName='" + mothersLastName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", idAddress=" + idAddress +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getIdEmployee() == employee.getIdEmployee() && getIdAddress() == employee.getIdAddress() && getName().equals(employee.getName()) && getMothersLastName().equals(employee.getMothersLastName()) && getLastName().equals(employee.getLastName()) && getPhoneNumber().equals(employee.getPhoneNumber()) && getEmail().equals(employee.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdEmployee(), getName(), getMothersLastName(), getLastName(), getPhoneNumber(), getEmail(), getIdAddress());
    }
}
