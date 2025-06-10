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

import com.cdac.dao.CategoryDAO;
import com.cdac.dao.CategoryDAOImp;
import com.cdac.tables.Category;

/**
 * Servlet implementation class UpdateCategory
 */
@WebServlet("/UpdateCategory")
public class UpdateCategory extends HttpServlet {
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
		CategoryDAO obj = new CategoryDAOImp(dbConnection);
		Iterator<Category> i = obj.allCategory();
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='UpdateCategory' method='post'>");
		out.println("<select name='drop'>");
		while(i.hasNext()) {
			Category c = i.next();
			out.println("<option value='"+c.getCategoryId()+"'>"+c.getCategoryName()+"</option>");
		}
		out.println("</select>");
		out.println("Category Name :<input type='text' name='name' placeholder='Name'/>");
		out.println("Discription :<input type='text' name='dis' placeholder='Discription'/>");
		out.println("Image :<input type='text' name='img' placeholder='City'/>");
		out.println("<button>Submit</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDAO obj = new CategoryDAOImp(dbConnection);
		obj.updateCategory(Integer.parseInt(request.getParameter("drop")) , request.getParameter("name"), request.getParameter("dis"), request.getParameter("img"));
		response.sendRedirect("Admin.jsp");
	}

}
