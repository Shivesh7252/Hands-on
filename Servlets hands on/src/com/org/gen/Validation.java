package com.org.gen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validation
 */
@WebServlet("/Validation")
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("user");
		String pass = request.getParameter("pass");
		if(name.equals("Dispatch") &&  pass.equals("pass"))
		{
			RequestDispatcher dis = request.getRequestDispatcher("welcome");
			dis.forward(request, response);
		}
		else {
			pw.println("USer name and pass is incorrect");
			RequestDispatcher dis = request.getRequestDispatcher("User.html");
			dis.include(request, response);
		}
		pw.close();
	}

}
