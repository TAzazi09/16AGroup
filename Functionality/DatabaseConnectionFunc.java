package Functionality;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

/**
 * @author Ethan
 * @code quality by Nikola
 */
public class DatabaseConnectionFunc {
    public static Connection connection;

    public static void main(String[] args) {
        running();
    }

    // This method is used to connect to the local database of the host machine
    public static void running() {
        System.out.print("Please enter your password: ");

        Scanner test = new Scanner(System.in);
        String password = test.nextLine();
        test.close();

        String username = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/", username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        getConnection();
    }

    public static Connection getConnection() {
        return connection;
    }
}