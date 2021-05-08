package com.mx.edu.j2se.GarciaSantamaria.Controllers;

import com.mx.edu.j2se.GarciaSantamaria.ImpDao.CarDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.ImpDao.ClientDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Car;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarDaoImpl carDaoImpl;

    @RequestMapping(path = "/getAllCarsAvailable")
    public String getAllCarsAvailable(String startDate, String startTime, String carClass, String endDate, String endTime, Model model) {

        String startDateToParse = String.format("%sT%s:00", startDate, startTime);
        String endDateToParse = String.format("%sT%s:00", endDate, endTime);

        LocalDateTime starttDate = LocalDateTime.parse(startDateToParse);
        LocalDateTime returnDate = LocalDateTime.parse(endDateToParse);

        List<Car> carsAvailable = carDaoImpl.getAllCarsAvailable(starttDate, returnDate, carClass);
        System.out.println(carsAvailable);
        model.addAttribute("listOfCars",carsAvailable);
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
