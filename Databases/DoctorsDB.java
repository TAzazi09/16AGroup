package Databases;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import Functionality.DatabaseConnectionFunc;

/**
 * @author Nikola
 */
public class DoctorsDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DatabaseConnectionFunc.getConnection();
            Statement statement = connection.createStatement();

            // Creates the Doctors table
            statement.executeUpdate("use NHS");
            statement.executeUpdate("DROP TABLE IF EXISTS doctors;");
            statement.execute("CREATE TABLE doctors (" +
                    "DoctorID int not null auto_increment," +
                    "Name VARCHAR(15) not null, " +
                    "PhoneNumber varchar(12) not null," +
                    "Background varchar(100), " +
                    "Speciality varchar(15) NOT NULL," +
                    "PRIMARY KEY (DoctorID)" +
                    ");");

            // Inserts the doctors into the table
            insertDoctor(statement, "Dr Jason", "12345 123456", "Cardiologist");
            insertDoctor(statement, "Dr Andrew", "56712 09876", "Dentist");
            insertDoctor(statement, "Dr Smith", "55555 666666", "Dermatologist");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertDoctor(Statement statement, String name, String phoneNumber, String specialty) throws Exception {
        statement.executeUpdate("INSERT into doctors (DoctorID, Name, PhoneNumber, Specialty) " +
                "VALUES (DEFAULT, '" + name + "', '" + phoneNumber + "', '" + specialty + "')");
    }

    public static int getDoctorID(String name) throws Exception {
        Connection connection = DatabaseConnectionFunc.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("use NHS");
        ResultSet resultSet = statement.executeQuery("SELECT DoctorID FROM doctors WHERE Name = '" + name + "';");
        resultSet.next();
        return Integer.parseInt(resultSet.getString("DoctorID"));
    }
}
