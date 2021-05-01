package com.mx.edu.j2se.GarciaSantamaria;

public interface ReservDaoInterface {
    public ReservationPOJO getReservationStatus(int reservationId);
    boolean save(ReservationPOJO reservationPOJO);
    boolean delete(ReservationPOJO reservationPOJO);
}
