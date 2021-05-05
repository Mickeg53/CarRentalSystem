package com.mx.edu.j2se.GarciaSantamaria.Objects;

import java.util.Objects;

public class Car {
    private String License_plate;
    private String Brand;
    private String Sub_brand;
    private String Class;
    private int Year_model;
    private double Price;

    public Car(String license_plate, String brand, String sub_brand, String classs, int year_model, double price){
        this.License_plate = license_plate;
        this.Brand = brand;
        this.Sub_brand = sub_brand;
        this.Class = classs;
        this.Year_model = year_model;
        this.Price = price;
    }

    public Car() {

    }

    public String getLicense_plate() {
        return License_plate;
    }

    public void setLicense_plate(String license_plate) {
        License_plate = license_plate;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getSub_brand() {
        return Sub_brand;
    }

    public void setSub_brand(String sub_brand) {
        Sub_brand = sub_brand;
    }

    public String getClasss() {
        return Class;
    }

    public void setClass(String aClass) {
        Class = aClass;
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

    @Override
    public String toString() {
        return "CarPOJO{" +
                "License_plate='" + License_plate + '\'' +
                ", Brand='" + Brand + '\'' +
                ", Sub_brand='" + Sub_brand + '\'' +
                ", Class='" + Class + '\'' +
                ", Year_model=" + Year_model +
                ", Price=" + Price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getYear_model() == car.getYear_model() && Double.compare(car.getPrice(), getPrice()) == 0 && getLicense_plate().equals(car.getLicense_plate()) && getBrand().equals(car.getBrand()) && getSub_brand().equals(car.getSub_brand()) && getClass().equals(car.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLicense_plate(), getBrand(), getSub_brand(), getClass(), getYear_model(), getPrice());
    }
}
