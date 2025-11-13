package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    private static final String URL = "jdbc:mysql://localhost:3306/hoian_db";
    private static final String USER = "root";
    private static final String PASS = "085213"; 

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
