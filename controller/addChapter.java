/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import dal.ChapterDAO;
import dal.NovalDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Chapter;
import model.Noval;

/**
 *
 * @author Uchitachi
 */
public class addChapter extends HttpServlet {

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
        
        NovalDAO ndb = new NovalDAO();
        ArrayList<Noval> novals = ndb.getNovalName();
        
        request.setAttribute("novals", novals);
        request.getRequestDispatcher("../admin/addChapter.jsp").forward(request, response);
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
        String content = request.getParameter("content");
        int idn = Integer.parseInt(request.getParameter("idn"));
        int numberOfChapter = Integer.parseInt(request.getParameter("numberofchapter"));
        
        
        Noval n = new Noval();
        n.setIdNoval(idn);
        
        Chapter ch = new Chapter();
        ch.setName(name);
        ch.setContent(content);
        ch.setIdn(n);
        ch.setNumberofchapter(numberOfChapter);
        
        ChapterDAO db = new ChapterDAO();
        db.addChapter(ch);
        
        
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
