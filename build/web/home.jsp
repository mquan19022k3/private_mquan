<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Users" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Diary</title>
        <style>
            /* CSS styles */
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }

            header {
                background-color: #f2f2f2;
                padding: 10px;
            }

            h1, h2, h3 {
                color: #333;
            }

            nav {
                margin-top: 20px;
            }

            nav a {
                margin-right: 10px;
                text-decoration: none;
                color: #333;
            }

            section {
                padding: 20px;
            }

            #write-diary {
                background-color: #f9f9f9;
            }

            #write-diary form {
                margin-bottom: 20px;
            }

            #diary-list {
                background-color: #fff;
            }

            .diary-item {
                margin-bottom: 20px;
                border-bottom: 1px solid #ccc;
                padding-bottom: 10px;
            }

            footer {
                background-color: #f2f2f2;
                padding: 10px;
                text-align: center;
            }
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                margin: 0;
                padding: 0;
            }

            /* Định dạng box chứa nội dung */
            .box_in {
                background-color: #fff;
                margin: 20px auto;
                padding: 20px;
                max-width: 800px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            /* Định dạng tiêu đề */
            .heading {
                font-size: 24px;
                margin-bottom: 10px;
                color: #333;
            }

            /* Định dạng đường gạch ngang */
            .line {
                height: 1px;
                background-color: #ccc;
                margin: 10px 0;
            }

            /* Định dạng logo */
            img {
                max-width: 100%;
                height: auto;
            }

            /* Định dạng nút */
            .btn {
                background-color: #007bff;
                color: #fff;
                text-decoration: none;
                padding: 10px 20px;
                border-radius: 5px;
                transition: background-color 0.2s;
            }

            .btn:hover {
                background-color: #0056b3;
            }

            /* Định dạng văn bản chính */
            .text-center {
                text-align: center;
                color: #666;
                font-size: 16px;
            }

            /* Định dạng phần mô tả */
            .text-center p {
                margin: 10px 0;
                line-height: 1.5;
            }

        </style>
        <%
        Users u = null;
        if(request.getSession().getAttribute("user")!=null){
        u = (Users) request.getSession().getAttribute("user");
            }
        %>
    </head>
    <body>
        <header>
            <h1>My Diary</h1>
            <nav>
                <a href="navbar?mod=4">Home</a>
                <a href="navbar?mod=5">Write Diary</a>
                <a href="public?mod=8">Public</a>
                <a href="diarylist?uid=<%= u != null ? u.getId() : "" %>&mod=6">Diary List</a>
                <a href="draft?uid=<%= u != null ? u.getId() : "" %>&mod=7">Drafts</a>
                <a href="detail?id=<%= u != null ? u.getId() : "" %>&mod=3">Account</a>
                <% if(session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) { %>
                <a href="login?mod=2">Logout</a>
                <span style="color:red">${sessionScope.user.account}</span>
                <% } else { %>
                <a href="navbar?mod=1">Login</a>

                <% } %>

            </nav>
        </header>

        <div id="frontpage" class="box_in">
            <h1 class="heading text-center">Chào mừng đến với nhật ký trực tuyến MIỄN PHÍ</h1>
            <div class="line"></div>
            <div class="text-center">
                <img src="image/logo.png" width="300" height="149" alt="my-diary.org logo">
                <p>Đây là dịch vụ nhật ký trực tuyến, cung cấp nhật ký và nhật ký cá nhân - hoàn toàn miễn phí tại my-diary.org! <br>
                    Trọng tâm của chúng tôi là bảo mật và quyền riêng tư, và tất cả nhật ký là riêng tư theo mặc định.
                    Hãy tiếp tục và đăng ký nhật ký công khai hoặc riêng tư của riêng bạn ngay hôm nay.</p>
                <p><a href="navbar?mod=5" class="btn btn-diary mb-2">Tạo nhật ký của bạn!</a></p>
                <p>
                    Viết nhật ký là một cách tốt để đảm bảo những kỷ niệm và trải nghiệm của bạn vẫn còn sống động. Nó cho phép bạn theo dõi và suy ngẫm về quá khứ của mình và học hỏi từ những sai lầm của bạn.
                    Nó cũng có thể được điều trị rất nhiều. Không chỉ để ghi lại những khoảnh khắc vui nhộn, vui vẻ và phiêu lưu mạo hiểm mà còn là những khoảng thời gian buồn đến rợn người. Việc ghi lại những thay đổi trong cuộc sống của bạn có thể hữu ích.
                </p>
            </div>
        </div>

        <footer>
            <p>Copyright 2022 My Diary</p>
        </footer>
    </body>
</html>