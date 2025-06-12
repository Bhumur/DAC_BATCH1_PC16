<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Admin Dashboard</title>
  <style>
    /* Reset and base styles */
    *, *::before, *::after {
      box-sizing: border-box;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    body {
      margin: 0;
      padding: 0;
      background: linear-gradient(120deg, #2980b9, #6dd5fa, #ffffff);
      min-height: 100vh;
      display: flex;
      align-items: center;
      justify-content: center;
    }

    /* Container styling */
    .admin-container {
      position: relative;
      background-color: #fff;
      padding: 40px 32px;
      border-radius: 16px;
      box-shadow: 0 15px 30px rgba(0,0,0,0.2);
      width: 400px;
      max-width: 90%;
      text-align: center;
      transition: box-shadow 0.3s ease;
    }

    .admin-container:hover {
      box-shadow: 0 25px 50px rgba(0,0,0,0.25);
    }

    /* Title */
    .admin-container h1 {
      margin: 0 0 32px;
      font-size: 2.5rem;
      font-weight: 700;
      color: #2980b9;
      user-select: none;
    }

    /* Logout button top right */
    .btn-logout-top {
      position: absolute;
      top: 16px;
      right: 16px;
      background-color: #7f8c8d;
      color: #fff;
      border: none;
      border-radius: 8px;
      padding: 8px 14px;
      font-size: 0.9rem;
      font-weight: 600;
      cursor: pointer;
      box-shadow: 0 2px 6px rgba(0,0,0,0.1);
      transition: background-color 0.3s ease, transform 0.2s ease;
      user-select: none;
    }
    .btn-logout-top:hover,
    .btn-logout-top:focus-visible {
      background-color: #636e72;
      outline: none;
    }
    .btn-logout-top:active {
      transform: scale(0.95);
    }

    button:focus-visible {
      outline: 3px solid #6dd5fa;
      outline-offset: 2px;
    }

    /* Button container */
    .admin-buttons {
      display: flex;
      flex-direction: column;
      gap: 18px;
    }

    /* Button base styles */
    button {
      padding: 14px 20px;
      font-size: 1rem;
      border-radius: 10px;
      border: none;
      cursor: pointer;
      font-weight: 600;
      color: #fff;
      transition: background-color 0.3s ease, transform 0.2s ease;
      user-select: none;
      box-shadow: 0 3px 6px rgba(0,0,0,0.1);
    }

    button:active {
      transform: scale(0.97);
    }

    /* Individual button colors */
    .btn-add {
      background-color: #27ae60;
    }
    .btn-add:hover,
    .btn-add:focus-visible {
      background-color: #219150;
    }

    .btn-pro {
      background-color: #2980b9;
    }
    .btn-pro:hover,
    .btn-pro:focus-visible {
      background-color: #2573a6;
    }

    .btn-tran {
      background-color: #c0392b;
    }
    .btn-tran:hover,
    .btn-tran:focus-visible {
      background-color: #962d22;
    }

    /* Responsive adjustments */
    @media (max-width: 400px) {
      .admin-container {
        padding: 30px 24px;
        width: 100%;
      }
    }
  </style>
</head>
<body>
<%
if(session.getAttribute("username")!=null && !session.getAttribute("username").equals("admin")){
	response.sendRedirect("login.html");
	return;
}
%>
  <main class="admin-container" role="main" aria-label="Admin Dashboard">
    <button class="btn-logout-top" type="button" aria-label="Logout" onclick="handleLogout()">Logout</button>
    <h1>Admin Dashboard</h1>
    <div class="admin-buttons">
      <button onclick="handleUsers()" class="btn-add" type="button" aria-label="Users">Users</button>
      <button onclick="handleCategory()" class="btn-cat" type="button" aria-label="Category">Category</button>
      <button onclick="handleProducts()" class="btn-pro" type="button" aria-label="Products">Products</button>
      <button onclick="handleTransaction()" class="btn-tran" type="button" aria-label="Transaction">Transaction</button>
    </div>
  </main>

  <script>
    function handleLogout() {
      windows.location.href("./Logout")
    }

    function handleUsers() {
    	windows.location.href("./AllUsers.jsp")
    }

    function handleCategory() {
    	windows.location.href("./CategoryWeb.jsp")
    }

    function handleProducts() {
    	windows.location.href("./ProductWeb.jsp")
    }

    function handleTransaction() {
    	windows.location.href("./Transaction.jsp")
    }
  </script>

</body>
</html>
