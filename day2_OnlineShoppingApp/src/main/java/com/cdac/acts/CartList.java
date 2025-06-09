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
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Iterator;

import com.cdac.dao.CartDAO;
import com.cdac.dao.CartDAOImp;
import com.cdac.tables.Cart;

/**
 * Servlet implementation class CartList
 */
@WebServlet("/CartList")
public class CartList extends HttpServlet {
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
		CartDAO obj = new CartDAOImp(dbConnection);
		HttpSession session = request.getSession(false);
		if(session==null) {
			response.sendRedirect("Login.html");
		}
		float total = 0;
		String username = (String)session.getAttribute("username");
		Iterator<Cart> cartProductList = obj.showCart(username);
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; text-align: center; }");
		out.println("table { width: 80%; margin: auto; border-collapse: collapse; background-color: white; }");
		out.println("th, td { padding: 12px; border: 1px solid #ddd; text-align: center; }");
		out.println("th { background-color: #007bff; color: white; }");
		out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Product List</h2>");
		out.println("<h2>Hello "+ session.getAttribute("username") +"</h2>");
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th> Name </th>");
		out.println("<th> Price </th>");
		out.println("<th> Quantity </th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		while(cartProductList.hasNext()) {
		    Cart cartItem = cartProductList.next();
		    out.println("<tr>");
		    out.println("<td> "+ cartItem.getName() +" </td>");
		    out.println("<td> " + cartItem.getPrice() + " </td>");
		    out.println("<td> "+ cartItem.getQuantity() +   "</td>");
		    out.println("<td><a href='DeleteItemFromCart?categoryId="+cartItem.getCategoryId()+"&productId="+cartItem.getProductId()+"'>-</a></td>");
		    out.println("</tr>");
		    total += cartItem.getPrice()*cartItem.getQuantity();
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("<a href='CategoryWeb'>Continue Shopping</a>");
		out.println("<h3>"+total+"</h3>");
		session.setAttribute("amount", total);
		out.println("<a href='Payment.html'>Buy Your Cart</a>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
