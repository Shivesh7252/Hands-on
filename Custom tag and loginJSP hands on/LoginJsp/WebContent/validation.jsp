<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- 
    Document   : validate
    Created on :01-03-2022, 8:50:26 AM
    Author     : Shivesh Bharti
--%>

<%@ page import ="java.sql.*" %>
<%
    try{
    	out.println("Connecting1...");
        String username = request.getParameter("username");   
        String password = request.getParameter("password");
        out.println(username+"  "+password);
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connection..");
		//step 2
		Connection conn = DriverManager.getConnection("jdbc:url","user","your password");
		System.out.println("Connection established");
		out.println("Connected");
        PreparedStatement pst = conn.prepareStatement("Select user,pass from login where user=? and pass=?");
        
        pst.setString(1, username);
        pst.setString(2, password);
        out.println(pst);
        ResultSet rs = pst.executeQuery();                        
        if(rs.next())           
           out.println("Valid login credentials");        
        else
           out.println("Invalid login credentials");            
   }
   catch(Exception e){       
       out.println("Something went wrong !! Please try again");
    	e.printStackTrace();
   }      
%>
