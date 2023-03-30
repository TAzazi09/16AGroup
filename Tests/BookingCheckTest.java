package Tests;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Tests;
import Checks.BookingCheck;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookingCheckTest {

    @Test
    public void testBookingCheck() {
        //test for false date
        assertFalse(BookingCheck.test("07:00", "2023-01-01", 1));

        assertFalse(BookingCheck.test("18:00", "2023-01-01", 1));
        //test for wrong time

        assertFalse(BookingCheck.test("12:15", "2023-01-01", 1));

        assertFalse(BookingCheck.test("13:45", "2023-01-01", 1));

        assertFalse(BookingCheck.test("10:00", "2022-01-01", 1));

        assertFalse(BookingCheck.test("10:00", "2023-13-01", 1));

        assertFalse(BookingCheck.test("10:00", "2023-02-29", 1));

        assertFalse(BookingCheck.test("abc", "2023-01-01", 1));


        //test correct details
        assertTrue(BookingCheck.test("08:00", "2023-04-01", 1));

        assertTrue(BookingCheck.test("17:00", "2023-04-01", 1));
        
        assertTrue(BookingCheck.test("16:30", "2023-04-01", 1));
    }
}






