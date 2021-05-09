package com.mx.edu.j2se.GarciaSantamaria.ImpDao;

import com.mx.edu.j2se.GarciaSantamaria.ApiDao.ReservDao;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Car;
import com.mx.edu.j2se.GarciaSantamaria.RowMappers.ReservationMap;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLIntegrityConstraintViolationException;


@Repository("ReservationDao")
public class ReservationDaoImpl implements ReservDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Reservation getReservationStatus(int reservationId) {
        String sql = String.format("SELECT r.Id_reservation, r.Id_client, r.Start_date, r.Return_date, r.License_plate FROM reservation r WHERE r.Id_reservation = %d", reservationId);
        return jdbcTemplate.queryForObject(sql, new Object[] {}, new ReservationMap());
    }

    @Override
    public boolean save(Reservation reservation) {
        String sql = String.format("INSERT INTO reservation (Start_date, Return_date, License_plate, Id_client) VALUES ('%s', '%s', '%s', %d)",
                reservation.getStartDate(), reservation.getReturnDate(),
                reservation.getLicensePlate(), reservation.getIdClient());
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
