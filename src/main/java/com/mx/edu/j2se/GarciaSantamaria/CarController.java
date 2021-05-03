package com.mx.edu.j2se.GarciaSantamaria;

import com.mx.edu.j2se.GarciaSantamaria.Implementations.CarDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.POJOs.CarPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarDaoImpl carDaoImpl;

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @GetMapping(path = "/getAllCarsAvailable")
    public List<CarPOJO> getAllCarsAvailable(String start_datee, String return_datee, String classs) {

        LocalDateTime start_date = LocalDateTime.parse(start_datee);
        LocalDateTime return_date = LocalDateTime.parse(return_datee);

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
