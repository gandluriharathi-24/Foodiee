<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="Model.Menu"%>

<%
List<Menu> favouriteList =
(List<Menu>)request.getAttribute("favouriteList");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>My Favourite Menu</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:'Poppins',sans-serif;
}

body{
background:#fff7f2;
}

/* Navbar */

.navbar{

background:#ff6b35;
padding:18px 50px;
display:flex;
justify-content:space-between;
align-items:center;

}

.logo{

color:white;
font-size:30px;
font-weight:bold;

}

.home{

text-decoration:none;
color:white;
font-size:17px;
font-weight:600;

}

/* Heading */

.heading{

text-align:center;
margin:35px;
font-size:35px;
color:#333;

}

/* Cards */

.container{

width:90%;
margin:auto;

display:grid;

grid-template-columns:repeat(auto-fit,minmax(320px,1fr));

gap:30px;

padding-bottom:50px;

}

.card{

background:white;

border-radius:18px;

overflow:hidden;

box-shadow:0 5px 15px rgba(0,0,0,.12);

transition:.3s;

}

.card:hover{

transform:translateY(-8px);

}

.card img{

width:100%;

height:220px;

object-fit:cover;

}

.content{

padding:20px;

}

.content h2{

margin-bottom:12px;

color:#333;

}

.content p{

color:#666;

line-height:24px;

margin-bottom:15px;

}

.price{

font-size:22px;

font-weight:bold;

color:#ff6b35;

margin-bottom:20px;

}

.btn{

display:inline-block;

padding:12px 25px;

background:#ff6b35;

color:white;

text-decoration:none;

border-radius:30px;

font-weight:600;

transition:.3s;

}

.btn:hover{

background:#e55b24;

}

/* Empty */

.empty{

text-align:center;

margin-top:100px;

}

.empty h2{

color:#666;

margin-bottom:25px;

}
.profile {
    display: inline-block;
    padding: 10px 20px;
    background-color: #fc8019;
    color: #fff;
    text-decoration: none;
    font-size: 16px;
    font-weight: 600;
    border-radius: 8px;
    transition: all 0.3s ease;
    cursor: pointer;
}

.profile:hover {
    background-color: #e46f0d;
    transform: translateY(-2px);
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
}

.profile:active {
    transform: scale(0.98);
}

</style>

</head>

<body>

<div class="navbar">

<div class="logo">

❤️ Foodie Favourite

</div>

<a href="profile.jsp" class="profile">
    Profile
</a>
</div>

<h1 class="heading">

My Favourite Menu

</h1>

<%
if(favouriteList==null || favouriteList.isEmpty()){
%>

<div class="empty">

<h2>No Favourite Menu Items Found ❤️</h2>

<a href="callRestaurantservlet" class="btn">

Browse Restaurants

</a>

</div>

<%
}
else{
%>

<div class="container">

<%
for(Menu menu:favouriteList){
%>

<div class="card">

<img src="<%=request.getContextPath()%>/image/<%=menu.getImage()%>">

<div class="content">

<h2><%=menu.getItemName()%></h2>

<p><%=menu.getDescription()%></p>

<div class="price">

₹ <%=menu.getPrice()%>

</div>

<a href="menu?restaurantId=<%=menu.getRestaurantId()%>"

class="btn">

View Restaurant

</a>

</div>

</div>

<%
}
%>

</div>

<%
}
%>

</body>
</html>