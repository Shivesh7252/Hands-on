package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection{
	public static Connection getConnection()
	{
		Connection con =null;
		try {
			//step 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection..");
			//step 2
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hands_on","root","Shivesh");
			System.out.println("Connection established");
			//step 3
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
		
	}
}
