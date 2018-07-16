package com.texasintl.ums.db;

import java.sql.*;

/**
 *
 * @author Yubaraj
 */
public class DatabaseConnection {

    public static Connection getConnection() {
        Connection cn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/ums";
            String username = "root";
            String password = "";
            // loading the driver
            Class.forName("com.mysql.jdbc.Driver");
            // Creating the connection
            cn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed!");
        }
        return cn;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
