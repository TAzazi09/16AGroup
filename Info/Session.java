package Info;

import java.sql.Connection;
import java.sql.Statement;
import Functionality.DBConnectionFunc;

/**
 * @author Nikola
 */
public class Session {
    // Authentication variables
    public static boolean connected;
    public static int userID = -1; // -1 means no user is logged in

    // User variables
    public static String firstname;
    public static String surname;

    // SQL variables
    public static Connection connection;
    public static Statement statement;
    public static Statement statement2;

    public static void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connects to the database
            connection = DBConnectionFunc.getConnection();
            statement = connection.createStatement();
            statement2 = connection.createStatement();

            // Sets the connected variable to true
            connected = true;
        } catch (Exception e) {
            connected = false;
        }
    }

    public static void useNHS() {
        try {
            Session.statement.executeUpdate("use NHS");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}