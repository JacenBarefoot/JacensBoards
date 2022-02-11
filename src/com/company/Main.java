package com.company;
import java.util.*;
import java.sql.*;

public class Main {
    public static List<String> order = new ArrayList<>();

    public static void main(String[] args) {
        List<String> order = new ArrayList<>();

        String action = "let's get this working";
        Scanner string = new Scanner(System.in);
        System.out.println("Hello there!");
        System.out.println("Welcome to JacensSkateboards!");
        System.out.println("What would you like to do?");
        while (!action.equals("quit")) {
            System.out.println("You can: [browse] shop, [create skateboard], [cart], or [quit]");
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
                case "cart":
                    order();
                    break;
                case "quit":
                    break;
                default:
                    System.out.println("Please choose a valid option!!!");
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
                PreparedStatement stmt = connection.prepareStatement("INSERT INTO BOARDS (boardBrand, boardSize, wheelSize, wheelColor, price) VALUES (?, ?, ?, ?, ?)")
        ) {
            stmt.setString(1, boardBrand);
            stmt.setFloat(2, boardSize);
            stmt.setInt(3, wheelSize);
            stmt.setString(4, wheelColor);
            stmt.setFloat(5, (float)79.99);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void order() {
        Iterator<String> variable = order.iterator();
        float total = 0;
        System.out.println("-----------------------------------");
        while (variable.hasNext()){
            Object e = variable.next();
            System.out.println(e);
            String a = e.toString();
            System.out.println("---------------------------------");
            total += Float.parseFloat(a.substring(a.indexOf("$") + 1, a.indexOf("$") + 6).trim());
        }
        System.out.print("Total: $" + total);
        System.out.println();
    }
    public static void browse() {
        Scanner string = new Scanner(System.in);
        System.out.println("What would you like to browse? [boards], [shoes], [clothing], [backpacks], [hats], [helmets], or [go back]");
        String action = string.nextLine();
        switch(action) {
            case "clothing":
                String action1;
                do {
                    System.out.println("Choose from one of these: [shirts], [pants], [hoodies], [socks], or [go back]");
                    action1 = string.nextLine();
                    switch (action1) {
                        case "shirts":
                            Scanner number = new Scanner(System.in);
                            try {
                                Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                                Statement st = connection.createStatement();
                                ResultSet rs = st.executeQuery("SELECT * FROM SHIRTS");
                                while (rs.next()) {
                                    System.out.print(rs.getInt("id") + "." + " Brand name: " + rs.getString("shirtBrand") + " |");
                                    System.out.print(" Shirt Type: " + rs.getString("shirtType") + " |");
                                    System.out.print(" Shirt Size: " + rs.getString("shirtSize") + " |");
                                    System.out.println(" Shirt Color: " + rs.getString("shirtColor"));
                                    System.out.println("------------------------------------------------------------------------------------");
                                }
                                rs.close();
                                st.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            System.out.println("What would like to order? or type [100] to quit");
                            System.out.print("> ");
                            int itemNum1 = number.nextInt();
                            if (itemNum1 == 100) {
                                browse();
                            } else if (itemNum1 >= 1 && itemNum1 <= 60) {
                                try {
                                    Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                                    PreparedStatement st = connection.prepareStatement("SELECT * FROM SHIRTS WHERE id = ?");
                                    st.setInt(1, itemNum1);
                                    ResultSet rs = st.executeQuery();
                                    while (rs.next()) {
                                        double price = Double.parseDouble(rs.getString("price"));
                                        Formatter formatter = new Formatter();
                                        formatter.format("%.2f", price);
                                        order.add(rs.getString("shirtBrand") + " Shirt" + " | $" + formatter + " | ");
                                    }
                                    rs.close();
                                    st.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("---Added to Cart Successfully---");
                                browse();
                            }
                            break;
                        case "pants":
                            Scanner number2 = new Scanner(System.in);
                            try {
                                Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                                Statement st = connection.createStatement();
                                ResultSet rs = st.executeQuery("SELECT * FROM PANTS");
                                while (rs.next()) {
                                    System.out.print(rs.getInt("id") + "." + " Brand name: " + rs.getString("pantsBrand") + " |");
                                    System.out.print(" Pants Type: " + rs.getString("pantsType") + " |");
                                    System.out.print(" Pants Size: " + rs.getString("pantsSize") + " |");
                                    System.out.println(" Pants Color: " + rs.getString("pantsColor"));
                                    System.out.println("------------------------------------------------------------------------------------");
                                }
                                rs.close();
                                st.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            System.out.println("What would like to order? or type [100] to quit");
                            System.out.print("> ");
                            int itemNum2 = number2.nextInt();
                            if (itemNum2 == 100) {
                                browse();
                            } else if (itemNum2 >= 1 && itemNum2 <= 60) {
                                try {
                                    Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                                    PreparedStatement st = connection.prepareStatement("SELECT * FROM PANTS WHERE id = ?");
                                    st.setInt(1, itemNum2);
                                    ResultSet rs = st.executeQuery();
                                    while (rs.next()) {
                                        double price = Double.parseDouble(rs.getString("price"));
                                        Formatter formatter = new Formatter();
                                        formatter.format("%.2f", price);
                                        order.add(rs.getString("pantsBrand") + " Pants" + " | $" + formatter + " | ");
                                    }
                                    rs.close();
                                    st.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("---Added to Cart Successfully---");
                                browse();
                            }
                        case "hoodies":
                            Scanner number3 = new Scanner(System.in);
                            try {
                                Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                                Statement st = connection.createStatement();
                                ResultSet rs = st.executeQuery("SELECT * FROM HOODIES");
                                while (rs.next()) {
                                    System.out.print(rs.getInt("id") + "." + " Brand name: " + rs.getString("hoodieBrand") + " |");
                                    System.out.print(" Hoodie Size: " + rs.getString("hoodieSize") + " |");
                                    System.out.println(" Hoodie Color: " + rs.getString("hoodieColor") + " |");
                                    System.out.println("------------------------------------------------------------------------------------");
                                }
                                rs.close();
                                st.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            System.out.println("What would like to order? or type [100] to quit");
                            System.out.print("> ");
                            int itemNum3 = number3.nextInt();
                            if (itemNum3 == 100) {
                                browse();
                            } else if (itemNum3 >= 1 && itemNum3 <= 60) {
                                try {
                                    Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                                    PreparedStatement st = connection.prepareStatement("SELECT * FROM HOODIES WHERE id = ?");
                                    st.setInt(1, itemNum3);
                                    ResultSet rs = st.executeQuery();
                                    while (rs.next()) {
                                        double price = Double.parseDouble(rs.getString("price"));
                                        Formatter formatter = new Formatter();
                                        formatter.format("%.2f", price);
                                        order.add(rs.getString("hoodieBrand") + " Hoodie" + " | $" + formatter + " | ");
                                    }
                                    rs.close();
                                    st.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("---Added to Cart Successfully---");
                                browse();
                            }
                        case "socks":
                            Scanner number4 = new Scanner(System.in);
                            try {
                                Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                                Statement st = connection.createStatement();
                                ResultSet rs = st.executeQuery("SELECT * FROM SOCKS");
                                while (rs.next()) {
                                    System.out.print(rs.getInt("id") + "." + " Brand name: " + rs.getString("socksBrand") + " |");
                                    System.out.print(" Socks Size: " + rs.getString("socksSize") + " |");
                                    System.out.println(" Socks Color: " + rs.getString("socksColor") + " |");
                                    System.out.println("------------------------------------------------------------------------------------");
                                }
                                rs.close();
                                st.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            System.out.println("What would like to order? or type [100] to quit");
                            System.out.print("> ");
                            int itemNum4 = number4.nextInt();
                            if (itemNum4 == 100) {
                                browse();
                            } else if (itemNum4 >= 1 && itemNum4 <= 60) {
                                try {
                                    Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                                    PreparedStatement st = connection.prepareStatement("SELECT * FROM SOCKS WHERE id = ?");
                                    st.setInt(1, itemNum4);
                                    ResultSet rs = st.executeQuery();
                                    while (rs.next()) {
                                        double price = Double.parseDouble(rs.getString("price"));
                                        Formatter formatter = new Formatter();
                                        formatter.format("%.2f", price);
                                        order.add(rs.getString("socksBrand") + " Socks" + " | $" + formatter + " | ");
                                    }
                                    rs.close();
                                    st.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("---Added to Cart Successfully---");
                                browse();
                            }
                        case "go back":
                            break;
                        default:
                            System.out.println("Please choose a valid option above!!!");
                            browse();
                    }
                } while (!action1.equals("go back"));
                break;
            case "boards":
                Scanner num = new Scanner(System.in);
                try {
                    Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                    Statement st = connection.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM BOARDS");
                    while (rs.next()) {
                        System.out.print(rs.getInt("id") + "." + " Brand name: " + rs.getString("boardBrand") + " |");
                        System.out.print(" Board Size: " + rs.getString("boardSize") + "in |");
                        System.out.print(" Wheel Size: " + rs.getString("wheelSize") + "cm |");
                        System.out.println(" Wheel Color: " + rs.getString("wheelColor"));
                        System.out.println("------------------------------------------------------------------------------------");
                    }
                    rs.close();
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println("What would like to order? or type [100] to quit");
                System.out.print("> ");
                int itemNumb = num.nextInt();
                if (itemNumb == 100) {
                    browse();
                } else if (itemNumb >= 1 && itemNumb <= 60) {
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                        PreparedStatement st = connection.prepareStatement("SELECT * FROM BOARDS WHERE id = ?");
                        st.setInt(1, itemNumb);
                        ResultSet rs = st.executeQuery();
                        while (rs.next()) {
                            double price = Double.parseDouble(rs.getString("price"));
                            Formatter formatter = new Formatter();
                            formatter.format("%.2f", price);
                            order.add(rs.getString("boardBrand") + " Board " + " | $" + formatter + " | ");
                        }
                        rs.close();
                        st.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.out.println("---Added to Cart Successfully---");
                    browse();
                }
                break;
            case "shoes":
                Scanner i = new Scanner(System.in);
                try {
                    Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                    Statement st = connection.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM SHOES");
                    while (rs.next()) {
                        System.out.print(rs.getInt("id") + "." + " Brand name: " + rs.getString("shoeBrand") + " |");
                        System.out.print(" Shoe Type: " + rs.getString("shoeType") + " |");
                        System.out.print(" Shoe Size: " + rs.getString("shoeSize") + "in |");
                        System.out.println(" Shoe Color: " + rs.getString("shoeColor"));
                        System.out.println("------------------------------------------------------------------------------------");
                    }
                    rs.close();
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println("What would like to order? or type [100] to quit");
                System.out.print("> ");
                int itemNumber = i.nextInt();
                if (itemNumber == 100) {
                    browse();
                } else if (itemNumber >= 1 && itemNumber <= 60) {
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                        PreparedStatement st = connection.prepareStatement("SELECT * FROM SHOES WHERE id = ?");
                        st.setInt(1, itemNumber);
                        ResultSet rs = st.executeQuery();
                        while (rs.next()) {
                            double price = Double.parseDouble(rs.getString("price"));
                            Formatter formatter = new Formatter();
                            formatter.format("%.2f", price);
                            order.add(rs.getString("shoeBrand") + " Shoes" + " | $" + formatter + " | ");
                        }
                        rs.close();
                        st.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.out.println("---Added to Cart Successfully---");
                    browse();
                }
                break;
            case "backpacks":
                Scanner number = new Scanner(System.in);

                try {
                    Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                    Statement st = connection.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM BACKPACKS");
                    while (rs.next()) {
                        System.out.print(rs.getInt("id") + "." + " Brand name: " + rs.getString("bagBrand") + " |");
                        System.out.print(" Backpack Size: " + rs.getString("bagSize") + " |");
                        System.out.print(" Backpack Color: " + rs.getString("bagColor") + " |");
                        System.out.println(" Waterproof: " + rs.getString("isWaterproof"));
                        System.out.println("------------------------------------------------------------------------------------");
                    }
                    rs.close();
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println("What would like to order? or type [100] to quit");
                System.out.print("> ");
                int itemNum = number.nextInt();
                if (itemNum == 100) {
                    browse();
                } else if (itemNum >= 1 && itemNum <= 60) {
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                        PreparedStatement st = connection.prepareStatement("SELECT * FROM BACKPACKS WHERE id = ?");
                        st.setInt(1, itemNum);
                        ResultSet rs = st.executeQuery();
                        while (rs.next()) {
                            double price = Double.parseDouble(rs.getString("price"));
                            Formatter formatter = new Formatter();
                            formatter.format("%.2f", price);
                            order.add(rs.getString("bagBrand") + " Backpack" + " | $" + formatter + " | ");
                        }
                        rs.close();
                        st.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.out.println("---Added to Cart Successfully---");
                    browse();
                }
                break;
            case "hats":
                Scanner number5 = new Scanner(System.in);

                try {
                    Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                    Statement st = connection.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM HATS");
                    while (rs.next()) {
                        System.out.print(rs.getInt("id") + "." + " Brand name: " + rs.getString("hatsBrand") + " |");
                        System.out.print(" Hat Type: " + rs.getString("hatsType") + " |");
                        System.out.println(" Hat Color: " + rs.getString("hatsColor") + " |");
                        System.out.println("------------------------------------------------------------------------------------");
                    }
                    rs.close();
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println("What would like to order? or type [100] to quit");
                System.out.print("> ");
                int itemNum5 = number5.nextInt();
                if (itemNum5 == 100) {
                    browse();
                } else if (itemNum5 >= 1 && itemNum5 <= 60) {
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                        PreparedStatement st = connection.prepareStatement("SELECT * FROM HATS WHERE id = ?");
                        st.setInt(1, itemNum5);
                        ResultSet rs = st.executeQuery();
                        while (rs.next()) {
                            double price = Double.parseDouble(rs.getString("price"));
                            Formatter formatter = new Formatter();
                            formatter.format("%.2f", price);
                            order.add(rs.getString("hatsBrand") + " Hat" + " | $" + formatter + " | ");
                        }
                        rs.close();
                        st.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.out.println("---Added to Cart Successfully---");
                    browse();
                }
                break;
            case "helmets":
                Scanner number6 = new Scanner(System.in);

                try {
                    Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                    Statement st = connection.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM HELMETS");
                    while (rs.next()) {
                        System.out.print(rs.getInt("id") + "." + " Brand name: " + rs.getString("helmetBrand") + " |");
                        System.out.print(" Helmet Size: " + rs.getString("helmetSize") + " |");
                        System.out.println(" Helmet Color: " + rs.getString("helmetColor") + " |");
                        System.out.println("------------------------------------------------------------------------------------");
                    }
                    rs.close();
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println("What would like to order? or type [100] to quit");
                System.out.print("> ");
                int itemNum6 = number6.nextInt();
                if (itemNum6 == 100) {
                    browse();
                } else if (itemNum6 >= 1 && itemNum6 <= 60) {
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:postgresql:Skateboards");
                        PreparedStatement st = connection.prepareStatement("SELECT * FROM HELMETS WHERE id = ?");
                        st.setInt(1, itemNum6);
                        ResultSet rs = st.executeQuery();
                        while (rs.next()) {
                            double price = Double.parseDouble(rs.getString("price"));
                            Formatter formatter = new Formatter();
                            formatter.format("%.2f", price);
                            order.add(rs.getString("helmetBrand") + " Helmet" + " | $" + formatter + " | ");
                        }
                        rs.close();
                        st.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.out.println("---Added to Cart Successfully---");
                    browse();
                }
                break;
            case "go back":
                break;
            default:
                System.out.println("Please choose a valid option above!!");
                browse();
        }
    }
}

// Maybe custom shoes