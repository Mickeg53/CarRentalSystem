package com.mx.edu.j2se.GarciaSantamaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
@RestController
public class CarRentalProjectApplication {

	public static void main(String[] args) {
		//SpringApplication.run(CarRentalProjectApplication.class, args);

		//Connection to database
		String url = "jdbc:mysql://localhost:3306/carrentaldb"; //Need to change the database name
		String userName = "root";
		String password = "123456789";


		try {
			Connection connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Connected to the database");

		} catch (SQLException e) {
			System.out.println("Database connection error !!");
			e.printStackTrace();
		}
	}

	//Test of the springBootApplication

	/*@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}*/
}
