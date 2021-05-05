package Controllers;

import com.mx.edu.j2se.GarciaSantamaria.ImpDao.ReservationDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/reservation")
public class ReservationController {
    @Autowired
    private ReservationDaoImpl reservationDaoImpl;

    @GetMapping
    public String check(){
        return "BIENVENIDO A LAS RESERVACIONES";
    }

    @GetMapping(path = "/getReservationStatus")
    public Reservation getReservationStatus(int reservationId) {
        return reservationDaoImpl.getReservationStatus(reservationId);
    }

    @PostMapping(path = "/saveReservation")
    public void save(Reservation reservation) {
        this.reservationDaoImpl.save(reservation);
    }

    @DeleteMapping(path = "/deleteReservation")
    public void delete(int reservationId) {
        this.reservationDaoImpl.delete(reservationId);
    }
}
