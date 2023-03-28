package Functionality;

// imports from the java library
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

// imports from the project
// import Tests.PasswordForDB;

/**
 * @author Ethan
 * @code quality by Nikola
 */
public class DatabaseConnectionFunc {
    public static Connection connection;
    public static boolean connected = false;

    public static void main(String[] args) {
        if (!connected) {
            // if (PasswordForDB.testing) {
            //     DatabaseConnectionFunc.connectForTests(PasswordForDB.password);
            // } else {
                DatabaseConnectionFunc.connect();
            // }
        }
    }

    // This method is used to connect to the local database of the host machine
    private static void connect() {
        Scanner test = new Scanner(System.in);
        System.out.print("Please enter your password: ");
        String password = test.nextLine();
        test.close();

        String username = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/", username, password);
            connected = true;
        } catch (Exception e) {
            System.out.println("Connection failed\nEither the password is incorrect, your username is not '" + username
                    + "', or the database is not running\nTry again");
        }
    }

    public static Connection getConnection() {
        if (!connected) {
            // if (PasswordForDB.testing) {
            //     connectForTests(PasswordForDB.password);
            // } else {
                connect();
            // }
        }
        return connection;
    }

    // private static void connectForTests(String password) {
    //     try {
    //         Class.forName("com.mysql.cj.jdbc.Driver");
    //         connection = DriverManager
    //                 .getConnection("jdbc:mysql://localhost/", "root", PasswordForDB.password);
    //         connected = true;
    //     } catch (Exception e) {
    //         System.out.println("Connection failed\nEither the password is incorrect, your username is not '" + "root"
    //                 + "', or the database is not running\nTry again");
    //     }
    // }
}