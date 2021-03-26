/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import dal.NovalDAO;
import dal.ChapterDAO;
import dal.TypeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Chapter;
import model.Noval;
import model.Type;

/**
 *
 * @author Uchitachi
 */

public class addNoval extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        TypeDAO tDB = new TypeDAO();
        ArrayList<Type> types = tDB.getType();
        request.setAttribute("types", types);
        request.getRequestDispatcher("../admin/add.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String name = request.getParameter("name");
        int id = Integer.parseInt(request.getParameter("id"));
        String author = request.getParameter("author");
        String summary = request.getParameter("summary");
        String img = request.getParameter("img");
        Date date = Date.valueOf(request.getParameter("date"));

        Type t = new Type();
        t.setId(id);

        Noval n = new Noval();

        n.setName(name);
        n.setType(t);
        n.setAuthor(author);
        n.setSummary(summary);
        n.setImg(img);
        n.setDate(date);

        NovalDAO db = new NovalDAO();
        db.addNoval(n);
        response.sendRedirect("../client/list");
        response.getWriter().println("Noval added successful!");
        //processRequest(request, response);
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
