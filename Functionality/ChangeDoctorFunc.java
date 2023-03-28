package Functionality;

// imports from the java library
import javax.swing.JOptionPane;

// imports from the project
import Checks.ChangeDoctorCheck;
import Databases.PatientsDB;
import Databases.DoctorsDB;
import Session.*;
import GUIs.MenuPage;

/**
 * @author Nikola
 */
public class ChangeDoctorFunc {
    public static void changeDoctor(String newDoctorName) {
        try {
            if (ChangeDoctorCheck.test(newDoctorName)) {
                int newDoctorID = DoctorsDB.getDoctorID(newDoctorName);

                // Change the doctor in the database
                PatientsDB.changeDoctor(Integer.parseInt(Info.backgroundID), newDoctorID);

                // add a message to the patient's log
                Info.statement
                        .execute("UPDATE patients SET messages = CONCAT(messages,'\n + " + Info.firstname
                                + " " + Info.surname + " has changed their doctor to " + newDoctorName
                                + ".') WHERE patientID = '" + Info.backgroundID + "';");

                // display a message to the user
                JOptionPane.showMessageDialog(null,
                        "Your doctor has successfully been changed to " + newDoctorName + ".");

                // Close all windows in the array
                General.closeAllWindows();

                // Open the menu page
                MenuPage.main(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}