package com.mx.edu.j2se.GarciaSantamaria.Interfaces;

import com.mx.edu.j2se.GarciaSantamaria.POJOs.ClientPOJO;

public interface ClientDaoInterface {
    public ClientPOJO getClient(int clientId);
    boolean save(ClientPOJO clientPOJO);
    boolean delete(ClientPOJO clientPOJO);
    boolean update(ClientPOJO clientPOJO);
}
