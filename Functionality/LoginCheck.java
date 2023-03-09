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

        System.out.println("username is " + user);
        System.out.println("password is " + password);
    }

    public static void testFunction(String username, String password) {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost/NHS?user=root&password=*Niko1312");
            statement = connection.createStatement();

            resultSet = statement.executeQuery("select * from patients WHERE FirstName = '" + username + "'");
            if(resultSet == null)
            {
                System.out.println("Fasddsil");
                System.exit(1);
            }
            boolean t = false;
            while (resultSet.next()) {
                if ((username.equals(resultSet.getString("FirstName")))
                        && (password.equals((resultSet.getString("Surname")) + (resultSet.getString("PatientID"))))) {
                    JOptionPane.showMessageDialog(null, "Welcome to the End!");
                    t = true;
                    break;
                }
            }
            if (t == false)
            {
                JOptionPane.showMessageDialog(null, "Incorect Credentials!");
            }
            //System.out.println("fai");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}