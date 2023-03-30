package Databases;

// imports from the java library
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
            insertDoctor("Dr Jason", "12345 123456", "Cardiologist");
            insertDoctor("Dr Andrew", "56712 09876", "Dentist");
            insertDoctor("Dr Smith", "55555 666666", "Dermatologist");
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
                    "DoctorID INT NOT NULL auto_increment," +
                    "Name VARCHAR(15) NOT NULL, " +
                    "PhoneNumber VARCHAR(12) NOT NULL," +
                    "Background VARCHAR(100), " +
                    "Speciality VARCHAR(15) NOT NULL," +
                    "PRIMARY KEY (DoctorID)" +
                    ");");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertDoctor(String doctorName, String phoneNumber, String specialty)
            throws Exception {
        Info.statement.executeUpdate("INSERT into doctors (DoctorID, Name, PhoneNumber, Speciality) " +
                "VALUES (DEFAULT, '" + doctorName + "', '" + phoneNumber + "', '" + specialty + "')");
    }

    public static int getDoctorID(String doctorName) throws Exception {
        Info.statement.executeUpdate("use NHS");
        ResultSet resultSet = Info.statement
                .executeQuery("SELECT DoctorID FROM doctors WHERE Name = '" + doctorName + "';");
        resultSet.next();
        return Integer.parseInt(resultSet.getString("DoctorID"));
    }

    public static String getDoctorName(int doctorId) throws Exception {
        Info.statement.executeUpdate("use NHS");
        ResultSet resultSet = Info.statement
                .executeQuery("SELECT Name FROM doctors WHERE DoctorID = '" + doctorId + "';");
        resultSet.next();
        return resultSet.getString("Name");
    }

    public static boolean doctorExists(String doctorName) throws Exception {
        Info.statement.executeUpdate("use NHS");
        ResultSet resultSet = Info.statement
                .executeQuery("SELECT Name FROM doctors WHERE Name = '" + doctorName + "';");
        return resultSet.next();
    }
}