package com.mx.edu.j2se.GarciaSantamaria.Objects;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reservation {
    private int idReservation;
    private String startDate;
    private String returnDate;
    private String licensePlate;
    private int idClient;

    public Reservation(String startDate, String returnDate, String licensePlate, int idClient) {
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.licensePlate = licensePlate;
        this.idClient = idClient;
    }

    public Reservation() {

    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", startDate=" + startDate +
                ", returnDate=" + returnDate +
                ", licensePlate='" + licensePlate + '\'' +
                ", idClient=" + idClient +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return getIdReservation() == that.getIdReservation() && getIdClient() == that.getIdClient() && getStartDate().equals(that.getStartDate()) && getReturnDate().equals(that.getReturnDate()) && getLicensePlate().equals(that.getLicensePlate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdReservation(), getStartDate(), getReturnDate(), getLicensePlate(), getIdClient());
    }
}
