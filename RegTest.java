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
        assertTrue(RegistrationCheck.test("James", "Lee", "male", 25, "11111 111111", "Dr Andrew", "deaf & blind"));
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
        assertFalse(RegistrationCheck.test(null, "Smith", "Male", 45, "12345 123456", "Dr Andrew", "bar"));

        //Test to see if it will accept correct firstName
        assertTrue(RegistrationCheck.test("John", "Green", "male", 27, "13579 246800", "Dr Jason", ""));
        assertTrue(RegistrationCheck.test("Jane", "Brown", "Female", 20, "12345 123456", "Dr Jason", null));
        assertTrue(RegistrationCheck.test("Mary", "Davis", "Female", 83, "07836 142516", "Dr Andrew", ""));
        assertTrue(RegistrationCheck.test("John", "Kolev", "Male", 18, "98765 098765", "Dr Jason", "foo"));

        //Test over character limit for firstName
        assertFalse(RegistrationCheck.test("Anhfdsfhdsfhsdfhdsfhfdsh", "Lee", "male", 25, "11111 111111", "Dr Jason",
                "deaf & blind"));
        assertFalse(RegistrationCheck.test("Qwertyuiopasdfghjklzxcvb", "Smith", "Male", 45, "12345 123456", "Dr Andrew",
                "something"));
        assertFalse(RegistrationCheck.test("Johnisaveryveryverylongname", "Smith", "Male", 45, "12345 123456",
                "Dr Andrew", "hello"));

        //Reject numbers in firstName
        assertFalse(RegistrationCheck.test("John1245", "Lee", "male", 25, "11111 111111", "Dr Jason", "deaf & blind"));
        assertFalse(RegistrationCheck.test("12345678", "Smith", "Male", 45, "12345 123456", "Dr Andrew", "something"));
        assertFalse(RegistrationCheck.test("123", "Smith", "Male", 45, "12345 123456", "Dr Andrew", "hello"));

        //Reject firstName under character limit
        assertFalse(RegistrationCheck.test("J", "Lee", "Male", 25, "11111 111111", "Dr Jason", "deaf & blind"));
        assertFalse(RegistrationCheck.test("A", "Smith", "Male", 45, "12345 123456", "Dr Andrew", "something"));

        //Checking for null value
        assertThrows(NullPointerException.class,
                () -> RegistrationCheck.test(null, "Lee", "female", 100, "15073 84920", "Dr Jason", "deaf & blind"),
                "firstName shouldn't be null");
    }

    @Test
    public void surnameTest() {
        //Test to see if it will reject empty string for surname
        assertFalse(RegistrationCheck.test("John", "", "male", 25, "11111 111111", "Dr Jason", ""));

        //Test surname character limit
        Assertions.assertFalse(
                RegistrationCheck.test("Sam", "leeerttysdffdfsdfsdffsds", "male", 25, "11111 111111", "Dr Jason",
                        "deaf & blind"));

        //Checking under limit
        Assertions.assertFalse(
                RegistrationCheck.test("Bob", "l", "male", 25, "11111 111111", "Dr Jason", ""));

        //Test for numbers included in surname
        Assertions.assertFalse(
                RegistrationCheck.test("Frank", "lee123", "male", 25, "11111 111111", "Dr Smith", "foo"));

        //test for null value for surname 
        assertFalse(RegistrationCheck.test("Smith", null, "male", 10, "11111 111111", "Dr Smith", "foo"));
    }

    @Test
    public void ageTest() {
        //Test under-age limit
        Assertions.assertFalse(
                RegistrationCheck.test("Rachel", "Long", "male", 17, "11111 111111", "Dr Smith", "something"));

        //Test over limit
        Assertions.assertFalse(
                RegistrationCheck.test("Daniel", "Lee", "male", 131, "11111 111111", "Dr Smith", null));

        //Test for null values for age
        assertFalse(RegistrationCheck.test("John", "Steward", "male", null, "11111 111111", "Dr Smith",
                "Hello world"));
    }

    @Test
    public void phoneNumberTest() {
        //Testing for only correct Phone Number is accepted
        Assertions
                .assertFalse(RegistrationCheck.test("Jack", "Lampard", "male", 25, "111", "Dr Smith", ""));

        //Testing for null values in phone number
        assertFalse(RegistrationCheck.test("Elon", "Musk", "male", 18, null, "Dr Andrew", null));
    }

    @Test
    public void detailsTest() {
        //Test to check details only accept under character limit 100
        Assertions.assertFalse(RegistrationCheck.test("James", "Stephan", "male", 25, "11111 111111", "Dr Andrew",
                "deaf & blindsadasdasdasdasdasdggfsafdsdaadssadasdasdsadasdasdsadsadsadsadsadasdasdasddsaasdsadadsasdadsdsaadsasdadsdasasddsasdasdasadsdadsadas"));
    }
}