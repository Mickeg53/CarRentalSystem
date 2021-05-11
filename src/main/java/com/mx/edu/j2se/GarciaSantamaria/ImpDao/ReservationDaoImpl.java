package com.mx.edu.j2se.GarciaSantamaria.ImpDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mx.edu.j2se.GarciaSantamaria.ApiDao.ReservDao;
import com.mx.edu.j2se.GarciaSantamaria.RowMappers.ReservationMap;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;


@Repository("ReservationDao")
public class ReservationDaoImpl implements ReservDao {

    private static final Logger logger = LoggerFactory.getLogger(ReservationDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Reservation getReservationStatus(int reservationId) {
        String sql = String.format("SELECT r.Id_reservation, r.Id_client, r.Start_date, r.Return_date, r.License_plate FROM reservation r WHERE r.Id_reservation = %d", reservationId);
        try{
            return jdbcTemplate.queryForObject(sql, new Object[] {}, new ReservationMap());
        }catch(Exception e){
            logger.info("THERE ARE NO EXISTING RESERVATION FOR THE ID ENTERED, HANDLING EXCEPTION IN ReservationDaoImpl(getReservationStatus)");
        }
        return null;
    }

    @Override
    public Reservation getReservation(LocalDateTime startDate, LocalDateTime returnDate, String licensePlate, int idClient){
        String sql = String.format("SELECT r.Id_reservation, r.Start_date, r.Return_date, r.License_plate, r.Id_client FROM reservation r WHERE r.Start_date = '%s' AND r.Return_date = '%s' AND r.License_plate = '%s' AND r.Id_client = %d ", startDate, returnDate, licensePlate, idClient);

        try{
            return jdbcTemplate.queryForObject(sql, new Object[] {}, new ReservationMap());
        }catch(Exception e){
            logger.info("THERE ARE NO EXISTING RESERVATION FOR THE DATA ENTERED, HANDLING EXCEPTION IN ReservationDaoImpl(getReservationStatus)");
        }
        return null;
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
            logger.info("THERE IS  A RESERVATION FOR THE CLIENT ENTERED, HANDLING EXCEPTION IN ReservationDaoImpl(save)");
            return false;
        }
    }

    @Override
    public void delete(int reservationId) {
        String sql = String.format("DELETE FROM reservation WHERE Id_reservation = %d", reservationId);
        try{
            jdbcTemplate.update(sql);
        }catch (Exception e){
            logger.info("THERE WAS AN ERROR DURING THE DELETE OF RESERVATION, HANDLING EXCEPTION IN ReservationDaoImpl(delete())");
        }
    }
}
