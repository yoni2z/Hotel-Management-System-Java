package hotel.management.system;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionWithSQL {
    
    Connection c; // for this mysql library is required
    Statement s;
    
    ConnectionWithSQL() {
        // using the try catch block since mysql is external driver it may not be found
        try {
            // registering the driver class .... it uses the mysql connector jar
            Class.forName("com.mysql.cj.jdbc.Driver");
            // creating connection with mysql
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "Yon24"); 
            s = c.createStatement(); // creating statement
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
