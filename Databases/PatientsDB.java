package Databases;

// imports from the java library
import java.sql.ResultSet;

// imports from the project
import Session.Info;

/**
 * @written by Ethan
 * @file created by Nikola (project structure)
 * && quality of life changes (added auto-login for me and Ethan)
 */
public class PatientsDB {
    public static void main(String[] args) {
        tableInitialization();

        try {
            // Inserts the patients into the table
            insertPatient("Nikola", "Kolev", "Male", 20, "07856 791314",
                    DoctorsDB.getDoctorID("Dr Jason"), "no details",
                    "Nikola Kolev successfully registered with Dr Jason as their doctor");
            insertPatient("Ethan", "Teather", "Male", 19, "00000 000000",
                    DoctorsDB.getDoctorID("Dr Andrew"), "",
                    "Ethan Teather successfully registered with Dr Andrew as their doctor");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Creates the Patients table
    private static void tableInitialization() {
        try {
            // Creates the Patients table
            Info.statement.executeUpdate("use NHS");
            Info.statement.executeUpdate("DROP TABLE IF EXISTS patients;");
            Info.statement.execute("CREATE TABLE patients (" +
                    "PatientID int not null auto_increment," +
                    "FirstName VARCHAR(20) not null, " +
                    "Surname varchar(20) NOT NULL," +
                    "Gender varchar(10) not null," +
                    "Age int (3) not null," +
                    "PhoneNumber varchar(12) not null ," +
                    "DoctorID int not null,  " +
                    "Details varchar(100), " +
                    "Messages text, " +
                    "PRIMARY KEY (patientID), " +
                    "FOREIGN KEY (DoctorID) REFERENCES doctors (DoctorID)" +
                    ");");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Inserts a patient into the table
    private static void insertPatient(String firstName, String surname, String gender, int age,
            String phoneNumber, int doctorId, String details, String messages) throws Exception {
        Info.statement.executeUpdate(
                "INSERT into patients (PatientID, FirstName, Surname, Gender, Age, PhoneNumber, DoctorID, Details, messages) "
                        + "VALUES (DEFAULT, '" + firstName + "', '" + surname + "', '" + gender + "', '" + age + "', '"
                        + phoneNumber + "', '" + doctorId + "', '" + details + "', '" + messages + "')");
    }

    // Change doctor for a patient
    public static void changeDoctor(int patientID, int doctorID) throws Exception {
        Info.statement.executeUpdate(
                "UPDATE patients SET DoctorID = '" + doctorID + "' WHERE PatientID = '" + patientID + "'");
    }

    // Get patient's doctor's name
    public static String getDoctorName(int patientID) throws Exception {
        ResultSet resultSet = Info.statement
                .executeQuery("SELECT DoctorID FROM patients WHERE PatientID = '" + patientID + "'");
        resultSet.next();
        int doctorID = Integer.parseInt(resultSet.getString("DoctorID"));

        return DoctorsDB.getDoctorName(doctorID);
    }

    // Get patient's doctor's ID
    public static int getDoctorID(int patientID) throws Exception {
        ResultSet resultSet = Info.statement
                .executeQuery("SELECT DoctorID FROM patients WHERE PatientID = '" + patientID + "'");
        resultSet.next();
        return Integer.parseInt(resultSet.getString("DoctorID"));
    }
}