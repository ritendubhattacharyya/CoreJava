import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;

public class connection {
	Connection con = null;
	public static Connection dbConnection()
	{
		try {
			String url = "jdbc:mysql://localhost:3306/onlinebankingsystem";
			String user = "root";
			String pass = "password";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			return con;
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
				return null;
			}
	}

}
