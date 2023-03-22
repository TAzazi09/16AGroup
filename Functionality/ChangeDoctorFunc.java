package Functionality;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ChangeDoctorFunc {
    public static void main(String[] args) {
        
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connects to the database
        Connection connection = DatabaseConnectionFunc.getConnection();
        Statement statement = connection.createStatement();
        ResultSet D = statement
                .executeQuery("SELECT DoctorID FROM patients WHERE PatientID = '" + LoginCheck.getID() + "'");
       D.next();
}
    }
}