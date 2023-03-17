package Databases;

/**
 * @written by ethan
 * @file created by nik (project structure)
 */

import java.sql.Connection;
import java.sql.Statement;
import Functionality.DatabaseConnectionFunc;

public class PatientsDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DatabaseConnectionFunc.getConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate("use NHS");
            statement.executeUpdate("DROP TABLE IF EXISTS patients;");
            statement.execute("CREATE TABLE patients (" +
                    "PatientID int not null auto_increment," +
                    "FirstName VARCHAR(15) not null, " +
                    "Surname varchar(15) NOT NULL," +
                    "PRIMARY KEY (patientID), " +
                    "Gender varchar(10) not null," +
                    "Age int (3) not null," +
                    "PhoneNumber varchar(12) ," +
                    "DoctorChosen varchar(25) not null,  " +
                    "Details varchar(100), " +
                    "Messages text" +
                    ");");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}