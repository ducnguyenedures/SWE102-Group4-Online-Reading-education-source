<%-- 
    Document   : edit
    Created on : Dec 9, 2020, 10:03:26 AM
    Author     : sonnt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="uppdate" method="POST">
            Id: <input type="text" name="idNoval" value="${requestScope.noval.idNoval}" /> <br/>
            Name: <input type="text" name="name" value="${requestScope.noval.name}" /> <br/>
            Type:
            <select name="id" >
               
                <c:forEach items="${requestScope.types}" var="t">
                      
                    <option value="${t.id}">${t.name}</option>
                </c:forEach>
            </select>
            <br/>
            Summary: <input type="text" name="summary" value="${requestScope.noval.summary}" /> <br/>
            Author: <input type="text" name="author" value="${requestScope.noval.author}" /> <br/>
            Img: <input type="text" name="img" value="${requestScope.noval.img}" /> <br/>
            Date: <input type="date" name="date" value="${requestScope.noval.date}"/> <br/>
            
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
