<%-- 
    Document   : UpdateDiary
    Created on : Nov 1, 2023, 3:09:07 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Post"  %>
<%@page import="Model.Tag" %>
<%@page import="Model.Category" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            width: 400px;
            margin: 0 auto;
        }

        input[type="text"], select {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .header {
                background-color: #007BFF;
                color: #fff;
                padding: 10px;
                display: flex;
                align-items: center;
            }

            .back-button {
                text-decoration: none;
                color: #fff;
                margin-right: 20px;
                font-size: 16px;
            }
    </style>
    </head>
    <body>
        <%
            Post p = null;
            if(request.getAttribute("p")!=null){
                p = (Post)request.getAttribute("p");
            }
        %>
        <div class="header">
            <a href="diarylist?uid=<%=p.getUser_id()%>&mod=6"" class="back-button">Back</a>
        </div>
        <form action="diarylist" method="post">
            <h1>Update Diary</h1>
            ID:<input type="text" name="id" value="${p.getId()}" readonly><br>
            User ID:<input type="text" name="uid" value="${p.getUser_id()}" readonly><br>
            Title:<input type="text" name="title" value="${p.getTitle()}" ><br>
            Content:<input type="text" name="content" value="${p.getContent()}" ><br>
            Created Time:<input type="text" name="time" value="${p.getCreated_at()}" readonly><br>
            Category:
            <select name="category">
                <c:forEach items="${data1}" var="item">
                    <option value="${item.getId()}">${item.getName()}</option>
                </c:forEach>
            </select><br>
            Tag:
            <select name="tag">
                <c:forEach items="${data2}" var="item">
                    <option value="${item.getId()}">${item.getName()}</option>
                </c:forEach>
            </select><br>
            <input type="checkbox" name="public" value="1"> Public
            <input type="submit" name="update" value="UPDATE"> <br>
        </form>
    </body>
</html>
