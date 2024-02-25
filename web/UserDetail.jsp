<%-- 
    Document   : UserDetail
    Created on : Oct 26, 2023, 12:48:40 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Users" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>User Detail</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f5f5f5;
        }
        h1 {
            color: #333;
        }
        .user-detail {
            margin: 20px;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            text-align: left;
        }
        .user-info {
            margin: 10px 0;
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
    <%
            Users u = null;
            if(request.getAttribute("user_detail")!=null){
                u = (Users)request.getAttribute("user_detail");
            }
        %>
</head>
<body>
    <div class="header">
            <a href="home.jsp" class="back-button">Back</a>
        </div>
    <div class="user-detail">
        <h1>User Detail</h1>
        <div class="user-info">
            <strong>ID:</strong> <%= u.getId() %>
        </div>
        <div class="user-info">
            <strong>Name:</strong> <%= u.getName() %>
        </div>
        <div class="user-info">
            <strong>Account:</strong> <%= u.getAccount() %>
        </div>
        <div class="user-info">
            <strong>Pass:</strong> <%= u.getPass() %>
        </div>
        <div class="user-info">
            <strong>Email:</strong> <%= u.getEmail() %>
        </div>
    </div>
        <a href="detail?id2=<%= u != null ? u.getId() : "" %>&mod=1">Change Information</a>
</body>
</html>
