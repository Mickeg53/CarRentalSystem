package com.mx.edu.j2se.GarciaSantamaria.ApiDao;

import com.mx.edu.j2se.GarciaSantamaria.Objects.Reservation;

public interface ReservDao {
    Reservation getReservationStatus(int reservationId);
    boolean save(Reservation reservation);
    void delete(int reservationId);
}
