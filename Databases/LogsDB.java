package Databases;

import Info.Session;

/**
 * @author Nikola
 */
public class LogsDB {
    // Creates the Logs table
    public static void initTable() {
        try {
            Session.useNHS();
            Session.statement.executeUpdate("DROP TABLE IF EXISTS Logs;");
            Session.statement.execute("CREATE TABLE Logs (" +
                    "LogID INT NOT NULL auto_increment," +
                    "PatientID INT NOT NULL, " +
                    "Timestamp TIMESTAMP NOT NULL," +
                    "Action VARCHAR(255) NOT NULL," +
                    "FOREIGN KEY (PatientID) REFERENCES Patients (PatientID)," +
                    "PRIMARY KEY (LogID)" +
                    ");");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addLog(int patientID, String action) throws Exception {
        Session.statement.executeUpdate("INSERT INTO Logs (LogID, PatientID, Timestamp, Action) " +
                "VALUES (DEFAULT, '" + patientID + "', CURRENT_TIMESTAMP, '" + action + "')");
    }
}