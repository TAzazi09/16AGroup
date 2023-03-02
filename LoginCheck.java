import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginCheck {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void main(String user, String password) {
        LoginCheck db = new LoginCheck();
        String u = user;
        String p = password;
        db.testFunction(u,p);
        System.out.println("username is " + user);
        System.out.println("password is " + password);
    }

    public void testFunction(String username, String password) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/testing?user=***&password=***");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from test where username = '" + username + "' and password = '"
                    + password + "'");
            boolean stop = false;
            while ((resultSet.next()) || (stop = false)) {

                if ((username.equals(resultSet.getString("username")))
                        || (password.equals(resultSet.getString("password")))) {
                    stop = true;
                    nextStep();
                    break;

                }
            }
            if (!stop) {
                System.out.println("Fails");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void nextStep() {
        System.out.println("this would be the next page");
    }
}