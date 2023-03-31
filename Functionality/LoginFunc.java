package Functionality;

// imports from the java library
import java.sql.ResultSet;
import javax.swing.JOptionPane;

// imports from the project
import Checks.LoginCheck;
import GUIs.MenuPage;
import Session.*;

/**
 * @author Nikola
 */
public class LoginFunc {
    public static int doctorName;
    public static boolean userFound = false;

    public static void sendData(String username, String password) {
        try {
            //Returns all tuples where the username matches
            ResultSet resultSet = Info.statement
                    .executeQuery("SELECT * FROM Patients WHERE FirstName = '" + username + "'");

            if (LoginCheck.test(username, password, resultSet)) {
                Info.userID = Integer.parseInt(resultSet.getString("patientID"));
                Info.firstname = resultSet.getString("FirstName");
                Info.surname = resultSet.getString("Surname");

                doctorName = resultSet.getInt("doctorID");
                JOptionPane.showMessageDialog(null, "Welcome to the NHS!");

                General.closeAllWindows();

                userFound = true;

                // Add the login to the log
                LogFunc.logLogin(Info.userID);

                //Returns the user to the main menu
                MenuPage.main(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}