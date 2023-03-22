package Functionality;

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
    public static String fname;
    public static String sname;
    public static int doctorName;
    public static void main(String user, String password) {
        testFunction(user, password);
    }
    
    public static void testFunction(String username, String password) {
        try {
            //Returns all tuples where the username matches
            ResultSet resultSet = Info.statement.executeQuery("select * from patients WHERE FirstName = '" + username + "'");
            if (resultSet == null) {
                JOptionPane.showMessageDialog(null, "No registered accounts with that name! Please register first!");
                System.exit(1);
            }

            boolean userFound = false;
            //Checks each tuple returned and checks if a password matches. Because each ID is unique, there will be no duplicate matches.
            while (resultSet.next()) {
                if ((username.equals(resultSet.getString("FirstName")))
                        && (password.equals((resultSet.getString("Surname")) + (resultSet.getString("PatientID"))))) {
                    Info.backgroundID = resultSet.getString("patientID");
                    fname = resultSet.getString("FirstName");
                    sname = resultSet.getString("Surname");
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

    public static String getFirstName() {
        return fname;
    }

    public static String getSurname() {
        return sname;
    }
}