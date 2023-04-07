import static org.junit.Assert.*;
import java.sql.ResultSet;
import org.junit.Test;
import Checks.LoginCheck;

/**
 * @author Callum
 */
public class TestLogin {
    @Test
    public void testValidCredentials() {
        // Test valid username, password
        String username = "testuser";
        String password = "testpassword";
        ResultSet resultSet = null;
        boolean result = LoginCheck.test(username, password, resultSet);
        assertTrue(result);
    }

    @Test
    public void testInvalidCredentials() {
        // Test invalid username, password
        String username = null;
        String password = null;
        ResultSet resultSet = null;
        boolean result = LoginCheck.test(username, password, resultSet);
        assertFalse(result);
    }

    @Test
    public void testInvalidLengthCheck() {
        // Test invalid username and password lengths
        String username = "thisusernameistoolongthisusernameistoolongthisusernameistoolongthisusernameistoolongthisusernameistoolongthisusernameistoolongthisusernameistoolong";
        String password = "thispasswordistoolongthispasswordistoolongthispasswordistoolongthispasswordistoolongthispasswordistoolongthispasswordistoolongthispasswordistoolong";
        boolean result = LoginCheck.credentialsLengthCheck(username, password);
        assertFalse(result);
    }
}