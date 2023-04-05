package Checks;

// imports from the java library
import javax.swing.JOptionPane;

// imports from the project
import Databases.DoctorsDB;
import Databases.PatientsDB;
import Session.Info;

/**
 * @author Nikola
 */
public class ChangeDoctorCheck {
    // Performs the new doctor name check
    public static boolean test(String newDoctorName) {
        return doctorNameCheck(newDoctorName);
    }

    // Checks if the new doctor name is valid
    private static boolean doctorNameCheck(String newDoctorName) {
        try {
            if (newDoctorName.equals("Choose a doctor")) {
                JOptionPane.showMessageDialog(null, "Please choose a doctor!");
                return false;
            } else if (!DoctorsDB.doctorExists(newDoctorName)) {
                JOptionPane.showMessageDialog(null, "Doctor does not exist!");
                return false;
            } else if (newDoctorName
                    .equals(PatientsDB.getDoctorName(Info.userID))) {
                JOptionPane.showMessageDialog(null, "You are already assigned to this doctor!");
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }
}