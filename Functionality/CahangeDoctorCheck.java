package Functionality;

import javax.swing.JOptionPane;
import Databases.DoctorsDB;
import Databases.PatientsDB;
import Session.Info;

/**
 * @author Nikola
 */
public class CahangeDoctorCheck {
    public static boolean test(String newDoctorName) {
        try {
            if (newDoctorName.equals("Choose a doctor")) {
                JOptionPane.showMessageDialog(null, "Please choose a doctor!");
                return false;
            } else if (!DoctorsDB.doctorExists(newDoctorName)) {
                JOptionPane.showMessageDialog(null, "Doctor does not exist!");
                return false;
            } else if (newDoctorName
                    .equals(PatientsDB.getDoctorName(Integer.parseInt(Info.backgroundID)))) {
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
