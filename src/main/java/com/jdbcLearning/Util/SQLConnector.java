package com.jdbcLearning.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnector {


    public static Connection createConnection() {

        Connection connection1 = null;

        final String DB_NAME = "flickFaree";
        final String DB_URL ="jdbc:mysql://localhost:3306/" + DB_NAME;
        final String DB_USERNAME = "root";
        final String DB_PASSWORD = "Chittagong100!";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection1 = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);

        } catch (ClassNotFoundException| SQLException e){
            System.out.println(e.getMessage());
        }

        return connection1;


    }
}
