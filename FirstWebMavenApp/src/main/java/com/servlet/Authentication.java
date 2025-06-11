package com.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.User;

/**
 * Servlet implementation class Authentication
 */
@WebServlet(loadOnStartup = 100,
		urlPatterns = {"/Authentication"})
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Configuration con= null;
	SessionFactory factory =null;
	Session ses =null;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		con = new Configuration();
		con.configure("first.cfg.xml");
		factory = con.buildSessionFactory();
		//ServletContext app = getServletContext();
		//app.setAttribute("factory", factory);
		ses = factory.openSession();
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
		ses.beginTransaction();
		User u = (User)ses.find(User.class, request.getParameter("username"));
		if(u!=null && u.getPassword().equals(request.getParameter("password"))) {
			response.sendRedirect("Home.jsp");
		}else {
			response.getWriter().println("INVAILD");
		}
		
		
		
	}

}
