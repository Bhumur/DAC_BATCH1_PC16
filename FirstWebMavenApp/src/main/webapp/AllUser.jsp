<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.dao.impl.UserDAOImp"%>
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Styled Table</title>
  <style>
    * {
      box-sizing: border-box;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    body {
      margin: 0;
      padding: 0;
      background: linear-gradient(120deg, #2980b9, #6dd5fa, #ffffff);
      height: 100vh;
      display: flex;
      align-items: center;
      justify-content: center;
    }

    .table-container {
      background: white;
      padding: 40px 30px;
      border-radius: 15px;
      box-shadow: 0 15px 30px rgba(0,0,0,0.2);
      width: 80%;
      max-width: 800px;
      transition: 0.3s;
    }

    .table-container h2 {
      text-align: center;
      margin-bottom: 25px;
      color: #2980b9;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }

    th, td {
      padding: 12px;
      text-align: left;
      border-bottom: 1px solid #ccc;
    }

    th {
      background-color: #2980b9;
      color: white;
    }

    tr:hover {
      background-color: #f1f1f1;
    }

    @media (max-width: 400px) {
      .table-container {
        padding: 30px 20px;
      }
    }
  </style>
</head>
<body>
<%
	UserDAOImp obj = new UserDAOImp((SessionFactory)application.getAttribute("hiberFactory"));
	Iterator<User> itr =  obj.showUsers();
%>
  <div class="table-container">
    <h2>User Information</h2>
    <table>
      <thead>
        <tr>
          <th>Username</th>
          <th>Name</th>
          <th>Email</th>
          <th>City</th>
        </tr>
      </thead>
      <tbody>
      
     <%
     while(itr.hasNext()){
    	 User u = itr.next();
    	 %>	 
    	 <tr>
    	 	<td><%=u.getUsername() 	%></td>
    	 	<td><%=u.getName() 		%></td>
    	 	<td><%=u.getEmail()		%></td>
    	 	<td><%=u.getCity()		%></td>
    	 </tr>
    	 <% 
     }
     %>
      </tbody>
    </table>
  </div>
</body>
</html>
