package com.mx.edu.j2se.GarciaSantamaria.ImpDao;

import com.mx.edu.j2se.GarciaSantamaria.ApiDao.ClientDao;
import com.mx.edu.j2se.GarciaSantamaria.RowMappers.ClientMap;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("ClientDao")
public class ClientDaoImpl implements ClientDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Client getClient(int clientId) {
        String sql = String.format("SELECT * FROM client WHERE Id_Client = %d", clientId);
        return jdbcTemplate.queryForObject(sql, new Object[] {}, new ClientMap());
    }

    @Override
    public void save(Client client) {
        String sql = String.format("INSERT INTO client (Name, Mothers_last_name, Last_name, Phone_number, Email, Id_address) VALUES (%s, %s, %s, %f, %s, %d)",
                client.getName(), client.getMothersLastName(), client.getLastName(), client.getPhoneNumber(),
                client.getEmail(), client.getId_address());
        jdbcTemplate.update(sql);
    }

    @Override
    public void delete(int clientId) {
        String sql = String.format("DELETE FROM client WHERE Id_client= %d", clientId);
        jdbcTemplate.update(sql);
    }

    @Override
    public void update(Client client) {
        String sql = String.format("UPDATE client SET Phone_number=%f, Email=%s, Id_address=%d WHERE Id_client=%d",
                client.getPhoneNumber(), client.getEmail(), client.getId_address(), client.getId_client());
        jdbcTemplate.update(sql);
    }
}
