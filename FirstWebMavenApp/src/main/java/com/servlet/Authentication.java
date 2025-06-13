package com.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.hibernate.SessionFactory;

import com.dao.impl.UserDAOImp;

/**
 * Servlet implementation class Authentication
 */
@WebServlet("/Authentication")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SessionFactory factory =null;
	UserDAOImp obj = null;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		factory = (SessionFactory)getServletContext().getAttribute("hiberFactory");
		obj = new UserDAOImp(factory);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(obj.validUser(request.getParameter("username"), request.getParameter("password"))) {
			HttpSession session = request.getSession(true);
			session.setAttribute("username", request.getParameter("username"));
			if(request.getParameter("username").equals("admin")) {
				response.sendRedirect("Admin.jsp");
			}else {
				response.sendRedirect("Category.jsp");
			}
		}else {
			response.getWriter().println("INVALID");
		}
	
		
		
	}

}
