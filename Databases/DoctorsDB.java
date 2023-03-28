package Databases;

// imports from the java library
import java.sql.Statement;
import java.sql.ResultSet;

// imports from the project
import Session.Info;

/**
 * @author Nikola
 */
public class DoctorsDB {
    public static void main(String[] args) {
        tableInitialization();

        try {
            // Inserts the doctors into the table
            insertDoctor(Info.statement, "Dr Jason", "12345 123456", "Cardiologist");
            insertDoctor(Info.statement, "Dr Andrew", "56712 09876", "Dentist");
            insertDoctor(Info.statement, "Dr Smith", "55555 666666", "Dermatologist");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Creates the Doctors table
    private static void tableInitialization() {
        try {
            Info.statement.executeUpdate("use NHS");
            Info.statement.executeUpdate("DROP TABLE IF EXISTS doctors;");
            Info.statement.execute("CREATE TABLE doctors (" +
                    "DoctorID int not null auto_increment," +
                    "Name VARCHAR(15) not null, " +
                    "PhoneNumber varchar(12) not null," +
                    "Background varchar(100), " +
                    "Speciality varchar(15) NOT NULL," +
                    "PRIMARY KEY (DoctorID)" +
                    ");");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertDoctor(Statement statement, String name, String phoneNumber, String specialty)
            throws Exception {
        statement.executeUpdate("INSERT into doctors (DoctorID, Name, PhoneNumber, Speciality) " +
                "VALUES (DEFAULT, '" + name + "', '" + phoneNumber + "', '" + specialty + "')");
    }

    public static int getDoctorID(String name) throws Exception {
        Info.statement.executeUpdate("use NHS");
        ResultSet resultSet = Info.statement.executeQuery("SELECT DoctorID FROM doctors WHERE Name = '" + name + "';");
        resultSet.next();
        return Integer.parseInt(resultSet.getString("DoctorID"));
    }

    public static String getDoctorName(int id) throws Exception {
        Info.statement.executeUpdate("use NHS");
        ResultSet resultSet = Info.statement.executeQuery("SELECT Name FROM doctors WHERE DoctorID = '" + id + "';");
        resultSet.next();
        return resultSet.getString("Name");
    }

    // Checks if a doctor exists
    public static boolean doctorExists(String name) throws Exception {
        Info.statement.executeUpdate("use NHS");
        ResultSet resultSet = Info.statement.executeQuery("SELECT Name FROM doctors WHERE Name = '" + name + "';");
        return resultSet.next();
    }
}