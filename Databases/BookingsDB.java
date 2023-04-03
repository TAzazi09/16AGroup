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
    public static void tableInitialization() {
        try {
            Info.statement.executeUpdate("use NHS");
            Info.statement.execute("DROP TABLE IF EXISTS Bookings");
            Info.statement.execute("CREATE TABLE Bookings ("
                    + "BookingID INT NOT NULL auto_increment,"
                    + "PatientID INT NOT NULL, "
                    + "DoctorID INT NOT NULL, "
                    + "Time Time NOT NULL,"
                    + "Date Date NOT NULL,"
                    + "Detail VARCHAR(250),"
                    + "Prescription VARCHAR(250),"
                    + "FOREIGN KEY (PatientID) REFERENCES Patients (PatientID),"
                    + "FOREIGN KEY (DoctorID) REFERENCES Doctors (DoctorID),"
                    + "PRIMARY KEY (BookingID),"
                    + "UNIQUE (PatientID, DoctorID, Time, Date)"
                    + ");");
            // Info.statement.executeQuery("INSERT INTO Bookings VALUES ")
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}