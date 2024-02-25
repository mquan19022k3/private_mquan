package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.Users;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>My Diary</title>\n");
      out.write("        <style>\n");
      out.write("            /* CSS styles */\n");
      out.write("            body {\n");
      out.write("                font-family: Arial, sans-serif;\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            header {\n");
      out.write("                background-color: #f2f2f2;\n");
      out.write("                padding: 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h1, h2, h3 {\n");
      out.write("                color: #333;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            nav {\n");
      out.write("                margin-top: 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            nav a {\n");
      out.write("                margin-right: 10px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                color: #333;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            section {\n");
      out.write("                padding: 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #write-diary {\n");
      out.write("                background-color: #f9f9f9;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #write-diary form {\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #diary-list {\n");
      out.write("                background-color: #fff;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .diary-item {\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("                border-bottom: 1px solid #ccc;\n");
      out.write("                padding-bottom: 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            footer {\n");
      out.write("                background-color: #f2f2f2;\n");
      out.write("                padding: 10px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            body {\n");
      out.write("                font-family: Arial, sans-serif;\n");
      out.write("                background-color: #f0f0f0;\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Định dạng box chứa nội dung */\n");
      out.write("            .box_in {\n");
      out.write("                background-color: #fff;\n");
      out.write("                margin: 20px auto;\n");
      out.write("                padding: 20px;\n");
      out.write("                max-width: 800px;\n");
      out.write("                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Định dạng tiêu đề */\n");
      out.write("            .heading {\n");
      out.write("                font-size: 24px;\n");
      out.write("                margin-bottom: 10px;\n");
      out.write("                color: #333;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Định dạng đường gạch ngang */\n");
      out.write("            .line {\n");
      out.write("                height: 1px;\n");
      out.write("                background-color: #ccc;\n");
      out.write("                margin: 10px 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Định dạng logo */\n");
      out.write("            img {\n");
      out.write("                max-width: 100%;\n");
      out.write("                height: auto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Định dạng nút */\n");
      out.write("            .btn {\n");
      out.write("                background-color: #007bff;\n");
      out.write("                color: #fff;\n");
      out.write("                text-decoration: none;\n");
      out.write("                padding: 10px 20px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                transition: background-color 0.2s;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .btn:hover {\n");
      out.write("                background-color: #0056b3;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Định dạng văn bản chính */\n");
      out.write("            .text-center {\n");
      out.write("                text-align: center;\n");
      out.write("                color: #666;\n");
      out.write("                font-size: 16px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Định dạng phần mô tả */\n");
      out.write("            .text-center p {\n");
      out.write("                margin: 10px 0;\n");
      out.write("                line-height: 1.5;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        ");

        Users u = null;
        if(request.getSession().getAttribute("user")!=null){
        u = (Users) request.getSession().getAttribute("user");
            }
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <h1>My Diary</h1>\n");
      out.write("            <nav>\n");
      out.write("                <a href=\"navbar?mod=4\">Home</a>\n");
      out.write("                <a href=\"navbar?mod=5\">Write Diary</a>\n");
      out.write("                <a href=\"public?mod=8\">Public</a>\n");
      out.write("                <a href=\"diarylist?uid=");
      out.print( u != null ? u.getId() : "" );
      out.write("&mod=6\">Diary List</a>\n");
      out.write("                <a href=\"draft?uid=");
      out.print( u != null ? u.getId() : "" );
      out.write("&mod=7\">Drafts</a>\n");
      out.write("                <a href=\"detail?id=");
      out.print( u != null ? u.getId() : "" );
      out.write("&mod=3\">Account</a>\n");
      out.write("                ");
 if(session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) { 
      out.write("\n");
      out.write("                <a href=\"login?mod=2\">Logout</a>\n");
      out.write("                <span style=\"color:red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.account}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("                ");
 } else { 
      out.write("\n");
      out.write("                <a href=\"navbar?mod=1\">Login</a>\n");
      out.write("\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <div id=\"frontpage\" class=\"box_in\">\n");
      out.write("            <h1 class=\"heading text-center\">Chào mừng đến với nhật ký trực tuyến MIỄN PHÍ</h1>\n");
      out.write("            <div class=\"line\"></div>\n");
      out.write("            <div class=\"text-center\">\n");
      out.write("                <img src=\"image/logo.png\" width=\"300\" height=\"149\" alt=\"my-diary.org logo\">\n");
      out.write("                <p>Đây là dịch vụ nhật ký trực tuyến, cung cấp nhật ký và nhật ký cá nhân - hoàn toàn miễn phí tại my-diary.org! <br>\n");
      out.write("                    Trọng tâm của chúng tôi là bảo mật và quyền riêng tư, và tất cả nhật ký là riêng tư theo mặc định.\n");
      out.write("                    Hãy tiếp tục và đăng ký nhật ký công khai hoặc riêng tư của riêng bạn ngay hôm nay.</p>\n");
      out.write("                <p><a href=\"navbar?mod=5\" class=\"btn btn-diary mb-2\">Tạo nhật ký của bạn!</a></p>\n");
      out.write("                <p>\n");
      out.write("                    Viết nhật ký là một cách tốt để đảm bảo những kỷ niệm và trải nghiệm của bạn vẫn còn sống động. Nó cho phép bạn theo dõi và suy ngẫm về quá khứ của mình và học hỏi từ những sai lầm của bạn.\n");
      out.write("                    Nó cũng có thể được điều trị rất nhiều. Không chỉ để ghi lại những khoảnh khắc vui nhộn, vui vẻ và phiêu lưu mạo hiểm mà còn là những khoảng thời gian buồn đến rợn người. Việc ghi lại những thay đổi trong cuộc sống của bạn có thể hữu ích.\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <footer>\n");
      out.write("            <p>Copyright 2022 My Diary</p>\n");
      out.write("        </footer>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
