package Functionality;

// imports from the project
import Databases.LogsDB;
import Databases.PatientsDB;

/**
 * @author Nikola
 */
public class LogFunc {
    // Logs the registration of a patient
    public static void logRegistration(int patientID) {
        try {
            LogsDB.insertLog(patientID, "Registered with doctor " + PatientsDB.getDoctorID(patientID));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void logChangeDoctor(int patientID, String newDoctorName) {
        try {
            LogsDB.insertLog(patientID, "Changed doctor to " + newDoctorName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void logLogin(int patientID) {
        try {
            LogsDB.insertLog(patientID, "Logged in");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void logBooking(int patientID, String time, String date, String doctorName) {
        try {
            LogsDB.insertLog(patientID, "Arranged a booking at " + time + " on " + date + " with " + doctorName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void logRescheduleBooking(int patientID, String oldTime, String oldDate, String newTime,
            String newDate, String doctorName) {
        try {
            LogsDB.insertLog(patientID, "Rescheduled a booking from " + oldTime + " on " + oldDate + " to " + newTime
                    + " on " + newDate + " with " + doctorName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}