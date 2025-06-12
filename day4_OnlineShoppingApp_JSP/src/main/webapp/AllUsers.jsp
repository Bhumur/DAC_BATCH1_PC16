<%@page import="com.doa.User"%>
<%@page import="com.dao.impl.UserDAOImp"%>
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
UserDAOImp obj = new UserDAOImp(dbConnection);
Iterator<User> list = obj.showUsers();
%>
<h1>Users</h1>
<table>
<thead>
<tr>
	<th> Username </th>
	<th> Password </th>
	<th> Name </th>
	<th> Email </th>
	<th> City </th>
</tr>
</thead>
<tbody>
	<%
		while(list.hasNext()){User t = list.next();
	%>
	<tr>
	<td><%= t.getUsername()			%></td>
	<td><%= t.getPassword()			%></td>
	<td><%= t.getName() 			%></td>
	<td><%= t.getEmail() 			%></td>
	<td><%= t.getCity()				%></td>
	<td><a href="DeleteUser?username=<%= t.getUsername()			%>">Delete</a></td>
	</tr>
	<%
		} 
	%>
</tbody>

</table>
<a href="Admin.jsp">Back</a>
</body>
</html>