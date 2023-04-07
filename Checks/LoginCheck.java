package Checks;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 * @author Ethan
 * @code quality by Nikola
 */
public class LoginCheck {
    // Performs the credentials, resultSet, and loginInfo checks
    public static boolean test(String username, String password, ResultSet resultSet) {
        if (!credentialsLengthCheck(username, password))
            return false;
        else if (!resultSetCheck(resultSet))
            return false;
        else
            return loginInfoCheck(resultSet, username, password);
    }

    // Checks if the username and password are too long
    private static boolean credentialsLengthCheck(String username, String password) {
        if (username == null || username.length() > 100) {
            JOptionPane.showMessageDialog(null, "Username too long!");
            return false;
        } else if (password == null || password.length() > 100) {
            JOptionPane.showMessageDialog(null, "Password too long!");
            return false;
        } else
            return true;
    }

    // Checks if the resultSet is empty
    private static boolean resultSetCheck(ResultSet resultSet) {
        if (resultSet == null) {
            JOptionPane.showMessageDialog(null, "No registered accounts with that name! Please register first!");
            return false;
        } else
            return true;
    }

    // Checks if the username and password match the database
    private static boolean loginInfoCheck(ResultSet resultSet, String username, String password) {
        try {
            while (resultSet.next()) {
                if ((username.equals(resultSet.getString("FirstName")))
                        && (password.equals((resultSet.getString("Surname")) + (resultSet.getString("PatientID"))))) {
                    return true;
                }
            }
            JOptionPane.showMessageDialog(null, "Incorrect username or password!");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}