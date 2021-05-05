package Controllers;

import com.mx.edu.j2se.GarciaSantamaria.ImpDao.CarDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarDaoImpl carDaoImpl;

    @RequestMapping(value = "/")
    public String index(){
        return"index";
    }

    @GetMapping(path = "/getAllCarsAvailable")
    public List<Car> getAllCarsAvailable(String startDatee, String returnDatee, String carClass) {

        LocalDateTime startDate = LocalDateTime.parse(startDatee);
        LocalDateTime returnDate = LocalDateTime.parse(returnDatee);

        return carDaoImpl.getAllCarsAvailable(startDate, returnDate, carClass);
    }

    @PostMapping(path = "/saveCar")
    public void saveCar(Car car){
        this.carDaoImpl.save(car);
        System.out.println(car);
    }

    @DeleteMapping(path = "/deleteCar")
    public void deleteCar(int carLicensePlate){
        this.carDaoImpl.delete(carLicensePlate);
    }

    @PutMapping(path = "/updateCar")
    public void updateCar(Car car){  //WE ARE NOT DOING ANY VALIDATION
        this.carDaoImpl.update(car);
    }

}
