package com.mx.edu.j2se.GarciaSantamaria;

import java.util.List;

public interface ReservDaoInterface {
    public ReservationPOJO getReservationStatus(int reservationId);
    boolean save(ReservationPOJO reservationPOJO);
    boolean delete(ReservationPOJO reservationPOJO);
}
