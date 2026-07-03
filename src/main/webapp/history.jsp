<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="Model.Ordertable"%>
<%@page import="DAOimplement.OrdertableDAOImple"%>

<%
List<Ordertable> orders =
(List<Ordertable>)request.getAttribute("orders");
%>

<%
OrdertableDAOImple dao = new OrdertableDAOImple();
%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>My Orders</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Poppins',sans-serif;
}

body{
    background:#f3f4f6;
}

.navbar{
    height:75px;
    background:#fff;
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:0 60px;
    box-shadow:0 2px 10px rgba(0,0,0,.08);
}

.navbar h2{
    color:#fc8019;
}

.navbar div{
    display:flex;
    gap:25px;
}

.navbar a{
    text-decoration:none;
    color:#333;
    font-weight:600;
}

.navbar a:hover{
    color:#fc8019;
}

.container{
    width:850px;
    margin:40px auto;
}

.container h2{
    margin-bottom:30px;
    color:#333;
}

.card{
    background:#fff;
    padding:25px;
    border-radius:15px;
    margin-bottom:25px;
    box-shadow:0 4px 15px rgba(0,0,0,.08);
}

.card h3{
    color:#fc8019;
    margin-bottom:20px;
    border-bottom:1px solid #eee;
    padding-bottom:10px;
}

.row{
    display:flex;
    justify-content:space-between;
    align-items:center;
    margin:18px 0;
}

.label{
    font-weight:600;
    color:#666;
}

.value{
    font-weight:500;
}

.status{
    background:#d4f7d9;
    color:#14833b;
    padding:6px 16px;
    border-radius:20px;
    font-weight:bold;
}

.price{
    font-size:24px;
    font-weight:bold;
    color:#fc8019;
}

.btn-area{
    text-align:right;
    margin-top:25px;
}

.order-btn{
    background:#fc8019;
    color:#fff;
    text-decoration:none;
    padding:12px 22px;
    border-radius:8px;
    font-weight:bold;
}

.order-btn:hover{
    background:#e56d00;
}

.empty{
    text-align:center;
    margin-top:120px;
}

.empty a{
    display:inline-block;
    margin-top:20px;
    padding:12px 25px;
    background:#fc8019;
    color:white;
    text-decoration:none;
    border-radius:8px;
}
</style>

</head>

<body>

<div class="navbar">

<h2>🍔 FODDIE</h2>

<div>

<a href="home.jsp">Home</a>

<a href="callRestaurantservlet">Restaurants</a>

<a href="LogoutServlet">Logout</a>

</div>

</div>

<div class="container">

<h2 style="margin-bottom:20px;">My Orders</h2>

<%
if(orders==null || orders.isEmpty()){
%>

<div class="empty">

<h2>No Orders Found</h2>

<p>You haven't ordered anything yet.</p>

<a href="callRestaurantservlet">
Order Now
</a>

</div>

<%
}
else{

for(Ordertable order : orders){
%>

<div class="card">

    <h3>Order #<%=order.getOrderId()%></h3>

    <div class="row">
        <span class="label">🍽 Restaurant</span>
        <span class="value">
            <%=dao.getRestaurantName(order.getRestaurantId())%>
        </span>
    </div>

    <div class="row">
        <span class="label">💳 Payment</span>
        <span class="value">
            <%=order.getPaymentMethod()%>
        </span>
    </div>

    <div class="row">
        <span class="label">📦 Status</span>
        <span class="status">
            <%=order.getStatus()%>
        </span>
    </div>

    <div class="row">
        <span class="label">💰 Total</span>
        <span class="price">
            ₹ <%=order.getTotalAmount()%>
        </span>
    </div>

    <div class="btn-area">
        <a href="menu?restaurantId=<%=order.getRestaurantId()%>"
           class="order-btn">
            🔁 Order Again
        </a>
    </div>

</div>
<%
}
}
%>

</div>

</body>

</html>