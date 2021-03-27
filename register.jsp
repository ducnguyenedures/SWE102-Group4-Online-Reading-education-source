<%-- 
    Document   : register
    Created on : Dec 24, 2020, 2:04:42 AM
    Author     : Uchitachi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/login.css">
    </head>
    <body>
        <form action="register" method="post">
            <div class="login">
            <h2>Register</h2>
            <input type="text"  placeholder="username" name="username">
            <input type="password" placeholder="password" name="password">
            <input type="password" placeholder="re_password" name="repassword"><br>
            <c:if test="${sessionScope.mess!=null}">${sessionScope.mess}</c:if><br>
            <button type="submit" name="button">Register</button>
        </div>
        </form>
    </body>
</html>
