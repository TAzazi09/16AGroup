package Functionality;

/**
 * @author ethan
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
        System.out.println(FirstName);
        if (FirstName.length() > 15) {
            JOptionPane.showMessageDialog(null, "First name too long!");
            return false;
        } else if (Surname.length() > 15) {
            JOptionPane.showMessageDialog(null, "Surname too long!");
            return false;
        } else if (Age > 120) {
            JOptionPane.showMessageDialog(null, "Invalid age!");
            return false;
        } else if (Age < 18) {
            JOptionPane.showMessageDialog(null, "You need to be 18 to register!");
            return false;
        } else if (!PhoneNumber.matches("\\d{5} \\d{6}")) {
            JOptionPane.showMessageDialog(null, "Invalid phone number");
            return false;
        } else if (Details.length() > 100) {
            JOptionPane.showMessageDialog(null, "First name too long!");
            return false;
        }
        return true;
    }

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