package sqlcontrol;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect_sql {
	
	 public static void main(String[] args) {
		 Connection conn = null;
	try {
        // The newInstance() call is a work around for some
        // broken Java implementations

        Class.forName("com.mysql.jdbc.Driver").newInstance();
    } catch (Exception ex) {
        System.out.println("Error");
    }
	try {
	    conn =
	       DriverManager.getConnection("jdbc:mysql://localhost/test?" +
	                                   "user=monty&password=greatsqldb");

	    // Do something with the Connection

	  
	} catch (SQLException ex) {
	    // handle any errors
	    System.out.println("SQLException: " + ex.getMessage());
	    System.out.println("SQLState: " + ex.getSQLState());
	    System.out.println("VendorError: " + ex.getErrorCode());
	}
	
	
	
	 }
	 
}
