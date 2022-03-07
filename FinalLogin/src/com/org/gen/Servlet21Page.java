package com.org.gen;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet21Page extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet21Page() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

		String username = request.getParameter("name");   
        String password = request.getParameter("password");
        boolean valid=false;
		System.out.println(username +"  ::  "+password);
				
		Connection con = null;
		PreparedStatement pstmt = null;		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loading...");
			
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/genpact","username","password);
			System.out.println(" Connecting to DB ");
			
			 pstmt = con.prepareStatement("select *from genpact.login where uName=? and password=?");
			 pstmt.setString(1, username);
		        pstmt.setString(2, password);
			System.out.println("Query exceution env is ready...");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				valid=true;
			}
	
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
		
			if(valid){
				RequestDispatcher dis= request.getRequestDispatcher("loginSuccess.jsp");
				dis.forward(request, response);
			}else{
				response.sendRedirect("login.jsp");
			}
			
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		 String skill = request.getParameter("skill");
	       
			
					
			Connection con = null;
			PreparedStatement pstmt = null;		
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver is loading...");
				
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/genpact","username","password");
				System.out.println(" Connecting to DB ");
				
				 pstmt = con.prepareStatement("select *from genpact.product ");
				
			       
				System.out.println("Query exceution env is ready...");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					pw.println("<h1> ProductId :: "+rs.getInt(1)+" \n  ProductName :: "+rs.getString(2)+" \n ProductCate :: "+rs.getString(3)+" </h1>");
				}
		
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
			System.out.println(" out valid= ");
	
		
		
		
	}

}
