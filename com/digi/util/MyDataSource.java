package com.digi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDataSource {
    private static final String URL = "jdbc:mysql://localhost:3306/user_room";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "java";
    private static Connection connection;

    public static Connection getConnection (){
        try {
            if (connection == null|| connection.isClosed()){
                connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
