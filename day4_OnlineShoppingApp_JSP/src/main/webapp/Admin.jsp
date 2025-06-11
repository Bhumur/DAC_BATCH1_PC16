<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        text-align: center;
        padding: 20px;
    }
    h1 {
        color: #333;
        margin-bottom: 20px;
    }
    .button-container {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        gap: 10px;
    }
    button {
        background-color: #007bff;
        color: white;
        border: none;
        padding: 10px 20px;
        cursor: pointer;
        font-size: 16px;
        border-radius: 5px;
        transition: 0.3s;
    }
    button:hover {
        background-color: #0056b3;
    }
</style>
<script>
function login(){
    window.location.href = "./Login.html";
}
function allUser(){
    window.location.href = "./AllUsers.jsp";
}
function allTran(){
	console.log("dwd")
    window.location.href = "./AllTransaction.jsp";
}
function addCategory(){
    window.location.href = "./Addcategory.html";
}
function addProduct(){
    window.location.href = "./AddProduct";
}
function updateUser(){
    window.location.href = "./UpdateUser";
}
function updateCategory(){
    window.location.href = "./UpdateCategory";
}
function updateProduct(){
    window.location.href = "./UpdateProduct.jsp";
}
function deleteProduct(){
    window.location.href = "./DeleteProduct";
}
function deleteCategory(){
    window.location.href = "./DeleteCategory";
}
</script>
</head>
<body>


	<h1>Admin Panel</h1>
    <div class="button-container style='display-flex '">
    	<button onclick="login()">Login</button>
        <button onclick="allUser()">All Users</button>
        <button onclick="allTran()">All Transaction</button>
        <button onclick="addCategory()">Add Category</button>
        <button onclick="addProduct()">Add Product</button>
        <button onclick="updateUser()">Update User</button>
        <button onclick="updateCategory()">Update Category</button>
        <button onclick="updateProduct()">Update Product</button>
        <button onclick="deleteProduct()">Delete Product</button>
        <button onclick="deleteCategory()">Delete Category</button>
    </div>
</body>
</html>