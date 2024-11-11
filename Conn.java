package UniversityManagementSystem;
import java.sql.*;


public class Conn {
    Connection c;
    Statement s;

    Conn() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            c = DriverManager.getConnection("jdbc:mysql:///universitymangenmentsystem", "root", "1234$$");

            // Create a statement object to execute queries
            s = c.createStatement();

        } catch (Exception e) {
            // Print stack trace for debugging
            e.printStackTrace();
        }
    }

    
}






