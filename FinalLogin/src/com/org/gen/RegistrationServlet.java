package com.org.gen;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("name");   
        String password = request.getParameter("password");
        String mobile = request.getParameter("mobile");
        boolean valid = false;
        
		//INSERT INTO `genpact`.`login` (`uName`, `password`, `mobile`) VALUES ('abc', '123', '1234567891');
		
        Connection con = null;
		PreparedStatement pstmt = null;		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loading...");
			
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/genpact","username","password");
			System.out.println(" Connecting to DB ");
			
			 pstmt = con.prepareStatement("insert into genpact.login (uName,password,mobile) values(?,?,?)");
			 pstmt.setString(1, username);
			 pstmt.setString(2,password);
			 pstmt.setString(3,mobile);
			
			 int result  = pstmt.executeUpdate();
			 if(result==1){
				 valid =true;
			 }
				pstmt.close();
        
		}catch(ClassNotFoundException e){
			System.out.println("Driver not load "+ e.getMessage());
		}catch(SQLException e){
			System.out.println("DB Error Exception "+e.getMessage());
		}
		catch(Exception e){
			
		}finally{
			if(con!=null){
				try{
					con.close(); //5
				}catch(Exception e){
					System.out.println("DB connection clossing error "+e.getMessage());
				}
			}
		}
		System.out.println(" out valid= "+valid);
        
        
	}

}
