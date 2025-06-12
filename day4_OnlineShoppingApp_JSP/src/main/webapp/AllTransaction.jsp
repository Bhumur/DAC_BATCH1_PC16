<%@page import="com.doa.Transaction"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.dao.impl.TransactionDAOImp"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%
Connection dbConnection = null;
ServletContext app = getServletContext();
dbConnection = (Connection)app.getAttribute("globalbd");
TransactionDAOImp obj = new TransactionDAOImp(dbConnection);
Iterator<Transaction> list = obj.showAllTransaction();
%>
<h1>Transaction</h1>
<table>
<thead>
<tr>
	<th> Transaction Id </th>
	<th> Transaction Date </th>
	<th> Username </th>
	<th> Card Number </th>
	<th> Amount </th>
	<th> Status </th>
</tr>
</thead>
<tbody>
	<%
		while(list.hasNext()){Transaction t = list.next();
	%>
	<tr>
	<td><%= t.getTransactionId()	%></td>
	<td><%= t.getDate() 			%></td>
	<td><%= t.getUsername() 		%></td>
	<td><%= t.getCardNumber() 		%></td>
	<td><%= t.getAmount() 			%></td>
	<td><%= t.isStatus() 			%></td>
	</tr>
	<%
		} 
	%>
</tbody>

</table>
<a href="Admin.jsp">Back</a>
</body>
</html>