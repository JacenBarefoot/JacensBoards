package com.company;
import java.util.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String action = "let's get this working";
        Scanner string = new Scanner(System.in);
        System.out.println("Hello there!");
        System.out.println("Welcome to JacensSkateboards!");
        System.out.println("What would you like to do?");
        while (!action.equals("quit")) {
            System.out.println("You can [create account], [browse] shop, [create skateboard], [order], or [quit]");
            action = string.nextLine();
            switch (action) {
                case "create account":
                    createAccount();
                    break;
                case "browse":
                    browse();
                    break;
                case "create skateboard":
                    createSkateboard();
                    break;
                case "quit":
                    break;
            }
        }
    }
    public static void createAccount() {
        Scanner input = new Scanner(System.in);
        Scanner numb = new Scanner(System.in);
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Phone number: ");
        Long phoneNumber = numb.nextLong();
        System.out.print("Address: ");
        String address = input.nextLine();
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                PreparedStatement stmt = connection.prepareStatement("INSERT INTO CUSTOMERS (name, email, phone, address) VALUES (?, ?, ?, ?)")
        ) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setLong(3, phoneNumber);
            stmt.setString(4, address);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("---Account added successfully---");
    }
    public static void createSkateboard() {
        Scanner input = new Scanner(System.in);
        Scanner numb = new Scanner(System.in);
        System.out.print("Board Brand: ");
        String boardBrand = input.nextLine();
        System.out.print("Board Size: ");
        Float boardSize = numb.nextFloat();
        System.out.print("Wheel Size: ");
        int wheelSize = numb.nextInt();
        System.out.print("Wheel Color: ");
        String wheelColor = input.nextLine();
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                PreparedStatement stmt = connection.prepareStatement("INSERT INTO BOARDS (boardBrand, boardSize, wheelSize, wheelColor) VALUES (?, ?, ?, ?)")
        ) {
            stmt.setString(1, boardBrand);
            stmt.setFloat(2, boardSize);
            stmt.setInt(3, wheelSize);
            stmt.setString(4, wheelColor);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void browse() {
        Scanner string = new Scanner(System.in);
        System.out.println("What would you like to browse? [Boards], [Shoes], or [Backpacks]");
        String action = string.nextLine();
        switch(action) {
            case "Boards":
                try {
                    Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                    Statement st = connection.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM BOARDS");
                    while (rs.next())
                    {
                        System.out.print(rs.getInt("id") + "." + "Brand name: " + rs.getString("boardBrand") + " |");
                        System.out.print(" Board Size: " + rs.getString("boardSize") + " |");
                        System.out.print(" Wheel Size: " + rs.getString("wheelSize") + " |");
                        System.out.println(" Wheel Color: " + rs.getString("wheelColor"));
                        System.out.println("------------------------------------------------------------------------------------");
                    }
                    rs.close();
                    st.close();
                } catch(SQLException e){
                        e.printStackTrace();
                }
            case "Shoes":
                try {
                    Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                    Statement st = connection.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM SHOES");
                    while (rs.next())
                    {
                        System.out.print(rs.getInt("id") + "." + "Brand name: " + rs.getString("shoeBrand") + " |");
                        System.out.print(" Shoe Type: " + rs.getString("shoeType") + " |");
                        System.out.print(" Shoe Size: " + rs.getString("shoeSize") + " |");
                        System.out.println(" Shoe Color: " + rs.getString("shoeColor"));
                        System.out.println("------------------------------------------------------------------------------------");
                    }
                    rs.close();
                    st.close();
                } catch(SQLException e){
                    e.printStackTrace();
                }

        }
    }
}
// Make sure to create the backpack table in schema
// Make sure to make the order system, adding lists to an Order ArrayList
// Maybe custom shoes