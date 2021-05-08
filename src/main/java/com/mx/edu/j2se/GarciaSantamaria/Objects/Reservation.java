package com.mx.edu.j2se.GarciaSantamaria.Objects;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reservation {
    private int idReservation;
    private LocalDateTime startDate;
    private LocalDateTime returnDate;
    private String licensePlate;
    private int idEmployee;
    private int idClient;

    private String brand;
    private String carClass;
    private int yearModel;
    private double price;

    public Reservation(LocalDateTime startDate, LocalDateTime returnDate, String licensePlate, int idEmployee, int idClient, String brand, String carClass, int yearModel, double price) {
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.licensePlate = licensePlate;
        this.idEmployee = idEmployee;
        this.idClient = idClient;
        this.brand = brand;
        this.carClass = carClass;
        this.yearModel = yearModel;
        this.price = price;
    }

    public Reservation() {

    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public int getYearModel() {
        return yearModel;
    }

    public void setYearModel(int yearModel) {
        this.yearModel = yearModel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", startDate=" + startDate +
                ", returnDate=" + returnDate +
                ", licensePlate='" + licensePlate + '\'' +
                ", idEmployee=" + idEmployee +
                ", idClient=" + idClient +
                ", brand='" + brand + '\'' +
                ", carClass='" + carClass + '\'' +
                ", yearModel=" + yearModel +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return getIdReservation() == that.getIdReservation() && getIdEmployee() == that.getIdEmployee() && getIdClient() == that.getIdClient() && getYearModel() == that.getYearModel() && Double.compare(that.getPrice(), getPrice()) == 0 && getStartDate().equals(that.getStartDate()) && getReturnDate().equals(that.getReturnDate()) && getLicensePlate().equals(that.getLicensePlate()) && getBrand().equals(that.getBrand()) && getCarClass().equals(that.getCarClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdReservation(), getStartDate(), getReturnDate(), getLicensePlate(), getIdEmployee(), getIdClient(), getBrand(), getCarClass(), getYearModel(), getPrice());
    }
}
