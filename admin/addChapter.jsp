<%-- 
    Document   : addChapter
    Created on : Dec 14, 2020, 10:06:48 PM
    Author     : Uchitachi
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

        <title>Creator</title>
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">

    </head>
    <body>
        <div class="container">
            <!--begin of menu-->

            <!--end of menu-->
            <!--begin of form-->
            <form class="col-sm-12" action="addChapter" method="post">
                <h2>Create new chapter</h2>
                
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Name Of Chapter</label>
                    <textarea name="name" class="form-control" id="exampleFormControlTextarea1" rows="1"></textarea>
                </div>

                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Number Of Chapter</label>
                    <textarea name="numberofchapter" class="form-control" id="exampleFormControlTextarea1" rows="1"></textarea>
                </div>


                <div class="form-group">
                    <label for="exampleFormControlInput1">Name Of Noval</label>
                    <select name="idn" >
                <c:forEach items="${novals}" var="n">
                    <option value="${n.idNoval}">${n.name}</option>
                </c:forEach>
            </select>
            <br/>
                </div>

                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Content</label>
                    <textarea name="content" class="form-control" id="exampleFormControlTextarea1"></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Create</button>
            </form>
            <!--end of form-->
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

    </body>
</html>

