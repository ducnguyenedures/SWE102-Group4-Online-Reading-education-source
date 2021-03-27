<%-- 
    Document   : view
    Created on : Dec 23, 2020, 9:40:06 AM
    Author     : Uchitachi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="../css/view.css">
    </head>
    <body>
        <jsp:include page="headerHome.jsp"></jsp:include>


                <div class="container">
                    <h2 class="hearder">${chapter.name}</h2>
                
                <div class="description">

                    <div class="content-chapter">
                        <p>${chapter.content}</p>
                    </div>

                </div>

            </div>

    </body>
</html>
