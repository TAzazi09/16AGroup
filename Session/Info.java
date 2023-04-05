package Session;

// imports from the java library
import java.sql.Connection;
import java.sql.Statement;

// imports from the project
import Functionality.DatabaseConnectionFunc;

/**
 * @author Nikola
 */
public class Info {
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
            connection = DatabaseConnectionFunc.getConnection();
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
            Info.statement.executeUpdate("use NHS");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}