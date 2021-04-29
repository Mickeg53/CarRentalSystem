package com.mx.edu.j2se.GarciaSantamaria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDaoImpl implements CarRentalProjectApplication.ReservDaoInterface {
    //Connection to database
    String url = "jdbc:mysql://localhost:3306/carrentaldb";
    String userName = "root";
    String password = "123456789";

    Statement stmt;
    ResultSet rs;

    @Override
    public List<ReservationPOJO> getReservationStatus(int reservationId) {
        List<ReservationPOJO> reservationPOJOS;
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected to the database");

            stmt = connection.createStatement();

            //CASE TO SHOW THE RESERVATION STATUS BASED ON RESERVATION_ID
            rs = stmt.executeQuery("SELECT r.Id_reservation, r.Start_date, r.Return_date, c.Brand, c.Sub_brand, c.Class, c.Year_model, r.License_plate, c.Price, r.Id_employee FROM reservation r\n" +
                    "\tLEFT JOIN car c ON c.License_plate = r.License_plate\n" +
                    "\tWHERE r.Id_reservation = '"+reservationId+"'");
            rs.next();
            reservationPOJOS = new ArrayList<ReservationPOJO>();
            do{
                //Printing
                System.out.println("RESERVATION STATUS");
                System.out.println("ID " + rs.getString("Id_reservation") + "\t FROM: " + rs.getString("Start_date") +
                        "\t TO: " + rs.getString("Return_date") + "\t Brand: " + rs.getString("Brand") +
                        "\t\t Sub_brand: " + rs.getString("Sub_brand")+ "\t Class: " + rs.getString("Class")
                        + "\t Year_model: " + rs.getString("Year_model")+ "\t License_plate: " + rs.getString("License_plate")
                        + "\t Price: " + rs.getString("Price")+ "\t Employee_ID: " + rs.getString("Id_employee"));

                //Creating new POJOS to add at the list
                ReservationPOJO newReservationPOJO = new ReservationPOJO(rs.getInt("Id_reservation"), rs.getDate("Start_date"),
                        rs.getDate("Return_date"), rs.getString("License_plate"), rs.getInt("Id_employee"),
                        rs.getInt("Id_client"));

                //Adding new POJOS at the list of reservationPOJOS to return it
                reservationPOJOS.add(newReservationPOJO);

            }while(rs.next());

            return reservationPOJOS;

            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Database connection error !!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(ReservationPOJO reservationPOJO) {

    }

    @Override
    public void delete(ReservationPOJO reservationPOJO) {

    }

    @Override
    public void update(ReservationPOJO reservationPOJO) {

    }
}
