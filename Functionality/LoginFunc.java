package Functionality;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Checks.LoginCheck;
import GUIs.MenuPage;
import Info.*;

/**
 * @author Nikola
 */
public class LoginFunc {
    public static int doctorName;
    public static boolean userFound = false;

    public static void sendData(String username, String password) {
        try {
            //Returns all tuples where the username matches
            ResultSet resultSet = Session.statement
                    .executeQuery("SELECT * FROM Patients WHERE FirstName = '" + username + "'");

            if (LoginCheck.test(username, password, resultSet)) {
                Session.userID = Integer.parseInt(resultSet.getString("patientID"));
                Session.firstname = resultSet.getString("FirstName");
                Session.surname = resultSet.getString("Surname");

                doctorName = resultSet.getInt("doctorID");
                JOptionPane.showMessageDialog(null, "Welcome to the NHS!");

                General.closeAllWindows();

                userFound = true;

                // Add the login to the log
                LogFunc.logLogin(Session.userID);

                //Returns the user to the main menu
                MenuPage.loadPage();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}