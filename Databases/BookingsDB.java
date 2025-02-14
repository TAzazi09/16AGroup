package Databases;

import Info.Session;

/**
 * @written by Ethan
 * @file created by Nikola (project structure)
 * @code quality review by Nikola
 */
public class BookingsDB {
    public static void initTableWithBookings() {
        initTable();

        try {
            // Inserts the patients into the table
            addBooking(1, 1, "12:00:00", "2021-01-01", "this is", "a test");
            addBooking(2, 1, "12:00:00", "2023-01-01", "this is", "a test");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Creates the Bookings table
    private static void initTable() {
        try {
            Session.useNHS();
            Session.statement.execute("DROP TABLE IF EXISTS Bookings");
            Session.statement.execute("CREATE TABLE Bookings ("
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addBooking(int patientID, int doctorID, String time, String date, String detail,
            String prescription) throws Exception {
        Session.statement
                .executeUpdate("INSERT INTO Bookings (PatientID, DoctorID, Time, Date, Detail, Prescription) VALUES ('"
                        + patientID + "', '" + doctorID + "', '" + time + "', '" + date + "', '" + detail + "', '"
                        + prescription + "')");
    }
}