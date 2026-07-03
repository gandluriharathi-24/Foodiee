<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>



<%@ page import="java.util.List"%>

<%@ page import="Model.restarunt"%>



<%

List<restarunt> restaurantList =

(List<restarunt>)request.getAttribute("restaurant");

%>



<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>FoodHub</title>



<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">



<style>



*{

margin:0;

padding:0;

box-sizing:border-box;

font-family:'Poppins',sans-serif;

}



body{

background:#fafafa;

}



/* Navbar */



nav{

display:flex;

justify-content:space-between;

align-items:center;

padding:18px 8%;

background:#fff;

box-shadow:0 2px 12px rgba(0,0,0,.08);

position:sticky;

top:0;

z-index:999;

}



.logo{

font-size:30px;

font-weight:700;

color:#ff5200;

}



.nav-links a{

text-decoration:none;

margin-left:25px;

color:#444;

font-weight:500;

transition:.3s;

}



.nav-links a:hover{

color:#ff5200;

}



/* Hero */



.hero{

height:550px;

display:flex;

justify-content:center;

align-items:center;

text-align:center;

background:linear-gradient(rgba(0,0,0,.45),rgba(0,0,0,.45)),

url("https://images.unsplash.com/photo-1504674900247-0877df9cc836?auto=format&fit=crop&w=1500&q=80");

background-size:cover;

background-position:center;

color:white;

}



.hero-content h1{

font-size:55px;

margin-bottom:20px;

}



.hero-content p{

font-size:22px;

margin-bottom:30px;

}



.search-box{

display:flex;

justify-content:center;

}



.search-box input{

width:450px;

padding:15px;

border:none;

outline:none;

border-radius:50px 0 0 50px;

font-size:16px;

}



.search-box button{

padding:15px 25px;

border:none;

background:#ff5200;

color:white;

font-size:16px;

border-radius:0 50px 50px 0;

cursor:pointer;

}



/* Section Title */



.section-title{

text-align:center;

font-size:35px;

margin:60px 0 30px;

color:#222;

}



/* Categories */



.categories{

padding:0 8%;

display:grid;

grid-template-columns:repeat(auto-fit,minmax(170px,1fr));

gap:25px;

}



.category-card{

background:#fff;

padding:30px;

text-align:center;

border-radius:15px;

box-shadow:0 5px 15px rgba(0,0,0,.08);

transition:.3s;

}



.category-card:hover{

transform:translateY(-8px);

}



.category-card img{

width:70px;

margin-bottom:15px;

}



/* Offers */



.offers{

padding:0 8%;

display:grid;

grid-template-columns:repeat(auto-fit,minmax(300px,1fr));

gap:25px;

}



.offer-card{

background:linear-gradient(45deg,#ff5200,#ff884d);

padding:30px;

border-radius:15px;

color:white;

}



.offer-card h2{

margin-bottom:10px;

}



/* Restaurants */



.restaurant-container{

padding:0 8%;

display:grid;

grid-template-columns:repeat(auto-fit,minmax(320px,1fr));

gap:30px;

margin-bottom:60px;

}



.restaurant-card{

background:#fff;

border-radius:15px;

overflow:hidden;

box-shadow:0 5px 15px rgba(0,0,0,.08);

transition:.3s;

}



.restaurant-card:hover{

transform:translateY(-8px);

}



.restaurant-card img{

width:100%;

height:220px;

object-fit:cover;

}



.restaurant-details{

padding:20px;

}



.restaurant-details h3{

margin-bottom:10px;

}



.restaurant-details p{

margin:8px 0;

color:#666;

}



.rating{

background:#28a745;

color:white;

padding:5px 12px;

border-radius:20px;

display:inline-block;

margin-top:10px;

}



.btn{

display:inline-block;

margin-top:20px;

padding:12px 20px;

background:#ff5200;

color:white;

text-decoration:none;

border-radius:8px;

}



/* Reviews */



.reviews{

padding:0 8%;

display:grid;

grid-template-columns:repeat(auto-fit,minmax(300px,1fr));

gap:25px;

}



.review{

background:white;

padding:30px;

border-radius:15px;

box-shadow:0 5px 15px rgba(0,0,0,.08);

}



/* Stats */



.stats{

margin-top:60px;

background:#ff5200;

padding:70px 8%;

display:grid;

grid-template-columns:repeat(auto-fit,minmax(200px,1fr));

text-align:center;

color:white;

}



.stat h2{

font-size:40px;

}



/* Download */



.download{

padding:70px 8%;

display:flex;

justify-content:space-between;

align-items:center;

flex-wrap:wrap;

}



.download img{

width:180px;

margin:10px;

}



/* Footer */



footer{

background:#222;

color:#ccc;

padding:45px 8%;

}



.footer-grid{

display:grid;

grid-template-columns:repeat(auto-fit,minmax(250px,1fr));

gap:30px;

}



footer h3{

color:white;

margin-bottom:15px;

}



ffooter a{
color:#ccc;
text-decoration:none;
margin:8px 0;
display:block;
}

footer a:hover{
color:#ff5200;
}

/* Social Icons */

.social-icons{
display:flex;
justify-content:center;
align-items:center;
gap:20px;
margin-top:15px;
}

.social-icons a{
display:flex;
justify-content:center;
align-items:center;
width:45px;
height:45px;
border-radius:50%;
background:#333;
color:white;
font-size:22px;
text-decoration:none;
transition:0.3s;
margin:0;
}

.social-icons a:hover{
background:#ff5200;
transform:translateY(-5px);
}



.copyright{

text-align:center;

margin-top:30px;

}



@media(max-width:768px){



.hero-content h1{

font-size:36px;

}



.search-box{

flex-direction:column;

}



.search-box input{

width:100%;

border-radius:50px;

margin-bottom:15px;

}



.search-box button{

border-radius:50px;

width:100%;

}



}



</style>



</head>



<body>



<nav>



<div class="logo">Foodiee</div>



<div class="nav-links">




<a href="login.jsp">Login</a>


<a href="register.html">Register</a>



</div>



</nav>



<section class="hero">



<div class="hero-content">



<h1>Order Delicious Food Online</h1>



<p>Fast Delivery • Best Restaurants • Amazing Offers</p>



<div class="search-box">







</div>



</div>



</section>



<h2 class="section-title">Popular Categories</h2>



<div class="categories">



<div class="category-card">

<img src="https://cdn-icons-png.flaticon.com/512/3595/3595455.png">

<h3>Pizza</h3>

</div>



<div class="category-card">

<img src="https://cdn-icons-png.flaticon.com/512/3075/3075977.png">

<h3>Burger</h3>

</div>



<div class="category-card">

<img src="https://cdn-icons-png.flaticon.com/512/5787/5787100.png">

<h3>Biryani</h3>

</div>



<div class="category-card">

<img src="https://cdn-icons-png.flaticon.com/512/1046/1046784.png">

<h3>South Indian</h3>

</div>



<div class="category-card">

<img src="https://cdn-icons-png.flaticon.com/512/2718/2718224.png">

<h3>Desserts</h3>

</div>



</div>



<h2 class="section-title">Today's Offers</h2>



<div class="offers">



<div class="offer-card">

<h2>50% OFF</h2>

<p>On orders above ₹299</p>

</div>



<div class="offer-card">

<h2>Free Delivery</h2>

<p>For your first order</p>

</div>



<div class="offer-card">

<h2>₹150 OFF</h2>

<p>Use Coupon FOOD150</p>

</div>



</div>






<div class="restaurant-container">



<%

if (restaurantList != null && !restaurantList.isEmpty()) {



    for (restarunt r : restaurantList) {

%>



<div class="restaurant-card">



    <!-- If your images are inside images folder -->

    <img src="images/<%=r.getImage()%>" alt="<%=r.getName()%>">



    <div class="restaurant-details">



        <h3><%=r.getName()%></h3>



        <p><strong>🍽 Cuisine:</strong> <%=r.getCulsinType()%></p>



        <p><strong>📍 Address:</strong> <%=r.getAddress()%></p>



        <p><strong>🛵 Delivery Time:</strong> <%=r.getDeliveryTime()%> mins</p>



        <span class="rating">

            ⭐ <%=r.getRating()%>

        </span>



        <br>



        <a class="btn"

           href="MenuServlet?restaurantId=<%=r.getRestaurantId()%>">

            View Menu

        </a>



    </div>



</div>



<%

    }



} else {

%>






<%

}

%>



</div>



<!-- ================= CUSTOMER REVIEWS ================= -->



<h2 class="section-title">What Our Customers Say</h2>



<div class="reviews">



    <div class="review">

        <h3>Rahul Sharma</h3>

        <p>⭐⭐⭐⭐⭐</p>

        <p>

            Excellent service! Food arrived within 20 minutes and was still hot.

            Highly recommended.

        </p>

    </div>



    <div class="review">

        <h3>Priya Verma</h3>

        <p>⭐⭐⭐⭐⭐</p>

        <p>

            Loved the discounts and the variety of restaurants available.

            Ordering was super easy.

        </p>

    </div>



    <div class="review">

        <h3>Arjun Kumar</h3>

        <p>⭐⭐⭐⭐⭐</p>

        <p>

            One of the best food delivery experiences. Fast delivery and amazing food quality.

        </p>

    </div>



</div>



<!-- ================= STATISTICS ================= -->



<section class="stats">



    <div class="stat">

        <h2>1000+</h2>

        <p>Restaurants</p>

    </div>



    <div class="stat">

        <h2>50K+</h2>

        <p>Happy Customers</p>

    </div>



    <div class="stat">

        <h2>200+</h2>

        <p>Cities Served</p>

    </div>



    <div class="stat">

        <h2>4.8 ★</h2>

        <p>Average Rating</p>

    </div>



</section>



<!-- ================= DOWNLOAD APP ================= -->



<section class="download">



    <div class="download-text">



        <h2>Download FoodHub App</h2>



        <p>

            Order food anytime, anywhere using our Android and iOS app.

            Enjoy exclusive app-only offers and lightning-fast delivery.

        </p>



    </div>



    <div>



        <img src="https://developer.apple.com/assets/elements/badges/download-on-the-app-store.svg"

             alt="App Store">



        <img src="https://upload.wikimedia.org/wikipedia/commons/7/78/Google_Play_Store_badge_EN.svg"

             alt="Google Play">



    </div>



</section>



<!-- ================= FOOTER ================= -->



<footer>



    <div class="footer-grid">



        <div>



            <h3>FoodHub</h3>



            <p>

                India's favourite food delivery platform.

                Discover restaurants, order delicious food,

                and enjoy fast doorstep delivery.

            </p>



        </div>



        <div>



            <h3>Company</h3>



            <a href="#">About Us</a>



            <a href="#">Careers</a>



            <a href="#">Blog</a>



            <a href="#">Investor Relations</a>



        </div>



        <div>



            <h3>Help & Support</h3>



            <a href="#">FAQs</a>



            <a href="#">Customer Care</a>



            <a href="#">Terms & Conditions</a>



            <a href="#">Privacy Policy</a>



        </div>



        <div>



            <h3>Contact</h3>



            <p>📍 Bengaluru, India</p>



            <p>📞 +91 9876543210</p>



            <p>✉ support@foodhub.com</p>



        </div>



    </div>



    <hr style="margin:35px 0;border:0;border-top:1px solid #444;">



    <div style="text-align:center;">



        <div style="text-align:center;">

    <h3 style="color:white;margin-bottom:15px;">
        Follow Us
    </h3>

    <div class="social-icons">

        <a href="#">📘</a>

        <a href="#">📷</a>

        <a href="#">🐦</a>

        <a href="#">▶</a>

    </div>

</div>


    <div class="copyright">



        <p>

            © 2026 FoodHub. All Rights Reserved.

        </p>



    </div>



</footer>



</body>

</html>