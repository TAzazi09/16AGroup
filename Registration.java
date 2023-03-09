/**
 * @author ethan
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
// import GeneralPage.java;
import javax.print.Doc;
import javax.swing.JOptionPane;
import javax.xml.stream.events.StartElement;

public class Registration {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void main(String[] args) {

    }

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
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/nhs?user=***&password=***");
            statement = connection.createStatement();
            int n = statement.executeUpdate(
                    "insert into patients (PatientID,FirstName, Surname, Gender, Age, PhoneNumber, DoctorChosen, Details )"
                            + "values (DEFAULT,'" + FirstName + "','" + Surname + "','" + Gender + "','" + Age + "','"
                            + PhoneNumber + "','" + DoctorChosen + "','" + Details + "')");
            // boolean stop = false;
            resultSet = statement.executeQuery("select * from patients");
            int l = 0;
            while (resultSet.next()) {
                l++;
                System.out.println(resultSet.getString("PatientID") + " - " + resultSet.getString("FirstName") + " - "
                        + resultSet.getString("Surname"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null,
                "Congratulations " + FirstName + " " + Surname + ", and welcome to the NHS!");
        new GeneralPage().setVisible(true);
    }
}