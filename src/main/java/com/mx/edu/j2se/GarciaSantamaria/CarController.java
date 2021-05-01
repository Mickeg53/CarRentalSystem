package com.mx.edu.j2se.GarciaSantamaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/car")
public class CarController {

    @Autowired
    private CarDaoImpl carDaoImpl;

    @GetMapping
    public String Check(){
        return "BIENVENIDO A LA RENTA DE COCHES";
    }

    @GetMapping(path = "/getAllCarsAvailable")
    public List<CarPOJO> getAllCarsAvailable(String start_datee, String return_datee, String classs) {
        String start_dateee = "";
        String return_dateee = "";

        start_dateee = start_datee;
        return_dateee = return_datee;

        LocalDateTime start_date = LocalDateTime.parse(start_dateee);
        LocalDateTime return_date = LocalDateTime.parse(return_dateee);
        return carDaoImpl.getAllCarsAvailable(start_date, return_date, classs);
    }

    @PostMapping(path = "/saveCar")
    public boolean saveCar(CarPOJO carPOJO){
        this.carDaoImpl.save(carPOJO);
        System.out.println(carPOJO);
        return true;
    }

    @DeleteMapping(path = "/deleteCar")
    public boolean deleteCar(CarPOJO carPOJO){
        this.carDaoImpl.delete(carPOJO);
        return true;
    }

    @PutMapping(path = "/updateCar")
    public boolean updateCar(CarPOJO carPOJO){  //WE ARE NOT DOING ANY VALIDATION
        this.carDaoImpl.update(carPOJO);
        return true;
    }

}
