package com.mx.edu.j2se.GarciaSantamaria.Interfaces;

import com.mx.edu.j2se.GarciaSantamaria.POJOs.ReservationPOJO;

public interface ReservDaoInterface {
    public ReservationPOJO getReservationStatus(int reservationId);
    boolean save(ReservationPOJO reservationPOJO);
    boolean delete(ReservationPOJO reservationPOJO);
}
