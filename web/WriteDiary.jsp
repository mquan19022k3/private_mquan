<%-- 
    Document   : WriteDiary
    Created on : Oct 26, 2023, 10:41:13 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Post" %>
<%@page import="Model.Tag" %>
<%@page import="Model.Category" %>
<%@page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                text-align: center;
                margin: 0;
                padding: 0;
            }

            h2 {
                color: #333;
            }

            select, input, textarea {
                width: 100%;
                padding: 10px;
                margin: 5px 0;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 16px;
            }

            select {
                background-color: #fff;
            }

            form {
                max-width: 600px;
                margin: 0 auto;
                background-color: #fff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            }

            button {
                background-color: #007BFF;
                color: #fff;
                border: none;
                padding: 10px 20px;
                border-radius: 5px;
                font-size: 18px;
                cursor: pointer;
            }

            button:hover {
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
        String err="";
                if(request.getAttribute("err")!=null){
                err = (String)request.getAttribute("err");
                }   
        %>
        <% if (request.getAttribute("successMessage") != null) { %>
        <div style="color: green;"><%= request.getAttribute("successMessage") %></div>
        <% } %>

        <div class="header">
            <a href="home.jsp" class="back-button">Back</a>
        </div>
        <h2>Write New Diary Entry</h2>
        <form action="write" method="post">
            <!--        <label for="category">Category:</label>
                    <select id="category" name="category">
                        <option value="category1">Category 1</option>
                        <option value="category2">Category 2</option>
                    </select><br>-->
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
            <input type="text" id="title" name="title" placeholder="Enter title"><br>
            <textarea id="diary" name="content" placeholder="Write your diary here..."></textarea><br>
            <button type="submit" name="save">Save Diary</button>
            <button type="submit" name="saveDraft">Save Draft</button><br>
            <span style="color: red;"><%= err %></span>
        </form>
        <script>
            var urlParams = new URLSearchParams(window.location.search);
            if (urlParams.get('success') === 'true') {
                if (confirm("Save diary successfully. Do you want to continue?")) {
                    window.location.href = 'write';
                } else {
                    window.location.href = 'home.jsp';
                }
            } else if (urlParams.get('draftSuccess') === 'true') {
                if (confirm("Save draft successfully. Do you want to continue?")) {
                    window.location.href = 'write';
                } else {
                    window.location.href = 'home.jsp';
                }
            }
        </script>
    </body>
</html>
