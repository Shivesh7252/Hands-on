package com.org.gen;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int userid = Integer.parseInt(request.getParameter("id"));
		String pass = request.getParameter("pass");
		if(age>=18 && pass.equals("pass")) {
			pw.println("YOU ARE ELIGIBLE FOR REGISTRATION");
			pw.println("<h1>" +"Welcome" +"</hr>");
			pw.println(name);
			
			}
		else {
			pw.println("SORRY!!!!! You ARE NOT ELIGIBLE FOR REGISTRATION EITHER YOU ENTERED WRONG PASSWORD <br> OR YOU ARE BELOW.... " +name);
		}
		pw.println("<br><br><a href= 'Form.html'>Home</a>");
		
		pw.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}