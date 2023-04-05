package Functionality;

// imports from the java library
import java.sql.ResultSet;
import javax.swing.JOptionPane;

// imports from the project
import GUIs.MenuPage;
import Info.*;
import Databases.DoctorsDB;

/**
 * @author Ethan
 */
public class ReschedulingFunc {
    public static void sendData(String oldDate, String oldTime, String newDate, String newTime) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connects to the database
            ResultSet D = Session.statement
                    .executeQuery("SELECT DoctorID FROM Patients WHERE PatientID = '" + Session.userID + "'");
            D.next();

            //Gets the Doctors name associated with the patient
            String currentDoctor = DoctorsDB.getDoctorName(Integer.parseInt(D.getString("DoctorID")));

            //Gets the DoctorsID
            int currentDoctorID = Integer.parseInt(D.getString("DoctorID"));

            // Checks if there are any bookings that could clash
            ResultSet results = Session.statement
                    .executeQuery("SELECT * FROM bookings WHERE Time = '" + newTime + "' AND DoctorID = '"
                            + currentDoctorID + "' AND Date = '" + newDate + "'");

            if (results.next()) {
                // Informs the user of the clashes
                JOptionPane.showMessageDialog(null, currentDoctor + " is unavailable at that time.");
            } else {
                JOptionPane.showMessageDialog(null,
                        "Your booking has successfully been changed to " + newTime + " on the " + newDate + ".");
                Session.statement.execute("UPDATE Patients SET messages = CONCAT(messages,'\n + "
                        + Session.firstname
                        + " " + Session.surname + " has changed their booking from " + oldTime + " " + oldDate
                        + " to "
                        + newTime + " " + newDate + ".') WHERE patientID = '" + Session.userID + "';");

                // Add the rescheduling to the log
                LogFunc.logReschedule(Session.userID, oldTime, oldDate, newTime, newDate,
                        currentDoctor);

                // Updates the booking DB
                Session.statement.executeUpdate(
                        "UPDATE bookings SET Date = '" + newDate + "', Time = '" + newTime + "' WHERE Time = '"
                                + oldTime + "' AND DoctorID = '" + currentDoctorID + "' AND Date = '" + oldDate + "'");

                // Close all windows in the array
                General.closeAllWindows();

                //Returns the user to the menu
                MenuPage.loadPage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}