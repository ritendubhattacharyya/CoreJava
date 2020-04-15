import java.sql.*;
import javax.swing.*;
public class Sqlite_Connection {
	Connection conn=null;
	public static Connection dbConnector()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Sonu\\eclipse-workspace\\SER_Project\\Employeedata.sqlite");
			//JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
}
