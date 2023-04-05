package Tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import Databases.*;
import Functionality.*;
import Info.*;

/**
 * @author Callum
 */
public class ReschedulingFuncTest {

	@Before
	public void setUp() throws Exception {
		//ArrangeBookingFunc a = new ArrangeBookingFunc();
		//kent.comp5590.ArrangeBookingFunc myClassMock = Mockito.mock(ArrangeBookingFunc.class);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			DBConnectionFunc.main(null);

			// Initialize the database
			if (DBConnectionFunc.connected) {
				DatabaseDB.initDB();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		//ResultSet selectDoc = Info.statement.executeQuery("SELECT DoctorID FROM Patients WHERE patientID = '1';");
	}

	@Test
	public void testOverall() {
		String oldDate = "2023-04-01";
		String oldTime = "12:00";
		String newDate = "2023-05-01";
		String newTime = "11:00";
		int docID = 1;

		try {
			ResultSet results = Session.statement
					.executeQuery("SELECT * FROM Bookings WHERE Time = '" + newTime + "' AND DoctorID = '"
							+ docID + "' AND Date = '" + newDate + "'");

			//Creating mock object for JOptionPane
			JOptionPane mockOptionPane = mock(JOptionPane.class);

			//Do nothing with mock object and return value from mock JOptionPane
			Mockito.doNothing().when(mockOptionPane).showMessageDialog(null, Mockito.anyString());

			//Calling resechduleBooking with date and time

			kent.comp5590.ReschedulingFunc.sendData(oldDate, oldTime, newDate, newTime);

			Mockito.verify(mockOptionPane);
			//Checking to see if same message was output once method was called with values

			mockOptionPane.showMessageDialog(null,
					"Your booking has successfully been changed to " + newTime + " on the " + newDate + ".");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testClash() {
		String oldDate = "2023-04-01";
		String oldTime = "12:00";
		String newDate = "2023-05-01";
		String newTime = "11:00";

		String date = "2023-05-01";
		String time = "11:00";
		int docID = 1;
		String curDoc = "Dr Jason";
		int curPatient = 1;

		int otherPatient = 2;

		try {
			//Populating table with booking already at desired data and time for reschedule with other patient
			Session.statement.execute(
					"INSERT INTO Bookings (PatientID, DoctorID, Time, Date) VALUES ('" + otherPatient
							+ "', '" + docID + "', '" + time + "', '" + date + "');");
			//Query to check for availability of Doctor
			ResultSet results = Session.statement
					.executeQuery("SELECT * FROM Bookings WHERE Time = '" + newTime + "' AND DoctorID = '"
							+ docID + "' AND Date = '" + newDate + "'");

			//Creating mock object for JOptionPane
			JOptionPane mockOptionPane = mock(JOptionPane.class);

			//Do nothing with mock object and return value from mock JOptionPane
			Mockito.doNothing().when(mockOptionPane).showMessageDialog(null, Mockito.anyString());

			//Calling resechduleBooking with date and time

			kent.comp5590.ReschedulingFunc.sendData(oldDate, oldTime, newDate, newTime);

			Mockito.verify(mockOptionPane);
			//Checking to see if same message was output once method was called with values

			mockOptionPane.showMessageDialog(null, curDoc + " is unavailable at that time.");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}