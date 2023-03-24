package kent.comp5590;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito.*;
import javax.swing.JOptionPane;

class ArrangeRescheduleCheckTest {
	
	@Test
	void CorrectInput() {
		String time = "08:00";
		String date = "2024-05-05";
		System.out.println(time.length());
		
		 JOptionPane optionPaneMock = mock(ArrangeRescheduleCheck.class);
		
		ArrangeRescheduleCheck.test(time, date);
		
		//assertFalse(ArrangeRescheduleCheck.test("1", "2024"));
		
		
		//ArrangeRescheduleCheck.timeCheck("12:00");
	}
	
	
}



