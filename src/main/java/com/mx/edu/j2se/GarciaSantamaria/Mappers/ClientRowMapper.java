package com.mx.edu.j2se.GarciaSantamaria.Mappers;

import com.mx.edu.j2se.GarciaSantamaria.POJOs.CarPOJO;
import com.mx.edu.j2se.GarciaSantamaria.POJOs.ClientPOJO;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<ClientPOJO> {
    @Override
    public ClientPOJO mapRow(ResultSet resultSet, int i) throws SQLException {
        ClientPOJO clientPOJOPOJO = new ClientPOJO();

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
