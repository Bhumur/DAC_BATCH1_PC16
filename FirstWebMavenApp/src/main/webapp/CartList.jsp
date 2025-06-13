<%@page import="com.entity.Cart"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.Session"%>
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
	User u = obj.getUser((String)session.getAttribute("username"));
	Iterator<Cart> itr = u.getCart().iterator();
%>
  <div class="table-container">
    <h2>User Information</h2>
    <table>
      <thead>
        <tr>
          <th>Product Name</th>
          <th>Price</th>
          <th>Quantity</th>
        </tr>
      </thead>
      <tbody>
      
     <%
     while(itr.hasNext()){
    	 Cart c = itr.next();
    	 %>	 
    	 <tr>
    	 	<td><%=c.getName() %></td>
    	 	<td><%=c.getPrice() %></td>
    	 	<td><div>
    	 	<div><a href="AddQuantity?pid=<%=c.getCartId().getProductId()%>&cid=<%=c.getCartId().getCategoryId()%>">+</a></div>
    	 	<div><%=c.getQuantity()%></div>
    	 	<div><a href="RemoveQuantity?pid=<%=c.getCartId().getProductId()%>&cid=<%=c.getCartId().getCategoryId()%>">-</a></div>
    	 	</div></td>
    	 </tr>
    	 <% 
     }
     %>
      </tbody>
    </table>
  </div>
</body>
</html>