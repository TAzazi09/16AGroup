package Tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Before;
import org.junit.Test;
import Functionality.*;
import Databases.*;
import Session.*;

// import kent.comp5590.Info;

/**
 * @author Callum
 */
public class ViewBookingTest {

	public static Connection connection;
	public static Statement statement;

	@Before
	public void setUp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			DatabaseConnectionFunc.main(null);

			// Initialize the database
			if (DatabaseConnectionFunc.connected) {
				DatabaseDB.initDB();

				connection = DatabaseConnectionFunc.getConnection();
				statement = connection.createStatement();

				Info.connect();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testViewBooking() throws SQLException {
		String time = "12:00";
		int doctorID = 1;
		String date = "2024-05-01";

		String yearAndMonth = "2024-05";

		try {
			//Add booking for time and date
			ResultSet testDocAvailability = Info.statement
					.executeQuery("SELECT * FROM Bookings WHERE DoctorID = '" + doctorID + "' AND Time = '"
							+ time + "' AND Date = '" + date + "';");

			//Query to check if there is a booking made in the same timeframe
			ResultSet results = statement.executeQuery(
					"SELECT DoctorID, Date, Time FROM Bookings WHERE Date LIKE '%" + yearAndMonth + "%';");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//assertEquals(testDocAvailability, results);
	}
}