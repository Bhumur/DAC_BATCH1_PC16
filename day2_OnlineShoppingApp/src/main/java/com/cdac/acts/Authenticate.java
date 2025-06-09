package com.cdac.acts;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cdac.dao.UserDAOImp;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection dbConnection = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		ServletContext app = getServletContext();
		String dburl = app.getInitParameter("dburl");
		String schema = app.getInitParameter("schema");
		String user = app.getInitParameter("user");
		String pass = app.getInitParameter("pass");
		String load = app.getInitParameter("loader");
		try {
			Class.forName(load);
			dbConnection = DriverManager.getConnection(dburl+schema,user,pass);
			app.setAttribute("globalbd", dbConnection);			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			UserDAOImp user = new UserDAOImp(dbConnection);
			
			if(user.validUser(username, password)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				if(username.equals("admin")) {
					response.sendRedirect("Admin.html");
				}else{
					response.sendRedirect("CategoryWeb");
				}
			}else{
				response.getWriter().println("<script>alert('Wrong User');</script>");
			}
	}

}
