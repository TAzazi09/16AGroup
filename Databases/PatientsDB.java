package Databases;

import java.sql.ResultSet;
import Info.Session;

/**
 * @written by Ethan
 * @file created by Nikola (project structure)
 * && quality of life changes (added auto-login for me and Ethan)
 */
public class PatientsDB {
    public static void initTableWithPatients() {
        initTable();

        try {
            // Inserts the patients into the table
            addPatient("Nikola", "Kolev", "Male", 20, "07856 791314",
                    DoctorsDB.getDoctorID("Dr Jason"), "no details",
                    "Nikola Kolev successfully registered with Dr Jason as their doctor");
            addPatient("Ethan", "Teather", "Male", 19, "00000 000000",
                    DoctorsDB.getDoctorID("Dr Andrew"), "",
                    "Ethan Teather successfully registered with Dr Andrew as their doctor");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Creates the Patients table
    private static void initTable() {
        try {
            // Creates the Patients table
            Session.useNHS();
            Session.statement.executeUpdate("DROP TABLE IF EXISTS Patients;");
            Session.statement.execute("CREATE TABLE Patients (" +
                    "PatientID INT NOT NULL auto_increment," +
                    "FirstName VARCHAR(20) NOT NULL, " +
                    "Surname VARCHAR(20) NOT NULL," +
                    "Gender VARCHAR(10) NOT NULL," +
                    "Age INT (3) NOT NULL CHECK (Age < 130)," +
                    "PhoneNumber VARCHAR(12) NOT NULL," +
                    "DoctorID INT NOT NULL,  " +
                    "Details VARCHAR(100), " +
                    "Messages TEXT, " +
                    "PRIMARY KEY (patientID), " +
                    "FOREIGN KEY (DoctorID) REFERENCES Doctors (DoctorID)" +
                    ");");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Inserts a patient into the table
    private static void addPatient(String firstName, String surname, String gender, int age,
            String phoneNumber, int doctorId, String details, String messages) throws Exception {
        Session.statement.executeUpdate(
                "INSERT INTO Patients (PatientID, FirstName, Surname, Gender, Age, PhoneNumber, DoctorID, Details, messages) "
                        + "VALUES (DEFAULT, '" + firstName + "', '" + surname + "', '" + gender + "', '" + age + "', '"
                        + phoneNumber + "', '" + doctorId + "', '" + details + "', '" + messages + "')");
    }

    // Change doctor for a patient
    public static void changeDoctor(int patientID, int doctorID) throws Exception {
        Session.statement.executeUpdate(
                "UPDATE Patients SET DoctorID = '" + doctorID + "' WHERE PatientID = '" + patientID + "'");
    }

    // Get patient's doctor's name
    public static String getDoctorName(int patientID) throws Exception {
        ResultSet resultSet = Session.statement
                .executeQuery("SELECT DoctorID FROM Patients WHERE PatientID = '" + patientID + "'");
        resultSet.next();
        int doctorID = Integer.parseInt(resultSet.getString("DoctorID"));

        return DoctorsDB.getDoctorName(doctorID);
    }

    // Get patient's doctor's ID
    public static int getDoctorID(int patientID) throws Exception {
        ResultSet resultSet = Session.statement
                .executeQuery("SELECT DoctorID FROM Patients WHERE PatientID = '" + patientID + "'");
        resultSet.next();
        return Integer.parseInt(resultSet.getString("DoctorID"));
    }
}