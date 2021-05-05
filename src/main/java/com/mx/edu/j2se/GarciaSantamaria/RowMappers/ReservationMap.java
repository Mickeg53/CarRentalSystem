package com.mx.edu.j2se.GarciaSantamaria.RowMappers;

import com.mx.edu.j2se.GarciaSantamaria.Objects.Reservation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationMap implements RowMapper<Reservation> {
    @Override
    public Reservation mapRow(ResultSet rs, int i) throws SQLException {
        Reservation reservation = new Reservation();

        reservation.setId_reservation(rs.getInt("Id_reservation"));
        reservation.setStart_date(rs.getDate("Start_date").toLocalDate().atTime(rs.getTime("Start_date").toLocalTime()));
        reservation.setReturn_date(rs.getDate("Return_date").toLocalDate().atTime(rs.getTime("Return_date").toLocalTime()));
        reservation.setLicense_plate(rs.getString("License_plate"));
        reservation.setId_employee(rs.getInt("Id_employee"));
        reservation.setId_client(rs.getInt("Id_client"));

        reservation.setBrand(rs.getString("Brand"));
        reservation.setClasss(rs.getString("Class"));
        reservation.setYear_model(rs.getInt("Year_model"));
        reservation.setPrice(rs.getDouble("Price"));

        return reservation;
    }
}
