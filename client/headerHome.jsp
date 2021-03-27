<%-- 
    Document   : headerHome
    Created on : Nov 9, 2020, 6:14:25 PM
    Author     : Uchitachi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>     
         
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="../css/header.css">
        
<!--        <style>
             body {
                background-image: url('img/Vietnam-New-Year-Background.jpg');
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: cover;
            }
            
        </style>  -->
    </head>
    

    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container">
                <a class="navbar-brand" href="../client/list">Noval </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <!--<a class="nav-link" href="list">Home <span class="sr-only">(current)</span></a>-->
                        </li>

                        <li class="nav-item active">
                            <a class="nav-link" href="../client/favorite">My Favorite <span class="sr-only">(current)</span></a>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Account    
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <c:if test="${sessionScope.user==null}">
                                    <a class="dropdown-item" href="../login">Login</a>
                                </c:if>
                              <c:if test="${sessionScope.user!=null}">
                                    <div>${sessionScope.user.user}</div>
                                    <a class="dropdown-item" href="../logout">Logout</a>
                                </c:if>
<!--                                <a class="dropdown-item" href="#">Properties</a>-->
                                <div class="dropdown-divider"></div>
                            </div>
                        </li>

                        <c:if test="${sessionScope.user.creator eq true}">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Creator    
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="../admin/add">Create Noval</a>
                                    <a class="dropdown-item" href="../admin/addChapter">Create Chapter</a>
                                    <a class="dropdown-item" href="../admin/list">List Noval</a>
                                    <div class="dropdown-divider"></div>
                                </div>
                            </li>
                        </c:if>

                    </ul>
                    <form class="form-inline my-2 my-lg-0" action="search" method="POST">
                        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" name="name">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </div>

        </nav>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    </body>
</html>
