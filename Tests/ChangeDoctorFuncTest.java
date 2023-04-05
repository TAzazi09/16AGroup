
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Databases.DatabaseDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import Functionality.*;
import Info.*;
import Databases.*;

/**
 * @author Callum
 */
public class ChangeDoctorFuncTest {
	public static Connection connection;
	public static Statement statement;

	@Before
	public void setUp() throws Exception {

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
	}

	@Test
	public void testChangeDoctor() throws Exception {
		// Set up initial state
		String oldDoctorName = "Dr. Smith";
		String newDoctorName = "Dr. Johnson";
		int oldDoctorID = 123;
		int newDoctorID = 456;
		String backgroundID = "789";
		String firstName = "John";
		String surname = "Doe";
		String expectedMessage = "Your doctor has successfully been changed to " + newDoctorName + ".";

		// Call the method
		Session.backgroundID = backgroundID;
		try {
			//statement = connection.createStatement();
			//Checking if it can change doctor if all requirements are hit	
			Session.statement
					.execute("UPDATE Patients SET messages = CONCAT(messages,'\n + " + firstName
							+ " " + surname + " has changed their doctor to " + newDoctorName
							+ ".') WHERE patientID = '" + Session.backgroundID + "';");
		} catch (Exception e) {
			assertEquals(expectedMessage, "Your doctor has successfully been changed to " + newDoctorName + ".");
		}
	}

	@Test
	public void testNotChangeDoctor() throws Exception {
		// Set up initial state

		String doctorName = "Dr. Johnson";
		String backgroundID = "789";
		String firstName = "John";
		String surname = "Doe";
		String expectedMessage = "Doctor does not exist!";

		// Call the method
		Session.backgroundID = backgroundID;
		try {
			//statement = connection.createStatement();
			//Checking if it can change doctor if all requirements are hit	
			Session.statement.executeUpdate("use NHS");
			ResultSet resultSet = Session.statement
					.executeQuery("SELECT Name FROM Doctors WHERE Name = '" + doctorName + "';");
		} catch (Exception e) {
			assertEquals(resultSet, "Doctor does not exist!");
		}
	}
}