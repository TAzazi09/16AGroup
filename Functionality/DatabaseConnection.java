package Functionality;

/**
 * @author ethan
 * @code quality by nik
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class DatabaseConnection {
    public static Connection connection;

    public static void main(String[] args) {
        running();
    }

    // connection =
    // DriverManager.getConnection("jdbc:mysql://localhost/nhs?user=root&password=***");
    public static void running() {
        System.out.println("Please enter your password: ");

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