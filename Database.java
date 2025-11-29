package BankApp.src.model;

import java.sql.*;

public class Database {

    private static String url = "jdbc:mysql://localhost:3306/bankapp";
    private static String user = "root";
    private static String pass = "123456";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
