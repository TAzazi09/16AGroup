package Functionality;

import java.sql.ResultSet;
import java.awt.Window;
import javax.swing.JOptionPane;
import GUIs.MenuPage;
import Session.Info;
import Databases.DoctorsDB;

/**
 * @author Nikola
 */
public class ArrangeBookingFunc {
    public static void arrangeBooking(String time, String date) {
        try {
            if (time == null || date == null) {
                JOptionPane.showMessageDialog(null, "Please select a time and date.");
            } else if (ArrangeRescheduleCheck.test(time, date)) {
                // get the patient's doctor
                ResultSet currentDoctor = Info.statement
                        .executeQuery(
                                "SELECT DoctorID FROM patients WHERE patientID = '" + Info.backgroundID + "';");
                currentDoctor.next();
                int doctorID = Integer.parseInt(currentDoctor.getString("DoctorID"));
                String doctor = DoctorsDB.getDoctorName(doctorID);

                //Checks if the doctor is available at that time
                ResultSet docAvailability = Info.statement
                        .executeQuery("SELECT * FROM bookings WHERE DoctorID = '" + doctorID + "' AND Time = '"
                                + time + "' AND Date = '" + date + "';");

                if (docAvailability.next()) {
                    //Informs the user the doctors unavailable
                    JOptionPane.showMessageDialog(null, doctor + " is unavailable at that time.");
                } else {
                    // insert the booking into the database (after ensuring the doctor is available)
                    Info.statement.execute(
                            "INSERT INTO bookings (PatientID, DoctorID, Time, Date) VALUES ('" + Info.backgroundID
                                    + "', '" + doctorID + "', '" + time + "', '" + date + "');");

                    // display a message to the user
                    JOptionPane.showMessageDialog(null,
                            "Your booking has successfully been arranged at " + time + " on the " + date + ".");

                    // add a message to the patient's log
                    Info.statement
                            .execute("UPDATE patients SET messages = CONCAT(messages,'\n + " + LoginCheck.getFirstName()
                                    + " " + LoginCheck.getSurname() + " has arranged a booking at "
                                    + time + " on " + date + " with " + doctor + ".') WHERE patientID = '"
                                    + Info.backgroundID + "';");

                    // Close all windows in the array
                    Window[] windows = Window.getWindows();
                    for (Window window : windows) {
                        window.dispose();
                    }
                    
                    //Returns the user to the main menu
                    MenuPage.main(null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}