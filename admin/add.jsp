<%-- 
    Document   : add
    Created on : Nov 10, 2020, 11:11:27 AM
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
            <form class="col-sm-12" action="add" method="post">
                <h2>Create new noval</h2>
                <div class="form-group">
                    <label for="exampleFormControlInput1">Link image</label>
                    <input name="img" type="text" class="form-control" id="exampleFormControlInput1" placeholder="https://genk.mediacdn.vn/thumb_w/660/139269124445442048/2020/10/14/jxcvj-16026312062441713789234.jpg">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Name of Noval</label>
                    <textarea name="name" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                </div>

                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Author</label>
                    <textarea name="author" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                </div>

                <div class="form-group">
                    <label for="exampleFormControlInput1">Date</label>
                    <input name="date" type="date" class="form-control" id="exampleFormControlInput1">
                </div>

                <div class="form-group">
                    <label for="exampleFormControlInput1">Type</label>
                    <select name="id" >
                        <c:forEach items="${requestScope.types}" var="t">
                            <option value="${t.id}">${t.name}</option>
                        </c:forEach>
                    </select>
                    <br/>
                </div>

                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Summary</label>
                    <textarea name="summary" class="form-control" id="exampleFormControlTextarea1" rows="10"></textarea>
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
