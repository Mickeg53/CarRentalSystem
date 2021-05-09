package com.mx.edu.j2se.GarciaSantamaria.Controllers;

import com.mx.edu.j2se.GarciaSantamaria.ImpDao.CarDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.ImpDao.ReservationDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Car;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class ReservationController {

    @Autowired
    private ReservationDaoImpl reservationDaoImpl;
    @Autowired
    private CarDaoImpl carDaoImpl;

    @RequestMapping(path = "/getReservationStatus")
    public String getReservationStatus(int reservationId, Model model) {
        Reservation reservation = reservationDaoImpl.getReservationStatus(reservationId);

        Car car = carDaoImpl.getCar(reservation.getLicensePlate());

        model.addAttribute("reservationStatus", reservation);
        model.addAttribute("carReserved", car);

        return "reservationStatusView";
    }

    @DeleteMapping(path = "/deleteReservation")
    public void delete(int reservationId) {
        this.reservationDaoImpl.delete(reservationId);
    }
}
