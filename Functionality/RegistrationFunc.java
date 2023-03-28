package Functionality;

// imports from the java library
import javax.swing.JOptionPane;
import java.sql.ResultSet;

// imports from the project
import Session.Info;
import Databases.DoctorsDB;
import GUIs.GeneralPage;

/**
 * @author Nikola
 * @some code wirten by Ethan
 */
public class RegistrationFunc {
    // Sends the data to the database
    public static void sendData(String FirstName, String Surname, String Gender, Integer Age, String PhoneNumber,
            String DoctorName, String Details) {
        int RightID = 0;
        try {
            Info.statement.executeUpdate(
                    "insert into patients (PatientID,FirstName, Surname, Gender, Age, PhoneNumber, DoctorID, Details, messages )"
                            + "values (DEFAULT,'" + FirstName + "','" + Surname + "','" + Gender + "','" + Age + "','"
                            + PhoneNumber + "','" + DoctorsDB.getDoctorID(DoctorName) + "','" + Details + "','"
                            + FirstName + " " + Surname
                            + " successfully registered with " + DoctorName + " as their doctor')");
            ResultSet resultSet = Info.statement.executeQuery("SELECT MAX(PatientID) AS PatientID FROM patients");

            if (resultSet.next()) {
                RightID = resultSet.getInt("PatientID");
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
