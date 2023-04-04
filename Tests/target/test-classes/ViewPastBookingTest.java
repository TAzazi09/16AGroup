import java.beans.Transient;

import org.junit.jupiter.api.Test;
import GUI.ViewPastBooking;


public class ViewPastBookingTest {

    ViewPastBooking ViewPastBooking = new ViewPastBooking();


    @Test
    public void date(){
        ViewPastBooking("Dr Jason", "2024-05-01", "13:00");

    }
    
}
