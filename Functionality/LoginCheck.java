package Functionality;

/**
 * @author ethan
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class LoginCheck {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void main(String user, String password) {
        testFunction(user, password);
    }

    public static void testFunction(String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Connects to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost/NHS?user=root&password=***");
            statement = connection.createStatement();
            
            //Returns all tuples where the username matches
            resultSet = statement.executeQuery("select * from patients WHERE FirstName = '" + username + "'");
            if (resultSet == null) {
                JOptionPane.showMessageDialog(null, "No registerd accounts with that name! Please register first!");
                System.exit(1);
            }

            boolean t = false;
            //Checks each tuple returned and checks if a password matches. Because each ID is unique, there will be no duplicate matches.
            while (resultSet.next()) {
                if ((username.equals(resultSet.getString("FirstName")))
                        && (password.equals((resultSet.getString("Surname")) + (resultSet.getString("PatientID"))))) {
                    JOptionPane.showMessageDialog(null, "Welcome to the NHS!");
                    t = true;
                    break;
                }
            }

            //If no matches are found, the user has entered incorrect credentials, and can try to login again.
            if (t == false) {
                JOptionPane.showMessageDialog(null, "Incorect Credentials!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}