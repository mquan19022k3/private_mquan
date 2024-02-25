/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Category;
import Model.Post;
import Model.Tag;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class writeDiaryController extends HttpServlet {

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
            out.println("<title>Servlet writeDiaryController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet writeDiaryController at " + request.getContextPath() + "</h1>");
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
        Post p = new Post();
        ArrayList<Category> data1 = p.getListCategory();
        request.setAttribute("data1", data1);
        ArrayList<Tag> data2 = p.getListTag();
        request.setAttribute("data2", data2);
        request.getRequestDispatcher("WriteDiary.jsp").forward(request, response);
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
        LocalDate curDate = java.time.LocalDate.now();
        String date = curDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String err = "";
        Users u = (Users) request.getSession().getAttribute("user");
        String id = u.getId();
        String category = request.getParameter("category");
        String tag = request.getParameter("tag");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        if (!title.isEmpty() && !content.isEmpty()) {
            if (request.getParameter("save") != null) {
                Post p = new Post(id, title, content, date, category, tag);
                boolean check = p.createPost();
                if (check) {
                    request.getSession().setAttribute("post", p);
                    response.sendRedirect("WriteDiary.jsp?success=true");
                }
            } else if (request.getParameter("saveDraft") != null) {
                Post p = new Post(id, title, content, date, category, tag);
                boolean check = p.draftPost();
                if (check) {
                    request.getSession().setAttribute("post", p);
                    response.sendRedirect("WriteDiary.jsp?draftSuccess=true");
                }
            }
        } else {
            err = "You must fill in all the fields";
            request.setAttribute("err", err);
            Post p = new Post();
            ArrayList<Category> data1 = p.getListCategory();
            request.setAttribute("data1", data1);
            ArrayList<Tag> data2 = p.getListTag();
            request.setAttribute("data2", data2);
            request.getRequestDispatcher("WriteDiary.jsp").forward(request, response);
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
