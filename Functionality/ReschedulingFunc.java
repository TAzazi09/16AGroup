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
    public static void resechduleBooking(String oldTime, String oldDate, String newTime, String newDate) {
        // System.out.println(time);
        // System.out.println(date);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Connects to the database
            Connection connection = DatabaseConnectionFunc.getConnection();
            Statement statement = connection.createStatement();
            //Test input
            System.out.println(LoginCheck.getID());
            ResultSet D = statement.executeQuery("SELECT DoctorID FROM patients WHERE PatientID = '1'");
            String currentDoctor = DoctorsDB.getDoctorName(Integer.parseInt(D.getString("DoctorID")));
            int currentDoctorID = Integer.parseInt(D.getString("DoctorID"));
            // statement.execute(
            //         "INSERT INTO Bookings (PatientID, BookingID, DoctorID, Time, Date, Detail, Prescription) VALUES ('1', '1', '"
            //                 + D + "' '12:12', '1212/12/12', 'test', 'other test');");
            ResultSet results = statement
                    .executeQuery("SELECT * FROM bookings WHERE Time = '" + newTime + "' AND DoctorChosen = '" + currentDoctorID + "' AND Date = '" + newDate + "'");
            if (results.next()) {
                JOptionPane.showMessageDialog(null, currentDoctor + " is unavailable at that time.");
            } else {
                JOptionPane.showMessageDialog(null,
                        "Your booking has successfully been changed to " + newTime + " on the " + newTime + ".");
                statement.execute("UPDATE patients SET messages = CONCAT(messages,'\n + " + LoginCheck.getFirstName()
                        + " " + LoginCheck.getSurname() + " has changed their booking from " + oldTime + " " + oldDate + " to "
                        + newTime + " " + newTime + ".') WHERE patientID = '" + LoginCheck.getID() + "';");

                // statement.executeUpdate("UPDATE bookings ")        
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