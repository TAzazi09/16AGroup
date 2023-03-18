package Functionality;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Window;
import javax.swing.JOptionPane;
import GUIs.MenuPage;

/**
 * @author nik
 */
public class ArrangeBookingFunc {
    public static void arrangeBooking(String time, String date) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Connects to the database
            Connection connection = DatabaseConnectionFunc.getConnection();
            Statement statement = connection.createStatement();

            //Test input
            ResultSet results = statement
                    .executeQuery("SELECT * FROM bookings WHERE Time = '" + time + "' AND Date = '" + date + "'");
            if (results.next()) {
                JOptionPane.showMessageDialog(null, "INSERT DOCTOR NAME is unavailable at that time.");
            } else {
                JOptionPane.showMessageDialog(null,
                        "Your booking has successfully been arranged at " + time + " on the " + date + ".");
                statement.execute("UPDATE patients SET messages = CONCAT(messages,'\n + " + LoginCheck.getFirstName()
                        + " " + LoginCheck.getSurname() + " has arranged a booking at "
                        + time + " on " + date + ".') WHERE patientID = '" + LoginCheck.getID() + "';");
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