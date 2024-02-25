/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Users;
import dal.UsersDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
public class LoginController extends HttpServlet {

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
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        if (request.getParameter("mod") != null && request.getParameter("mod").equals("2")) {
            request.getSession().setAttribute("loggedIn", false);
            session.removeAttribute("user");
            // Chuyển hướng đến trang home sau khi đăng xuất
            response.sendRedirect("home.jsp");
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
        boolean loggedIn = true;
        String alert = "";
        String err = "";
        HttpSession session = request.getSession();
        session.setAttribute("loggedIn", loggedIn);
        String account = request.getParameter("account");
        String pass = request.getParameter("pass");
        UsersDBContext usersDBContext = new UsersDBContext();
        Users users = usersDBContext.checkLogin(account, pass);
        if (account != null && !account.isEmpty() && pass != null && !pass.isEmpty()) {
            if (users != null) {
                request.getSession().setAttribute("user", users);
                response.sendRedirect("/Assignmentdemo");
            } else {
                err = "Account or password is not correct!";
                request.setAttribute("err", err);
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        } else if (account.isEmpty() || pass.isEmpty()) {
            if (request.getParameter("signup") == null) {
                err = "Please input account or password!";
                request.setAttribute("err", err);
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        }
        if (request.getParameter("signup") != null) {
            String account1 = request.getParameter("account1");
            String pass1 = request.getParameter("pass1");
            String name1 = request.getParameter("name1");
            String email1 = request.getParameter("email1");
            Users u1 = new Users(account1, pass1, name1, email1);
            if (!account1.isEmpty() && !name1.isEmpty() && !pass1.isEmpty() && !email1.isEmpty()) {
                boolean check = u1.addUsers();
                if (check) {
                    alert = "Sign up successfully. You can login now!";
                    request.setAttribute("alert", alert);
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
            } else {
                alert = "Please enter your information for signup.";
                request.setAttribute("alert", alert);
                request.getRequestDispatcher("Login.jsp").forward(request, response);
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
