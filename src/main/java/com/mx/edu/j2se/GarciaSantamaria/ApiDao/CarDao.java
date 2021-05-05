package com.mx.edu.j2se.GarciaSantamaria.ApiDao;

import com.mx.edu.j2se.GarciaSantamaria.Objects.Car;

import java.time.LocalDateTime;
import java.util.List;

public interface CarDao {
    List<Car> getAllCarsAvailable(LocalDateTime start_date, LocalDateTime return_date, String classs);

    void save(Car car);
    void delete(int carLicensePlate);
    void update(Car car);
}
