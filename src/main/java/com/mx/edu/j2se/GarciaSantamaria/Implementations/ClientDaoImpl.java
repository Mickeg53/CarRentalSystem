package com.mx.edu.j2se.GarciaSantamaria.Implementations;

import com.mx.edu.j2se.GarciaSantamaria.Interfaces.ClientDaoInterface;
import com.mx.edu.j2se.GarciaSantamaria.Mappers.ClientRowMapper;
import com.mx.edu.j2se.GarciaSantamaria.Mappers.reservationRowMapper;
import com.mx.edu.j2se.GarciaSantamaria.POJOs.ClientPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("ClientDao")
public class ClientDaoImpl implements ClientDaoInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public ClientPOJO getClient(int clientId) {
        String sql = "SELECT * FROM client WHERE Id_client = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {clientId}, new ClientRowMapper());
    }

    @Override
    public boolean save(ClientPOJO clientPOJO) {
        String sql = "INSERT INTO client (Name, Mothers_last_name, Last_name, Phone_number, Email, Id_address) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, clientPOJO.getName(), clientPOJO.getMothersLastName(), clientPOJO.getLastName(), clientPOJO.getPhoneNumber(), clientPOJO.getEmail(), clientPOJO.getId_address());
        return true;
    }

    @Override
    public boolean delete(ClientPOJO clientPOJO) {
        String sql = "DELETE FROM client WHERE Id_client=?";
        jdbcTemplate.update(sql, clientPOJO.getId_client());
        return true;
    }

    @Override
    public boolean update(ClientPOJO clientPOJO) {
        String sql = "UPDATE client SET Phone_number=?, Email=?, Id_address=? WHERE Id_client=?";
        jdbcTemplate.update(sql, clientPOJO.getPhoneNumber(), clientPOJO.getEmail(), clientPOJO.getId_address(), clientPOJO.getId_client());
        return true;
    }
}
