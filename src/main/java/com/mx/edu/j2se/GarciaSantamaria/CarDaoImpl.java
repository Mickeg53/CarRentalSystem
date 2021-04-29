package com.mx.edu.j2se.GarciaSantamaria;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarRentalProjectApplication.CarDaoInterface {
    //Connection to database
    String url = "jdbc:mysql://localhost:3306/carrentaldb";
    String userName = "root";
    String password = "123456789";

    Statement stmt;
    ResultSet rs;

    @Override
    public List<CarPOJO> getAllCarsAvailable(LocalDateTime startTime, LocalDateTime returnTime, String classs) {
        List<CarPOJO> Cars;
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected to the database");

            stmt = connection.createStatement();

            rs = stmt.executeQuery("SELECT * FROM car c \n" +
                    "\tLEFT JOIN reservation r USING (License_plate)\n" +
                    "\t\tWHERE (Id_reservation IS NULL OR (r.Start_date > '"+returnTime+"' OR r.Return_date < '"+startTime+"')) AND c.Class = '"+classs+"'");
            rs.next();
            Cars = new ArrayList<CarPOJO>();
            do{
                System.out.println("LIST OF ALL CARS AVAILABLE BASED ON START/END && CLASS PARAMETERS");
                System.out.println(rs.getString("License_plate") + "\t Brand: " + rs.getString("Brand") +
                        "\t\t Sub_brand: " + rs.getString("Sub_brand")+ "\t Class: " + rs.getString("Class") +
                        "\t Year_model: " + rs.getString("Year_model")+ "\t Price: " + rs.getString("Price"));

                CarPOJO car = new CarPOJO(rs.getString("License_plate"), rs.getString("Brand"), rs.getString("Sub_brand"),
                        rs.getString("Class"), rs.getInt("Year_model"), rs.getDouble("Price"));

                Cars.add(car);
            }while(rs.next());

            connection.close();
            return Cars;

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Database connection error !!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(CarPOJO carPOJO) {

    }

    @Override
    public void delete(CarPOJO carPOJO) {

    }

    @Override
    public void update(CarPOJO carPOJO) {

    }
}
