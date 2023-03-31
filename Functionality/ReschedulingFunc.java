package Functionality;

// imports from the java library
import java.sql.ResultSet;
import javax.swing.JOptionPane;

// imports from the project
import GUIs.MenuPage;
import Databases.DoctorsDB;
import Session.*;

/**
 * @author Ethan
 */
public class ReschedulingFunc {
    public static void resechduleBooking(String oldDate, String oldTime, String newDate, String newTime) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connects to the database
            ResultSet D = Info.statement
                    .executeQuery("SELECT DoctorID FROM Patients WHERE PatientID = '" + Info.userID + "'");
            D.next();

            //Gets the Doctors name associated with the patient
            String currentDoctor = DoctorsDB.getDoctorName(Integer.parseInt(D.getString("DoctorID")));

            //Gets the DoctorsID
            int currentDoctorID = Integer.parseInt(D.getString("DoctorID"));

            // Checks if there are any bookings that could clash
            ResultSet results = Info.statement
                    .executeQuery("SELECT * FROM bookings WHERE Time = '" + newTime + "' AND DoctorID = '"
                            + currentDoctorID + "' AND Date = '" + newDate + "'");

            if (results.next()) {
                // Informs the user of the clashes
                JOptionPane.showMessageDialog(null, currentDoctor + " is unavailable at that time.");
            } else {
                JOptionPane.showMessageDialog(null,
                        "Your booking has successfully been changed to " + newTime + " on the " + newDate + ".");
                Info.statement.execute("UPDATE Patients SET messages = CONCAT(messages,'\n + "
                        + Info.firstname
                        + " " + Info.surname + " has changed their booking from " + oldTime + " " + oldDate
                        + " to "
                        + newTime + " " + newDate + ".') WHERE patientID = '" + Info.userID + "';");

                // Add the rescheduling to the log
                LogFunc.logRescheduleBooking(Info.userID, oldTime, oldDate, newTime, newDate,
                        currentDoctor);

                // Updates the booking DB
                Info.statement.executeUpdate(
                        "UPDATE bookings SET Date = '" + newDate + "', Time = '" + newTime + "' WHERE Time = '"
                                + oldTime + "' AND DoctorID = '" + currentDoctorID + "' AND Date = '" + oldDate + "'");

                // Close all windows in the array
                General.closeAllWindows();

                //Returns the user to the menu
                MenuPage.main(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}