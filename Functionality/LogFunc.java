package Functionality;

// imports from the project
import Databases.LogsDB;
import Checks.LogCheck;
import Databases.PatientsDB;

public class LogFunc {
    public static void logRegistration(int patientID) {
        if (LogCheck.checkRegistration(patientID)) {
            try {
                LogsDB.insertLog(patientID, "Registered with doctor " + PatientsDB.getDoctorID(patientID));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
