package com.mx.edu.j2se.GarciaSantamaria;

public class CarPOJO {
    private String License_plate;
    private String Brand;
    private String Sub_brand;
    private String Class;
    private int Year_model;
    private double Price;

    CarPOJO(String license_plate, String brand, String sub_brand, String classs, int year_model, double price){
        this.License_plate = license_plate;
        this.Brand = brand;
        this.Sub_brand = sub_brand;
        this.Class = classs;
        this.Year_model = year_model;
        this.Price = price;
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

    public void setPrice(float price) {
        Price = price;
    }
}
