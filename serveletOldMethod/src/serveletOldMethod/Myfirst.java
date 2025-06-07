package serveletOldMethod;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.Date;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Myfirst extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse respond) throws IOException, ServerException {
		PrintWriter out = respond.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1> bhumur Current time is : " + new Date() + "</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}
