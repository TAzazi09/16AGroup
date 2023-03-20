package Functionality;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Window;
import javax.swing.JOptionPane;
import GUIs.MenuPage;

/**
 * @author Nikola
 */
public class ArrangeBookingFunc {
    public static void arrangeBooking(String time, String date) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connects to the database
            Connection connection = DatabaseConnectionFunc.getConnection();
            Statement statement = connection.createStatement();

            // Test input
            ResultSet currentDoctor = statement
                    .executeQuery("SELECT DoctorChosen FROM patients WHERE patientID = '" + LoginCheck.getID() + "';");
            currentDoctor.next();
            String doctor = currentDoctor.getString("DoctorChosen");
            ResultSet results = statement
                    .executeQuery("SELECT * FROM bookings WHERE Time = '" + time + "' AND DoctorChosen = '"
                            + doctor + "' AND Date = '" + date + "';");
            if (results.next()) {
                JOptionPane.showMessageDialog(null, doctor + " is unavailable at that time.");
            } else {
                statement.execute(
                        "INSERT INTO Bookings (PatientID, DoctorChosen, Time, Date) VALUES ('" + LoginCheck.getID()
                                + "' , '" + doctor + "', '" + time + "' , '" + date + "');");

                JOptionPane.showMessageDialog(null,
                        "Your booking has successfully been arranged at " + time + " on the " + date + ".");
                statement.execute("UPDATE patients SET messages = CONCAT(messages,'\n + " + LoginCheck.getFirstName()
                        + " " + LoginCheck.getSurname() + " has arranged a booking at "
                        + time + " on " + date + " with " + doctor + ".') WHERE patientID = '"
                        + LoginCheck.getID() + "';");
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