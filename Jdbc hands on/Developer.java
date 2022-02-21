package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Developer {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		try{
			Connection con = GetConnection.getConnection();
			System.out.println("Enter account name to add ");
			String name = sc.nextLine();
			System.out.println("Enter account no:");
			int acc = sc.nextInt();
			System.out.println("Enter balance to add ");
			int balance=sc.nextInt();
			System.out.println("Enter mobile no:");
			long  l= sc.nextLong();
			System.out.println("Entered details:"+name +"  "+acc+" "+balance +"  "+l);
			PreparedStatement pr =con.prepareStatement("insert into bank values(?,?,?,?)");
			pr.setInt(1, acc);
			pr.setString(2, name);
			pr.setInt(3, balance);
			pr.setLong(4, l);
			System.out.println("Record saved:"+pr);
			
			//step 4
			int data = pr.executeUpdate();
			System.out.println("record executed.."+data);
			pr=con.prepareStatement("select * from bank");
			ResultSet rs=pr.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getLong(4));
			}
			con.close();
//			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}

}
