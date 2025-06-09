package com.cdac.acts;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		CategoryDAOImp obj = new CategoryDAOImp();
//		Iterator<Category> i = obj.allCategory();
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<form action='UpdateProduct' method='post'>");
//		out.println("<select name='drop'>");
//		while(i.hasNext()) {
//			Category c = i.next();
//			out.println("<option value='"+c.getCategoryId()+"'>"+c.getCategoryName()+"</option>");
//		}
//		out.println("</select>");
//		out.println("<button>Submit</button>");
//		out.println("</form>");
//		out.println("</body>");
//		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ProductDAOImp obj = new ProductDAOImp();
//		Iterator<Product> i = obj.showProduct(Integer.parseInt(request.getParameter("drop")));
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<form action='UpdateProduct?categoryId="+request.getParameter("drop")+"' method='put'>");
//		out.println("<select name='drop'>");
//		while(i.hasNext()) {
//			Product p = i.next();
//			out.println("<option value='"+p.getProductId()+"'>"+p.getProductName()+"</option>");
//		}
//		out.println("</select>");
//		out.println("Product Name :<input type='text' name='name' placeholder='Product Name'/>");
//		out.println("Product Price :<input type='text' name='price' placeholder='Product Price'/>");
//		out.println("Product Quantity :<input type='text' name='qty' placeholder='Product Quantity'/>");
//		out.println("<button>Submit</button>");
//		out.println("</form>");
//		out.println("</body>");
//		out.println("</html>");
	}

}
