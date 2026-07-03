<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    // Destroy the user session
    if(session != null){
        session.invalidate();
    }
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Logout | Foodie</title>

<meta http-equiv="refresh" content="3;url=login.jsp">

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Poppins',sans-serif;
}

body{
    background:#f5f5f5;
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.card{
    width:450px;
    background:#fff;
    padding:45px;
    border-radius:18px;
    text-align:center;
    box-shadow:0 8px 20px rgba(0,0,0,.15);
}

.icon{
    font-size:70px;
    margin-bottom:20px;
}

h1{
    color:#fc8019;
    margin-bottom:15px;
}

p{
    color:#555;
    font-size:17px;
    line-height:28px;
}

.btn{
    display:inline-block;
    margin-top:30px;
    padding:12px 28px;
    background:#fc8019;
    color:#fff;
    text-decoration:none;
    border-radius:8px;
    font-weight:bold;
    transition:.3s;
}

.btn:hover{
    background:#e46f0b;
}

</style>

</head>

<body>

<div class="card">

    <div class="icon">
        👋
    </div>

    <h1>Logged Out Successfully</h1>

    <p>
        Thank you for using <b>Foodie</b>.<br>
        You have been logged out successfully.
        <br><br>
        Redirecting to the Login page...
    </p>

    <a href="login.jsp" class="btn">
        Login Again
    </a>

</div>

</body>

</html>