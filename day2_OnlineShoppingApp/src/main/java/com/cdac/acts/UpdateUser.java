package com.cdac.acts;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.cdac.dao.UserDAO;
import com.cdac.dao.UserDAOImp;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='UpdateUser' method='post'>");
		out.println("First Name :<input type='text' name='fname' placeholder='First Name'/>");
		out.println("Last Name :<input type='text' name='lname' placeholder='Last Name'/>");
		out.println("Email :<input type='text' name='email' placeholder='Email'/>");
		out.println("City :<input type='text' name='city' placeholder='City'/>");
		out.println("Username :<input type='text' name='username' placeholder='Username'/>");
		out.println("Password :<input type='text' name='password' placeholder='Password'/>");
		out.println("<button>Submit</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = new UserDAOImp();
		if(dao.validUser(request.getParameter("username"), request.getParameter("password"))) {
			dao.updateUser(
					request.getParameter("username"),
					request.getParameter("fname") + " " +request.getParameter("lname"),
					request.getParameter("email"),
					request.getParameter("city")
					);
			response.sendRedirect("Admin.html");
		}else {
			response.getWriter().println("Invalid Username or PassWord");
		}
	}

}
