<%@ page import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Selection</title>
<style>
        /* Apply basic styling to the page */
body {
    background-color: #f4f4f4;
    font-family: Arial, sans-serif;
    margin: 20px;
    padding: 20px;
    text-align: center;
}

/* Style the form */
form {
    background: white;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
    max-width: 400px;
    margin: auto;
}

/* Style labels */
label {
    font-weight: bold;
    display: block;
    margin-top: 10px;
    font-size: 16px;
}

/* Style dropdowns */
select {
    width: 100%;
    padding: 8px;
    border-radius: 5px;
    border: 1px solid #ccc;
    background-color: #fff;
    cursor: pointer;
    font-size: 16px;
}

/* Add some spacing */
select:not(:last-child) {
    margin-bottom: 15px;
}

/* Style button */
button {
    background-color: #007bff;
    color: white;
    font-size: 16px;
    padding: 10px 15px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: 0.3s;
}

button:hover {
    background-color: #0056b3;
}

    </style>
<script type="text/javascript">

<%
ServletContext app = application;
Connection dbConnection = (Connection)app.getAttribute("globalbd");
PreparedStatement ps = null;
ResultSet rs = null;
%>
function categoryChange() {
    var selectedCategory = document.getElementById("catDrop").value;
    var products = document.getElementById("proDrop");
    products.innerHTML = "";
    <% 
        ps = dbConnection.prepareStatement("SELECT productId, productName, categoryId FROM product");
        rs = ps.executeQuery();
    %>

    var productOptions = "";

    <% while (rs.next()) { %>
        if (selectedCategory == "<%= rs.getInt("categoryId") %>") {
            productOptions += "<option value='<%= rs.getInt("productId") %>'><%= rs.getString("productName") %></option>";
        }
    <% } %>
    products.innerHTML = productOptions;
}
</script>

</head>
<body>

    <form action="UpdateProduct" method="post">
        <label for="catDrop">Select Category:</label>
        <select id="catDrop" name="catDrop" onchange="categoryChange()">
            <% 
                ps = dbConnection.prepareStatement("SELECT categoryId, categoryName FROM category");
                rs = ps.executeQuery();
                while (rs.next()) { 
            %>
                <option value="<%= rs.getInt("categoryId") %>"><%= rs.getString("categoryName") %></option>
            <% } %>
        </select>
        <label for="proDrop" >Select Product:</label>
        <select id="proDrop" name="proDrop">
        </select>
    	<input type="text" name="name" placeholder="Name"/>
    	<input type="text" name="price" placeholder="Price"/>
    	<input type="text" name="quantity" placeholder="Quantity"/>
        <button type="submit">Update Product</button>
    </form>
</body>
</html>
