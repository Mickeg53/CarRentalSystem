package com.mx.edu.j2se.GarciaSantamaria.Controllers;

import com.mx.edu.j2se.GarciaSantamaria.ImpDao.AddressDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.ImpDao.ClientDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Address;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.math.BigDecimal;


@Controller
public class ClientController {

    @Autowired
    private ClientDaoImpl clientDaoImpl;

    @Autowired
    private AddressDaoImpl addressDaoImpl;

    //ONLY FOR RETURN THE WELCOME PAGE
    @RequestMapping(value = "/")
    public String index(Model model){
        String name = "Miguel García Santamaría";
        model.addAttribute("myNameValue", name);
        return"loginView";
    }
    @RequestMapping(value = "/getClient")
    public String getClient(String email, int clientId, Model model){
        Client clientTempPojo = clientDaoImpl.getClient(clientId);
        String message = "";

        if(clientTempPojo.getEmail().equals(email)){
            message =String.format("NICE TO SEE YOU HERE, %s %s !", clientTempPojo.getName(), clientTempPojo.getLastName());
            model.addAttribute("clientMessage", message);
            return "clientMenuView";
        }else{
            message = "***THE DATA PROVIDED IS INCORRECT, PLEASE TRY AGAIN***";
            model.addAttribute("clientMessage", message);
            return "loginView";
        }
    }

    @RequestMapping(path = "/SignupView")
    public String save() {
        return "signupView";
    }
    @RequestMapping(path = "/saveClient")
    public String saveClient(String name, String lastName, String mothersLastName, String email, BigDecimal phoneNumber,
                             String street, int outDoorNumber, int inDoorNumber, String colony, String state,
                             String municipality, int postalCode, Model model) throws InterruptedException {

        Address address = new Address(street, outDoorNumber, inDoorNumber, colony, state, municipality, postalCode);
        this.addressDaoImpl.save(address);

        int idAddress = this.addressDaoImpl.getAddress(street, outDoorNumber, colony, state, postalCode).getId_address();

        Client client = new Client(name, mothersLastName, lastName, phoneNumber, email, idAddress);
        this.clientDaoImpl.save(client);

        int clientId = this.clientDaoImpl.getClient(name, lastName, mothersLastName, email).getId_client();
        String message = String.format("*****YOUR SIGNUP HAS BEEN SUCESSFUL***** \n Client ID: %d",clientId );
        model.addAttribute("messageSignup", message);
        return "signupView";
    }
}
