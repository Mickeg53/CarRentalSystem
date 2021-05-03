package com.mx.edu.j2se.GarciaSantamaria;

import com.mx.edu.j2se.GarciaSantamaria.Implementations.ReservationDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.POJOs.ReservationPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/reservation")
public class ReservationController {
    @Autowired
    private ReservationDaoImpl reservationDaoImpl;

    @GetMapping
    public String Check(){
        return "BIENVENIDO A LAS RESERVACIONES";
    }

    @GetMapping(path = "/getReservationStatus")
    public ReservationPOJO getReservationStatus(int reservationId) {
        return reservationDaoImpl.getReservationStatus(reservationId);
    }

    @PostMapping(path = "/saveReservation")
    public boolean save(ReservationPOJO reservationPOJO) {
        this.reservationDaoImpl.save(reservationPOJO);
        System.out.println(reservationPOJO);
        return true;
    }

    @DeleteMapping(path = "/deleteReservation")
    public boolean delete(ReservationPOJO reservationPOJO) {
        this.reservationDaoImpl.delete(reservationPOJO);
        System.out.println(reservationPOJO);
        return true;
    }
}
