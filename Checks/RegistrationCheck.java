package Checks;

import javax.swing.JOptionPane;
import Databases.DoctorsDB;

/**
 * @author Ethan
 * @additional checks by Nikola
 */
public class RegistrationCheck {
    // Performs the first name, surname, age, phone number, doctor name, and details checks
    public static boolean test(String FirstName, String Surname, String Gender, Integer Age, String PhoneNumber,
            String DoctorName, String Details) {
        if (FirstName == null || Surname == null || Gender == null || Age == null || PhoneNumber == null
                || DoctorName == null)
            return false;
        else if (!firstNameCheck(FirstName))
            return false;
        else if (!surnameCheck(Surname))
            return false;
        else if (!ageCheck(Age))
            return false;
        else if (!phoneNumberCheck(PhoneNumber))
            return false;
        else if (!doctorCheck(DoctorName))
            return false;
        else
            return detailsCheck(Details);
    }

    // Checks if the first name is valid (between 2 and 15 characters, and only
    // contains letters)
    private static boolean firstNameCheck(String firstName) {
        if (firstName.length() > 20) {
            JOptionPane.showMessageDialog(null, "First name too long!");
            return false;
        } else if (firstName.length() < 2) {
            JOptionPane.showMessageDialog(null, "First name too short!");
            return false;
        } else if (!firstName.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(null, "First name must only contain letters!");
            return false;
        } else if (Character.isLowerCase(firstName.charAt(0))) {
            JOptionPane.showMessageDialog(null, "First name must start with a capital letter!");
            return false;
        }
        return true;
    }

    // Checks if the surname is valid (between 2 and 15 characters, and only
    // contains letters)
    private static boolean surnameCheck(String surname) {
        if (surname.length() > 20) {
            JOptionPane.showMessageDialog(null, "Surname too long!");
            return false;
        } else if (surname.length() < 2) {
            JOptionPane.showMessageDialog(null, "Surname too short!");
            return false;
        } else if (!surname.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(null, "Surname must only contain letters!");
            return false;
        } else if (Character.isLowerCase(surname.charAt(0))) {
            JOptionPane.showMessageDialog(null, "Surname must start with a capital letter!");
            return false;
        }
        return true;
    }

    // Checks if the age is valid (between 18 and 130)
    private static boolean ageCheck(int age) {
        if (age < 18) {
            JOptionPane.showMessageDialog(null, "You need to be 18 to register!");
            return false;
        } else if (age > 130) {
            JOptionPane.showMessageDialog(null, "Invalid age!");
            return false;
        }
        return true;
    }

    // Checks if the phone number is valid (format: XXXXX XXXXXX)
    private static boolean phoneNumberCheck(String phoneNumber) {
        if (!phoneNumber.matches("\\d{5} \\d{6}")) {
            JOptionPane.showMessageDialog(null, "Invalid phone number format (format: XXXXX XXXXXX)");
            return false;
        }
        return true;
    }

    // If we add "Select a doctor" to the doctor list, we can use this check
    // Checks if the doctor is valid (not "Select a doctor")
    // Checks if the doctor is in the database
    private static boolean doctorCheck(String doctor) {
        try {
            if (doctor.equals("Select a doctor")) {
                JOptionPane.showMessageDialog(null, "Please select a doctor!");
                return false;
            } else if (!DoctorsDB.doctorExists(doctor)) {
                JOptionPane.showMessageDialog(null, "Doctor does not exist!");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Doctor does not exist!");
            return false;
        }

        return true;
    }

    // Checks if the details are valid (less than 100 characters)
    private static boolean detailsCheck(String details) {
        if (details != null && details.length() > 100) {
            JOptionPane.showMessageDialog(null, "Details too long!");
            return false;
        }
        return true;
    }
}