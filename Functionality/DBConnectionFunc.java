package Functionality;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

// Commented out because tests broke after sprint 2
// import Tests.PasswordForDB;

/**
 * @author Ethan
 * @code quality review by Nikola
 */
public class DBConnectionFunc {
    public static Connection connection;
    public static boolean connected = false;

    public static void main(String[] args) {
        if (!connected) {
            // Commented out because tests broke after sprint 2
            // if (PasswordForDB.testing) {
            //     DatabaseConnectionFunc.connectForTests(PasswordForDB.password);
            // } else {
            DBConnectionFunc.connect();
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
            // Commented out because tests broke after sprint 2
            // if (PasswordForDB.testing) {
            //     connectForTests(PasswordForDB.password);
            // } else {
            connect();
            // }
        }
        return connection;
    }

    // Commented out because tests broke after sprint 2
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