package com.mx.edu.j2se.GarciaSantamaria.ImpDao;

import com.mx.edu.j2se.GarciaSantamaria.ApiDao.ClientDao;
import com.mx.edu.j2se.GarciaSantamaria.RowMappers.ClientMap;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("ClientDao")
public class ClientDaoImpl implements ClientDao {
    private static final Logger logger = LoggerFactory.getLogger(ClientDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Client getClient(int clientId) {
        String sql = String.format("SELECT * FROM client WHERE Id_Client = %d", clientId);

        try{
            return jdbcTemplate.queryForObject(sql, new Object[] {}, new ClientMap());
        }catch(Exception e){
            logger.info("THERE ARE NO EXISTING CLIENT FOR THE ID ENTERED, HANDLING EXCEPTION IN ClientDaoImpl(getClient)");
        }
        return null;
    }

    @Override
    public Client getClient(String name, String lastName, String mothersLastName, String email) {
        String sql = String.format("SELECT * FROM client WHERE Name = '%s' AND Last_name='%s' AND Mothers_last_name='%s' AND Email='%s'", name, lastName, mothersLastName, email);

        try{
            return jdbcTemplate.queryForObject(sql, new Object[] {}, new ClientMap());
        }catch(Exception e){
            logger.info("THERE ARE NO EXISTING CLIENT FOR THE DATA ENTERED, HANDLING EXCEPTION IN ClientDaoImpl(getClient)");
        }
        return null;
    }

    @Override
    public void save(Client client) {
        String sql = String.format("INSERT INTO client (Name, Mothers_last_name, Last_name, Phone_number, Email, Id_address) VALUES ('%s', '%s', '%s', %f, '%s', %d)",
                client.getName(), client.getMothersLastName(), client.getLastName(), client.getPhoneNumber(),
                client.getEmail(), client.getIdAddress());
        try{
            jdbcTemplate.update(sql);
        }catch (Exception e){
            logger.info("THERE WAS AN ERROR DURING THE SAVE OF CLIENT, HANDLING EXCEPTION IN ClientDaoImpl(save)");
        }
    }

    @Override
    public void delete(int clientId) {
        String sql = String.format("DELETE FROM client WHERE Id_client= %d", clientId);
        try{
            jdbcTemplate.update(sql);
        }catch (Exception e){
            logger.info("THERE WAS AN ERROR DURING THE DELETE OF CLIENT, HANDLING EXCEPTION IN ClientDaoImpl(delete)");
        }
    }

    @Override
    public void update(Client client) {
        String sql = String.format("UPDATE client SET Phone_number=%f, Email='%s', Id_address=%d WHERE Id_client=%d",
                client.getPhoneNumber(), client.getEmail(), client.getIdAddress(), client.getIdClient());
        try{
            jdbcTemplate.update(sql);
        }catch (Exception e){
            logger.info("THERE WAS AN ERROR DURING THE UPDATE OF CLIENT, HANDLING EXCEPTION IN ClientDaoImpl(update)");
        }
    }
}
