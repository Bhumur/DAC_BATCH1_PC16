<%@page import="com.entity.Product"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.dao.impl.ProductDAOImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Catagory</title>
  <style>
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    body {
      background-color: #f9f9f9;
    }

    header {
      background-color: #2c3e50;
      color: white;
      padding: 15px 30px;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    header h1 {
      font-size: 24px;
    }

    nav a {
      color: white;
      margin-left: 20px;
      text-decoration: none;
      font-weight: 500;
      transition: color 0.3s;
    }

    nav a:hover {
      color: #1abc9c;
    }

    .hero {
      background: url('https://images.unsplash.com/photo-1542831371-29b0f74f9713') center/cover no-repeat;
      color: white;
      height: 400px;
      display: flex;
      flex-direction: column;
      justify-content: center;
      padding: 0 40px;
      text-shadow: 0 2px 5px rgba(0,0,0,0.5);
    }

    .hero h2 {
      font-size: 40px;
      margin-bottom: 10px;
    }

    .hero p {
      font-size: 18px;
      margin-bottom: 20px;
    }

    .hero button {
      padding: 10px 25px;
      background-color: #1abc9c;
      border: none;
      color: white;
      font-size: 16px;
      border-radius: 5px;
      cursor: pointer;
      transition: background 0.3s;
    }

    .hero button:hover {
      background-color: #16a085;
    }

    .section-title {
      text-align: center;
      padding: 40px 20px 20px;
      font-size: 28px;
      color: #2c3e50;
    }

    .products {
      display: flex;
      justify-content: center;
      flex-wrap: wrap;
      gap: 20px;
      padding: 20px 40px 60px;
    }

    .product {
      background-color: white;
      border-radius: 10px;
      overflow: hidden;
      box-shadow: 0 5px 15px rgba(0,0,0,0.1);
      width: 280px;
      transition: transform 0.3s;
    }

    .product:hover {
      transform: translateY(-5px);
    }

    .product img {
      width: 100%;
      height: 200px;
      object-fit: cover;
    }

    .product-info {
      padding: 15px;
    }

    .product-info h3 {
      margin-bottom: 10px;
      color: #2c3e50;
    }

    .product-info p {
      font-weight: bold;
      color: #1abc9c;
    }

    footer {
      text-align: center;
      padding: 20px;
      background-color: #2c3e50;
      color: white;
      margin-top: 40px;
    }

    @media (max-width: 768px) {
      .hero h2 {
        font-size: 28px;
      }

      .hero p {
        font-size: 16px;
      }

      .products {
        flex-direction: column;
        align-items: center;
      }
    }
  </style>
  <script type="text/javascript">

  
  </script>
</head>
<body>

  <header>
    <h1>BhumurKART</h1>
    <nav>
      <a href="Category.jsp">Home</a>
      <a href="PasswordChange.html">Change Password</a>
      <a href="Logout">Logout</a>
    </nav>
  </header>

  <h2 class="section-title">Featured Products</h2>
  <section class="products">
  <%
  ProductDAOImp obj = new ProductDAOImp((SessionFactory)application.getAttribute("hiberFactory"));
	int cid = Integer.parseInt(request.getParameter("categoryId"));
    		Iterator<Product> itr = obj.showProduct(cid);
    while(itr.hasNext()){
    	Product p = itr.next();
  %>
  

    <div class="product">
      <div class="product-info">
        <h3><%=p.getProductsName() %></h3>
        <p>₹<%=p.getProductsPrice() %></p>
        <button onclick="pro<%=p.getProductid().getProductId()%>()">Add To Cart</button>
      </div>
    </div>
<%} %>
    
    </div>
  </section>

  <footer>
    &copy; 2025 ShopEase. All rights reserved.
  </footer>
  <script type="text/javascript">
  
  <%
    	itr = obj.showProduct(cid);
  while(itr.hasNext()){
  	Product p = itr.next();
  %>
    
    const pro<%=p.getProductid().getProductId()%> = ()=>{
    	window.location.href="AddToCart?categoryId=<%=cid%>&productId=<%=p.getProductid().getProductId()%>";
    }
    <%}%>
  </script>

</body>
</html>
