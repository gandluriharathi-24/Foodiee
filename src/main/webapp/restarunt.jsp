<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@
    	page import="java.util.List, Model.restarunt"
     %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Food Delivery App</title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Poppins',sans-serif;
}
<script>

function searchRestaurant(){

    let input=document.getElementById("searchInput").value.toLowerCase();

    let cards=document.querySelectorAll(".restaurant-card");

    cards.forEach(function(card){

        let name=card.querySelector(".restaurant-name").innerText.toLowerCase();

        let cuisine=card.querySelector(".cuisine").innerText.toLowerCase();

        if(name.includes(input) || cuisine.includes(input)){
            card.parentElement.style.display="block";
        }
        else{
            card.parentElement.style.display="none";
        }

    });

}
<script>
function searchRestaurant(){

    let input=document.getElementById("searchInput").value.toLowerCase();

    let cards=document.querySelectorAll(".restaurant-card");

    cards.forEach(function(card){

        let name=card.querySelector(".restaurant-name").innerText.toLowerCase();

        let cuisine=card.querySelector(".cuisine").innerText.toLowerCase();

        if(name.includes(input) || cuisine.includes(input)){
            card.parentElement.style.display="block";
        }else{
            card.parentElement.style.display="none";
        }

    });

}
</script>

</body>

</script>

body{
    background:#f8f8f8;
    color:#282c3f;
}

/* ==========================
        NAVBAR
========================== */

.navbar{
    background:#ffffff;
    height:80px;
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:0 80px;
    box-shadow:0 2px 15px rgba(0,0,0,0.08);
    position:sticky;
    top:0;
    z-index:1000;
}

.logo{
    font-size:30px;
    font-weight:700;
    color:#fc8019;
}

.nav-links{
    display:flex;
    gap:35px;
}

.nav-links a{
    text-decoration:none;
    color:#3d4152;
    font-weight:500;
    transition:0.3s;
}

.nav-links a:hover{
    color:#fc8019;
}

/* ==========================
        HERO SECTION
========================== */

.hero{

    height:75vh;

    display:flex;

    flex-direction:column;

    justify-content:center;

    align-items:center;

    text-align:center;

    padding:20px;

    background:
    linear-gradient(rgba(15,23,42,0.78),rgba(30,41,59,0.75)),
    url("https://images.unsplash.com/photo-1517248135467-4c7edcad34c4?auto=format&fit=crop&w=1600&q=80");

    background-size:cover;

    background-position:center;

    background-repeat:no-repeat;

    color:#fff;
}

.hero h1{

    font-size:60px;

    font-weight:700;

    letter-spacing:1px;

    margin-bottom:18px;

    color:#FFD166;

    text-shadow:0 5px 20px rgba(0,0,0,.5);

}

.hero p{

    font-size:22px;

    max-width:750px;

    line-height:1.8;

    color:#f8fafc;

    margin-bottom:40px;

}=======
        SEARCH BAR
========================== */

.search-container{
    margin-top:35px;
    display:flex;
    justify-content:center;
    align-items:center;
    gap:15px;
}

.search-container input{

    width:700px;          /* Extended width */

    height:58px;

    padding:0 25px;

    border:2px solid transparent;

    outline:none;

    border-radius:50px;

    font-size:16px;

    background:#fff;

    box-shadow:0 6px 18px rgba(0,0,0,0.10);

    transition:0.3s;
}

.search-container input:focus{

    border-color:#ff6b35;

    box-shadow:0 8px 25px rgba(252,128,25,0.35);

}

.search-container button{

    width:140px;

    height:58px;

    border:none;

    border-radius:50px;

    background:#fc8019;

    color:white;

    font-size:16px;

    font-weight:600;

    cursor:pointer;

    transition:0.3s;
}

.search-container button:hover{

    background:#e96d0d;

    transform:translateY(-2px);

}
/* ==========================
        FILTERS
========================== */

.filters{
    padding:20px 100px;
    display:flex;
    gap:15px;
    flex-wrap:wrap;
}

.filter-btn{
    border:none;
    background:white;
    padding:12px 18px;
    border-radius:25px;
    cursor:pointer;
    font-weight:500;
    box-shadow:0 2px 8px rgba(0,0,0,0.08);
    transition:0.3s;
}

.filter-btn:hover{
    background:#fc8019;
    color:white;
}

/* ==========================
      RESTAURANT SECTION
========================== */

.restaurant-section{
    padding:20px 100px 60px;
}

.section-title{
    font-size:30px;
    font-weight:700;
    margin-bottom:30px;
}

.restaurant-grid{
    display:grid;
    grid-template-columns:repeat(auto-fill,minmax(280px,1fr));
    gap:30px;
}

/* ==========================
      RESTAURANT CARD
========================== */

.restaurant-card{
    background:white;
    border-radius:20px;
    overflow:hidden;
    transition:0.3s;
    cursor:pointer;
    box-shadow:0 4px 12px rgba(0,0,0,0.08);
}

.restaurant-card:hover{
    transform:translateY(-8px);
    box-shadow:0 12px 25px rgba(0,0,0,0.15);
}

.restaurant-card img{
    width:100%;
    height:220px;
    object-fit:cover;
}

.card-content{
    padding:18px;
}

.restaurant-name{
    font-size:20px;
    font-weight:600;
    margin-bottom:6px;
}

.cuisine{
    color:#686b78;
    font-size:14px;
    margin-bottom:12px;
}

.info-row{
    display:flex;
    justify-content:space-between;
    align-items:center;
    margin-bottom:12px;
}

.rating{
    background:#1ba672;
    color:white;
    padding:4px 10px;
    border-radius:8px;
    font-size:13px;
    font-weight:600;
}

.delivery{
    font-size:14px;
    font-weight:500;
}

.location{
    color:#7e808c;
    font-size:14px;
    margin-bottom:12px;
}

.offer{
    background:#fff3e8;
    color:#fc8019;
    text-align:center;
    padding:10px;
    border-radius:10px;
    font-weight:600;
    font-size:13px;
}

/* ==========================
        RESPONSIVE
========================== */

@media(max-width:768px){

    .navbar{
        padding:0 20px;
    }

    .hero,
    .filters,
    .restaurant-section{
        padding-left:20px;
        padding-right:20px;
    }

    .search-container{
        flex-direction:column;
    }

    .search-container input{
        width:100%;
    }

    .hero h1{
        font-size:30px;
    }
}

</style>
</head>

<body>

<!-- NAVBAR -->

<header class="navbar">

    <div class="logo">Foodie!</div>

    <div class="nav-links">
        <a href="login.jsp">Login</a>
        <a href="profile.jsp">Profile</a>
        <a href="history.jsp">My Orders</a>
        <a href="logout.jsp">Logout</a>
    </div>

</header>

<!-- HERO SECTION -->

<section class="hero">

    <h1>Discover the Best Food Near You</h1>

    <p>
🍕 Fresh Food • 🚀 Fast Delivery • 🥗 Healthy Choices • 🍔 1000+ Restaurants
</p>

   <div class="search-container">

    <input
        type="text"
        id="searchInput"
        placeholder="🔍 Search restaurants, cuisines..."
        onkeyup="searchRestaurant()">

    <button type="button">
        Search
    </button>

</div>

</section>

<!-- FILTERS -->

<div class="filters">

    <button class="filter-btn">Fast Delivery</button>
    <button class="filter-btn">Rating 4.0+</button>
    <button class="filter-btn">Pure Veg</button>
    <button class="filter-btn">Under 30 Mins</button>
    <button class="filter-btn">Biryani</button>
    <button class="filter-btn">Pizza</button>

</div>

<!-- RESTAURANTS -->

<section class="restaurant-section">

    <h2 class="section-title">
        Restaurants with Online Food Delivery
    </h2>

    <div class="restaurant-grid">

        <!-- Card 1 -->
        
        <%
        	List<restarunt> allRestaurant=(List<restarunt>) request.getAttribute("restaurant");
        		if(allRestaurant!=null){
        			for(restarunt restaurant:allRestaurant){
        		
        %>
        
       <a href="menu?restaurantId=<%= restaurant.getRestaurantId() %>">
        	<div class="restaurant-card">

<img src="<%= request.getContextPath() %>/image/<%= restaurant.getImage() %>"
     alt="<%= restaurant.getName() %>">
            <div class="card-content">

                <div class="restaurant-name"><%= restaurant.getName() %></div>

                <div class="cuisine">
                   <%= restaurant.getCulsinType() %>
	                </div>

                <div class="info-row">
                    <span class="rating">⭐ <%= restaurant.getRating() %></span>
                    <span class="delivery"><%= restaurant.getDeliveryTime() %> mins</span>
                </div>

                <div class="location">
                    <%= restaurant.getAddress() %>
                </div>

                <div class="offer">
                    ₹125 OFF ABOVE ₹399
                </div>

            </div>

        </div>
        	
        
        
        </a>
                	
        

        
    
    <%
        			}
        		}
    %>
    </div>

</section>

</body>
</html>