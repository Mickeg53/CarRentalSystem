package com.mx.edu.j2se.GarciaSantamaria;

public interface ClientDaoInterface {
    public ClientPOJO getClient(int clientId);
    void save(ClientPOJO clientPOJO);
    void delete(ClientPOJO clientPOJO);
    void update(ClientPOJO clientPOJO);
}
