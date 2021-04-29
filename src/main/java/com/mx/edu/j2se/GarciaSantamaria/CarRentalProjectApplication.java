package com.mx.edu.j2se.GarciaSantamaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@RestController
public class CarRentalProjectApplication {

    public interface CarDaoInterface{
        public List<CarPOJO> getAllCarsAvailable(LocalDateTime startTime, LocalDateTime returnTime, String classs);
        void save(CarPOJO carPOJO);
        void delete(CarPOJO carPOJO);
		void update(CarPOJO carPOJO);
    }

	public interface ReservDaoInterface{
		public List<ReservationPOJO> getReservationStatus(int reservationId);
		void save(ReservationPOJO reservationPOJO);
		void delete(ReservationPOJO reservationPOJO);
		void update(ReservationPOJO reservationPOJO);
	}

	public interface ClientDaoInterface{
		public ClientPOJO getClient(int clientId);
		void save(ClientPOJO clientPOJO);
		void delete(ClientPOJO clientPOJO);
		void update(ClientPOJO clientPOJO);
	}

	public interface EmployeeDaoInterface{
		public EmployeePOJO getEmployee(int employeeId);
		void save(EmployeePOJO employeePOJO);
		void delete(EmployeePOJO employeePOJO);
		void update(EmployeePOJO employeePOJO);
	}

	public interface AddresDaoInterface{
		public AddressPOJO getAddress(int addressId);
		void save(AddressPOJO addressPOJO);
		void delete(AddressPOJO addressPOJO);
		void update(AddressPOJO addressPOJO);
	}

	public static void main(String[] args) {
		//SpringApplication.run(CarRentalProjectApplication.class, args);

		//Connection to database
		String url = "jdbc:mysql://localhost:3306/carrentaldb";
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
				case 2:

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
