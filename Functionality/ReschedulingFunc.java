package Functionality;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Window;
import javax.swing.JOptionPane;
import GUIs.MenuPage;

/**
 * @author Ethan
 */
public class ReschedulingFunc {
    public static void resechduleBooking(String time, String date) {
        System.out.println(time);
        System.out.println(date);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Connects to the database
            Connection connection = DatabaseConnectionFunc.getConnection();
            Statement statement = connection.createStatement();
            //Test input
            System.out.println(LoginCheck.getID());
            ResultSet D = statement.executeQuery("SELECT DoctorChosen FROM patients WHERE PatientID = '1'");
            // System.out.println(D.getString("DoctorChosen"));
            statement.execute(
                    "INSERT INTO Bookings (PatientID, BookingID, DoctorChosen, Time, Date, Detail, Prescription) VALUES ('1', '1', '"
                            + D + "' '12:12', '1212/12/12', 'test', 'other test');");
            ResultSet results = statement
                    .executeQuery("SELECT * FROM bookings WHERE Time = '" + time + "' AND Date = '" + date + "'");
            if (results.next()) {
                JOptionPane.showMessageDialog(null, "INSERT DOCTOR NAME is unavailable at that time.");
            } else {
                JOptionPane.showMessageDialog(null,
                        "Your booking has successfully been changed to " + time + " on the " + date + ".");
                statement.execute("UPDATE patients SET messages = CONCAT(messages,'\n + " + LoginCheck.getFirstName()
                        + " " + LoginCheck.getSurname() + " has changed their booking from INSERT DATE AND TIME to "
                        + time + " " + date + ".') WHERE patientID = '" + LoginCheck.getID() + "';");
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