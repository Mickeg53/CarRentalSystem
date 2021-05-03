package com.mx.edu.j2se.GarciaSantamaria.POJOs;

import java.time.LocalDateTime;

public class ReservationPOJO {
    private int Id_reservation;
    private LocalDateTime Start_date;
    private LocalDateTime Return_date;
    private String License_plate;
    private int Id_employee;
    private int Id_client;

    private String Brand;
    private String Classs;
    private int Year_model;
    private double Price;

    ReservationPOJO(int id_reservation, LocalDateTime start_date, LocalDateTime return_date, String license_plate, int id_employee, int id_client, String brand, String classs, int year_model, double price){
        this.Id_reservation = id_reservation;
        this.Start_date = start_date;
        this.Return_date = return_date;
        this.License_plate = license_plate;
        this.Id_employee = id_employee;
        this.Id_client = id_client;

        this.Brand = brand;
        this.Classs = classs;
        this.Year_model = year_model;
        this.Price = price;

    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getClasss() {
        return Classs;
    }

    public void setClasss(String aClass) {
        Classs = aClass;
    }

    public int getYear_model() {
        return Year_model;
    }

    public void setYear_model(int year_model) {
        Year_model = year_model;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public ReservationPOJO() {

    }

    public int getId_reservation() {
        return Id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        Id_reservation = id_reservation;
    }

    public LocalDateTime getStart_date() {
        return Start_date;
    }

    public void setStart_date(LocalDateTime start_date) {
        Start_date = start_date;
    }

    public LocalDateTime getReturn_date() {
        return Return_date;
    }

    public void setReturn_date(LocalDateTime return_date) {
        Return_date = return_date;
    }

    public String getLicense_plate() {
        return License_plate;
    }

    public void setLicense_plate(String license_plate) {
        License_plate = license_plate;
    }

    public int getId_employee() {
        return Id_employee;
    }

    public void setId_employee(int id_employee) {
        Id_employee = id_employee;
    }

    public int getId_client() {
        return Id_client;
    }

    public void setId_client(int id_client) {
        Id_client = id_client;
    }

    @Override
    public String toString() {
        return "ReservationPOJO{" +
                "Id_reservation=" + Id_reservation +
                ", Start_date=" + Start_date +
                ", Return_date=" + Return_date +
                ", License_plate='" + License_plate + '\'' +
                ", Id_employee=" + Id_employee +
                ", Id_client=" + Id_client +
                ", Brand='" + Brand + '\'' +
                ", Class='" + Classs + '\'' +
                ", Year_model=" + Year_model +
                ", Price=" + Price +
                '}';
    }
}
