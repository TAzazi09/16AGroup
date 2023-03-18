package Databases;

/**
 * @written by ethan
 * @file created by nik (project structure)
 */

import java.sql.Connection;
import java.sql.Statement;
import Functionality.DatabaseConnectionFunc;

public class DatabaseDB {
    // Creates the database
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DatabaseConnectionFunc.getConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate("DROP DATABASE IF EXISTS NHS;");
            statement.executeUpdate("CREATE DATABASE NHS");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
