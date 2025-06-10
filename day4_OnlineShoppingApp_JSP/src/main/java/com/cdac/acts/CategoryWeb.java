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

import com.cdac.dao.CategoryDAOImp;
import com.cdac.tables.Category;

/**
 * Servlet implementation class CategoryWeb
 */
@WebServlet("/CategoryWeb")
public class CategoryWeb extends HttpServlet {
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
			
			HttpSession session = request.getSession(false);
			if(session==null) {
				response.sendRedirect("Login.html");
				return;
			}
		
			CategoryDAOImp category = new CategoryDAOImp(dbConnection); 
			Iterator<Category> categoryList = category.allCategory();
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<style>");
			out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; text-align: center; }");
			out.println("table { width: 80%; margin: auto; border-collapse: collapse; background-color: white; }");
			out.println("th, td { padding: 12px; border: 1px solid #ddd; }");
			out.println("th { background-color: #007bff; color: white; }");
			out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
			out.println("td a { color: #007bff; text-decoration: none; font-weight: bold; }");
			out.println("td a:hover { text-decoration: underline; }");
			out.println("img { border-radius: 5px; box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.2); }");
			out.println("</style>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>Category List</h2>");
			out.println("<h2>Hello "+ session.getAttribute("username") +"</h2>");
			out.println("<a href='Logout'>Logout</a>");
			out.println("<table border='1'>");
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th> Name </th>");
			out.println("<th> Description </th>");  // Fixed spelling: "Discription" → "Description"
			out.println("<th> Image </th>");
			out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			while(categoryList.hasNext()) {
			    Category obj = categoryList.next();
			    out.println("<tr>");
			    out.println("<td> <a href='ProductWeb?categoryId=" + obj.getCategoryId() + "'>" + obj.getCategoryName() +"</a> </td>");
			    out.println("<td> " + obj.getCategoryDiscription() + " </td>");
			    out.println("<td> <img src='Images/"+obj.getCategoryImg() +"' height='40px' width='40px'/> </td>");
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
