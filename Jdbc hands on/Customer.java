package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Customer {
	static Scanner sc = new Scanner(System.in);
	static int account_no=0,balance=0;
	static String acc_name = null;
	

	public static void main(String[] args) {
		try{
			Connection con = GetConnection.getConnection();
			System.out.println("Enter your name");
			String name = sc.nextLine();
			System.out.println("Enter your account no:");
			int acc = sc.nextInt();
			System.out.println("Entered details:"+name +"  "+acc);
//			
			PreparedStatement pr = con.prepareStatement("select * from bank where account_no=? and cust_name=?");
			pr.setString(2, name);
			pr.setInt(1, acc);
			System.out.println(pr);
			
			ResultSet rs = pr.executeQuery();
			rs.next();
			account_no= rs.getInt(1);
			acc_name=rs.getString(2);
			balance=rs.getInt(3);
			System.out.println(account_no+" "+ acc_name);
			if(acc==account_no) {
				int ch=0;
				while(ch!=4) {
					pr.setInt(1, acc);
					rs = pr.executeQuery();
					rs.next();
					account_no= rs.getInt(1);
					acc_name=rs.getString(2);
					balance=rs.getInt(3);
				
				System.out.println("Chose what you want to do:");
				System.out.println("1. to check balance:");
				System.out.println("2. to deposit:");
				System.out.println("3. to withdraw:");
				System.out.println("4. to exit:");
				ch= sc.nextInt();
				switch(ch) {
				case 1:
					System.out.println("Available balance: "+balance);
					break;
				case 2:
					PreparedStatement pr1=con.prepareStatement("update bank set balance =? where account_no=? ");
					System.out.println("Enter amount to deposit:");
					int bal=sc.nextInt();
					pr1.setInt(1, balance+bal);
					pr1.setInt(2, account_no);
					pr1.executeUpdate();
					System.out.println("Deposited");
					break;
				case 3:
					if(balance>10000) {
						int d=Withdraw(rs);
						if(d>0) {
							rs=pr.executeQuery();
							rs.next();
							System.out.println("New Balance:"+rs.getInt(3));
						}
					}
					else {
						System.out.println("Available balance too low to withdraw");
					}
					break;
				default:
					System.out.println("Wrong choice");
				}
				}
			}
			else {
				System.out.println("you are not registered in our bank");
			}
			sc.close();
			con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub

	private static int Withdraw(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter amount to withdraw:");
		int withdraw=sc.nextInt();
		int data=0;
		if(withdraw>=balance){
			System.out.println("Available balance too low to withdraw");
			
		}
		else {
			PreparedStatement pr2 =GetConnection.getConnection().prepareStatement("update bank set balance =? where account_no=?");
			pr2.setInt(1, balance-withdraw);
			pr2.setInt(2, account_no);
			data =pr2.executeUpdate();
			System.out.println("executed:"+data);
			}
		return data;
		
		
	}


	}


