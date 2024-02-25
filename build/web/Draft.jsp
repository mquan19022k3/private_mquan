<%-- 
    Document   : DiaryList
    Created on : Oct 31, 2023, 2:13:32 AM
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

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            table, th, td {
                border: 1px solid #ddd;
            }

            th, td {
                padding: 8px;
                text-align: left;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            tr:nth-child(odd) {
                background-color: #fff;
            }

            th {
                background-color: #007BFF;
                color: #fff;
            }

            td a {
                text-decoration: none;
                margin-right: 10px;
            }
        </style>
    </head>
    <body>
        <%
            ArrayList<Post> data=new ArrayList<Post>();
            if(request.getAttribute("data")!=null)
                data=(ArrayList<Post>)request.getAttribute("data");
        %>
        <div id="successMessage" style="display: none; color: red;">Add to Diary successfully</div>

        <div class="header">
            <a href="home.jsp" class="back-button">Back</a>
        </div>
        Draft List:
        <table border="1">
            <tr>
                <td>ID</td>
                <td>Title</td>
                <td>Created Time</td>
                <!--                <td>Category</td>
                                <td>Tag</td>-->
                <td>Action</td>
            </tr>
            <c:forEach items="${data}" var="item">
                <tr>
                    <td>${item.getId()}</td>
                    <td>${item.getTitle()}</td>
                    <td>${item.getCreated_at()}</td>
<!--                    <td>${item.getCategory_id()}</td>
                    <td>${item.getTag_id()}</td>-->
                    <td>
                        <a href="draft?id=${item.getId()}&uid=${item.getUser_id()}&mod=2" onclick="return showDeleteConfirmation();">Delete</a>
                        <a href="draft?id=${item.getId()}&uid=${item.getUser_id()}&mod=3">Add To Diary</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <script type="text/javascript">
                            function showDeleteConfirmation() {
                                // Sử dụng thư viện jQuery để hiển thị hộp thoại xác nhận
                                var isConfirmed = confirm("Are you sure to delete?");
                                return isConfirmed; // Trả về true nếu người dùng chọn "OK", và false nếu họ chọn "Cancel"
                            }
                            // Kiểm tra xem data có null hoặc rỗng không
                            if (${empty data}) {
                                alert("Bạn chưa có bài draft nào.");
                            }
        </script>
        <script>
            <% if (request.getAttribute("addToDiarySuccess") != null && (boolean)request.getAttribute("addToDiarySuccess")) { %>
            document.getElementById("successMessage").style.display = "block";
            <% } %>
        </script>

    </body>
</html>
