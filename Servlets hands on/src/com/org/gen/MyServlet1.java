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
 * Servlet implementation class MyServlet1
 */
@WebServlet("/MyServlet1")
public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();

		String name = request.getParameter("user");

		String pass = request.getParameter("pass");

		pw.println(" Hello : "+name);

		pw.println(" your password is :"+ pass);
		//creating 2 cookies
		Cookie c1 = new Cookie("user", name);
		Cookie c2 = new Cookie("pass",pass);
//		add the cookie to response
		response.addCookie(c1);
		response.addCookie(c2);
		
		pw.println("<br>" +"<a href='welcome'>"+"View details"+"</a>");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
