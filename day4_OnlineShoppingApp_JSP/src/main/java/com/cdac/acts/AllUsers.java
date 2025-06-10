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

import com.cdac.dao.UserDAOImp;
import com.cdac.tables.User;

/**
 * Servlet implementation class AllUsers
 */
@WebServlet("/AllUsers")
public class AllUsers extends HttpServlet {
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
		UserDAOImp user = new UserDAOImp(dbConnection);
		Iterator<User> userList = user.showUsers();
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; text-align: center; }");
		out.println("table { width: 80%; margin: auto; border-collapse: collapse; background-color: white; }");
		out.println("th, td { padding: 10px; border: 1px solid #ddd; }");
		out.println("th { background-color: #007bff; color: white; }");
		out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>User List</h2>");
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th> Username </th>");
		out.println("<th> Password </th>");
		out.println("<th> Name </th>");
		out.println("<th> Email </th>");
		out.println("<th> City </th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		while(userList.hasNext()) {
		    User obj = userList.next();
		    out.println("<tr>");
		    out.println("<td>"+ obj.getUsername() +"</td>");
		    out.println("<td>"+ obj.getPassword() +"</td>");
		    out.println("<td>"+ obj.getName() +"</td>");
		    out.println("<td>"+ obj.getEmail() +"</td>");
		    out.println("<td>"+ obj.getCity() +"</td>");
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
