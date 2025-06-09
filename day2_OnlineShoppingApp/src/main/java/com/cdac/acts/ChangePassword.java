package com.cdac.acts;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import com.cdac.dao.UserDAO;
import com.cdac.dao.UserDAOImp;
/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection dbConnection = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		ServletContext app = getServletContext();
		dbConnection = (Connection)app.getAttribute("gobaldb");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='ChangePassword' method='post'>");
		out.println("Username :<input type='text' name='username' placeholder='Username'/>");
		out.println("Current Password :<input type='password' name='cpass' placeholder='Current Password'/>");
		out.println("New Password :<input type='password' name='npass' placeholder='New Password'/>");
		out.println("<button>Submit</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = new UserDAOImp(dbConnection);
		if(dao.validUser(request.getParameter("username"), request.getParameter("cpass"))) {
			dao.passChange(request.getParameter("username"), request.getParameter("npass"));
			response.sendRedirect("Login.html");
		}else {
			response.getWriter().println("Invalid Username or PassWord");
		}
	}

}
