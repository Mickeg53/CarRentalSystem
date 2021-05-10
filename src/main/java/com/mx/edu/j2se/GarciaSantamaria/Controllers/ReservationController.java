package com.mx.edu.j2se.GarciaSantamaria.Controllers;

import com.mx.edu.j2se.GarciaSantamaria.ImpDao.CarDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.ImpDao.ReservationDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Car;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ReservationController {

    @Autowired
    private ReservationDaoImpl reservationDaoImpl;
    @Autowired
    private CarDaoImpl carDaoImpl;

    int universalReservationId = 0;

    @RequestMapping(path = "/getReservationStatus")
    public String getReservationStatus(int reservationId, Model model) {
        universalReservationId = reservationId;
        Reservation reservation = reservationDaoImpl.getReservationStatus(reservationId);
        
        String reservationInexistentMessage = null;
        Car car = null;

        if(reservation == null){
            reservationInexistentMessage = "***THE RESERVATION ENTERED DOES NOT EXIST, TRY WITH ANOTHER RESERVATION NUMBER***";
        }else{
            car = carDaoImpl.getCar(reservation.getLicensePlate());
        }
        model.addAttribute("reservationStatus", reservation);
        model.addAttribute("carReserved", car);
        model.addAttribute("inexistentReservation", reservationInexistentMessage);

        return "reservationStatusView";
    }

    @RequestMapping(path = "/deleteReservation")
    public String delete(Model model) {
        this.reservationDaoImpl.delete(universalReservationId);
        String deleteMessage = "***CAR RETURNED SUCESSFULLY***";
        model.addAttribute("deleteSucessfulMessage", deleteMessage);
        return "reservationStatusView";
    }
}
