package com.mx.edu.j2se.GarciaSantamaria.Interfaces;

import com.mx.edu.j2se.GarciaSantamaria.POJOs.AddressPOJO;

public interface AddressDaoInterface {
    public AddressPOJO getAddress(int addressId);
    boolean save(AddressPOJO addressPOJO);
    boolean delete(AddressPOJO addressPOJO);
    boolean update(AddressPOJO addressPOJO);
}
