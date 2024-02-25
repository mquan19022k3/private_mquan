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
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class DiaryListController extends HttpServlet {

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
            out.println("<title>Servlet DiaryListController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DiaryListController at " + request.getContextPath() + "</h1>");
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
        if (request.getParameter("mod") != null && request.getParameter("mod").equals("2")) {
            String id = request.getParameter("id");
            p.deletePost(id);
        }
        if (request.getParameter("mod") != null && request.getParameter("mod").equals("3")) {
            String id = request.getParameter("id");
            p.getPostById(id);
            request.setAttribute("p", p);
            request.getRequestDispatcher("UpdateDiary.jsp").forward(request, response);
        }
        if (request.getParameter("mod") != null && request.getParameter("mod").equals("4")) {
            String id = request.getParameter("id");
            p.getPostById(id);
            request.setAttribute("p", p);
            request.getRequestDispatcher("ViewDiary.jsp").forward(request, response);
        }
        String uid = request.getParameter("uid");
        ArrayList<Post> data = p.getListPost(uid);
        request.setAttribute("data", data);
        Users u = (Users) request.getSession().getAttribute("user");
        if (u != null) {
            if (data != null && !data.isEmpty()) {
                request.getRequestDispatcher("DiaryList.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("DiaryList.jsp").forward(request, response);
            }
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
        
        String uid = request.getParameter("uid");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String time = request.getParameter("time");
        String category = request.getParameter("category");
        String tag = request.getParameter("tag");
        String isPublic = request.getParameter("public");
        if (request.getParameter("update") != null) {
            if (request.getParameter("public") != null) {
                
                String id = request.getParameter("id");
                Post p = new Post(id, uid, title, content, time, category, tag, isPublic);
                if (p.updatePost()) {
                    p.getPostById(id);
                    request.setAttribute("p", p);
                    ArrayList<Post> data = p.getListPost(uid);
                    request.setAttribute("data", data);
                    request.getRequestDispatcher("DiaryList.jsp").forward(request, response);
                }
            } else {
                String id = request.getParameter("id");
                Post p = new Post(id, uid, title, content, time, category, tag, String.valueOf(0));
                if (p.updatePost()) {
                    p.getPostById(id);
                    request.setAttribute("p", p);
                    ArrayList<Post> data = p.getListPost(uid);
                    request.setAttribute("data", data);
                    request.getRequestDispatcher("DiaryList.jsp").forward(request, response);
                }
                
            }
        }
    }
        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
