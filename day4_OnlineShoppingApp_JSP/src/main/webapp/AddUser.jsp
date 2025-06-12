<%@page import="com.dao.impl.UserDAOImp"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.doa.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="objUser" type="com.doa.User" scope="session"></jsp:useBean>
	<%
	ServletContext app = getServletContext();
	String dburl = app.getInitParameter("dburl");
	String schema = app.getInitParameter("schema");
	String user = app.getInitParameter("user");
	String pass = app.getInitParameter("pass");
	String load = app.getInitParameter("loader");
	Class.forName(load);
	Connection dbConnection = DriverManager.getConnection(dburl+schema,user,pass);
	app.setAttribute("globalbd", dbConnection);	
	UserDAOImp obj = new UserDAOImp(dbConnection);
	User u = new User(
			objUser.getUsername(),
			objUser.getPassword(),
			objUser.getName(),
			objUser.getEmail(),
			objUser.getCity()
			);
	obj.addUser(u);
	response.sendRedirect("Login.html");
	%>
	
</body>
</html>