package Functionality;

// imports from the java library
import java.sql.ResultSet;
import javax.swing.JOptionPane;

// imports from the project
import Checks.ArrangeRescheduleCheck;
import GUIs.MenuPage;
import Session.*;
import Databases.PatientsDB;

/**
 * @author Nikola
 */
public class ArrangeBookingFunc {
    public static void arrangeBooking(String time, String date) {
        try {
            if (time == null || date == null) {
                JOptionPane.showMessageDialog(null, "Please select a time and date.");
            } else if (ArrangeRescheduleCheck.test(time, date)) {
                // get the patient's doctor ID
                int patientID = Integer.parseInt(Info.backgroundID);
                int currentDocID = PatientsDB.getDoctorID(patientID);
                String currentDocName = PatientsDB.getDoctorName(patientID);

                //Checks if the doctor is available at that time
                ResultSet docAvailability = Info.statement
                        .executeQuery("SELECT * FROM bookings WHERE DoctorID = '" + currentDocID + "' AND Time = '"
                                + time + "' AND Date = '" + date + "';");

                if (docAvailability.next()) {
                    //Informs the user the doctors unavailable
                    JOptionPane.showMessageDialog(null, currentDocName + " is unavailable at that time.");
                } else {
                    // insert the booking into the database (after ensuring the doctor is available)
                    Info.statement.execute(
                            "INSERT INTO bookings (PatientID, DoctorID, Time, Date) VALUES ('" + Info.backgroundID
                                    + "', '" + currentDocID + "', '" + time + "', '" + date + "');");

                    // display a message to the user
                    JOptionPane.showMessageDialog(null,
                            "Your booking has successfully been arranged at " + time + " on the " + date + ".");

                    // add a message to the patient's log
                    Info.statement
                            .execute("UPDATE patients SET messages = CONCAT(messages,'\n + " + Info.firstname
                                    + " " + Info.surname + " has arranged a booking at "
                                    + time + " on " + date + " with " + currentDocName + ".') WHERE patientID = '"
                                    + Info.backgroundID + "';");

                    // Close all windows in the array
                    General.closeAllWindows();

                    //Returns the user to the main menu
                    MenuPage.main(null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}