<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="Model.Cart"%>
<%@ page import="Model.CartItem"%>

<%
Cart cart = (Cart) session.getAttribute("cart");
double grandTotal = 0;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FODDIE | Cart</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Poppins',sans-serif;
}

body{
    background:#fff7f2;
    color:#333;
}

/* ==========================
        NAVBAR
========================== */

.navbar{
    height:80px;
    background:#ffffff;
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:0 70px;
    position:sticky;
    top:0;
    z-index:1000;
    box-shadow:0 5px 20px rgba(0,0,0,.08);
}

.logo{
    font-size:34px;
    font-weight:700;
    color:#ff6b35;
}

.nav-links{
    display:flex;
    align-items:center;
    gap:35px;
}

.nav-links a{
    text-decoration:none;
    color:#444;
    font-size:17px;
    font-weight:600;
    transition:.3s;
}

.nav-links a:hover{
    color:#ff6b35;
}

/* ==========================
      MAIN CONTAINER
========================== */

.container{
    width:90%;
    margin:40px auto;
    display:flex;
    gap:30px;
}

.left{
    width:70%;
}

.right{
    width:30%;
}

/* ==========================
      CART CARD
========================== */

.card{
    background:#ffffff;
    border-radius:18px;
    padding:22px;
    margin-bottom:20px;
    box-shadow:0 6px 20px rgba(0,0,0,.08);
}

.item{
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:20px 0;
    border-bottom:1px solid #ececec;
}

.item:last-child{
    border:none;
}

.details h3{
    color:#333;
    font-size:22px;
    margin-bottom:8px;
}

.details p{
    color:#777;
    font-size:16px;
}

/* ==========================
      QUANTITY BUTTONS
========================== */

.qty{
    display:flex;
    align-items:center;
    gap:15px;
}

.qty a{
    width:35px;
    height:35px;
    display:flex;
    justify-content:center;
    align-items:center;
    background:#ff6b35;
    color:white;
    text-decoration:none;
    border-radius:50%;
    font-size:20px;
    font-weight:bold;
    transition:.3s;
}

.qty a:hover{
    background:#e85b22;
}

.qty strong{
    font-size:18px;
}

/* ==========================
      REMOVE BUTTON
========================== */

.remove a{
    background:#ff3b30;
    color:white;
    padding:10px 18px;
    border-radius:8px;
    text-decoration:none;
    font-weight:600;
    transition:.3s;
}

.remove a:hover{
    background:#d92b22;
}

/* ==========================
      BILL
========================== */

.bill{
    position:sticky;
    top:110px;
}

.bill h2{
    color:#ff6b35;
    margin-bottom:25px;
}

.bill-row{
    display:flex;
    justify-content:space-between;
    margin:18px 0;
    font-size:17px;
}

.total{
    margin-top:20px;
    border-top:2px dashed #ddd;
    padding-top:18px;
    font-size:22px;
    font-weight:bold;
    color:#333;
}

/* ==========================
      BUTTONS
========================== */

.checkout{
    display:block;
    width:100%;
    margin-top:25px;
    padding:15px;
    background:#ff6b35;
    color:white;
    text-align:center;
    text-decoration:none;
    border-radius:12px;
    font-size:18px;
    font-weight:600;
    transition:.3s;
}

.checkout:hover{
    background:#e85b22;
}

.shop{
    display:block;
    text-align:center;
    margin-top:18px;
    color:#ff6b35;
    text-decoration:none;
    font-weight:600;
    transition:.3s;
}

.shop:hover{
    color:#e85b22;
}

/* ==========================
      EMPTY CART
========================== */

.empty{
    background:white;
    padding:70px;
    text-align:center;
    border-radius:20px;
    box-shadow:0 5px 15px rgba(0,0,0,.08);
}

.empty h2{
    color:#ff6b35;
    margin-bottom:15px;
    font-size:32px;
}

.empty p{
    color:#777;
    font-size:18px;
}

.empty a{
    display:inline-block;
    margin-top:30px;
    background:#ff6b35;
    color:white;
    padding:15px 30px;
    border-radius:12px;
    text-decoration:none;
    font-size:17px;
    font-weight:600;
}

.empty a:hover{
    background:#e85b22;
}

/* ==========================
      RESPONSIVE
========================== */

@media(max-width:900px){

.container{
    flex-direction:column;
}

.left,
.right{
    width:100%;
}

.navbar{
    flex-direction:column;
    height:auto;
    padding:20px;
}

.nav-links{
    margin-top:15px;
    flex-wrap:wrap;
    justify-content:center;
}
}

</style>
</head>

<body>

<div class="navbar">

    <div class="logo">
        🍔 Foodie!
    </div>

    <div class="nav-links">

        <a href="callRestaurantservlet">🏠 Home</a>

        <a href="profile.jsp">👤 My Profile</a>

        <a href="orders.jsp">📦 My Orders</a>

        <a href="LogoutServlet">🚪 Logout</a>

    </div>

</div>

<!-- Main Container -->
<div class="container">

    <!-- Left Side -->
    <div class="left">

    <%
    if(cart == null || cart.getItems().isEmpty()){
    %>

        <div class="empty">
            <h2>Your Cart is Empty 🛒</h2>
            <p>Add delicious food to your cart.</p>
            <a href="callRestaurantservlet">Continue Shopping</a>
        </div>

    <%
    } else {

        for(CartItem item : cart.getItems().values()){

            double total = item.getPrice() * item.getQuantity();
            grandTotal += total;
    %>

        <div class="card">

            <div class="item">

                <div class="details">
                    <h3><%= item.getItemName() %></h3>
                    <p>₹ <%= item.getPrice() %></p>
                </div>

                <div class="qty">
                    <a href="cartServlet?action=decrease&id=<%= item.getMenuId() %>">-</a>

                    <strong><%= item.getQuantity() %></strong>

                    <a href="cartServlet?action=increase&id=<%= item.getMenuId() %>">+</a>
                </div>

                <div>
                    <strong>₹ <%= total %></strong>
                </div>

                <div class="remove">
                    <a href="cartServlet?action=remove&id=<%= item.getMenuId() %>">
                        Remove
                    </a>
                </div>

            </div>

        </div>

    <%
        }
    }
    %>

    </div>

    <!-- Right Side -->
    <%
    if(cart != null && !cart.getItems().isEmpty()){

        double gst = grandTotal * 0.05;
        double delivery = 40;
        double finalTotal = grandTotal + gst + delivery;

        int restaurantId = cart.getItems().values().iterator().next().getRestaurantId();
    %>

    <div class="right">

        <div class="card bill">

            <h2>Bill Details</h2>

            <div class="bill-row">
                <span>Item Total</span>
                <span>₹ <%= String.format("%.2f", grandTotal) %></span>
            </div>

            <div class="bill-row">
                <span>Delivery Fee</span>
                <span>₹ 40.00</span>
            </div>

            <div class="bill-row">
                <span>GST (5%)</span>
                <span>₹ <%= String.format("%.2f", gst) %></span>
            </div>

            <div class="bill-row total">
                <span>Grand Total</span>
                <span>₹ <%= String.format("%.2f", finalTotal) %></span>
            </div>

            <a href="checkout.jsp" class="checkout">
                Proceed to Checkout
            </a>

            <a href="<%= request.getContextPath() %>/menu?restaurantId=<%= restaurantId %>" class="shop">
                Add More Items
            </a>

        </div>

    </div>

    <%
    }
    %>

</div>

</body>
</html>
