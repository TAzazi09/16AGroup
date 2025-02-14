package Functionality;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import Databases.DoctorsDB;
import GUIs.GeneralPage;
import Info.Session;

/**
 * @author Nikola
 * @some code written by Ethan
 */
public class RegistrationFunc {
    // Sends the data to the database
    public static void sendData(String FirstName, String Surname, String Gender, Integer Age, String PhoneNumber,
            String DoctorName, String Details) {
        int patientID = 0;
        try {
            Session.statement.executeUpdate(
                    "INSERT INTO Patients (PatientID,FirstName, Surname, Gender, Age, PhoneNumber, DoctorID, Details, messages) "
                            + "VALUES (DEFAULT,'" + FirstName + "','" + Surname + "','" + Gender + "','" + Age + "','"
                            + PhoneNumber + "','" + DoctorsDB.getDoctorID(DoctorName) + "','" + Details + "','"
                            + FirstName + " " + Surname
                            + " successfully registered with " + DoctorName + " as their doctor')");
            ResultSet resultSet = Session.statement.executeQuery("SELECT MAX(PatientID) AS PatientID FROM Patients");

            if (resultSet.next()) {
                patientID = resultSet.getInt("PatientID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Adds the registration to the log
        LogFunc.logRegistration(patientID);

        // Displays the username and password
        JOptionPane.showMessageDialog(null,
                (("Thank you for registering " + FirstName + " " + Surname
                        + ", and welcome to the NHS! \nYour username is " + FirstName + " and your password is "
                        + Surname + patientID + ". \nPlease keep theses safe!")));
        new GeneralPage().setVisible(true);
    }
}