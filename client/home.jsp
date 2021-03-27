<%-- 
    Document   : home
    Created on : Nov 8, 2020, 10:21:30 PM
    Author     : Uchitachi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="../css/stylehome.css">
        <script src="../js/pagger.js" type="text/javascript"></script>
        <link href="../css/pagger.css" rel="stylesheet" type="text/css"/>
        <script>
            function sendRedirect(url)
            {
                window.location.href = url;
            }
        </script>

    </head>

    <body>
        <jsp:include page="headerHome.jsp"></jsp:include>



            <div class="container" >
                <div class="row mt-4">
                    <h2 class="list-noval">Noval</h2>
                </div>
                <div class="noval-group">
                    <div class="row">
                    <c:forEach items="${requestScope.n}" var="no" varStatus="loop">

                        <div class="col-md-3 col-sm-6 col-12">
                            <div class="card-noval mb-4" >
                                <img class="card-img" src="../img/${no.img}" width="207" height="320">

                                <div class="card-body">
                                    <h5 class="card-title">${no.name}</h5>



                                    <input type="button" value="Read" 
                                           onclick="sendRedirect('view?idNoval=${no.idNoval}')" />

                                    <c:if test="${sessionScope.user != null}">
                                        <a href="like?idNoval=${no.idNoval}" style="text-decoration: none; margin-right: 10px">
                                            <span style="font-size:30px">&#128077;</span>
                                        </a>
                                    </c:if>
                                    <c:if test="${sessionScope.user == null}">
                                        <a href="../login" style="text-decoration: none; margin-right: 10px">
                                            <span style="font-size:30px">&#128077;</span>
                                        </a>
                                    </c:if>

                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

            </div> 
            <div id="pager_bottom" class="pagger"> </div>
            <script>

                renderPager("pager_bottom",${requestScope.pageindex},${requestScope.totalpage}, 3);
            </script>
        </div>



    </body>
</html>
