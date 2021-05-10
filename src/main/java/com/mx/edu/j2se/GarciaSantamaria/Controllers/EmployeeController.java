package com.mx.edu.j2se.GarciaSantamaria.Controllers;

import com.mx.edu.j2se.GarciaSantamaria.ImpDao.EmployeeDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.ImpDao.ReservationDaoImpl;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDaoImpl employeeDaoImpl;

    @RequestMapping(path = "/employeeVerification")
    public String getEmployee(int employeeId, String email, Model model) {
        Employee employee;
        String verificationFailedMessage;
        String verificationSucessful;

        try{
            employee = this.employeeDaoImpl.getEmployee(employeeId);
        }catch(Exception e){
            verificationFailedMessage = "***INVALID EMPLOYEE DATA, PLEASE TRY AGAIN***";
            model.addAttribute("verifFailedMessage", verificationFailedMessage);
            return "reservationStatusView";
        }

        if(employee.getEmail().equals(email)) {
            verificationSucessful = "VERIFICATION SUCESSFUL, CLICK TO RETURN CAR";
            model.addAttribute("verifSucessful", verificationSucessful);
        }else{
            verificationFailedMessage = "***INVALID EMPLOYEE DATA, PLEASE TRY AGAIN***";
            model.addAttribute("verifFailedMessage", verificationFailedMessage);
        }
        return "reservationStatusView";
    }
}
