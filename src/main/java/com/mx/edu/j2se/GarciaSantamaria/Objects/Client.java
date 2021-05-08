package com.mx.edu.j2se.GarciaSantamaria.Objects;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

public class Client {
    private int Id_client;
    private String Name;
    private String MothersLastName;
    private String LastName;
    private BigDecimal PhoneNumber;
    private String Email;
    private int Id_address;

    public Client(String name, String mothersLastName, String lastName, BigDecimal phoneNumber, String email, int id_address) {
        this.Name = name;
        this.MothersLastName = mothersLastName;
        this.LastName = lastName;
        this.PhoneNumber = phoneNumber;
        this.Email = email;
        this.Id_address = id_address;
    }

    public Client() {

    }

    public int getId_client() {
        return Id_client;
    }

    public void setId_client(int id_client) {
        Id_client = id_client;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMothersLastName() {
        return MothersLastName;
    }

    public void setMothersLastName(String mothersLastName) {
        MothersLastName = mothersLastName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public BigDecimal getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(BigDecimal phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getId_address() {
        return Id_address;
    }

    public void setId_address(int id_address) {
        Id_address = id_address;
    }

    @Override
    public String toString() {
        return "ClientPOJO{" +
                "Id_client=" + Id_client +
                ", Name='" + Name + '\'' +
                ", MothersLastName='" + MothersLastName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                ", Email='" + Email + '\'' +
                ", Id_address=" + Id_address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getId_client() == client.getId_client() && getId_address() == client.getId_address() && getName().equals(client.getName()) && Objects.equals(getMothersLastName(), client.getMothersLastName()) && getLastName().equals(client.getLastName()) && getPhoneNumber().equals(client.getPhoneNumber()) && getEmail().equals(client.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_client(), getName(), getMothersLastName(), getLastName(), getPhoneNumber(), getEmail(), getId_address());
    }
}
