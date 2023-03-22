import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Functionality.RegistrationCheck;

/**
 * @author Callum
 * @expansion of test cases by Nikola (& code quality check)
 */
class RegTest {
    @Test
    public void testRegDetailsCorrect() {
        //Test to check if correct details are accepted
        assertTrue(RegistrationCheck.test("james", "lee", "male", 25, "11111 111111", "Dr Andrew", "deaf & blind"));
    }

    @Test
    public void firstNameTest() {
        //test to see if it will reject empty string for firstName
        Assertions
                .assertFalse(RegistrationCheck.test("", "Lee", "male", 25, "11111 111111", "Dr Jason", "deaf & blind"));
        assertFalse(RegistrationCheck.test("", "Brown", "Female", 20, "12345 123456", "Dr Jason", null));
        assertFalse(RegistrationCheck.test("", "Davis", "Female", 83, "07836 142516", "Dr Andrew", ""));

        //Test to see if it will reject null value for firstName
        assertFalse(RegistrationCheck.test(null, "Kolev", "Male", 18, "98765 098765", "Dr Jason", "foo"));
        assertFalse (RegistrationCheck.test(null, "Smith", "Male", 45, "12345 123456", "Dr Andrew", "bar"));

        //Test to see if it will accept correct firstName
        assertTrue(RegistrationCheck.test("John", "Green", "male", 27, "13579 246800", "Dr Jason", ""));
        assertTrue(RegistrationCheck.test("Jane", "Brown", "Female", 20, "12345 123456", "Dr Jason", null));
        assertTrue(RegistrationCheck.test("Mary", "Davis", "Female", 83, "07836 142516", "Dr Andrew", ""));
        assertTrue(RegistrationCheck.test("John", "Kolev", "Male", 18, "98765 098765", "Dr Jason", "foo"));

        //Test over character limit for firstName
        assertFalse(RegistrationCheck.test("Anhfdsfhdsfhsdfhdsfhfdsh", "Lee", "male", 25, "11111 111111", "Dr Jason",
                "deaf & blind"));
        assertFalse (RegistrationCheck.test("Qwertyuiopasdfghjklzxcvb", "Smith", "Male", 45, "12345 123456", "Dr Andrew", "something"));
        assertFalse (RegistrationCheck.test("Johnisaveryveryverylongname", "Smith", "Male", 45, "12345 123456", "Dr Andrew", "hello"));

        //Reject numbers in firstName
        assertFalse(RegistrationCheck.test("john1245", "lee", "male", 25, "11111 111111", "Dr Jason", "deaf & blind"));

        //Reject firstName under character limit
        assertFalse(RegistrationCheck.test("j", "Lee", "Male", 25, "11111 111111", "Dr Jason", "deaf & blind"));

        //Checking for null value
        assertThrows(NullPointerException.class,
                () -> RegistrationCheck.test(null, "lee", "male", 10, "11111 111111", "Dr Jason", "deaf & blind"),
                "firstName shouldn't be null");
    }

    @Test
    public void surnameTest() {
        //Test surname character limit
        Assertions.assertFalse(
                RegistrationCheck.test("john", "leeerttysdffdfsdfsdffsds", "male", 25, "11111 111111", "Dr Jason",
                        "deaf & blind"));

        //Checking under limit
        Assertions.assertFalse(
                RegistrationCheck.test("john", "l", "male", 25, "11111 111111", "Dr Jason", "deaf & blind"));

        //Test for numbers included in surname
        Assertions.assertFalse(
                RegistrationCheck.test("john", "lee123", "male", 25, "11111 111111", "Dr Smith", "deaf & blind"));

        //test for null value for surname 
        assertThrows(NullPointerException.class,
                () -> RegistrationCheck.test("john", null, "male", 10, "11111 111111", "Dr Smith", "deaf & blind"),
                "age shouldn't be null");
    }

    @Test
    public void ageTest() {
        //Test under-age limit
        Assertions.assertFalse(
                RegistrationCheck.test("john", "lee", "male", 17, "11111 111111", "Dr Smith", "deaf & blind"));

        //Test over limit
        Assertions.assertFalse(
                RegistrationCheck.test("john", "lee", "male", 131, "11111 111111", "Dr Smith", "deaf & blind"));

        //Test for null values for age
        assertThrows(NullPointerException.class,
                () -> RegistrationCheck.test("john", "lee", "male", null, "11111 111111", "Dr Smith", "deaf & blind"),
                "age shouldn't be null");
    }

    @Test
    public void phoneNumberTest() {
        //Testing for only correct Phone Number is accepted
        Assertions.assertFalse(RegistrationCheck.test("john", "lee", "male", 25, "111", "Dr Smith", "deaf & blind"));

        //Testing for null values in phone number
        assertThrows(NullPointerException.class,
                () -> RegistrationCheck.test("john", "lee", "male", 18, null, "Dr Andrew", "deaf & blind"),
                "Phone Number shouldn't be null");
    }

    @Test
    public void detailsTest() {
        //Test to check details only accept under character limit 100
        Assertions.assertFalse(RegistrationCheck.test("james", "lee", "male", 25, "11111 111111", "Dr Andrew",
                "deaf & blindsadasdasdasdasdasdggfsafdsdaadssadasdasdsadasdasdsadsadsadsadsadasdasdasddsaasdsadadsasdadsdsaadsasdadsdasasddsasdasdasadsdadsadas"));

        //Test for null values in detail
        assertThrows(NullPointerException.class,
                () -> RegistrationCheck.test("john", "lee", "male", 18, "11111 111111", "Dr Andrew", null),
                "Detail shouldn't be null");
    }
}