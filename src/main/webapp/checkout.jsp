<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="Model.User"%>
<%@ page import="Model.Cart"%>
<%@ page import="Model.CartItem"%>

<%
User user = (User) session.getAttribute("loggedInUser");

if(user == null){
    response.sendRedirect("login.jsp");
    return;
}

Cart cart = (Cart) session.getAttribute("cart");

if(cart == null || cart.getItems().isEmpty()){
    response.sendRedirect("cart.jsp");
    return;
}

double itemTotal = 0;

for(CartItem item : cart.getItems().values()){
    itemTotal += item.getPrice() * item.getQuantity();
}

double delivery = 40;
double gst = itemTotal * 0.05;
double finalTotal = itemTotal + delivery + gst;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FODDIE | Checkout</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:Arial,Helvetica,sans-serif;
}

body{
background:#f5f5f5;
}

/* Navbar */

.navbar{
background:#fc8019;
padding:18px 60px;
display:flex;
justify-content:space-between;
align-items:center;
color:white;
box-shadow:0 2px 10px rgba(0,0,0,.15);
}

.logo{
font-size:30px;
font-weight:bold;
}

.nav-links a{
text-decoration:none;
color:white;
margin-left:25px;
font-weight:bold;
}

/* Main */

.container{
width:90%;
margin:40px auto;
display:flex;
gap:30px;
align-items:flex-start;
}

/* Left */

.left{
width:65%;
}

/* Right */

.right{
width:35%;
}

/* Card */

.card{
background:white;
padding:30px;
border-radius:12px;
box-shadow:0 3px 10px rgba(0,0,0,.12);
margin-bottom:25px;
}

.card h2{
color:#fc8019;
margin-bottom:25px;
}

/* Labels */

label{
font-weight:bold;
display:block;
margin-bottom:8px;
color:#444;
}

/* Inputs */

input,
textarea,
select{

width:100%;
padding:13px;
margin-bottom:20px;
border:1px solid #ddd;
border-radius:8px;
font-size:16px;
outline:none;

}

input:focus,
textarea:focus,
select:focus{

border:1px solid #fc8019;

}

textarea{

resize:none;

}

/* Bill */

.bill-row{

display:flex;
justify-content:space-between;
margin:18px 0;
font-size:17px;

}

.total{

border-top:2px solid #ddd;
padding-top:15px;
font-size:22px;
font-weight:bold;

}

/* Button */

button{

width:100%;
padding:15px;
background:#60b246;
color:white;
font-size:18px;
border:none;
border-radius:8px;
cursor:pointer;
transition:.3s;

}

button:hover{

background:#4c9638;

}

/* User Box */

.user-box{

background:#fff8f1;
padding:15px;
border-left:5px solid #fc8019;
margin-bottom:25px;
border-radius:8px;

}

.user-box h3{

margin-bottom:10px;
color:#fc8019;

}

.user-box p{

margin:5px 0;
color:#555;

}

/* Payment */

.payment-note{

margin-top:15px;
color:gray;
font-size:14px;

}

</style>

</head>

<body>

<!-- Navbar -->

<div class="navbar">

<div class="logo">
🍔 FODDIE
</div>

<div class="nav-links">

<a href="home.jsp">Home</a>

<a href="cart.jsp">Cart</a>

<a href="LogoutServlet">Logout</a>

</div>

</div>

<div class="container">

<!-- LEFT -->

<div class="left">

<div class="card">

<h2>Delivery Details</h2>

<form action="CheckoutServlet" method="post">

<label>Full Name</label>

<input
type="text"
name="name"
value="<%=user.getUserName()%>"
readonly>

<label>Email</label>

<input
type="email"
name="email"
value="<%=user.getEmail()%>"
readonly>

<label>Phone Number</label>

<input
type="text"
name="phone"
placeholder="Enter Mobile Number"
required>

<label>Delivery Address</label>

<textarea
name="address"
rows="4"
required><%=user.getAddress()%></textarea>

<label>Payment Method</label>

<select name="paymentMethod">

<option value="Cash On Delivery">
Cash On Delivery
</option>

<option value="UPI">
UPI
</option>

<option value="Credit Card">
Credit Card
</option>

<option value="Debit Card">
Debit Card
</option>

</select>

<input
type="hidden"
name="totalAmount"
value="<%=finalTotal%>">

<button type="submit">
🛒 Place Order
</button>

<p class="payment-note">
Your order will be securely processed.
</p>

</form>

</div>

</div>

<!-- RIGHT -->

<div class="right">

<div class="card">

<h2>Bill Details</h2>

<div class="bill-row">

<span>Item Total</span>

<span>₹ <%=String.format("%.2f",itemTotal)%></span>

</div>

<div class="bill-row">

<span>Delivery Fee</span>

<span>₹ 40.00</span>

</div>

<div class="bill-row">

<span>GST (5%)</span>

<span>₹ <%=String.format("%.2f",gst)%></span>

</div>

<div class="bill-row total">

<span>Grand Total</span>

<span>₹ <%=String.format("%.2f",finalTotal)%></span>

</div>

</div>

</div>

</div>

</body>
</html>