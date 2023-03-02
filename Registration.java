import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.print.Doc;

public class Registration {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    public static void main(String[] args) {
        test("Ethan", "Teather", "Male", 19, "11111 111111", "Me", "Not Known" );
    }
    public static void test(String FirstName, String Surname, String Gender, Integer Age, String PhoneNumber, String DoctorChosen, String Details) {
        if (FirstName.length() > 15 )
        {
            throw new RuntimeException("First name too long!");
        }
        else if (Surname.length() > 15 )
        {
            throw new RuntimeException("Surname too long!");
        }
        else if (Age > 120 )
        {
            throw new RuntimeException("Invalid age!");
        }
        else if (Age < 18 )
        {
            throw new RuntimeException("You need to be 18 to register!");
        }
        else if (!PhoneNumber.matches("\\d{5} \\d{6}"))
        {
            throw new RuntimeException("Invalid phone number");
        }
        // else if (DoctorChosen.length() > 15 )
        // {
        //     throw new RuntimeException("First name too long!")
        // }
        else if (Details.length() > 100 )
        {
            throw new RuntimeException("First name too long!");
        }

        System.out.println("Correct! Sending data!");
    

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/testing?user=et365&password=legome12");
        statement = connection.createStatement();
        resultSet = statement.executeQuery("insert into patients (FirstName, Surname, Gender, Age, PhoneNumber, DoctorChosen, Values )"
        + "values (" + FirstName + "," + Surname + "," + Gender  + "," + Age + "," + PhoneNumber + "," + DoctorChosen + "," + Details + ";" + 
        "select * from patients");
       // boolean stop = false;
        while (resultSet.next())
        System.out.println(resultSet.getString("PatientID") + " - " + resultSet.getString("FirstName") + " - " + resultSet.getString("Surname"));
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}