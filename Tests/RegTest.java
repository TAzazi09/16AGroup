package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Functionality.RegistrationCheck;

/**
 * @author Callum
 * @expansion of test cases by Nikola (& code quality check)
 */
class RegTest {
    @Test
    public void correctEverything() {
        //Test to check if correct details are accepted
        assertTrue(RegistrationCheck.test("James", "Lee", "male", 25, "11111 111111", "Dr Andrew", "deaf & blind"));
        assertTrue(RegistrationCheck.test("John", "Smith", "Male", 45, "12345 123456", "Dr Jason", null));
        assertTrue(RegistrationCheck.test("Jane", "Smith", "Female", 130, "07836 142516", "Dr Andrew", ""));
        assertTrue(RegistrationCheck.test("Samantha", "Liu", "female", 18, "98765 098765", "Dr Jason", "foo"));
    }

    @Test
    public void firstNameTest() {
        // Test to see if it will reject empty string for firstName
        assertFalse(RegistrationCheck.test("", "Lee", "male", 25, "11111 111111", "Dr Jason", "deaf & blind"));
        assertFalse(RegistrationCheck.test("", "Brown", "Female", 20, "12345 123456", "Dr Jason", null));

        // Test to see if it will reject null value for firstName
        assertFalse(RegistrationCheck.test(null, "Kolev", "Male", 18, "98765 098765", "Dr Jason", "foo"));
        assertFalse(RegistrationCheck.test(null, "Smith", "Male", 45, "12345 123456", "Dr Andrew", "bar"));

        // Test over character limit for firstName
        assertFalse(RegistrationCheck.test("Anhfdsfhdsfhsdfhdsfhfdsh", "Lee", "male", 25, "11111 111111", "Dr Jason",
                "deaf & blind"));
        assertFalse(RegistrationCheck.test("Qwertyuiopasdfghjklzxcvb", "Smith", "Male", 45, "12345 123456", "Dr Andrew",
                "something"));

        // Reject firstName under character limit
        assertFalse(RegistrationCheck.test("J", "Lee", "Male", 25, "11111 111111", "Dr Jason", "deaf & blind"));
        assertFalse(RegistrationCheck.test("A", "Smith", "Male", 45, "12345 123456", "Dr Andrew", "something"));

        // Reject numbers in firstName
        assertFalse(RegistrationCheck.test("John1245", "Lee", "male", 25, "11111 111111", "Dr Jason", "deaf & blind"));
        assertFalse(RegistrationCheck.test("123", "Smith", "Male", 45, "12345 123456", "Dr Andrew", "hello"));

        // Test to see if it will accept correct firstName
        assertTrue(RegistrationCheck.test("John", "Green", "male", 27, "13579 246800", "Dr Jason", ""));
        assertTrue(RegistrationCheck.test("Jane", "Brown", "Female", 20, "12345 123456", "Dr Jason", null));
        assertTrue(RegistrationCheck.test("John", "Kolev", "Male", 18, "98765 098765", "Dr Jason", "foo"));
    }

    @Test
    public void surnameTest() {
        // Test to see if it will reject empty string for surname
        assertFalse(RegistrationCheck.test("John", "", "male", 25, "11111 738432", "Dr Jason", ""));
        assertFalse(RegistrationCheck.test("Jane", "", "Female", 20, "12345 123456", "Dr Jason", null));

        // Test for null value for surname 
        assertFalse(RegistrationCheck.test("Smith", null, "male", 10, "11111 000000", "Dr Smith", "foo"));

        // Test over character limit for surname
        assertFalse(RegistrationCheck.test("Sam", "Keeerttysdffdfsdfsdffsds", "male", 25, "86783 145792", "Dr Jason",
                "deaf & blind"));

        // Reject surname under character limit
        assertFalse(RegistrationCheck.test("Bob", "K", "male", 25, "12346 718235", "Dr Jason", ""));

        // Test for numbers included in surname
        assertFalse(RegistrationCheck.test("Frank", "Lee123", "male", 25, "87325 129834", "Dr Smith", "foo"));

        // Test to see if it will accept correct surname
        assertTrue(RegistrationCheck.test("Frank", "Sinatra", "Male", 27, "13579 246800", "Dr Jason", null));
    }

    @Test
    public void ageTest() {
        // Test under-age limit
        assertFalse(RegistrationCheck.test("Rachel", "Long", "male", 17, "43157 532197", "Dr Smith", "something"));

        // Test over limit
        assertFalse(RegistrationCheck.test("Daniel", "Lee", "female", 131, "27385 123593", "Dr Smith", null));

        // Test for null values for age
        assertFalse(RegistrationCheck.test("John", "Steward", "Female", null, "78623 897234", "Dr Smith",
                "Hello world"));

        // Test for correct age lower limit
        assertTrue(RegistrationCheck.test("Anna", "Steward", "Female", 18, "78623 897234", "Dr Smith", "Hello world"));

        // Test for correct age upper limit
        assertTrue(RegistrationCheck.test("John", "Steward", "Male", 130, "78623 897234", "Dr Smith", "Hello world"));
    }

    @Test
    public void phoneNumberTest() {
        // Testing for wrong format of phone number
        // wrong format of space
        assertFalse(RegistrationCheck.test("Stephan", "King", "Male", 99, "123456 78901", "Dr Smith", "Author"));
        // wrong length of phone number
        assertFalse(RegistrationCheck.test("Jack", "Lampard", "male", 25, "111", "Dr Smith", ""));

        // Testing for null values in phone number
        assertFalse(RegistrationCheck.test("Elon", "Musk", "male", 18, null, "Dr Andrew", null));

        // Test for correct phone number
        assertTrue(RegistrationCheck.test("Mark", "Zuckerberg", "male", 18, "08828 082001", "Dr Andrew", null));
    }

    @Test
    public void detailsTest() {
        // Test to check details only accept under character limit 100
        assertFalse(RegistrationCheck.test("James", "Stephan", "male", 25, "11111 111111", "Dr Andrew",
                "deaf & blindsadasdasdasdasdasdggfsafdsdaadssadasdasdsadasdasdsadsadsadsadsadasdasdasddsaasdsadadsasdadsdsaadsasdadsdasasddsasdasdasadsdadsadas"));

        // Test to check details accept null values
        assertTrue(RegistrationCheck.test("James", "Stephan", "male", 25, "11111 111111", "Dr Andrew", null));

        // Test to check details accept empty string
        assertTrue(RegistrationCheck.test("James", "Stephan", "male", 25, "11111 111111", "Dr Andrew", ""));

        // Test to check details accept correct character limit
        assertTrue(RegistrationCheck.test("James", "Stephan", "male", 25, "11111 111111", "Dr Andrew",
                "These are some details about the patient"));
    }
}