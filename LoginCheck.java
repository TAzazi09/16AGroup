import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginCheck {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void main(String user, String password) {
        testFunction(user, password);

        System.out.println("username is " + user);
        System.out.println("password is " + password);
    }

    public static void testFunction(String username, String password) {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost/NHS?user=root&password=legome12");
            statement = connection.createStatement();
            //Lines below are used for creating tables
       //     statement.executeUpdate("DROP DATABASE IF EXISTS NHS;");
         //   statement.executeUpdate("CREATE DATABASE NHS");
            // statement.executeUpdate("use NHS");
            // statement.executeUpdate("CREATE DATABASE NHS");
        //    statement.executeUpdate("DROP TABLE IF EXISTS patients;");
        //    statement.execute("CREATE TABLE patients (            PatientID int not null auto_increment,              FirstName VARCHAR(15) not null,              Surname varchar(15) NOT NULL,              PRIMARY KEY (patientID),              Gender varchar(10),              Age int (3),              PhoneNumber varchar(15),              DoctorChosen varchar(20),              Details varchar(100)            );");
            statement.execute("INSERT INTO patients (FirstName, Surname, Gender, Age, PhoneNumber, DoctorChosen, Details) VALUES ('John', 'ER', 'Male', 19, '11111 111111', 'Me', 'Not Known')");
            //

            resultSet = statement.executeQuery("select * from patients WHERE FirstName = '" + username + "'"
            //  + "'
            //  and FirstName = '"
                    // + password + "'"
                    );
            boolean stop = false;
            if(resultSet == null)
            {
                System.out.println("Fasddsil");
                System.exit(1);
            }

            // while (resultSet.next())
			// 	System.out.println(resultSet.getString("PatientID") + " - " + resultSet.getString("FirstName") + " - " + resultSet.getString("Surname"));
            while (resultSet.next()) {
                if ((username.equals(resultSet.getString("FirstName")))
                        || (password.equals((resultSet.getString("FirstName")) + (resultSet.getString("PatientID"))))) {
                    stop = true;
                    System.out.println("Y");
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

    public static void nextStep() {
        System.out.println("this would be the next page");
    }
}