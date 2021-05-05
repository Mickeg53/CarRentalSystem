package com.mx.edu.j2se.GarciaSantamaria.ApiDao;

import com.mx.edu.j2se.GarciaSantamaria.Objects.Reservation;

public interface ReservDao {
    Reservation getReservationStatus(int reservationId);
    void save(Reservation reservation);
    void delete(int reservationId);
}
