package Functionality;

import javax.swing.JOptionPane;
import Checks.BookingCheck;
import Databases.BookingsDB;
import GUIs.MenuPage;
import Info.*;
import Databases.PatientsDB;

/**
 * @author Nikola
 */
public class BookingFunc {
    public static void sendData(String time, String date) {
        try {
            if (time == null || date == null) {
                JOptionPane.showMessageDialog(null, "Please select a time and date.");
            } else if (BookingCheck.test(time, date, PatientsDB.getDoctorID(Session.userID))) {
                int patientID = Session.userID;
                int currentDocID = PatientsDB.getDoctorID(patientID);
                String currentDocName = PatientsDB.getDoctorName(patientID);

                // insert the booking into the database (after ensuring the doctor is available)
                BookingsDB.addBooking(patientID, currentDocID, time, date, null, null);

                // Add the booking to the log
                LogFunc.logBooking(patientID, time, date, currentDocName);

                // display a message to the user
                JOptionPane.showMessageDialog(null,
                        "Your booking has successfully been arranged at " + time + " on the " + date + ".");

                // add a message to the patient's log
                Session.statement
                        .execute("UPDATE Patients SET messages = CONCAT(messages,'\n + " + Session.firstname
                                + " " + Session.surname + " has arranged a booking at "
                                + time + " on " + date + " with " + currentDocName + ".') WHERE patientID = '"
                                + Session.userID + "';");

                // Close all windows and return to the main menu
                General.closeAllWindows();
                MenuPage.loadPage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}