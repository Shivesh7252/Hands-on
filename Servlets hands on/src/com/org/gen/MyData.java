package com.org.gen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyData
 */
@WebServlet("/MyData")
public class MyData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("uname");
		String age = request.getParameter("uage");
		String exp =request.getParameter("uex");
		String skill = request.getParameter("upro");
		pw.println("<h1>"+ " User Details "+"</h1>");
		pw.println("Name : "+name);
		pw.println("Age : "+age);
		pw.println("exp : "+exp);
		pw.println("skill : "+skill);
		pw.close();
	}

}
