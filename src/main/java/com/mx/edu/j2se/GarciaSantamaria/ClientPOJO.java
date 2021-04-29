package com.mx.edu.j2se.GarciaSantamaria;

import java.math.BigInteger;

public class ClientPOJO {
    int Id_client;
    String Name;
    String MothersLastName;
    String LastName;
    BigInteger PhoneNumber;
    String Email;
    int Id_address;

    ClientPOJO(int id_client, String name, String mothersLastName, String lastName, BigInteger phoneNumber, String email, int id_address) {
        this.Id_client = id_client;
        this.Name = name;
        this.MothersLastName = mothersLastName;
        this.LastName = lastName;
        this.PhoneNumber = phoneNumber;
        this.Email = email;
        this.Id_address = id_address;
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

    public BigInteger getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(BigInteger phoneNumber) {
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
}
