package com.mx.edu.j2se.GarciaSantamaria.Controllers;

import com.mx.edu.j2se.GarciaSantamaria.ImpDao.CarDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.ImpDao.ClientDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.ImpDao.ReservationDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Car;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Client;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;
import java.util.List;

@Controller
public class CarController {

    LocalDateTime universalStartDate;
    LocalDateTime universalReturnDate;

    @Autowired
    private CarDaoImpl carDaoImpl;

    @Autowired
    private ReservationDaoImpl reservationDaoImpl;

    @RequestMapping(path = "/getAllCarsAvailable")
    public String getAllCarsAvailable(String startDate, String startTime, String carClass, String endDate, String endTime, Model model) {

        String startDateToParse = String.format("%sT%s:00", startDate, startTime);
        String endDateToParse = String.format("%sT%s:00", endDate, endTime);

        universalStartDate = LocalDateTime.parse(startDateToParse);
        universalReturnDate = LocalDateTime.parse(endDateToParse);

        List<Car> carsAvailable = carDaoImpl.getAllCarsAvailable(universalStartDate, universalReturnDate, carClass);
        if(carsAvailable.isEmpty()){
            String noCars = "*** SORRY, THERE ARE NO CARS AVAILABLE FOR THIS PERIOD OF TIME, BUT WE HAVE FOR ANOTHER PERIOD ***";
            model.addAttribute("noCarsMessage", noCars);
        }else{
            model.addAttribute("listOfCars",carsAvailable);
        }
        return "clientMenuView";
    }

    @RequestMapping(path = "/saveReservation")
    public String save(String licensePlate, int idClient, Model model) {
        Reservation reservation = new Reservation(universalStartDate, universalReturnDate, licensePlate, idClient);
        String message;

        if(this.reservationDaoImpl.save(reservation)){
            message = "***SUCCESSFUL RESERVATION***";
        }else{
            message = "***YOU ALREADY HAVE A PENDING RESERVATION, THANK YOU FOR UNDERSTANDING***";
        }
        model.addAttribute("sucessMessage", message);
        return "clientMenuView";
    }

    @RequestMapping(path = "/saveCar")
    public void saveCar(Car car){
        this.carDaoImpl.save(car);
        System.out.println(car);
    }

    @DeleteMapping(path = "/deleteCar")
    public void deleteCar(int carLicensePlate){
        this.carDaoImpl.delete(carLicensePlate);
    }

    @RequestMapping(path = "/updateCar")
    public void updateCar(Car car){  //WE ARE NOT DOING ANY VALIDATION
        this.carDaoImpl.update(car);
    }

    public LocalDateTime getUniversalStartDate() {
        return universalStartDate;
    }

    public LocalDateTime getUniversalReturnDate() {
        return universalReturnDate;
    }

}
