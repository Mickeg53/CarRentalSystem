package com.mx.edu.j2se.GarciaSantamaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class CarRentalProjectApplication {

	public static void main(String[] args) {
		//SpringApplication.run(CarRentalProjectApplication.class, args);

		//Connection to database
		String url = "jdbc:mysql://localhost:3306/carrentaldb"; //Need to change the database name
		String userName = "root";
		String password = "123456789";

		Statement stmt;
		ResultSet rs;

		int opt = 1;
        LocalDateTime from = LocalDateTime.parse("2021-04-22T13:00:00");
        LocalDateTime to = LocalDateTime.parse("2021-04-23T13:00:00");

		try {
			Connection connection = DriverManager.getConnection(url, userName, password);

            Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connected to the database");

			stmt = connection.createStatement();

			switch(opt){
				case 1:
					//CASE TO SHOW ALL AVAILABLE CARS BASED ON PARAMETERS ENTERED BY USER(START/END && CLASS)
					rs = stmt.executeQuery("SELECT * FROM car c \n" +
                            "\tLEFT JOIN reservation r USING (License_plate)\n" +
                            "\t\tWHERE (Id_reservation IS NULL OR (r.Start_date > '"+to+"' OR r.Return_date < '"+from+"')) AND c.Class = 'Compact'");
					rs.next();

					do{
						System.out.println("LIST OF ALL CARS AVAILABLE BASED ON START/END && CLASS PARAMETERS");
						System.out.println(rs.getString("License_plate") + "\t Brand: " + rs.getString("Brand") +
								"\t\t Sub_brand: " + rs.getString("Sub_brand")+ "\t Class: " + rs.getString("Class") +
								"\t Year_model: " + rs.getString("Year_model")+ "\t Price: " + rs.getString("Price"));
					}while(rs.next());
				break;

				case 2:
					//CASE TO SHOW THE RESERVATION STATUS BASED ON RESERVATION_ID
					rs = stmt.executeQuery("SELECT r.Id_reservation, r.Start_date, r.Return_date, c.Brand, c.Sub_brand, c.Class, c.Year_model, r.License_plate, c.Price, r.Id_employee FROM reservation r\n" +
							"\tLEFT JOIN car c ON c.License_plate = r.License_plate\n" +
							"\tWHERE r.Id_reservation = '5'");
					rs.next();
					do{
						System.out.println("RESERVATION STATUS");
						System.out.println("ID " + rs.getString("Id_reservation") + "\t FROM: " + rs.getString("Start_date") +
								"\t TO: " + rs.getString("Return_date") + "\t Brand: " + rs.getString("Brand") +
								"\t\t Sub_brand: " + rs.getString("Sub_brand")+ "\t Class: " + rs.getString("Class")
								+ "\t Year_model: " + rs.getString("Year_model")+ "\t License_plate: " + rs.getString("License_plate")
								+ "\t Price: " + rs.getString("Price")+ "\t Employee_ID: " + rs.getString("Id_employee"));
					}while(rs.next());
				break;

			}

		} catch (SQLException | ClassNotFoundException e) {
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
