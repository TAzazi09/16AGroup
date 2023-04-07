import static org.junit.Assert.assertFalse;

import java.beans.Transient;
import java.sql.ResultSet;

import org.junit.jupiter.api.Test;

import com.mysql.cj.Session;
import java.sql.Statement;

import Databases.DoctorsDB;
import Info.General;
import Tests.target.classes.*;;


public class ViewPastBookingTest {

   


    @Test
    public void dateIncorrect(){

        String DoctorID = "Dr Jason";
        String Date = "2001 05 01";
        String Time = "13:00";
        PastBookingsPage PastBookingsPage = new PastBookingsPage(DoctorID,Date,Time);
        assertNull(PastBookingsPage); 
    }

    public void dateFormatIncorrect(){
        String DoctorID = "Dr Jason";
        String Date = "05.01.2024";
        String Time = "13:00";
        PastBookingsPage PastBookingsPage = new PastBookingsPage(DoctorID,Date,Time);
        assertNull(PastBookingsPage);
    }


    @Test
    public void testNull() {
        // Arrange
        String DoctorID = "1";
        String Date = null;
        String Time = null;
        PastBookingsPage p = new PastBookingsPage(DoctorID,Date,Time);
        // Assert
        assertNull( PastBookingsPage.loadPage(DoctorID, Date, Time));
    }

    @Test
    public void testCorrect() {

        // Arrange
        String DoctorID = "1";
        String Date = "2024-05-01";
        String Time = "12:00";
        // Act
        PastBookingsPage p = new PastBookingsPage(DoctorID,Date,Time);
        // Assert
        assertNotNull( PastBookingsPage.loadPage(DoctorID, Date, Time));
    }
    
}
