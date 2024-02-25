/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Users;
import dal.AccountDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class UserDetail extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserDetail</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserDetail at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        AccountDBContext accountDBContext = new AccountDBContext();
        Users u = accountDBContext.getUserById(id);
        if (request.getParameter("mod") != null && request.getParameter("mod").equals("1")) {
            String id2 = request.getParameter("id2");
            Users u2 = new Users();
            u2.getUserById(id2);
            request.setAttribute("u2", u2);
            request.getRequestDispatcher("changeInfor.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("home.jsp");
        }
        if (u != null) {
            request.setAttribute("user_detail", u);
            request.getRequestDispatcher("UserDetail.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("code");
        String name = request.getParameter("name");
        String account = request.getParameter("account");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");

        if (request.getParameter("change") != null) {
            Users u = new Users(id, account, pass, name, email);
            request.setAttribute("u", u);
            if (u.updateUsers(id)) {
                request.setAttribute("user_detail", u);
                request.getRequestDispatcher("UserDetail.jsp").forward(request, response);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
