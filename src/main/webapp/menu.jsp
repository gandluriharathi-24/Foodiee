<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="Model.Menu"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Foodiee - Restaurant Menu</title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Poppins',sans-serif;
}

body{
    background:#f8f8f8;
}

/* Navbar */

.navbar{
    background:white;
    height:75px;
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:0 60px;
    box-shadow:0 2px 10px rgba(0,0,0,.08);
    position:sticky;
    top:0;
    z-index:100;
}

.logo{
    font-size:30px;
    font-weight:700;
    color:#fc8019;
}

.nav-links{
    display:flex;
    gap:30px;
}

.nav-links a{
    text-decoration:none;
    color:#333;
    font-weight:500;
}

/* Container */

.container{
    width:90%;
    max-width:1200px;
    margin:40px auto;
}

.section-title{
    font-size:30px;
    margin-bottom:25px;
}

/* Menu Grid */

.menu-grid{
    display:grid;
    grid-template-columns:repeat(auto-fill,minmax(330px,1fr));
    gap:25px;
}

/* Menu Card */

.menu-card{
    position:relative;
    background:#fff;
    border-radius:18px;
    overflow:hidden;
    box-shadow:0 4px 12px rgba(0,0,0,.08);
    transition:.3s;
}

.menu-card:hover{
    transform:translateY(-5px);
}

.menu-card img{
    width:100%;
    height:220px;
    object-fit:cover;
}

.card-content{
    padding:18px;
}

.item-name{
    font-size:22px;
    font-weight:600;
    margin-bottom:8px;
}

.description{
    color:#666;
    font-size:14px;
    margin-bottom:15px;
}

.bottom-row{
    display:flex;
    justify-content:space-between;
    align-items:center;
}

.price{
    font-size:22px;
    font-weight:bold;
}

.badge{
    background:#e8f8ea;
    color:#1ba672;
    padding:5px 12px;
    border-radius:20px;
    font-size:13px;
}

.add-btn{
    width:100%;
    margin-top:18px;
    background:#fc8019;
    color:white;
    border:none;
    padding:12px;
    border-radius:10px;
    cursor:pointer;
    font-size:16px;
    font-weight:bold;
}

.add-btn:hover{
    background:#e76f00;
}

/* Favourite Button */

.fav-form{
    position:absolute;
    top:12px;
    right:12px;
    z-index:10;
}

.fav-btn{
    width:45px;
    height:45px;
    border:none;
    border-radius:50%;
    background:white;
    color:#ff3b5c;
    font-size:24px;
    cursor:pointer;
    box-shadow:0 3px 8px rgba(0,0,0,.25);
    transition:.3s;
}

.fav-btn:hover{
    background:#ff3b5c;
    color:white;
    transform:scale(1.1);
}

@media(max-width:768px){

.navbar{
padding:0 20px;
}

.menu-grid{
grid-template-columns:1fr;
}

}

</style>

</head>

<body>

<div class="navbar">

    <div class="logo">
        🍔 Foodiee
    </div>

    <div class="nav-links">

        <a href="callRestaurantservlet">🏠 Home</a>

        <a href="profile.jsp">👤 Profile</a>

        <a href="cart.jsp">🛒 Cart</a>

        <a href="LogoutServlet">🚪 Logout</a>

    </div>

</div>

<div class="container">

<h2 class="section-title">
Popular Dishes
</h2>

<div class="menu-grid">

<%
List<Menu> menuList =
(List<Menu>)request.getAttribute("getMenuByRestaruntId");

if(menuList!=null){

for(Menu menu : menuList){
%>

<div class="menu-card">

<img src="<%=request.getContextPath()%>/image/<%=menu.getImage()%>"
     alt="<%=menu.getItemName()%>">

<!-- Favourite Button -->
<form action="FavouriteServlet" method="post" class="fav-form">

    <input type="hidden" name="menuId"
           value="<%=menu.getMenuId()%>">

    <input type="hidden" name="restaurantId"
           value="<%=menu.getRestaurantId()%>">

    <input type="hidden" name="itemName"
           value="<%=menu.getItemName()%>">

    <input type="hidden" name="description"
           value="<%=menu.getDescription()%>">

    <input type="hidden" name="price"
           value="<%=menu.getPrice()%>">

    <input type="hidden" name="image"
           value="<%=menu.getImage()%>">

    <button type="submit" class="fav-btn">
        ❤
    </button>

</form>
<div class="card-content">

    <div class="item-name">
        <%= menu.getItemName() %>
    </div>

    <div class="description">
        <%= menu.getDescription() %>
    </div>

    <div class="bottom-row">

        <div class="price">
            ₹<%= menu.getPrice() %>
        </div>

        <span class="badge">
            <%= menu.getCategory() %>
        </span>

    </div>

    <!-- Add To Cart Form -->
    <form action="cartServlet" method="post">

        <input type="hidden" name="action" value="add">

        <input type="hidden" name="MenuId"
               value="<%= menu.getMenuId() %>">

        <input type="hidden" name="Restaurantid"
               value="<%= menu.getRestaurantId() %>">

        <input type="hidden" name="quantity" value="1">

        <button type="submit" class="add-btn">
            Add To Cart
        </button>

    </form>

</div>

</div>

<%
    }
} else {
%>

<h2 style="text-align:center;color:#666;">
    No Menu Items Available
</h2>

<%
}
%>

</div>

</div>

</body>
</html>