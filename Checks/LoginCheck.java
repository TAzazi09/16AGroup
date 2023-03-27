package Checks;

import java.awt.Window;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import GUIs.MenuPage;
import Session.Info;

/**
 * @author Ethan
 * @code quality by Nikola
 */
public class LoginCheck {
    public static String firstname;
    public static String surname;
    public static int doctorName;
    public static boolean userFound = false;

    public static void main(String user, String password) {
        test(user, password);
    }

    public static boolean test(String username, String password) {
        try {
            //Returns all tuples where the username matches
            ResultSet resultSet = Info.statement
                    .executeQuery("select * from patients WHERE FirstName = '" + username + "'");

            if (!credentialsLengthCheck(username, password)) {
                return false;
            } else if (!resultSetCheck(resultSet)) {
                return false;
            } else if (!loginInfoCheck(resultSet, username, password)) {
                return false;
            } else {
                Info.backgroundID = resultSet.getString("patientID");
                firstname = resultSet.getString("FirstName");
                surname = resultSet.getString("Surname");
                doctorName = resultSet.getInt("doctorID");
                JOptionPane.showMessageDialog(null, "Welcome to the NHS!");
                Window[] windows = Window.getWindows();

                // Close all windows in the array
                for (Window window : windows) {
                    window.dispose();
                }
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

    public static String getFirstName() {
        return firstname;
    }

    public static String getSurname() {
        return surname;
    }
}