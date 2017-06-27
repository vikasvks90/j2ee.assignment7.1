package assignment7.session1.factories;

import java.sql.*;
public class ConnectionFactory {
	public static Connection con = null;
	static{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "vikas";
			String password = "vikas";
			con = DriverManager.getConnection(dbURL, username, password);
			} catch (Exception e) {
			System.out.println("Error in connection factory");
			e.printStackTrace();
			}
	}
			
	public static Connection getConnection() {
		return con;

	}

}