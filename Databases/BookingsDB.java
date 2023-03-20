package Databases;

import java.sql.Connection;
import java.sql.Statement;
import Functionality.DatabaseConnectionFunc;

/**
 * @written by Ethan
 * @file created by Nikola (project structure)
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
                    + "BookingID int not null auto_increment,"
                    + "PatientID int not null, "
                    + "DoctorChosen varchar(25) not null, "
                    + "Time Time not null,"
                    + "Date Date not null,"
                    + "Detail VARCHAR(250),"
                    + "Prescription VARCHAR(250),"
                    + "FOREIGN KEY (PatientID) REFERENCES patients (PatientID),"
                    + "PRIMARY KEY (BookingID),"
                    + "UNIQUE (PatientID, DoctorChosen, Time, Date)"
                    + ");");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
