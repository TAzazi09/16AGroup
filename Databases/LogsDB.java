package Databases;

// imports from the project
import Session.Info;

/**
 * @author Nikola
 */
public class LogsDB {
    public static void main(String[] args) {
        tableInitialization();
    }

    // Creates the Logs table
    private static void tableInitialization() {
        try {
            Info.statement.executeUpdate("use NHS");
            Info.statement.executeUpdate("DROP TABLE IF EXISTS logs;");
            Info.statement.execute("CREATE TABLE logs (" +
                    "LogID INT NOT NULL auto_increment," +
                    "PatientID INT NOT NULL, " +
                    "Timestamp TIMESTAMP NOT NULL," +
                    "Action VARCHAR(255)," +
                    "FOREIGN KEY (PatientID) REFERENCES patients (PatientID)," +
                    "PRIMARY KEY (LogID)" +
                    ");");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertLog(int patientID, String action) throws Exception {
        Info.statement.executeUpdate("INSERT into logs (LogID, PatientID, Timestamp, Action) " +
                "VALUES (DEFAULT, '" + patientID + "', CURRENT_TIMESTAMP, '" + action + "')");
    }
}