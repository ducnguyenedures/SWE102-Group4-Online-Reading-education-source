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
import model.Noval;
import model.Type;

/**
 *
 * @author Uchitachi
 */
public class updateNoval extends HttpServlet {

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
        int id = Integer.parseInt(request.getParameter("idNoval"));
        
        NovalDAO ndb = new NovalDAO();
        Noval noval = ndb.getNovalById(id);
        
        TypeDAO tdb = new TypeDAO();
        ArrayList<Type> types = tdb.getType();

        request.setAttribute("noval", noval);
        request.setAttribute("types", types);
        request.getRequestDispatcher("../admin/edit.jsp").forward(request, response);
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
        
        int id = Integer.parseInt(request.getParameter("idNoval"));
        String name  = request.getParameter("name");
        int type = Integer.parseInt(request.getParameter("id"));
        String author = request.getParameter("author");
        String summary = request.getParameter("summary");
        String img = request.getParameter("img");
        Date date = Date.valueOf(request.getParameter("date"));
        
        Type t= new Type();
        t.setId(type);
        
        Noval n = new Noval();
        n.setName(name);
        n.setType(t);
        n.setAuthor(author);
        n.setSummary(summary);
        n.setImg(img);
        n.setDate(date);
        n.setIdNoval(id);
        
        NovalDAO nodb = new NovalDAO();
        nodb.update(n);
        
        response.sendRedirect("list");

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
