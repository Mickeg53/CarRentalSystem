package com.mx.edu.j2se.GarciaSantamaria.Objects;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

public class Client {
    private int idClient;
    private String name;
    private String mothersLastName;
    private String lastName;
    private BigDecimal phoneNumber;
    private String email;
    private int idAddress;

    public Client(String name, String mothersLastName, String lastName, BigDecimal phoneNumber, String email, int idAddress) {
        this.name = name;
        this.mothersLastName = mothersLastName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idAddress = idAddress;
    }

    public Client() {

    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMothersLastName() {
        return mothersLastName;
    }

    public void setMothersLastName(String mothersLastName) {
        this.mothersLastName = mothersLastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(BigDecimal phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", name='" + name + '\'' +
                ", mothersLastName='" + mothersLastName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", idAddress=" + idAddress +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getIdClient() == client.getIdClient() && getIdAddress() == client.getIdAddress() && getName().equals(client.getName()) && getMothersLastName().equals(client.getMothersLastName()) && getLastName().equals(client.getLastName()) && getPhoneNumber().equals(client.getPhoneNumber()) && getEmail().equals(client.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdClient(), getName(), getMothersLastName(), getLastName(), getPhoneNumber(), getEmail(), getIdAddress());
    }
}
