package com.mx.edu.j2se.GarciaSantamaria.RowMappers;

import com.mx.edu.j2se.GarciaSantamaria.Objects.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMap implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet resultSet, int i) throws SQLException {
        Client clientPOJOPOJO = new Client();

        clientPOJOPOJO.setId_client(resultSet.getInt("Id_client"));
        clientPOJOPOJO.setName(resultSet.getString("Name"));
        clientPOJOPOJO.setMothersLastName(resultSet.getString("Mothers_last_name"));
        clientPOJOPOJO.setLastName(resultSet.getString("Last_name"));
        clientPOJOPOJO.setPhoneNumber(resultSet.getBigDecimal("Phone_number"));
        clientPOJOPOJO.setEmail(resultSet.getString("Email"));
        clientPOJOPOJO.setId_address(resultSet.getInt("Id_address"));

        return clientPOJOPOJO;
    }
}
