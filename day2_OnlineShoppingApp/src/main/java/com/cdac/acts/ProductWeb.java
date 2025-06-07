package com.cdac.acts;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import com.cdac.dao.ProductDAOImp;
import com.cdac.tables.Product;

/**
 * Servlet implementation class ProductWeb
 */
@WebServlet("/ProductWeb")
public class ProductWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDAOImp product = new ProductDAOImp();
		Iterator<Product> productList = product.showProduct(Integer.parseInt(request.getParameter("categoryId")));
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
			out.println("<table border='1'>");
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th> Name </th>");
			out.println("<th> Price </th>");
			out.println("<th> Quantity </th>");
			out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			while(productList.hasNext()) {
			    Product obj = productList.next();
			    out.println("<tr>");
			    out.println("<td> "+ obj.getProductName() +" </td>");
			    out.println("<td> " + obj.getProductPrice() + " </td>");
			    out.println("<td> "+ obj.getProductQuantity() +   "</td>");
			    out.println("</tr>");
			}
			out.println("</tbody>");
			out.println("</table>");
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
