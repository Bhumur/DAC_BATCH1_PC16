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

import com.dao.impl.CartDAOImp;

/**
 * Servlet implementation class RemoveQuantity
 */
@WebServlet("/RemoveQuantity")
public class RemoveQuantity extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SessionFactory factory =null;
	CartDAOImp obj = null;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		factory = (SessionFactory)getServletContext().getAttribute("hiberFactory");
		obj = new CartDAOImp(factory);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session==null) {
			response.sendRedirect("Login.html");
		}
		String username = (String)session.getAttribute("username");
		int cid = Integer.parseInt(request.getParameter("cid"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		obj.removeQuantityFromCart(username, cid, pid);
		response.sendRedirect("CartList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
