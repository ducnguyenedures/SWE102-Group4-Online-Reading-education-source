<%-- 
    Document   : noval
    Created on : Dec 19, 2020, 9:50:25 PM
    Author     : Uchitachi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="../css/noval.css">
    </head>
    <body>
        <jsp:include page="headerHome.jsp"></jsp:include>
            <div class="container">
                <div class="description">
                    <h1 class="thong-tin-truyen">Thông tin truyện</h1>

                    <h2 class="thong-tin-truyen">${noval.name}</h2>

                <img class="img-truyen" src="../img/${noval.img}">
            </div>
            
            <div class="info">
                <div><h4>Tác giả: </h4><p> ${noval.author}</p></div>
                <div><h4>Thể loại: </h4><c:forEach items="${requestScope.types}" var="t" varStatus="loop">
                           <c:if test="${t.id eq noval.type.id}"><p>${t.name}</p> </c:if>
     
                    </c:forEach>
                </div>
                <div><h4>Ngày đăng: </h4><p>${noval.date}</p></div>
                <div><h4>Tóm tắt: </h4><p class="mo-ta-truyen">${noval.summary}</p></div>
            </div>
        </div>



        <div class="col-xs-12" id="list-chapter">
            <div class="title-list"><h2>Danh sách chương</h2></div>
            <div class="row">
                <div class="col-xs-12 col-sm-6 col-md-6">
                    <ol class="list-chapter">

                        <c:forEach items="${requestScope.chapters}" var="c" varStatus="loop">

                            <li>
                                <a href="../client/viewC?numberofchap=${c.numberofchapter}&idn=${c.idn.idNoval}">${c.name}</a>
                            </li>
                        </c:forEach>
                    </ol>
                </div>
            </div>
        </div>
    </body>
</html>
