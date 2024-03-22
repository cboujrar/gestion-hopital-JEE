package Connextion_Sql;

import java.sql.Connection;  
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Connextion {
Connection conn ;
	
	public static Connection  ConnecrDb(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/devoir","root","");
			return conn;
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null,e);
			
			return null;
		}
		
		
		
	}

}