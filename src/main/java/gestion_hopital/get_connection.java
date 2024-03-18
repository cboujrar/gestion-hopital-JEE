package gestion_hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class get_connection {
	public static Connection c = null;
	private get_connection()
	{
		
	}
	public static Connection getconnection() {
		if(c == null)
		{
			try {
				c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital", "root", "root");
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return(c);
		}else {
			return(c);
		}
	}
	
}
