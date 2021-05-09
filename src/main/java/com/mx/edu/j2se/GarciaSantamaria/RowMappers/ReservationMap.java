package com.mx.edu.j2se.GarciaSantamaria.RowMappers;

import com.mx.edu.j2se.GarciaSantamaria.Objects.Reservation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationMap implements RowMapper<Reservation> {
    @Override
    public Reservation mapRow(ResultSet rs, int i) throws SQLException {
        Reservation reservation = new Reservation();

        reservation.setIdReservation(rs.getInt("Id_reservation"));
        reservation.setStartDate(rs.getDate("Start_date").toLocalDate().atTime(rs.getTime("Start_date").toLocalTime()));
        reservation.setReturnDate(rs.getDate("Return_date").toLocalDate().atTime(rs.getTime("Return_date").toLocalTime()));
        reservation.setLicensePlate(rs.getString("License_plate"));
        reservation.setIdClient(rs.getInt("Id_client"));
        reservation.setOverallPrice(rs.getDouble("Overall_price"));

        return reservation;
    }
}
