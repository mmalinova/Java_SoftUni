package com.company;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", props);

        PreparedStatement stmt =
                connection.prepareStatement("SELECT * FROM users JOIN users_games WHERE users.user_name LIKE ? AND users.id = users_games.user_id");

        System.out.println("Enter the name of the player: ");
        String username = sc.nextLine();

        stmt.setString(1, username);

        ResultSet rs = stmt.executeQuery();

        int size = 0;
        String firstName = null, lastName = null;
        while(rs.next()){
            size++;
            firstName = rs.getString("first_name");
            lastName = rs.getString("last_name");
        }

        if (size > 0) {
            System.out.println("User: " + username);
            System.out.println(firstName + lastName + " has played " + size + " games");
        } else {
            System.out.print("No such user exists");
        }
    }
}
