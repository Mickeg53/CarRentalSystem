package com.mx.edu.j2se.GarciaSantamaria.ApiDao;

import com.mx.edu.j2se.GarciaSantamaria.Objects.Client;

public interface ClientDao {
    Client getClient(int clientId);
    Client getClient(String name, String mothersLastName, String lastName, String email);
    void save(Client client);
    void delete(int clientId);
    void update(Client client);
}
