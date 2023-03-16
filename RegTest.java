/**
 * @author Callum
 * @code quality check by nik
 */

import Functionality.Registration;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RegTest {
    @Test
    public void testRegDetailsCorrect() {
        //Test to check if correct details are accepted
        assertTrue(Registration.test("james", "lee", "male", 25, "11111 111111", "Dr chan", "deaf & blind"));
    }

    @Test
    public void firstNameTest() {
        //test to see if it will reject empty string for firstName
        Assertions.assertFalse(Registration.test("", "lee", "male", 25, "11111 111111", "Dr chan", "deaf & blind"));

        //Test over character limit for firstName
        assertFalse(Registration.test("anhfdsfhdsfhsdfhdsfhfdsh", "lee", "male", 25, "11111 111111", "Dr chan",
                "deaf & blind"));

        //Reject numbers in firstName
        assertFalse(Registration.test("john1245", "lee", "male", 25, "11111 111111", "Dr chan", "deaf & blind"));

        //Checking for null value
        assertThrows(NullPointerException.class,
                () -> Registration.test(null, "lee", "male", 10, "11111 111111", "Dr chan", "deaf & blind"),
                "firstName shouldn't be null");
    }

    @Test
    public void surnameTest() {
        //Test surname character limit
        Assertions.assertFalse(Registration.test("john", "leeerttysdffdfsdfsdffsds", "male", 25, "11111 111111", "Dr chan",
                "deaf & blind"));

        //Checking under limit
        Assertions.assertFalse(Registration.test("john", "l", "male", 25, "11111 111111", "Dr chan", "deaf & blind"));
        
        //Test for numbers included in surname
        Assertions.assertFalse(Registration.test("john", "lee123", "male", 25, "11111 111111", "Dr chan", "deaf & blind"));
        
        //test for null value for surname 
        assertThrows(NullPointerException.class,
                () -> Registration.test("john", null, "male", 10, "11111 111111", "Dr chan", "deaf & blind"),
                "age shouldn't be null");
    }

    @Test
    public void ageTest() {
        //Test under-age limit
        Assertions.assertFalse(Registration.test("john", "lee", "male", 17, "11111 111111", "Dr chan", "deaf & blind"));
        
        //Test over limit
        Assertions.assertFalse(Registration.test("john", "lee", "male", 131, "11111 111111", "Dr chan", "deaf & blind"));
        
        //Test for null values for age
        assertThrows(NullPointerException.class,
                () -> Registration.test("john", "lee", "male", null, "11111 111111", "Dr chan", "deaf & blind"),
                "age shouldn't be null");
    }

    @Test
    public void phoneNumberTest() {
        //Testing for only correct Phone Number is accepted
        Assertions.assertFalse(Registration.test("john", "lee", "male", 25, "111", "Dr chan", "deaf & blind"));
        
        //Testing for null values in phone number
        assertThrows(NullPointerException.class,
                () -> Registration.test("john", "lee", "male", 18, null, "Dr chan", "deaf & blind"),
                "Phone Number shouldn't be null");
    }

    @Test
    public void detailsTest() {
        //Test to check details only accept under character limit 100
        Assertions.assertFalse(Registration.test("james", "lee", "male", 25, "11111 111111", "Dr chan",
                "deaf & blindsadasdasdasdasdasdggfsafdsdaadssadasdasdsadasdasdsadsadsadsadsadasdasdasddsaasdsadadsasdadsdsaadsasdadsdasasddsasdasdasadsdadsadas"));
        
        //Test for null values in detail
        assertThrows(NullPointerException.class,
                () -> Registration.test("john", "lee", "male", 18, "11111 111111", "Dr chan", null),
                "Detail shouldn't be null");
    }
}