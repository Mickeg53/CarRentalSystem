package com.mx.edu.j2se.GarciaSantamaria.ImpDao;

import com.mx.edu.j2se.GarciaSantamaria.ApiDao.ReservDao;
import com.mx.edu.j2se.GarciaSantamaria.RowMappers.ReservationMap;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;


@Repository("ReservationDao")
public class ReservationDaoImpl implements ReservDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Reservation getReservationStatus(int reservationId) {
        String sql = String.format("SELECT r.Id_reservation, r.Id_client, r.Start_date, r.Return_date, r.License_plate, r.Overall_price FROM reservation r WHERE r.Id_reservation = %d", reservationId);
        try{
            return jdbcTemplate.queryForObject(sql, new Object[] {}, new ReservationMap());
        }catch(Exception e){
            System.out.println("No existe la reservación");
        }
        return null;
    }

    @Override
    public Reservation getReservation(LocalDateTime startDate, LocalDateTime returnDate, String licensePlate, int idClient){
        String sql = String.format("SELECT r.Id_reservation, r.Start_date, r.Return_date, r.License_plate, r.Id_client, r.Overall_price FROM reservation r WHERE r.Start_date = '%s' AND r.Return_date = '%s' AND r.License_plate = '%s' AND r.Id_client = %d ", startDate, returnDate, licensePlate, idClient);
        return jdbcTemplate.queryForObject(sql, new Object[] {}, new ReservationMap());
    }

    @Override
    public boolean save(Reservation reservation) {
        String sql = String.format("INSERT INTO reservation (Start_date, Return_date, License_plate, Id_client, Overall_price) VALUES ('%s', '%s', '%s', %d, %f)",
                reservation.getStartDate(), reservation.getReturnDate(),
                reservation.getLicensePlate(), reservation.getIdClient(), reservation.getOverallPrice());
        try{
            jdbcTemplate.update(sql);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public void delete(int reservationId) {
        String sql = String.format("DELETE FROM reservation WHERE Id_reservation = %d", reservationId);
        jdbcTemplate.update(sql);
    }
}
