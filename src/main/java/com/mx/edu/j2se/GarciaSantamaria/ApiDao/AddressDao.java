package com.mx.edu.j2se.GarciaSantamaria.ApiDao;

import com.mx.edu.j2se.GarciaSantamaria.Objects.Address;

public interface AddressDao {
    Address getAddress(int addressId);
    Address getAddress(String street, int outdoorNumber, String colony, String state, int postalCode);
    void save(Address address);
    void delete(int addressId);
    void update(Address address);
}
