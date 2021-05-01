package com.mx.edu.j2se.GarciaSantamaria;

import java.time.LocalDateTime;
import java.util.List;

public interface CarDaoInterface {
    public List<CarPOJO> getAllCarsAvailable(LocalDateTime start_date, LocalDateTime return_date, String classs);

    boolean save(CarPOJO carPOJO);
    boolean delete(CarPOJO carPOJO);
    boolean update(CarPOJO carPOJO);
}
