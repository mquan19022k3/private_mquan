<%-- 
    Document   : ViewDiary
    Created on : Oct 31, 2023, 3:54:22 PM
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
        background-color: #f3f3f3;
        margin: 0;
        padding: 0;
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

    .Post-detail {
        background-color: #fff;
        margin: 20px;
        padding: 20px;
        border: 1px solid #ccc;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        border-radius: 5px;
    }

    h1 {
        color: #333;
        font-size: 24px;
        margin-bottom: 20px;
    }

    .post-info {
        margin-bottom: 10px;
    }

    strong {
        font-weight: bold;
    }

    .content-box {
        background-color: #f9f9f9;
        padding: 10px;
        border: 1px solid #ccc;
        margin: 10px 0;
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
        <div class="Post-detail">
            <h1>Your Diary</h1>
            <div class="post-info content-box">
                <strong>Title:</strong> <%= p.getTitle() %>
            </div>
            <div class="post-info content-box">
                <strong>Content:</strong> <%= p.getContent() %>
            </div>
            <div class="post-info content-box">
                <strong>Created Time:</strong> <%= p.getCreated_at() %>
            </div>
            <div class="post-info content-box">
                <strong>Category:</strong> <%= p.getCategory_id() %>
            </div><!-- comment -->
            <div class="post-info content-box">
                <strong>Tag:</strong> <%= p.getTag_id() %>
            </div>
        </div>
    </body>
</html>
