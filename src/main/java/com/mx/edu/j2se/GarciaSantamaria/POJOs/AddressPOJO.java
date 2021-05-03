package com.mx.edu.j2se.GarciaSantamaria.POJOs;

public class AddressPOJO {
    private int Id_address;
    private String Street;
    private int OutDoorNumber;
    private int InDoorNumber;
    private String Colony;
    private String State;
    private String Municipality;
    private int PostalCode;

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

    public AddressPOJO() {

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

    @Override
    public String toString() {
        return "AddressPOJO{" +
                "Id_address=" + Id_address +
                ", Street='" + Street + '\'' +
                ", OutDoorNumber=" + OutDoorNumber +
                ", InDoorNumber=" + InDoorNumber +
                ", Colony='" + Colony + '\'' +
                ", State='" + State + '\'' +
                ", Municipality='" + Municipality + '\'' +
                ", PostalCode=" + PostalCode +
                '}';
    }
}
