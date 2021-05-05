package com.mx.edu.j2se.GarciaSantamaria.Objects;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {
    private int Id_employee;
    private String Name;
    private String MothersLastName;
    private String LastName;
    private BigDecimal PhoneNumber;
    private String Email;
    private int Id_address;

    public Employee(int id_employee, String name, String mothersLastName, String lastName, BigDecimal phoneNumber, String email, int id_address) {
        this.Id_employee = id_employee;
        this.Name = name;
        this.MothersLastName = mothersLastName;
        this.LastName = lastName;
        this.PhoneNumber = phoneNumber;
        this.Email = email;
        this.Id_address = id_address;
    }

    public Employee() {

    }

    public int getId_employee() {
        return Id_employee;
    }

    public void setId_employee(int id_employee) {
        Id_employee = id_employee;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMothersLastName() {
        return MothersLastName;
    }

    public void setMothersLastName(String mothersLastName) {
        MothersLastName = mothersLastName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public BigDecimal getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(BigDecimal phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getId_address() {
        return Id_address;
    }

    public void setId_address(int id_address) {
        Id_address = id_address;
    }

    @Override
    public String toString() {
        return "EmployeePOJO{" +
                "Id_employee=" + Id_employee +
                ", Name='" + Name + '\'' +
                ", MothersLastName='" + MothersLastName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                ", Email='" + Email + '\'' +
                ", Id_address=" + Id_address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId_employee() == employee.getId_employee() && getId_address() == employee.getId_address() && getName().equals(employee.getName()) && Objects.equals(getMothersLastName(), employee.getMothersLastName()) && getLastName().equals(employee.getLastName()) && getPhoneNumber().equals(employee.getPhoneNumber()) && getEmail().equals(employee.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_employee(), getName(), getMothersLastName(), getLastName(), getPhoneNumber(), getEmail(), getId_address());
    }
}
