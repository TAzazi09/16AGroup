package Databases;

import Info.Session;

/**
 * @written by Ethan
 * @file created by Nikola (project structure)
 * @code quality review by Nikola
 */
public class DatabaseDB {
    // Creates the database and the tables
    public static void initDB() {
        try {
            // Connects to the database (if not already connected)
            if (!Session.connected) {
                Session.connect();

                Session.statement.executeUpdate("DROP DATABASE IF EXISTS NHS;");
                Session.statement.executeUpdate("CREATE DATABASE NHS");

                // Creates the Doctors, Patients, and Bookings tables
                DoctorsDB.initTableWithDoctors();
                PatientsDB.initTableWithPatients();
                BookingsDB.initTableWithBookings();
                LogsDB.initTable();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}