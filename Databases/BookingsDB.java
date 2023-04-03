package Databases;

// imports from the project
import Session.Info;

/**
 * @written by Ethan
 * @file created by Nikola (project structure)
 */
public class BookingsDB {
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
                    Info.statement.execute("INSERT INTO Bookings (PatientID, DoctorID, Time, Date, Detail, Prescription) VALUES ('2', '1', '12:00:00', '2023-01-01', 'this is', 'a test')");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}