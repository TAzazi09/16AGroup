package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Checks.RegistrationCheck;

/**
 * @author Callum
 * @expansion of test cases by Nikola (& code quality check)
 */
class RegTest {
    @Test
    public void correctEverything() {
        //Test to check if correct details are accepted
        assertTrue(
                RegistrationCheck.test("Mrogan", "Freeman", "male", 75, "11111 111111", "Dr Andrew",
                        "The Shawshank Redemption"));
        assertTrue(RegistrationCheck.test("Keanu", "Reeves", "Male", 45, "12345 123456", "Dr Jason", null));
        assertTrue(RegistrationCheck.test("Sandra", "Bullock", "Female", 130, "07836 142516", "Dr Andrew", ""));
        assertTrue(RegistrationCheck.test("Julia", "Roberts", "female", 18, "98765 098765", "Dr Jason", "foo"));
    }

    @Test
    public void firstNameTest() {
        // Test to see if it will reject empty string for firstName
        assertFalse(RegistrationCheck.test("", "Lee", "male", 25, "11111 111111", "Dr Jason", "deaf & blind"));
        assertFalse(RegistrationCheck.test("", "Brown", "Female", 20, "12345 123456", "Dr Jason", null));

        // Test to see if it will reject null value for firstName
        assertFalse(RegistrationCheck.test(null, "Kolev", "Male", 18, "98765 098765", "Dr Jason", "foo"));
        assertFalse(RegistrationCheck.test(null, "Teather", "Male", 42, "12345 123456", "Dr Andrew", "bar"));

        // Test over character limit for firstName
        assertFalse(RegistrationCheck.test("Anhfdsfhdsfhsdfhdsfhfdsh", "Wills", "male", 28, "11111 111111", "Dr Jason",
                "deaf & blind"));
        assertFalse(RegistrationCheck.test("Qwertyuiopasdfghjklzxcvb", "Smith", "Male", 43, "12345 123456", "Dr Andrew",
                "something"));

        // Reject firstName under character limit
        assertFalse(RegistrationCheck.test("N", "Tesla", "Male", 29, "11111 111111", "Dr Jason", "Physics"));
        assertFalse(RegistrationCheck.test("A", "Einstein", "Male", 49, "12345 123456", "Dr Andrew", "Theories"));

        // Reject numbers in firstName
        assertFalse(RegistrationCheck.test("Stephen1245", "Hawking", "male", 24, "11111 111111", "Dr Jason",
                "COSMIC RAY"));
        assertFalse(RegistrationCheck.test("123", "Styles", "Male", 40, "12345 123456", "Dr Andrew", "hello world"));

        // Test to see if it will accept correct firstName
        assertTrue(RegistrationCheck.test("Ed", "Sheeran", "male", 97, "13579 246800", "Dr Jason", "Shape of you"));
        assertTrue(RegistrationCheck.test("Ariana", "Grande", "Female", 20, "12345 123456", "Dr Jason", null));
        assertTrue(RegistrationCheck.test("Justin", "Bieber", "Male", 18, "98765 098765", "Dr Jason", "foo"));
    }

    @Test
    public void surnameTest() {
        // Test to see if it will reject empty string for surname
        assertFalse(RegistrationCheck.test("Adele", "", "female", 35, "11111 738432", "Dr Jason",
                "Hello, it's me | I was wondering..."));
        assertFalse(RegistrationCheck.test("Beyoncé", "", "Female", 20, "12345 123456", "Dr Jason", null));

        // Test for null value for surname 
        assertFalse(RegistrationCheck.test("Smith", null, "male", 10, "11111 000000", "Dr Smith", "foo"));

        // Test over character limit for surname
        assertFalse(RegistrationCheck.test("Alan", "Turingysdffdfsdfsdffsds", "male", 26, "86783 145792", "Dr Jason",
                "Computer goes bleep bloop"));

        // Reject surname under character limit
        assertFalse(RegistrationCheck.test("John", "M", "male", 23, "12346 718235", "Dr Jason", ""));

        // Test for numbers included in surname
        assertFalse(RegistrationCheck.test("Frank", "Lee123", "male", 35, "87325 129834", "Dr Smith", "foo"));

        // Test to see if it will accept correct surname
        assertTrue(RegistrationCheck.test("Frank", "Sinatra", "Male", 27, "13579 246800", "Dr Jason", null));
    }

    @Test
    public void ageTest() {
        // Test under-age limit
        assertFalse(RegistrationCheck.test("Ludwig", "Beethoven", "male", 17, "43157 532197", "Dr Smith",
                "Please don't play so loud!"));

        // Test over limit
        assertFalse(RegistrationCheck.test("Jane", "Austen", "female", 131, "27385 123593", "Dr Smith", null));

        // Test for null values for age
        assertFalse(RegistrationCheck.test("Joan", "OfArc", "Female", null, "78623 897234", "Dr Smith",
                "Remember, remember the 5th of November"));

        // Test for correct age lower limit
        assertTrue(RegistrationCheck.test("Queen", "ElizabethII", "Female", 18, "78623 897234", "Dr Smith",
                "Long live the queen!"));

        // Test for correct age upper limit
        assertTrue(RegistrationCheck.test("Mahatma", "Gandhi", "Male", 130, "78623 897234", "Dr Smith", "Hello world"));
    }

    @Test
    public void phoneNumberTest() {
        // Testing for wrong format of phone number
        // wrong format of space
        assertFalse(RegistrationCheck.test("Stephan", "King", "Male", 99, "123456 78901", "Dr Smith", "Author"));
        // wrong length of phone number
        assertFalse(RegistrationCheck.test("Frank", "Lampard", "male", 22, "111", "Dr Smith", "Footballer"));

        // Testing for null values in phone number
        assertFalse(RegistrationCheck.test("Elon", "Musk", "male", 18, null, "Dr Andrew", null));

        // Test for correct phone number
        assertTrue(RegistrationCheck.test("Mark", "Zuckerberg", "male", 19, "08828 082001", "Dr Andrew", null));
    }

    @Test
    public void detailsTest() {
        // Test to check details only accept under character limit 100
        assertFalse(RegistrationCheck.test("Charles", "Darwin", "male", 25, "54231 643132", "Dr Andrew",
                "Evolution blindsadasdasdasdasdasdggfsafdsdaadssadasdasdsadasdasdsadsadsadsadsadasdasdasddsaasdsadadsasdadsdsaadsasdadsdasasddsasdasdasadsdadsadas"));

        // Test to check details accept null values
        assertTrue(RegistrationCheck.test("Jon", "Snow", "male", 79, "14785 876423", "Dr Andrew", null));

        // Test to check details accept empty string
        assertTrue(RegistrationCheck.test("Vasil", "Levski", "male", 50, "12321 556655", "Dr Andrew", "Narode"));

        // Test to check details accept correct character limit
        assertTrue(RegistrationCheck.test("Hristo", "Botev", "male", 52, "55555 666666", "Dr Andrew",
                "These are some details about the patient"));
    }
}