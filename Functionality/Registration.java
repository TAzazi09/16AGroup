package Functionality;

/**
 * @author ethan
 * @additional check by nik
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;

import GUIs.GeneralPage;

public class Registration {
    // Tests if the data is valid, and if it is, sends it to the database
    public static boolean test(String FirstName, String Surname, String Gender, Integer Age, String PhoneNumber,
            String DoctorChosen, String Details) {
        if (!firstNameCheck(FirstName))
            return false;
        else if (!surnameCheck(Surname))
            return false;
        else if (!ageCheck(Age))
            return false;
        else if (!phoneNumberCheck(PhoneNumber))
            return false;
        else if (!doctorCheck(DoctorChosen))
            return false;
        else return checkDetails(Details);
            
    }

    // Checks if the first name is valid (between 2 and 15 characters, and only
    // contains letters)
    private static boolean firstNameCheck(String firstName) {
        if (firstName.length() > 15) {
            JOptionPane.showMessageDialog(null, "First name too long!");
            return false;
        } else if (firstName.length() < 2) {
            JOptionPane.showMessageDialog(null, "First name too short!");
            return false;
        } else if (!firstName.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(null, "First name must only contain letters!");
            return false;
        }
        return true;
    }

    // Checks if the surname is valid (between 2 and 15 characters, and only
    // contains letters)
    private static boolean surnameCheck(String surname) {
        if (surname.length() > 15) {
            JOptionPane.showMessageDialog(null, "Surname too long!");
            return false;
        } else if (surname.length() < 2) {
            JOptionPane.showMessageDialog(null, "Surname too short!");
            return false;
        } else if (!surname.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(null, "Surname must only contain letters!");
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
    private static boolean doctorCheck(String doctor) {
        if (doctor.equals("Select a doctor")) {
            JOptionPane.showMessageDialog(null, "Please select a doctor!");
            return false;
        }
        return true;
    }

    // Checks if the details are valid (less than 100 characters)
    private static boolean checkDetails(String details) {
        if (details.length() > 100) {
            JOptionPane.showMessageDialog(null, "Details too long!");
            return false;
        }
        return true;
    }

    // Sends the data to the database
    public static void sendData(String FirstName, String Surname, String Gender, Integer Age, String PhoneNumber,
            String DoctorChosen, String Details) {
        int RightID = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // DriverManager.getConnection("jdbc:mysql://localhost/nhs?user=root&password=***");
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate(
                    "insert into patients (PatientID,FirstName, Surname, Gender, Age, PhoneNumber, DoctorChosen, Details, messages )"
                            + "values (DEFAULT,'" + FirstName + "','" + Surname + "','" + Gender + "','" + Age + "','"
                            + PhoneNumber + "','" + DoctorChosen + "','" + Details + "','" + FirstName + " " + Surname + " succesfully registered with " + DoctorChosen + " as their doctor')");
            ResultSet resultSet = statement.executeQuery("SELECT MAX(PatientID) AS PatientID FROM patients");
            if (resultSet.next()) {
            RightID = resultSet.getInt("PatientID");
            System.out.println(RightID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Displays the username and password
        JOptionPane.showMessageDialog(null,
                (("Thank you for registering " + FirstName + " " + Surname
                        + ", and welcome to the NHS! \nYour username is " + FirstName + " and your password is "
                        + Surname + RightID + ". \nPlease keep theses safe!")));
        new GeneralPage().setVisible(true);
    }
}