package com.mx.edu.j2se.GarciaSantamaria.Controllers;

import com.mx.edu.j2se.GarciaSantamaria.ImpDao.CarDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.ImpDao.ReservationDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Car;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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
        String outOfTime = null;
        Car car = null;
        double price = 0;

        if(reservation == null){
            reservationInexistentMessage = "***THE RESERVATION ENTERED DOES NOT EXIST, TRY WITH ANOTHER RESERVATION NUMBER***";
            model.addAttribute("inexistentReservation", reservationInexistentMessage);
            return "reservationStatusView";
        }else{
            car = carDaoImpl.getCar(reservation.getLicensePlate());
            if(LocalDateTime.parse(reservation.getReturnDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).isBefore(LocalDateTime.now())){
                outOfTime = "-----------CAR OUT OF TIME, YOU MUST RETURN THE CAR-----------";
            }else{
                Duration duration = Duration.between(LocalDateTime.parse(reservation.getStartDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), LocalDateTime.parse(reservation.getReturnDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                long diffHours = Math.abs(duration.toHours());
                long diffDays = Math.abs(duration.toDays());
                double completeDays = diffHours/24.00;
                
                if(completeDays - diffDays > 0){
                    price = (diffDays+1)*(car.getPrice());
                }else{
                    price = diffDays*(car.getPrice());
                }
            }
            
        }
        model.addAttribute("reservationStatus", reservation);
        model.addAttribute("carReserved", car);
        model.addAttribute("outOfTimeMessage", outOfTime);
        model.addAttribute("overallPrice", price);

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
