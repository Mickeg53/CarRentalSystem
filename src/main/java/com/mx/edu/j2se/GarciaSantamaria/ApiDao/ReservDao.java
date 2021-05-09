package com.mx.edu.j2se.GarciaSantamaria.ApiDao;

import com.mx.edu.j2se.GarciaSantamaria.Objects.Reservation;

import java.time.LocalDateTime;

public interface ReservDao {
    Reservation getReservationStatus(int reservationId);
    Reservation getReservation(LocalDateTime startDate, LocalDateTime returnDate, String licensePlate, int idClient);
    boolean save(Reservation reservation);
    void delete(int reservationId);
}
