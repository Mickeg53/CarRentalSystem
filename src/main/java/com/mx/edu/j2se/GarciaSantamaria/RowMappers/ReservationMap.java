package com.mx.edu.j2se.GarciaSantamaria.RowMappers;

import com.mx.edu.j2se.GarciaSantamaria.Objects.Reservation;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReservationMap implements RowMapper<Reservation> {
    @Override
    public Reservation mapRow(ResultSet rs, int i) throws SQLException {
        Reservation reservation = new Reservation();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        reservation.setIdReservation(rs.getInt("Id_reservation"));

        //reservation.setStartDate(rs.getDate("Start_date").toLocalDate().atTime(rs.getTime("Start_date").toLocalTime()));
        LocalDateTime startDate = rs.getDate("Start_date").toLocalDate().atTime(rs.getTime("Start_date").toLocalTime());
        reservation.setStartDate(startDate.format(formatter));

        //reservation.setReturnDate(rs.getDate("Return_date").toLocalDate().atTime(rs.getTime("Return_date").toLocalTime()));
        LocalDateTime returnDate = rs.getDate("Return_date").toLocalDate().atTime(rs.getTime("Return_date").toLocalTime());
        reservation.setReturnDate(returnDate.format(formatter));

        reservation.setLicensePlate(rs.getString("License_plate"));
        reservation.setIdClient(rs.getInt("Id_client"));
        reservation.setOverallPrice(rs.getDouble("Overall_price"));

        return reservation;
    }
}
