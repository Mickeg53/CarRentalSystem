package com.mx.edu.j2se.GarciaSantamaria.ApiDao;

import com.mx.edu.j2se.GarciaSantamaria.Objects.Address;

public interface AddressDao {
    Address getAddress(int addressId);
    void save(Address address);
    void delete(int addressId);
    void update(Address address);
}
