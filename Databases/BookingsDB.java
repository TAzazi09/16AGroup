package Databases;

import java.sql.Connection;
import java.sql.Statement;
import Functionality.DatabaseConnectionFunc;

/**
 * @written by ethan
 * @file created by nik (project structure)
 */
public class BookingsDB {
    public static void main(String[] args) {
        // Creates the Bookings table
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DatabaseConnectionFunc.getConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate("use NHS");
            statement.execute("DROP TABLE IF EXISTS bookings");
            statement.execute("CREATE TABLE bookings ("
                    + "PatientID int not null, "
                    + "Time VARCHAR(250) not null,"
                    + "Date VARCHAR(250) not null,"
                    + "Detail VARCHAR(250),"
                    + "Prescription VARCHAR(250),"
                    + "FOREIGN KEY (PatientID) REFERENCES patients (PatientID),"
                    + "PRIMARY KEY (PatientID, Time, Date)"
                    + ");");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
