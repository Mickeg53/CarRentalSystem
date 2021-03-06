package com.mx.edu.j2se.GarciaSantamaria.RowMappers;

import com.mx.edu.j2se.GarciaSantamaria.Objects.Address;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMap implements RowMapper<Address> {

    @Override
    public Address mapRow(ResultSet resultSet, int i) throws SQLException {
        Address address = new Address();

        address.setIdAddress(resultSet.getInt("Id_address"));
        address.setStreet(resultSet.getString("Street"));
        address.setOutDoorNumber(resultSet.getInt("Outdoor_number"));
        address.setInDoorNumber(resultSet.getInt("Indoor_number"));
        address.setColony(resultSet.getString("Colony"));
        address.setState(resultSet.getString("State"));
        address.setMunicipality(resultSet.getString("Municipality"));
        address.setPostalCode(resultSet.getInt("Postal_code"));

        return address;
    }
}
