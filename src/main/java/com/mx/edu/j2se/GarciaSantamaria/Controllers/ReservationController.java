package com.mx.edu.j2se.GarciaSantamaria.Controllers;

import com.mx.edu.j2se.GarciaSantamaria.ImpDao.ReservationDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservationController {
    @Autowired
    private ReservationDaoImpl reservationDaoImpl;

    @ResponseBody
    @RequestMapping(value = "/reservations")
    public String check(){
        return "BIENVENIDO A LAS RESERVACIONES";
    }

    @RequestMapping(path = "/getReservationStatus")
    public Reservation getReservationStatus(int reservationId) {
        return reservationDaoImpl.getReservationStatus(reservationId);
    }

    @RequestMapping(path = "/saveReservation")
    public void save(Reservation reservation) {
        this.reservationDaoImpl.save(reservation);
    }

    @DeleteMapping(path = "/deleteReservation")
    public void delete(int reservationId) {
        this.reservationDaoImpl.delete(reservationId);
    }
}
