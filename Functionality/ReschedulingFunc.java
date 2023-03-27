package Functionality;

import java.sql.ResultSet;
import java.awt.Window;
import javax.swing.JOptionPane;

import Checks.LoginCheck;
import GUIs.MenuPage;
import Databases.DoctorsDB;
import Session.Info;

/**
 * @author Ethan
 */
public class ReschedulingFunc {
    public static void resechduleBooking(String oldDate, String oldTime, String newDate, String newTime) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connects to the database
            ResultSet D = Info.statement
                    .executeQuery("SELECT DoctorID FROM patients WHERE PatientID = '" + Info.backgroundID + "'");
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
                Info.statement.execute("UPDATE patients SET messages = CONCAT(messages,'\n + "
                        + LoginCheck.getFirstName()
                        + " " + LoginCheck.getSurname() + " has changed their booking from " + oldTime + " " + oldDate
                        + " to "
                        + newTime + " " + newDate + ".') WHERE patientID = '" + Info.backgroundID + "';");

                // Updates the booking
                Info.statement.executeUpdate(
                        "UPDATE bookings SET Date = '" + newDate + "', Time = '" + newTime + "' WHERE Time = '"
                                + oldTime + "' AND DoctorID = '" + currentDoctorID + "' AND Date = '" + oldDate + "'");
                Window[] windows = Window.getWindows();

                // Close all windows in the array
                for (Window window : windows) {
                    window.dispose();
                }

                //Returns the user to the menu
                MenuPage.main(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}