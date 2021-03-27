<%-- 
    Document   : list
    Created on : Dec 13, 2020, 5:16:11 PM
    Author     : Uchitachi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<script src="../js/pagger.js" type="text/javascript"></script>
<link href="../css/pagger.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>
        <script>
            function sendRedirect(url)
            {
                window.location.href = url;
            }
        </script>
    </head>
    <body>
        <table border="1px"> 
            <tr>               
                <th>Name</th>
                <th>Type</th>
                <th>Author</th>
                <th>Summary</th>
                
                <th>Date</th>
                <th></th>
            </tr>
            <c:forEach items="${requestScope.n}" var="no" varStatus="loop">

                <tr>

                    
                    <td>${no.name}</td>
                    <td><c:forEach items="${requestScope.types}" var="t" varStatus="loop">
                           <c:if test="${t.id eq no.type.id}"><p>${t.name}</p> </c:if>
     
                    </c:forEach></td>
                    <td>${no.author}</td>
                    <td>${no.summary}</td>
                    
                    <td>${no.date}</td>   
                    <td>
<!--                        <input type="button" value="AddChapter"
                               onclick="sendRedirect('addChapter')" />-->
                        <input type="button" value="Edit" 
                               onclick="sendRedirect('uppdate?idNoval=${no.idNoval}')" />
                        
                    </td>
                </tr>
            </c:forEach>
        </table>
         <div id="pager_bottom" class="pagger"> </div>
            <script>

                renderPager("pager_bottom",${requestScope.pageindex},${requestScope.totalpage}, 3);
            </script>
    </body>
</html>
