package Functionality;

// imports from the java library
import javax.swing.JOptionPane;

// imports from the project
import Checks.BookingCheck;
import GUIs.MenuPage;
import Session.*;
import Databases.PatientsDB;

/**
 * @author Nikola
 */
public class BookingFunc {
    public static void arrangeBooking(String time, String date) {
        try {
            if (time == null || date == null) {
                JOptionPane.showMessageDialog(null, "Please select a time and date.");
            } else if (BookingCheck.test(time, date, PatientsDB.getDoctorID(Integer.parseInt(Info.backgroundID)))) {
                // get the patient's doctor ID
                int patientID = Integer.parseInt(Info.backgroundID);
                int currentDocID = PatientsDB.getDoctorID(patientID);
                String currentDocName = PatientsDB.getDoctorName(patientID);

                // insert the booking into the database (after ensuring the doctor is available)
                Info.statement.execute(
                        "INSERT INTO bookings (PatientID, DoctorID, Time, Date) VALUES ('" + Info.backgroundID
                                + "', '" + currentDocID + "', '" + time + "', '" + date + "');");

                // Add the booking to the log
                LogFunc.logBooking(patientID, time, date, currentDocName);

                // display a message to the user
                JOptionPane.showMessageDialog(null,
                        "Your booking has successfully been arranged at " + time + " on the " + date + ".");

                // add a message to the patient's log
                Info.statement
                        .execute("UPDATE patients SET messages = CONCAT(messages,'\n + " + Info.firstname
                                + " " + Info.surname + " has arranged a booking at "
                                + time + " on " + date + " with " + currentDocName + ".') WHERE patientID = '"
                                + Info.backgroundID + "';");

                // Close all windows and return to the main menu
                General.closeAllWindows();
                MenuPage.main(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}