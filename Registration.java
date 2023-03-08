/**
 * @author ethan
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

import javax.print.Doc;
import javax.xml.stream.events.StartElement;

public class Registration {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void main(String[] args) {
        Registration n = new Registration();
        n.test("John", "ER", "Male", 19, "11111 111111", "Me", "Not Known");
        // test("girs","er", "male", 12, "00000 000000", "me", "then")
        //    test(String FirstName, String Surname, String Gender, Integer Age, String PhoneNumber, String DoctorChosen, String Details) {

    }

    public void test(String FirstName, String Surname, String Gender, Integer Age, String PhoneNumber,
            String DoctorChosen, String Details) {
        if (FirstName.length() > 15) {
            throw new RuntimeException("First name too long!");
        } else if (Surname.length() > 15) {
            throw new RuntimeException("Surname too long!");
        } else if (Age > 120) {
            throw new RuntimeException("Invalid age!");
        } else if (Age < 18) {
            throw new RuntimeException("You need to be 18 to register!");
        } else if (!PhoneNumber.matches("\\d{5} \\d{6}")) {
            throw new RuntimeException("Invalid phone number");
        }
        // else if (DoctorChosen.length() > 15 )
        // {
        // //     throw new RuntimeException("First name too long!")
        // // }
        else if (Details.length() > 100) {
            throw new RuntimeException("First name too long!");
        }

        System.out.println("Correct! Sending data!");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost?user=***&password=***");
            statement.execute("create database NHS");
            statement = connection.createStatement();
            int n = statement.executeUpdate(
                    "insert into patients (PatientID,FirstName, Surname, Gender, Age, PhoneNumber, DoctorChosen, Details )"
                            + "values (DEFAULT,'" + FirstName + "','" + Surname + "','" + Gender + "','" + Age + "','"
                            + PhoneNumber + "','" + DoctorChosen + "','" + Details + "')");
            //    boolean stop = false;
            resultSet = statement.executeQuery("select * from patients");
            int l = 0;
            while (resultSet.next()) {
                l++;
                System.out.println(resultSet.getString("PatientID") + " - " + resultSet.getString("FirstName") + " - "
                        + resultSet.getString("Surname"));
            }
            if (l > 3) {
                statement.executeUpdate("drop table patients; ");
                statement.executeUpdate("CREATE TABLE patients (PatientID int not null auto_increment,"
                        + "FirstName VARCHAR(15) not null,"
                        + "Surname varchar(15) NOT NULL,"
                        + "PRIMARY KEY (patientID),"
                        + "Gender varchar(10),"
                        + "Age int (3),"
                        + "PhoneNumber varchar(15),"
                        + "DoctorChosen varchar(20),"
                        + "Details varchar(100));");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}