package Functionality;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Window;
import javax.swing.JOptionPane;
import GUIs.MenuPage;
import Databases.DoctorsDB;

/**
 * @author Ethan
 */
public class ReschedulingFunc {
    public static void resechduleBooking(String oldDate, String oldTime, String newDate, String newTime) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connects to the database
            Connection connection = DatabaseConnectionFunc.getConnection();
            Statement statement = connection.createStatement();
            ResultSet D = statement
                    .executeQuery("SELECT DoctorID FROM patients WHERE PatientID = '" + LoginCheck.getID() + "'");
           D.next();
           
            String currentDoctor = DoctorsDB.getDoctorName(Integer.parseInt(D.getString("DoctorID")));
            int currentDoctorID = Integer.parseInt(D.getString("DoctorID"));
            //Checks if there are any bookings that could clash
            ResultSet results = statement
                    .executeQuery("SELECT * FROM bookings WHERE Time = '" + newTime + "' AND DoctorID = '"
                            + currentDoctorID + "' AND Date = '" + newDate + "'");
            if (results.next()) {
                //Informs the user of the clashes
                JOptionPane.showMessageDialog(null, currentDoctor + " is unavailable at that time.");
            } else {
                JOptionPane.showMessageDialog(null,
                        "Your booking has successfully been changed to " + newTime + " on the " + newDate + ".");
                statement.execute("UPDATE patients SET messages = CONCAT(messages,'\n + " + LoginCheck.getFirstName()
                        + " " + LoginCheck.getSurname() + " has changed their booking from " + oldTime + " " + oldDate
                        + " to "
                        + newTime + " " + newDate + ".') WHERE patientID = '" + LoginCheck.getID() + "';");
                //Updates the booking
                statement.executeUpdate(
                        "UPDATE bookings SET Date = '" + newDate + "', Time = '" + newTime + "' WHERE Time = '"
                                + oldTime + "' AND DoctorID = '" + currentDoctorID + "' AND Date = '" + oldDate + "'");
                Window[] windows = Window.getWindows();

                // Close all windows in the array
                for (Window window : windows) {
                    window.dispose();
                }
                MenuPage.main(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}