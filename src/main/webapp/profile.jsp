<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="Model.User"%>

<%
User user = (User) session.getAttribute("loggedInUser");

if(user == null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Profile | FODDIE</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:'Poppins',sans-serif;
}

body{
background:#f5f5f7;
}

/* NAVBAR */

.navbar{
height:70px;
background:white;
display:flex;
justify-content:space-between;
align-items:center;
padding:0 60px;
box-shadow:0 2px 10px rgba(0,0,0,.08);
}

.logo{
font-size:30px;
font-weight:bold;
color:#fc8019;
}

.nav-links a{
text-decoration:none;
margin-left:25px;
font-weight:500;
color:#444;
}

.nav-links a:hover{
color:#fc8019;
}

/* MAIN */

.container{

max-width:1200px;
margin:40px auto;

display:flex;
gap:30px;
}

/* LEFT */

.left{

width:300px;
background:white;
border-radius:18px;
padding:30px;
text-align:center;

box-shadow:0 10px 25px rgba(0,0,0,.08);

}

.avatar{

width:120px;
height:120px;

background:#fc8019;
color:white;

font-size:45px;
font-weight:bold;

display:flex;
align-items:center;
justify-content:center;

border-radius:50%;

margin:auto;
margin-bottom:20px;

}

.left h2{
margin-bottom:10px;
}

.role{

color:#777;
margin-bottom:30px;

}

.menu{

display:flex;
flex-direction:column;
gap:15px;

}

.menu a{

text-decoration:none;

padding:14px;

border-radius:12px;

background:#fafafa;

color:#333;

transition:.3s;

font-weight:500;

}

.menu a:hover{

background:#fc8019;
color:white;

}

/* RIGHT */

.right{

flex:1;

display:flex;
flex-direction:column;
gap:25px;

}

.card{

background:white;

padding:30px;

border-radius:18px;

box-shadow:0 10px 20px rgba(0,0,0,.08);

}

.card h3{

margin-bottom:20px;

color:#fc8019;

}

.info{

display:grid;

grid-template-columns:180px auto;

row-gap:18px;

font-size:17px;

}

.info label{

font-weight:600;

color:#666;

}

.buttons{

margin-top:30px;

display:flex;

gap:20px;

}

.btn{

padding:14px 30px;

border:none;

border-radius:10px;

cursor:pointer;

font-size:15px;

font-weight:600;

text-decoration:none;

}

.edit{

background:#fc8019;

color:white;

}

.logout{

background:#d32f2f;

color:white;

}

.stat-container{

display:flex;

justify-content:space-between;

margin-top:15px;

}

.stat{

width:30%;

background:#fff3e9;

padding:20px;

border-radius:15px;

text-align:center;

}

.stat h1{

color:#fc8019;

}

.stat p{

margin-top:10px;

color:#666;

}

</style>

</head>

<body>

<div class="navbar">

<div class="logo">FODDIE</div>

<div class="nav-links">

<a href="home.jsp">Home</a>

<a href="cart.jsp">Cart</a>

<a href="OrderHistoryServlet">Orders</a>

<a href="profile.jsp">Profile</a>

</div>

</div>


<div class="container">

<div class="left">

<div class="avatar">

<%= user.getUserName().substring(0,1).toUpperCase() %>

</div>

<h2><%= user.getUserName() %></h2>

<p class="role"><%= user.getRole() %></p>

<div class="menu">

<a href="OrderHistoryServlet">📦 My Orders</a>

<a href="address.jsp">📍 Saved Addresses</a>

<a href="FavouriteServlet">❤️ Favourite Restaurants</a>

<a href="settings.jsp">⚙ Account Settings</a>

</div>

</div>

<div class="right">

<div class="card">

<h3>Personal Information</h3>

<div class="info">

<label>Full Name</label>
<div><%= user.getUserName() %></div>

<label>Email</label>
<div><%= user.getEmail() %></div>


<label>Address</label>
<div><%= user.getAddress() %></div>

<label>Role</label>
<div><%= user.getRole() %></div>

</div>

<div class="buttons">

<a class="btn edit" href="editProfile.jsp">Edit Profile</a>

<a class="btn logout" href="home.jsp">Logout</a>

</div>

</div>

<div class="card">

<h3>Your Activity</h3>

<div class="stat-container">

<div class="stat">

<h1>18</h1>

<p>Total Orders</p>

</div>

<div class="stat">

<h1>6</h1>

<p>Saved Addresses</p>

</div>

<div class="stat">

<h1>12</h1>

<p>Favorites</p>

</div>

</div>

</div>

</div>

</div>

</body>
</html>