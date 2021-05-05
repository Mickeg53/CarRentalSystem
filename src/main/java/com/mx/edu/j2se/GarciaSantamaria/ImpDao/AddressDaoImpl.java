package com.mx.edu.j2se.GarciaSantamaria.ImpDao;

import com.mx.edu.j2se.GarciaSantamaria.ApiDao.AddressDao;
import com.mx.edu.j2se.GarciaSantamaria.RowMappers.AddressMap;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("AddressDao")
public class AddressDaoImpl implements AddressDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Address getAddress(int addressId) {
        String sql = String.format("SELECT * FROM address WHERE Id_address = %d", addressId);
        return jdbcTemplate.queryForObject(sql, new Object[] {}, new AddressMap());
    }

    @Override
    public void save(Address address) {
        String sql = String.format("INSERT INTO address (int Id_address, Street, OutDoor_number, InDoor_number, Colony, State, Municipality, Postal_code) VALUES (%s, %s, %d, %d, %s, %s, %s, %d)",
                address.getId_address(), address.getStreet(), address.getOutDoorNumber(), address.getInDoorNumber(),
                address.getColony(), address.getState(), address.getMunicipality(), address.getPostalCode());
        jdbcTemplate.update(sql);
    }

    @Override
    public void delete(int addressId) {
        String sql = String.format("DELETE FROM address WHERE Id_address = %d", addressId);
        jdbcTemplate.update(sql);
    }

    @Override
    public void update(Address address) {
        String sql = String.format("UPDATE address SET Street=%s, OutDoor_number=%d, InDoor_number=%d, Colony=%s, State=%s, Municipality=%s, Postal_code=%d WHERE Id_address=%d",
                address.getStreet(), address.getOutDoorNumber(), address.getInDoorNumber(), address.getColony(),
                address.getState(), address.getMunicipality(), address.getPostalCode(), address.getId_address());
        jdbcTemplate.update(sql);
    }
}
