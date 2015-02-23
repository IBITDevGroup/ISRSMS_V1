import java.sql.*;
import javax.swing.*;

public class SQLite_login_connector {
	//Initializes global connection variable (unused until now!)
	Connection conn_log = null;
	
	public static Connection logindb_connection(){
		
		//Simple try catch block that prints error trace log in a JOptionPane if runtime error occurs.
		
		try{
			Class.forName("org.sqlite.JDBC");
			
			Connection conn_log = DriverManager.getConnection("jdbs:sqlite:/SQLite/ISRSMS_Login.sqlite");
			JOptionPane.showMessageDialog(null, "Connection Successful!");
			return conn_log;
			
		}	catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
	

}
