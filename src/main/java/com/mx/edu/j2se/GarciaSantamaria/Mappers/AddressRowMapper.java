package com.mx.edu.j2se.GarciaSantamaria.Mappers;

import com.mx.edu.j2se.GarciaSantamaria.POJOs.AddressPOJO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressRowMapper implements RowMapper<AddressPOJO> {

    @Override
    public AddressPOJO mapRow(ResultSet resultSet, int i) throws SQLException {
        AddressPOJO addressPOJO = new AddressPOJO();

        addressPOJO.setId_address(resultSet.getInt("Id_address"));
        addressPOJO.setStreet(resultSet.getString("Street"));
        addressPOJO.setOutDoorNumber(resultSet.getInt("OutDoorNumber"));
        addressPOJO.setInDoorNumber(resultSet.getInt("InDoorNumber"));
        addressPOJO.setColony(resultSet.getString("Colony"));
        addressPOJO.setState(resultSet.getString("State"));
        addressPOJO.setMunicipality(resultSet.getString("Municipality"));
        addressPOJO.setPostalCode(resultSet.getInt("Postal_code"));

        return addressPOJO;
    }
}
