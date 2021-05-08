package com.mx.edu.j2se.GarciaSantamaria.Objects;

import java.util.Objects;

public class Car {
    private String licensePlate;
    private String brand;
    private String subBrand;
    private String classOfCar;
    private int yearModel;
    private double price;
    private double overallPrice;

    public Car(String licenseplate, String brand, String subbrand, String classofcar, int yearmodel, double price){
        this.licensePlate = licenseplate;
        this.brand = brand;
        this.subBrand = subbrand;
        this.classOfCar = classofcar;
        this.yearModel = yearmodel;
        this.price = price;
    }

    public Car() {

    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licenseplate) {
        licensePlate = licenseplate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brandd) {
        brand = brandd;
    }

    public String getSubBrand() {
        return subBrand;
    }

    public void setSubBrand(String subbrand) {
        subBrand = subbrand;
    }

    public String getClassOfCar() {
        return classOfCar;
    }

    public void setClass(String ClassOfCar) {
        classOfCar = ClassOfCar;
    }

    public int getYearModel() {
        return yearModel;
    }

    public void setYearModel(int yearmodel) {
        yearModel = yearmodel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double priceCar) {
        price = priceCar;
    }

    public double getOverallPrice() {
        return overallPrice;
    }

    public void setOverallPrice(double overallPrice) {
        this.overallPrice = overallPrice;
    }

    @Override
    public String toString() {
        return "CarPOJO{" +
                "License_plate='" + licensePlate + '\'' +
                ", Brand='" + brand + '\'' +
                ", Sub_brand='" + subBrand + '\'' +
                ", Class='" + classOfCar + '\'' +
                ", Year_model=" + yearModel +
                ", Price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getYearModel() == car.getYearModel() && Double.compare(car.getPrice(), getPrice()) == 0 && getLicensePlate().equals(car.getLicensePlate()) && getBrand().equals(car.getBrand()) && getSubBrand().equals(car.getSubBrand()) && getClass().equals(car.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLicensePlate(), getBrand(), getSubBrand(), getClass(), getYearModel(), getPrice());
    }
}
