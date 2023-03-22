package Functionality;

import java.awt.Window;
import javax.swing.JOptionPane;
import Databases.PatientsDB;
import Databases.DoctorsDB;
import Session.Info;
import GUIs.MenuPage;

public class ChangeDoctorFunc {
    public static void changeDoctor(String newDoctorName) {
        try {
            if (CahangeDoctorCheck.test(newDoctorName)) {
                int newDoctorID = DoctorsDB.getDoctorID(newDoctorName);

                // Change the doctor in the database
                PatientsDB.changeDoctor(Integer.parseInt(Info.backgroundID), newDoctorID);

                // add a message to the patient's log
                Info.statement
                        .execute("UPDATE patients SET messages = CONCAT(messages,'\n + " + LoginCheck.getFirstName()
                                + " " + LoginCheck.getSurname() + " has changed their doctor to " + newDoctorName
                                + ".') WHERE patientID = '" + Info.backgroundID + "';");

                // display a message to the user
                JOptionPane.showMessageDialog(null,
                        "Your doctor has successfully been changed to " + newDoctorName + ".");

                // Close all windows in the array
                for (Window window : Window.getWindows()) {
                    window.dispose();
                }

                // Open the menu page
                MenuPage.main(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}