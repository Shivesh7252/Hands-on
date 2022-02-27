package com.org.gen;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try{  
			  
			    response.setContentType("text/html");  
			    PrintWriter out = response.getWriter();  
			          
			    String n=request.getParameter("id"); 
			    
			    if(n.equals("1")) {
			    out.print("Welcome "+"Shivesh Raj");  
			 
			   Cookie c=new Cookie("id",n);//creating cookie object  
			   response.addCookie(c);//adding cookie in the response  
			  
			    //creating submit button  
			    out.print("<form action='servlet2'method='post'>");  
			    out.print("<input type='submit' value='OK'>");  
			    out.print("</form>"); 
			    }
			    else {
			    	out.println("FirstServlet");
			    }
			     
			    out.close();
			        }catch(Exception e){System.out.println(e);} 
		 
			  }  
		 
	}

