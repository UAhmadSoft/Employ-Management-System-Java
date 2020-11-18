package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

	private static Connection connection = null;
	private static Statement statement = null;
	
	public static void getConnection(String path) {
		
		try {
			
			//String p = "D:\\ACP Practice Projects\\Assignment 3.1.1\\record.accdb";
			String p = "D:\\ACP Projects\\Assignment 3\\record.accdb";
			String p = "D:\\Umad Ahmad\\ACP Projects\\Assignment 3\\record.accdb";
			String url = "jdbc:ucanaccess://"+p;
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			connection = DriverManager.getConnection(url);
			//connection = DriverManager.getConnection("jdbc:ucanaccess://" + path);
			statement  = connection.createStatement();

		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		catch (SQLException e) {
		// TODO Auto-generated catch block
			System.out.println("exception");
		e.printStackTrace();
		}	
	}
	public static Statement getStatement() {
		return statement;
	}
	public static void disconnect() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
