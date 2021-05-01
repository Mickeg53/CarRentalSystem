package com.mx.edu.j2se.GarciaSantamaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;


public interface CarDaoInterface {
    public List<CarPOJO> getAllCarsAvailable(LocalDateTime start_date, LocalDateTime return_date, String classs);

    boolean save(CarPOJO carPOJO);
    boolean delete(CarPOJO carPOJO);
    boolean update(CarPOJO carPOJO);
}
