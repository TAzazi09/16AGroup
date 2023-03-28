package Checks;

// imports from the java library
import java.sql.ResultSet;
import javax.swing.JOptionPane;

// imports from the project
import GUIs.MenuPage;
import Session.*;

/**
 * @author Ethan
 * @code quality by Nikola
 */
public class LoginCheck {
    public static int doctorName;
    public static boolean userFound = false;

    // Performs the credentials, resultSet, and loginInfo checks
    public static boolean test(String username, String password) {
        try {
            //Returns all tuples where the username matches
            ResultSet resultSet = Info.statement
                    .executeQuery("select * from patients WHERE FirstName = '" + username + "'");

            if (!credentialsLengthCheck(username, password))
                return false;
            else if (!resultSetCheck(resultSet))
                return false;
            else if (!loginInfoCheck(resultSet, username, password))
                return false;
            else {
                Info.backgroundID = resultSet.getString("patientID");
                Info.firstname = resultSet.getString("FirstName");
                Info.surname = resultSet.getString("Surname");

                doctorName = resultSet.getInt("doctorID");
                JOptionPane.showMessageDialog(null, "Welcome to the NHS!");
                
                General.closeAllWindows();

                userFound = true;

                //Returns the user to the main menu
                MenuPage.main(null);

                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean credentialsLengthCheck(String username, String password) {
        if (username == null || username.length() > 100) {
            JOptionPane.showMessageDialog(null, "Username too long!");
            return false;
        } else if (password == null || password.length() > 100) {
            JOptionPane.showMessageDialog(null, "Password too long!");
            return false;
        }
        return true;
    }

    private static boolean resultSetCheck(ResultSet resultSet) {
        if (resultSet == null) {
            JOptionPane.showMessageDialog(null, "No registered accounts with that name! Please register first!");
            return false;
        }
        return true;
    }

    private static boolean loginInfoCheck(ResultSet resultSet, String username, String password) {
        try {
            while (resultSet.next()) {
                if ((username.equals(resultSet.getString("FirstName")))
                        && (password.equals((resultSet.getString("Surname")) + (resultSet.getString("PatientID"))))) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}