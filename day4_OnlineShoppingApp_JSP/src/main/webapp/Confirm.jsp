<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    /* General page styling */
    body {
        background-color: #f4f4f4;
        font-family: Arial, sans-serif;
        margin: 20px;
    }

    /* Styling for text elements */
    p {
        font-size: 16px;
        color: #333;
    }

    /* Link styling */
    a {
        display: inline-block;
        margin-top: 10px;
        padding: 8px 12px;
        text-decoration: none;
        background-color: #007bff;
        color: white;
        border-radius: 5px;
    }

    a:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
	
	<jsp:useBean id="objUser" class="com.doa.User" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="objUser"/>
	Name : <jsp:getProperty property="name" name="objUser"/>
	Email : <jsp:getProperty property="email" name="objUser"/>
	City : <jsp:getProperty property="city" name="objUser"/>
	Username : <jsp:getProperty property="username" name="objUser"/>
	Password : <jsp:getProperty property="password" name="objUser"/>
	<a href="AddUser">Confirm</a></br><a href="Login.html">Delete</a>
</body>
</html>