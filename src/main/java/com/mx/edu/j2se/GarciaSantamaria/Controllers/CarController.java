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
import java.util.List;

@Controller
public class CarController {

    LocalDateTime universalStartDate;
    LocalDateTime universalReturnDate;
    List<Car> universalCarList;
    double overallPrice;

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

        universalCarList = carDaoImpl.getAllCarsAvailable(universalStartDate, universalReturnDate, carClass);
        if(universalCarList.isEmpty()){
            String noCars = "*** SORRY, THERE ARE NO CARS AVAILABLE FOR THIS PERIOD OF TIME, BUT WE HAVE FOR ANOTHER PERIOD ***";
            model.addAttribute("noCarsMessage", noCars);
        }else{
            model.addAttribute("listOfCars",universalCarList);
        }
        return "clientMenuView";
    }

    @RequestMapping(path = "/saveReservation")
    public String save(String licensePlate, int idClient, Model model) {

        for(Car x : universalCarList){
            if(x.getLicensePlate().equals(licensePlate)) {
                overallPrice = x.getOverallPrice();
                System.out.println(overallPrice);
            }
        }

        Reservation reservation = new Reservation(universalStartDate, universalReturnDate, licensePlate, idClient, overallPrice);

        String message;
        String idMessage = null;
        if(this.reservationDaoImpl.save(reservation)){
            message = "***SUCCESSFUL RESERVATION***";
            int reservationId = this.reservationDaoImpl.getReservation(universalStartDate, universalReturnDate, licensePlate, idClient).getIdReservation();
            idMessage = String.format("PLEASE SAVE YOUR RESERVATION NUMBER: %d", reservationId);
        }else{
            message = "***YOU ALREADY HAVE A PENDING RESERVATION, THANK YOU FOR UNDERSTANDING***";
        }

        model.addAttribute("sucessMessage", message);
        model.addAttribute("messageId", idMessage);
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

}
