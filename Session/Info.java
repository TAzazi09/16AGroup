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
    public static boolean connected;

    public static String firstname;
    public static String surname;

    public static int userID;

    public static Connection connection;
    public static Statement statement;

    public static void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connects to the database
            connection = DatabaseConnectionFunc.getConnection();
            statement = connection.createStatement();

            // Sets the connected variable to true
            connected = true;
        } catch (Exception e) {
            connected = false;
        }
    }
}