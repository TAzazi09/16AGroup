package Functionality;

import javax.swing.JOptionPane;
import Checks.ChangeDoctorCheck;
import Databases.PatientsDB;
import Databases.DoctorsDB;
import GUIs.MenuPage;
import Info.*;

/**
 * @author Nikola
 */
public class ChangeDoctorFunc {
    public static void sendData(String newDoctorName) {
        try {
            if (ChangeDoctorCheck.test(newDoctorName)) {
                int newDoctorID = DoctorsDB.getDoctorID(newDoctorName);

                // Change the doctor in the database
                PatientsDB.changeDoctor(Session.userID, newDoctorID);

                // add a message to the patient's log
                Session.statement
                        .execute("UPDATE Patients SET messages = CONCAT(messages,'\n + " + Session.firstname
                                + " " + Session.surname + " has changed their doctor to " + newDoctorName
                                + ".') WHERE patientID = '" + Session.userID + "';");

                // Adds the change of doctor to the log
                LogFunc.logChangeDoctor(Session.userID, newDoctorName);

                // display a message to the user
                JOptionPane.showMessageDialog(null,
                        "Your doctor has successfully been changed to " + newDoctorName + ".");

                // Close all windows and return to the main menu
                General.closeAllWindows();
                MenuPage.loadPage();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}