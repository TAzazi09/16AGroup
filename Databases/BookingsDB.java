package Databases;

// imports from the project
import Session.Info;

/**
 * @written by Ethan
 * @file created by Nikola (project structure)
 */
public class BookingsDB {
    public static void main(String[] args) {
        tableInitialization();
    }

    // Creates the Bookings table
    private static void tableInitialization() {
        try {
            Info.statement.executeUpdate("use NHS");
            Info.statement.execute("DROP TABLE IF EXISTS bookings");
            Info.statement.execute("CREATE TABLE bookings ("
                    + "BookingID INT NOT NULL auto_increment,"
                    + "PatientID INT NOT NULL, "
                    + "DoctorID INT NOT NULL, "
                    + "Time Time NOT NULL,"
                    + "Date Date NOT NULL,"
                    + "Detail VARCHAR(250),"
                    + "Prescription VARCHAR(250),"
                    + "FOREIGN KEY (PatientID) REFERENCES patients (PatientID),"
                    + "FOREIGN KEY (DoctorID) REFERENCES doctors (DoctorID),"
                    + "PRIMARY KEY (BookingID),"
                    + "UNIQUE (PatientID, DoctorID, Time, Date)"
                    + ");");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}