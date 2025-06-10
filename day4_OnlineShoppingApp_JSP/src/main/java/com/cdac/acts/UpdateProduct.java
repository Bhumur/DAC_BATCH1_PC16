package com.cdac.acts;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import com.cdac.dao.ProductDAOImp;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection dbConnection = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		ServletContext app = getServletContext();
		dbConnection = (Connection)app.getAttribute("globalbd");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cId = Integer.parseInt(request.getParameter("catDrop"));
		int pId = Integer.parseInt(request.getParameter("proDrop"));
		String name = request.getParameter("name");
		int qty = Integer.parseInt(request.getParameter("quantity"));
		float Price = Float.parseFloat(request.getParameter("price"));
		System.out.println(cId);
		ProductDAOImp obj = new ProductDAOImp(dbConnection);
		
		obj.updateProduct(cId, pId, name, Price, qty);
		response.sendRedirect("Admin.jsp");
	}

}
