package Functionality;
import Functionality.*;
/**
 * @author ethan
 * @code quality by nik
 */
import GUIs.menu;
import java.awt.Window;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class LoginCheck {
    public static String backgroundID;
    public static void main(String user, String password) {
        testFunction(user, password);
    }

    public static void testFunction(String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Connects to the database
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            
            //Returns all tuples where the username matches
            ResultSet resultSet = statement.executeQuery("select * from patients WHERE FirstName = '" + username + "'");
            if (resultSet == null) {
                JOptionPane.showMessageDialog(null, "No registered accounts with that name! Please register first!");
                System.exit(1);
            }

            boolean userFound = false;
            //Checks each tuple returned and checks if a password matches. Because each ID is unique, there will be no duplicate matches.
            while (resultSet.next()) {
                if ((username.equals(resultSet.getString("FirstName")))
                        && (password.equals((resultSet.getString("Surname")) + (resultSet.getString("PatientID"))))) {
                    backgroundID = resultSet.getString("patientID");
                    JOptionPane.showMessageDialog(null, "Welcome to the NHS!");
                    Window[] windows = Window.getWindows();

                    // Close all windows in the array
                    for (Window window : windows) {
                        window.dispose();
                    }
                    userFound = true;
                    menu.main(null);
                    break;
                }
            }

            //If no matches are found, the user has entered incorrect credentials, and can try to log-in again.
            if (!userFound) {
                JOptionPane.showMessageDialog(null, "Incorrect Credentials!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getID() {
        return backgroundID;
    }
}