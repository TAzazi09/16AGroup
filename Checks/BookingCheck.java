package Checks;

// imports from the java library
import javax.swing.JOptionPane;
import java.sql.ResultSet;

// imports from the project
import Session.Info;

/**
 * @author Nikola
 */
public class BookingCheck {
    // Performs the time and date checks
    public static boolean test(String time, String date, int doctorID) {
        if (!timeCheck(time))
            return false;
        else if (!dateCheck(date))
            return false;
        else
            return doctorCheck(time, date, doctorID);
    }

    // Checks if the time is valid (format HH:MM and between 8:00 and 17:00)
    private static boolean timeCheck(String time) {
        // Checks if the time is in the format HH:MM
        if (time.length() != 5) {
            JOptionPane.showMessageDialog(null, "Time must be in the format HH:MM!");
            return false;
        } else if (!time.matches("[0-9][0-9]:[0-9][0-9]")) {
            JOptionPane.showMessageDialog(null, "Time must be in the format HH:MM!");
            return false;
        } else if (Integer.parseInt(time.substring(0, 2)) < 8) {
            JOptionPane.showMessageDialog(null, "Time must be between 8:00 and 17:30!");
            return false;
        } else if (Integer.parseInt(time.substring(0, 2)) > 17) {
            JOptionPane.showMessageDialog(null, "Time must be between 8:00 and 17:30!");
            return false;
        } else if (Integer.parseInt(time.substring(3, 5)) != 0 && Integer.parseInt(time.substring(3, 5)) != 30) {
            JOptionPane.showMessageDialog(null, "Time must be in 30 minute intervals (eg. 16:00, 16:30, 17:00)!");
            return false;
        }
        return true;
    }

    // Checks if the date is valid (between 1 and 31)
    // Doesn't check if the date is valid in cases like, for example, 31st of February
    private static boolean dateCheck(String date) {
        if (date.length() != 10) {
            JOptionPane.showMessageDialog(null, "Date must be in the format YYYY-MM-DD!");
            return false;
        } else if (!date.matches("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]")) {
            JOptionPane.showMessageDialog(null, "Date must be in the format YYYY-MM-DD!");
            return false;
        } else if (Integer.parseInt(date.substring(0, 4)) < 2023) {
            JOptionPane.showMessageDialog(null, "Reservation must be for 2023 and onwards!");
            return false;
        } else if (Integer.parseInt(date.substring(5, 7)) > 12) {
            JOptionPane.showMessageDialog(null, "Month must be between 1 and 12!");
            return false;
        } else if (Integer.parseInt(date.substring(8, 10)) > 31) {
            JOptionPane.showMessageDialog(null, "Day must be between 1 and 31!");
            return false;
        }
        return true;
    }

    // Checks if the doctor is available at the time and date
    public static boolean doctorCheck(String time, String date, int doctorID) {
        try {
            // Returns all tuples where the doctor is available at the time and date
            ResultSet resultSet = Info.statement
                    .executeQuery("SELECT * FROM Bookings WHERE doctorID = '" + doctorID + "' AND time = '" + time
                            + "' AND date = '" + date + "'");

            // If there are no tuples, the doctor is available
            if (!resultSet.next())
                return true;
            else {
                JOptionPane.showMessageDialog(null, "Doctor is not available at this time and date!");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }
}