package com.mx.edu.j2se.GarciaSantamaria.Controllers;

import com.mx.edu.j2se.GarciaSantamaria.ImpDao.ClientDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientController {

    @Autowired
    private ClientDaoImpl clientDaoImpl;

    //ONLY FOR RETURN THE WELCOME PAGE
    @RequestMapping(value = "/")
    public String index(Model model){
        String name = "Miguel García Santamaría";
        model.addAttribute("myNameValue", name);
        return"index";
    }
    @RequestMapping(value = "/getClient")
    public String getClient(String email, int clientId, Model model){
        Client clientTempPojo = clientDaoImpl.getClient(clientId);
        String message = "";

        if(clientTempPojo.getEmail().equals(email)){
            message =String.format("NICE TO SEE YOU HERE, %s %s !", clientTempPojo.getName(), clientTempPojo.getLastName());
            model.addAttribute("clientMessage", message);
            return "clientMenu";
        }else{
            message =String.format("THE DATA PROVIDED IS INCORRECT, PLEASE TRY AGAIN", clientTempPojo.getName(), clientTempPojo.getLastName());
            model.addAttribute("clientMessage", message);
        }
        return null;
    }
}
