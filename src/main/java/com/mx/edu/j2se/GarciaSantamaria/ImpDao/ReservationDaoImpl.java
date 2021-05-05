package com.mx.edu.j2se.GarciaSantamaria.ImpDao;

import com.mx.edu.j2se.GarciaSantamaria.ApiDao.ReservDao;
import com.mx.edu.j2se.GarciaSantamaria.RowMappers.ReservationMap;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository("ReservationDao")
public class ReservationDaoImpl implements ReservDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Reservation getReservationStatus(int reservationId) {
        String sql = String.format("SELECT r.Id_reservation, r.Id_client, r.Start_date, r.Return_date, c.Brand, c.Sub_brand, c.Class, c.Year_model, r.License_plate, c.Price, r.Id_employee FROM reservation r LEFT JOIN car c USING(License_plate) WHERE r.Id_reservation = %d", reservationId);

        return jdbcTemplate.queryForObject(sql, new Object[] {}, new ReservationMap());
    }

    @Override
    public void save(Reservation reservation) {
        String sql = String.format("INSERT INTO reservation (Start_date, Return_date, License_plate, Id_employee, Id_client) VALUES (%s, %s, %s, %d, %d)",
                reservation.getStart_date(), reservation.getReturn_date(), reservation.getLicense_plate(),
                reservation.getId_employee(), reservation.getId_client());
        jdbcTemplate.update(sql);
    }

    @Override
    public void delete(int reservationId) {
        String sql = String.format("DELETE FROM reservation WHERE Id_reservation = %d", reservationId);
        jdbcTemplate.update(sql);
    }
}
