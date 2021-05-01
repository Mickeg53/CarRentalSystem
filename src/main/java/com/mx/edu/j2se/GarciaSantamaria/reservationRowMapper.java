package com.mx.edu.j2se.GarciaSantamaria;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class reservationRowMapper implements RowMapper<ReservationPOJO> {
    @Override
    public ReservationPOJO mapRow(ResultSet rs, int i) throws SQLException {
        ReservationPOJO reservationPOJO = new ReservationPOJO();

        reservationPOJO.setId_reservation(rs.getInt("Id_reservation"));
        reservationPOJO.setStart_date(rs.getDate("Start_date").toLocalDate().atTime(rs.getTime("Start_date").toLocalTime()));
        reservationPOJO.setReturn_date(rs.getDate("Return_date").toLocalDate().atTime(rs.getTime("Return_date").toLocalTime()));
        reservationPOJO.setLicense_plate(rs.getString("License_plate"));
        reservationPOJO.setId_employee(rs.getInt("Id_employee"));
        reservationPOJO.setId_client(rs.getInt("Id_client"));

        reservationPOJO.setBrand(rs.getString("Brand"));
        reservationPOJO.setClasss(rs.getString("Class"));
        reservationPOJO.setYear_model(rs.getInt("Year_model"));
        reservationPOJO.setPrice(rs.getDouble("Price"));

        return reservationPOJO;
    }
}
