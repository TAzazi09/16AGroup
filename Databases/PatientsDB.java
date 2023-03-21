package Databases;

import java.sql.Connection;
import java.sql.Statement;
import Functionality.DatabaseConnectionFunc;

/**
 * @written by Ethan
 * @file created by Nikola (project structure)
 * && quality of life changes (added auto-login for me and Ethan)
 */
public class PatientsDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DatabaseConnectionFunc.getConnection();
            Statement statement = connection.createStatement();

            // Creates the Patients table
            statement.executeUpdate("use NHS");
            statement.executeUpdate("DROP TABLE IF EXISTS patients;");
            statement.execute("CREATE TABLE patients (" +
                    "PatientID int not null auto_increment," +
                    "FirstName VARCHAR(15) not null, " +
                    "Surname varchar(15) NOT NULL," +
                    "PRIMARY KEY (patientID), " +
                    "Gender varchar(10) not null," +
                    "Age int (3) not null," +
                    "PhoneNumber varchar(12) ," +
                    "DoctorChosen varchar(25) not null,  " +
                    "Details varchar(100), " +
                    "Messages text" +
                    ");");

            // Inserts the patients into the table
            insertPatient(statement, "Nikola", "Kolev", "Male", 20, "07856 791314", "Dr Jason", "no details",
                    "Nikola Kolev succesfully registered with Dr Jason as their doctor");
            insertPatient(statement, "Ethan", "Teather", "Male", 19, "00000 000000", "Dr Andrew", "",
                    "Ethan Teather succesfully registered with Dr Andrew as their doctor");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertPatient(Statement statement, String firstName, String surname, String gender, int age,
            String phoneNumber, String doctorChosen, String details, String messages) throws Exception {
        statement.executeUpdate(
                "INSERT into patients (PatientID, FirstName, Surname, Gender, Age, PhoneNumber, DoctorChosen, Details, messages) "
                        +
                        "VALUES (DEFAULT, '" + firstName + "', '" + surname + "', '" + gender + "', '" + age + "', '"
                        + phoneNumber + "', '" + doctorChosen + "', '" + details + "', '" + messages + "')");
    }
}