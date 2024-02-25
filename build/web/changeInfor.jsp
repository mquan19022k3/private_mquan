<%-- 
    Document   : changInfor
    Created on : Oct 30, 2023, 3:42:05 AM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Users" %>
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

    form {
        width: 300px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }

    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    input[type="text"]:read-only {
        background-color: #f3f3f3;
        cursor: not-allowed;
    }

    input[type="submit"] {
        background-color: #007BFF;
        color: #fff;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    /* Add spacing between form elements */
    br {
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

    </head>
    <body>
        <%
            Users u = null;
            if(request.getSession().getAttribute("user")!=null){
            u = (Users) request.getSession().getAttribute("user");
                }
            %>
         <div class="header">
            <a href="detail?id=<%= u != null ? u.getId() : "" %>&mod=3" class="back-button">Back</a>
        </div>
        <form action="detail" method="post">
            ID: <input type="text" name="code" value="${u2.getId()}" readonly> <br>
            Name: <input type="text" name="name" value="${u2.getName()}"> <br><!-- comment -->
            Account: <input type="text" name="account" value="${u2.getAccount()}" readonly> <br>
            Pass: <input type="text" name="pass" value="${u2.getPass()}"> <br><!-- comment -->
            Email: <input type="text" name="email" value="${u2.getEmail()}"> <br>
            <input type="submit" name="change" value="Change"> <br>
        </form>
    </body>
</html>
