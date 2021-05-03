package com.mx.edu.j2se.GarciaSantamaria.Implementations;

import com.mx.edu.j2se.GarciaSantamaria.Interfaces.ReservDaoInterface;
import com.mx.edu.j2se.GarciaSantamaria.Mappers.reservationRowMapper;
import com.mx.edu.j2se.GarciaSantamaria.POJOs.ReservationPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository("ReservationDao")
public class ReservationDaoImpl implements ReservDaoInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ReservationPOJO getReservationStatus(int reservationId) {
        String sql = "SELECT r.Id_reservation, r.Id_client, r.Start_date, r.Return_date, c.Brand, c.Sub_brand, c.Class, c.Year_model, r.License_plate, c.Price, r.Id_employee FROM reservation r LEFT JOIN car c USING(License_plate) WHERE r.Id_reservation = ?";

        return jdbcTemplate.queryForObject(sql, new Object[] {reservationId}, new reservationRowMapper());
    }

    @Override
    public boolean save(ReservationPOJO reservationPOJO) {
        String sql = "INSERT INTO reservation (Start_date, Return_date, License_plate, Id_employee, Id_client) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, reservationPOJO.getStart_date(), reservationPOJO.getReturn_date(), reservationPOJO.getLicense_plate(), reservationPOJO.getId_employee(), reservationPOJO.getId_client());
        return true;
    }

    @Override
    public boolean delete(ReservationPOJO reservationPOJO) {
        String sql = "DELETE FROM reservation WHERE Id_reservation=?";
        jdbcTemplate.update(sql, reservationPOJO.getId_reservation());
        return true;
    }
}
