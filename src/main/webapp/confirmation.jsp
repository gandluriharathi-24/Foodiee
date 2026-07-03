<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Order Confirmed | FODDIE</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial,Helvetica,sans-serif;
}

body{
    background:#f8f8f8;
    display:flex;
    justify-content:center;
    align-items:center;
    min-height:100vh;
    padding-top:100px; /* space for fixed navbar */
}

/* Navbar */

.navbar{
    height:80px;
    background:#ffffff;
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:0 70px;
    position:fixed;
    top:0;
    left:0;
    width:100%;
    z-index:1000;
    box-shadow:0 4px 15px rgba(0,0,0,.08);
}

.logo{
    font-size:32px;
    font-weight:700;
    color:#ff6b35;
}

.nav-links{
    display:flex;
    align-items:center;
    gap:30px;
}

.nav-links a{
    text-decoration:none;
    color:#333;
    font-size:17px;
    font-weight:600;
    transition:.3s;
}

.nav-links a:hover{
    color:#ff6b35;
}

/* Confirmation Card */

.card{
    width:560px;
    background:white;
    padding:50px;
    border-radius:20px;
    text-align:center;
    box-shadow:0 10px 25px rgba(0,0,0,.12);
}

.icon{
    font-size:90px;
}

h1{
    margin-top:20px;
    color:#1ba672;
}

p{
    margin-top:15px;
    font-size:18px;
    color:#666;
    line-height:30px;
}

.order{
    margin-top:25px;
    font-size:22px;
    font-weight:bold;
    color:#ff6b35;
}

.buttons{
    margin-top:40px;
    display:flex;
    justify-content:center;
    gap:20px;
    flex-wrap:wrap;
}

.btn{
    text-decoration:none;
    padding:14px 30px;
    border-radius:10px;
    font-size:17px;
    font-weight:600;
    transition:.3s;
}

.home{
    background:#ff6b35;
    color:white;
}

.home:hover{
    background:#e85b22;
}

.orders{
    background:#1ba672;
    color:white;
}

.orders:hover{
    background:#14875b;
}

.history{
    background:#7c3aed;
    color:white;
}

.history:hover{
    background:#6d28d9;
}
</style>

</head>

<body>

<body>

<!-- Navbar -->

<div class="navbar">

    <div class="logo">
        🍔 Foodie!
    </div>

    <div class="nav-links">

        <a href="callRestaurantservlet">🏠 Home</a>

        <a href="LogoutServlet">🚪 Logout</a>

    </div>

</div>

<!-- Confirmation Card -->

<div class="card">

    <div class="icon">
        ✅
    </div>

    <h1>Order Confirmed!</h1>

    <p>
        Your order has been placed successfully.
        <br>
        Our restaurant has received your order.
    </p>

    <div class="order">
        Estimated Delivery
        <br><br>
        🛵 25 - 35 Minutes
    </div>

    <div class="buttons">

        <a href="callRestaurantservlet" class="btn home">
            🏠 Home
        </a>

        <a href="callRestaurantservlet" class="btn orders">
            🍴 Order Again
        </a>

        <a href="OrderHistoryServlet" class="btn history">
            📜 Order History
        </a>

    </div>

</div>

</body>
</body>

</html>