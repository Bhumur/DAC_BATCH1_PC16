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
import java.util.Iterator;
import com.cdac.dao.CategoryDAOImp;
import com.cdac.dao.ProductDAOImp;
import com.cdac.tables.Category;
import com.cdac.tables.Product;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
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
		// TODO Auto-generated method stub
		CategoryDAOImp obj = new CategoryDAOImp(dbConnection);
		Iterator<Category> i = obj.allCategory();
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='AddProduct' method='post'>");
		out.println("<select name='drop'>");
		while(i.hasNext()) {
			Category c = i.next();
			out.println("<option value='"+c.getCategoryId()+"'>"+c.getCategoryName()+"</option>");
		}
		out.println("</select>");
		out.println("Product Id :<input type='text' name='id' placeholder='Product Id'/>");
		out.println("Product Name :<input type='text' name='name' placeholder='Product Name'/>");
		out.println("Product Price :<input type='text' name='price' placeholder='Product Price'/>");
		out.println("Product Quantity :<input type='text' name='qty' placeholder='Product Quantity'/>");
		out.println("<button>Submit</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAOImp obj = new ProductDAOImp(dbConnection);
		obj.addProduct(new Product(
				Integer.parseInt(request.getParameter("drop")),
				Integer.parseInt(request.getParameter("id")),
				request.getParameter("name"),
				Float.parseFloat(request.getParameter("price")),
				Integer.parseInt(request.getParameter("qty"))
				));
		response.sendRedirect("Admin.jsp");
	}

}
