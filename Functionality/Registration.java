package Functionality;

/**
 * @author ethan
 * @additional check by nik
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;

import GUIs.GeneralPage;

public class Registration {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

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
        else if (!checkDetails(Details))
            return false;
        else
            return true;
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

    // Checks if the age is valid (between 18 and 120)
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
        String RightID = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/nhs?user=***&password=***");
            statement = connection.createStatement();

            int n = statement.executeUpdate(
                    "insert into patients (PatientID,FirstName, Surname, Gender, Age, PhoneNumber, DoctorChosen, Details )"
                            + "values (DEFAULT,'" + FirstName + "','" + Surname + "','" + Gender + "','" + Age + "','"
                            + PhoneNumber + "','" + DoctorChosen + "','" + Details + "')");
            resultSet = statement.executeQuery("select * from patients");

            int l = 0;
            while (resultSet.next()) {
                l++;
                System.out.println(resultSet.getString("PatientID") + " - " + resultSet.getString("FirstName") + " - "
                        + resultSet.getString("Surname"));
                RightID = resultSet.getString("PatientID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null,
                (("Thank you for registering " + FirstName + " " + Surname
                        + ", and welcome to the NHS! \nYour username is " + FirstName + " and your password is "
                        + Surname + RightID + ". \nPlease keep theses safe!")));
        new GeneralPage().setVisible(true);
    }
}