<%-- 
    Document   : Favorite
    Created on : 17-Mar-2021, 02:09:42
    Author     : Nekko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../css/favorite1.css">
    </head>
    <body>
        <div class="container">
            <!--begin of menu-->
            <jsp:include page="headerHome.jsp"></jsp:include>
                <!--end of menu-->
                <!--begin of list article-->
                <h2>My favorite </h2>
            <c:forEach items="${listF}" var="o">
                <div class="row">
                    <div class="col-sm-4">

                        <a href="delete?idNoval=${o.idNoval}" tyle="button">
                            <button class="delete-favorite" >Delete</button>
                        </a>
                            

                        <a href="#" class="">
                            <img class="img-favorite" src="../img/${o.img}">
                        </a>
                    </div>
                    <div class="col-sm-8">
                        <h3 class="title">${o.name}</h3>
                    </div>
                </div>
            </c:forEach>
            <!--end of list article-->
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    </body>
</html>
