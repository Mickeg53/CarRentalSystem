package com.mx.edu.j2se.GarciaSantamaria;

public interface AddressDaoInterface {
    public AddressPOJO getAddress(int addressId);
    void save(AddressPOJO addressPOJO);
    void delete(AddressPOJO addressPOJO);
    void update(AddressPOJO addressPOJO);
}
