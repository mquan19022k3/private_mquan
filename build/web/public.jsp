<%-- 
    Document   : public
    Created on : Nov 7, 2023, 5:22:26 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Post"  %>
<%@page import="Model.Users"  %>
<%@page import="Model.Tag" %>
<%@page import="Model.Category" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        /* CSS cho bảng */
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }

        table, th, td {
            border: 1px solid #ccc;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        /* CSS cho hàng bảng */
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        /* CSS cho tiêu đề cột */
        th {
            background-color: #333;
            color: #fff;
        }

        /* CSS cho các phần tử cụ thể */
        td {
            max-width: 300px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }
        .header {
                background-color: #007BFF;
                color: #fff;
                padding: 10px;
                display: flex;
                align-items: center;
                justify-content: space-between;
            }

            .back-button {
                text-decoration: none;
                color: #fff;
                font-size: 16px;
            }
    </style>
    </head>
    <body>
        <%
            ArrayList<Post> data=new ArrayList<Post>();
            if(request.getAttribute("data")!=null)
                data=(ArrayList<Post>)request.getAttribute("data");
           ArrayList<Users> data1 = new ArrayList<Users>();
            if(request.getAttribute("data1")!=null)
                data1=(ArrayList<Users>)request.getAttribute("data1");    
        %>
        <div class="header">
            <a href="home.jsp" class="back-button">Back</a>
        </div>
        List Public:
        <table border="1">
            <c:forEach items="${data}" var="item">
                <tr>
                    <td>${item.getUser_id()} created at ${item.getCreated_at()}</td>
                    <td>Title: ${item.getTitle()}</td>
                    <td>Content: ${item.getContent()}</td>
                </tr>
            </c:forEach>
        </table>
            
    </body>
</html>
