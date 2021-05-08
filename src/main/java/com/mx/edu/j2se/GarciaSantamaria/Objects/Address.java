package com.mx.edu.j2se.GarciaSantamaria.Objects;

import java.util.Objects;

public class Address {
    private int idAddress;
    private String street;
    private int outDoorNumber;
    private int inDoorNumber;
    private String colony;
    private String state;
    private String municipality;
    private int postalCode;

    public Address(String street, int outDoorNumber, int inDoorNumber, String colony, String state, String municipality, int postalCode) {
        this.street = street;
        this.outDoorNumber = outDoorNumber;
        this.inDoorNumber = inDoorNumber;
        this.colony = colony;
        this.state = state;
        this.municipality = municipality;
        this.postalCode = postalCode;
    }

    public Address() {

    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getOutDoorNumber() {
        return outDoorNumber;
    }

    public void setOutDoorNumber(int outDoorNumber) {
        this.outDoorNumber = outDoorNumber;
    }

    public int getInDoorNumber() {
        return inDoorNumber;
    }

    public void setInDoorNumber(int inDoorNumber) {
        this.inDoorNumber = inDoorNumber;
    }

    public String getColony() {
        return colony;
    }

    public void setColony(String colony) {
        this.colony = colony;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "idAddress=" + idAddress +
                ", street='" + street + '\'' +
                ", outDoorNumber=" + outDoorNumber +
                ", inDoorNumber=" + inDoorNumber +
                ", colony='" + colony + '\'' +
                ", state='" + state + '\'' +
                ", municipality='" + municipality + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return getIdAddress() == address.getIdAddress() && getOutDoorNumber() == address.getOutDoorNumber() && getInDoorNumber() == address.getInDoorNumber() && getPostalCode() == address.getPostalCode() && getStreet().equals(address.getStreet()) && getColony().equals(address.getColony()) && getState().equals(address.getState()) && Objects.equals(getMunicipality(), address.getMunicipality());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAddress(), getStreet(), getOutDoorNumber(), getInDoorNumber(), getColony(), getState(), getMunicipality(), getPostalCode());
    }
}
