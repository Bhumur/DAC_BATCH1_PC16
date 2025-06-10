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
import java.sql.Connection;
import java.time.LocalDate;

import com.cdac.dao.CardDAOImp;
import com.cdac.dao.CartDAOImp;
import com.cdac.dao.TransactionDAOImp;
import com.cdac.exception.CardExpiredException;
import com.cdac.exception.InsufficentBalanceException;
import com.cdac.exception.InvalidCardException;
import com.cdac.tables.Card;
import com.cdac.tables.Transaction;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/Payment")
public class Payment extends HttpServlet {
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
		HttpSession session = request.getSession(false);
		if(session==null) {
			response.sendRedirect("Login.html");
		}
		String num = request.getParameter("cardnumber");
		String expiry = request.getParameter("cardexpiry");
		int cardcvv = Integer.parseInt(request.getParameter("cardcvv"));
		float amo = (float)session.getAttribute("amount");
		Card card = new Card(
				num,
				LocalDate.parse(expiry),
				cardcvv,
				0
				);
		
		CardDAOImp obj = new CardDAOImp(dbConnection);
		TransactionDAOImp tran = new TransactionDAOImp(dbConnection);
		Transaction tobj = new Transaction(0,
				(String)session.getAttribute("username"),
				LocalDate.now().toString(),
				num,
				amo,
				true
				);
			try {
				obj.validCard(card, amo);
				CartDAOImp o = new CartDAOImp(dbConnection);
				o.emptyCart((String)session.getAttribute("username"));
			} catch (InvalidCardException | CardExpiredException | InsufficentBalanceException e) {
				tobj.setStatus(false);
				response.getWriter().println("<h1>"+ e.getMessage()+"</h1>");
				e.printStackTrace();
			}
			tran.addTransaction(tobj);
			
			
			response.sendRedirect("CartList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
