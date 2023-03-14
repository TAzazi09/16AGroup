package Functionality;

/**
 * @author ethan
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DatabaseConnection {
    public static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        running();
    }

    // connection =
    // DriverManager.getConnection("jdbc:mysql://localhost/nhs?user=root&password=***");
    public static void running() {
        System.out.println("Please enter your password: ");
        Scanner test = new Scanner(System.in);
        String next = test.nextLine();
        test.close(); 
        String root = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/", root, next);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getConnection();
    }

    public static Connection getConnection() {
        return connection;
    }
}
