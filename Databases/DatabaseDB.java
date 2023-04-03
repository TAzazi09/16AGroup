package Databases;

// imports from the project
import Session.Info;

/**
 * @written by Ethan
 * @file created by Nikola (project structure)
 */
public class DatabaseDB {
    // Creates the database and the tables
    public static void initializeDB() {
        try {
            // Connects to the database (if not already connected)
            if (!Info.connected) {
                Info.connect();
            }

            Info.statement.executeUpdate("DROP DATABASE IF EXISTS NHS;");
            Info.statement.executeUpdate("CREATE DATABASE NHS");

            // Creates the Doctors, Patients, and Bookings tables
            DoctorsDB.tableInitializationAndInsertDoctors();;
            PatientsDB.tableInitializationAndInsertPatients();
            BookingsDB.tableInitialization();
            LogsDB.tableInitialization();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}