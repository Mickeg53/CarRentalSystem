package com.mx.edu.j2se.GarciaSantamaria;

public class AddressPOJO {
    int Id_address;
    String Street;
    int OutDoorNumber;
    int InDoorNumber;
    String Colony;
    String State;
    String Municipality;
    int PostalCode;

    public AddressPOJO(int id_address, String street, int outDoorNumber, int inDoorNumber, String colony, String state, String municipality, int postalCode) {
        this.Id_address = id_address;
        this.Street = street;
        this.OutDoorNumber = outDoorNumber;
        this.InDoorNumber = inDoorNumber;
        this.Colony = colony;
        this.State = state;
        this.Municipality = municipality;
        this.PostalCode = postalCode;
    }

    public int getId_address() {
        return Id_address;
    }

    public void setId_address(int id_address) {
        Id_address = id_address;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public int getOutDoorNumber() {
        return OutDoorNumber;
    }

    public void setOutDoorNumber(int outDoorNumber) {
        OutDoorNumber = outDoorNumber;
    }

    public int getInDoorNumber() {
        return InDoorNumber;
    }

    public void setInDoorNumber(int inDoorNumber) {
        InDoorNumber = inDoorNumber;
    }

    public String getColony() {
        return Colony;
    }

    public void setColony(String colony) {
        Colony = colony;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getMunicipality() {
        return Municipality;
    }

    public void setMunicipality(String municipality) {
        Municipality = municipality;
    }

    public int getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(int postalCode) {
        PostalCode = postalCode;
    }
}
