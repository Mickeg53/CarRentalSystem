package com.mx.edu.j2se.GarciaSantamaria.Implementations;

import com.mx.edu.j2se.GarciaSantamaria.Interfaces.AddressDaoInterface;
import com.mx.edu.j2se.GarciaSantamaria.Mappers.AddressRowMapper;
import com.mx.edu.j2se.GarciaSantamaria.POJOs.AddressPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("AddressDao")
public class AddressDaoImpl implements AddressDaoInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public AddressPOJO getAddress(int addressId) {
        String sql = "SELECT * FROM address WHERE Id_address = '"+addressId+"'";
        return jdbcTemplate.queryForObject(sql, new Object[] {addressId}, new AddressRowMapper());
    }

    @Override
    public boolean save(AddressPOJO addressPOJO) {
        String sql = "INSERT INTO address (int Id_address, Street, OutDoor_number, InDoor_number, Colony, State, Municipality, Postal_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, addressPOJO.getId_address(), addressPOJO.getStreet(), addressPOJO.getOutDoorNumber(), addressPOJO.getInDoorNumber(), addressPOJO.getColony(), addressPOJO.getState(), addressPOJO.getMunicipality(), addressPOJO.getPostalCode());
        return true;
    }

    @Override
    public boolean delete(AddressPOJO addressPOJO) {
        String sql = "DELETE FROM address WHERE Id_address=?";
        jdbcTemplate.update(sql, addressPOJO.getId_address());
        return true;
    }

    @Override
    public boolean update(AddressPOJO addressPOJO) {
        String sql = "UPDATE address SET Street=?, OutDoor_number=?, InDoor_number=?, Colony=?, State=?, Municipality=?, Postal_code=? WHERE Id_address=?";
        jdbcTemplate.update(sql, addressPOJO.getStreet(), addressPOJO.getOutDoorNumber(), addressPOJO.getInDoorNumber(), addressPOJO.getColony(), addressPOJO.getState(), addressPOJO.getMunicipality(), addressPOJO.getPostalCode());
        return true;
    }
}
