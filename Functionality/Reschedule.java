package Functionality;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;

public class Reschedule {
    public static void resechduleBooking(String time, String date) {
        System.out.println(time);
        System.out.println(date);

         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Connects to the database
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            //Test input
            System.out.println(LoginCheck.getID());
            statement.execute("INSERT INTO Booking (BookingID, Time, Date, Detail, Prescription) VALUES ('1', '12:12', 12/12/1212', 'test', 'other test')");
            ResultSet results = statement.executeQuery("SELECT * FROM Booking WHERE Time = '" + time + "' AND Date = '" + date + "'");
            if(results.next())
            {
                System.out.println(results.getString("patientID"));
            }
         } catch (Exception e) {
            e.printStackTrace();
         }
    }
}
