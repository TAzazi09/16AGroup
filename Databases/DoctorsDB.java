package Databases;

import java.sql.ResultSet;
import Info.Session;

/**
 * @author Nikola
 */
public class DoctorsDB {
    public static void initTableWithDoctors() {
        initTable();

        try {
            // Inserts the doctors into the table
            addDoctor("Dr Jason", "12345 123456", "Cardiologist");
            addDoctor("Dr Andrew", "56712 09876", "Dentist");
            addDoctor("Dr Smith", "55555 666666", "Dermatologist");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Creates the Doctors table
    public static void initTable() {
        try {
            Session.useNHS();
            Session.statement.executeUpdate("DROP TABLE IF EXISTS Doctors;");
            Session.statement.execute("CREATE TABLE Doctors (" +
                    "DoctorID INT NOT NULL auto_increment," +
                    "Name VARCHAR(15) NOT NULL, " +
                    "PhoneNumber VARCHAR(12) NOT NULL," +
                    "Background VARCHAR(255), " +
                    "Speciality VARCHAR(15) NOT NULL," +
                    "PRIMARY KEY (DoctorID)" +
                    ");");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addDoctor(String doctorName, String phoneNumber, String specialty)
            throws Exception {
        Session.statement.executeUpdate("INSERT INTO Doctors (DoctorID, Name, PhoneNumber, Speciality) " +
                "VALUES (DEFAULT, '" + doctorName + "', '" + phoneNumber + "', '" + specialty + "')");
    }

    public static int getDoctorID(String doctorName) throws Exception {
        Session.statement.executeUpdate("use NHS");
        ResultSet resultSet = Session.statement
                .executeQuery("SELECT DoctorID FROM Doctors WHERE Name = '" + doctorName + "';");
        resultSet.next();
        return Integer.parseInt(resultSet.getString("DoctorID"));
    }

    public static String getDoctorName(int doctorId) throws Exception {
        Session.statement2.executeUpdate("use NHS");
        ResultSet resultSet = Session.statement2
                .executeQuery("SELECT Name FROM Doctors WHERE DoctorID = '" + doctorId + "';");
        resultSet.next();
        return resultSet.getString("Name");
    }

    public static boolean doctorExists(String doctorName) throws Exception {
        Session.statement.executeUpdate("use NHS");
        ResultSet resultSet = Session.statement
                .executeQuery("SELECT Name FROM Doctors WHERE Name = '" + doctorName + "';");
        return resultSet.next();
    }
}