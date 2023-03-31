
import static org.mockito.Mockito.*;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Checks.LoginCheck;
import Databases.*;
import Functionality.ArrangeBookingFunc;
import Session.*;

class ArrangeBookingFuncTest {

    private ResultSet resultSetMock;
    private ArrangeBookingFunc arrangeBookingFunc;

    @Before
    void setUp() {
        resultSetMock = mock(ResultSet.class);
        arrangeBookingFunc = new ArrangeBookingFunc();
    }

    @Test
    void testArrangeBookingWithNullValues() throws Exception {
        // Arrange
        String time = null;
        String date = null;

        // Mock JOptionPane.showMessageDialog method to capture the message shown to the user
        JOptionPane mockOptionPane = mock(JOptionPane.class);
        doNothing().when(mockOptionPane).showMessageDialog(null, "Please select a time and date.");

        // Act
        ArrangeBookingFunc.arrangeBooking(time, date);

        // Assert
        verify(mockOptionPane, times(1)).showMessageDialog(null, "Please select a time and date.");
    }

    @Test
    void testArrangeBookingWithDoctorUnavailable() throws Exception {
        // Arrange
        String time = "10:00";
        String date = "2022-01-01";

        // Mock ResultSet
        when(resultSetMock.next()).thenReturn(true);

        // Mock Info.statement.executeQuery method to return the mocked ResultSet
        Info infoMock = mock(Info.class);
        when(infoMock.statement.executeQuery(anyString())).thenReturn(resultSetMock);

        // Mock JOptionPane.showMessageDialog method to capture the message shown to the user
        JOptionPane mockOptionPane = mock(JOptionPane.class);
        doNothing().when(mockOptionPane).showMessageDialog(null, "Doctor is unavailable at that time.");

        // Act
        ArrangeBookingFunc.arrangeBooking(time, date);

        // Assert
        verify(infoMock.statement, times(1)).executeQuery(
                "SELECT DoctorID FROM patients WHERE patientID = '" + Info.backgroundID + "';");
        verify(infoMock.statement, times(1)).executeQuery("SELECT * FROM Bookings WHERE DoctorID = '"
                + Integer.parseInt(resultSetMock.getString("DoctorID")) + "' AND Time = '" + time + "' AND Date = '"
                + date + "';");
        verify(mockOptionPane, times(1)).showMessageDialog(null, "Doctor is unavailable at that time.");
    }

    @Test
    void testArrangeBookingWithDoctorAvailable() throws Exception {
        // Arrange
        String time = "10:00";
        String date = "2022-01-01";

        // Mock ResultSet
        when(resultSetMock.next()).thenReturn(false);

        // Mock Info.statement.executeQuery method to return the mocked ResultSets
        Info infoMock = mock(Info.class);
        when(infoMock.statement.executeQuery(anyString())).thenReturn(resultSetMock);

        // Mock Info.statement.execute method to return 1 (successful execution)
        when(infoMock.statement.execute(anyString())).thenReturn(true);

        // Mock JOptionPane.showMessageDialog method to capture the message shown to the user
        JOptionPane mockOptionPane = mock(JOptionPane.class);
        doNothing().when(mockOptionPane).showMessageDialog(null,
                "Your booking has successfully been arranged at " + time + " on the " + date + ".");

        // Mock LoginCheck methods to return test data
        LoginCheck loginCheckMock = mock(LoginCheck.class);
        when(loginCheckMock.getFirstName()).thenReturn("John");
        when(loginCheckMock.getSurname()).thenReturn("Doe");

        // Mock DoctorsDB.getDoctorName method to return test data
        when(DoctorsDB.getDoctorName(anyInt()));
    }
}