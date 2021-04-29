package com.mx.edu.j2se.GarciaSantamaria;

import java.time.LocalDateTime;

public class ReservationPOJO {
    int Id_reservation;
    LocalDateTime Start_date;
    LocalDateTime Return_date;
    String License_plate;
    int Id_employee;
    int Id_client;

    ReservationPOJO(int id_reservation, LocalDateTime start_date, LocalDateTime return_date, String license_plate, int id_employee, int id_client){
        this.Id_reservation = id_reservation;
        this.Start_date = start_date;
        this.Return_date = return_date;
        this.License_plate = license_plate;
        this.Id_employee = id_employee;
        this.Id_client = id_client;
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
}
