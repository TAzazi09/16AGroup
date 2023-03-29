package Functionality;

// imports from the project
import Databases.LogsDB;
import Checks.LogCheck;
import Databases.PatientsDB;

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

    // TODO
    public static void logLogin(int patientID) {
        if (LogCheck.checkLogin(patientID)) {
            try {
                LogsDB.insertLog(patientID, "Logged in");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // TODO
    public static void logArrangeBooking(int patientID) {
        if (LogCheck.checkArrangeBooking(patientID)) {
            try {
                LogsDB.insertLog(patientID, "Arranged a booking");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // TODO
    public static void logRearrangeBooking(int patientID) {
        if (LogCheck.checkRearrangeBooking(patientID)) {
            try {
                LogsDB.insertLog(patientID, "Rearranged a booking");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
