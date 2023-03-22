package Databases;

import java.sql.Connection;
import java.sql.Statement;
import Functionality.DatabaseConnectionFunc;
import Session.Info;

/**
 * @written by Ethan
 * @file created by Nikola (project structure)
 */
public class DatabaseDB {
    // Creates the database
    public static void main(String[] args) {
        try {
            if (!Info.connected) {
                Info.connect();
            }
            // Class.forName("com.mysql.cj.jdbc.Driver");

            // Connection connection = DatabaseConnectionFunc.getConnection();
            // Statement statement = connection.createStatement();

            Info.statement.executeUpdate("DROP DATABASE IF EXISTS NHS;");
            Info.statement.executeUpdate("CREATE DATABASE NHS");

            // Creates the Doctors, Patients, and Bookings tables
            DoctorsDB.main(null);
            PatientsDB.main(null);
            BookingsDB.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
