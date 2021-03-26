/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import dal.NovalDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Noval;

/**
 *
 * @author Uchitachi
 */
public class listNoval extends HttpServlet {

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
        
        int pagesize = 8;
        String raw_pageindex = request.getParameter("page");
        if(raw_pageindex == null || raw_pageindex.equals(""))
            raw_pageindex= "1";
        int pageindex = Integer.parseInt(raw_pageindex);
        
        NovalDAO db = new NovalDAO();
        ArrayList<Noval> n = db.paging(pagesize, pageindex);
        int totalRows = db.count();
        int totalPage = totalRows/pagesize + (totalRows % pagesize>0?1:0);
        
     
        
        request.setAttribute("pageindex", pageindex);
        request.setAttribute("totalpage", totalPage);
        
        /*NovalDAO nDB = new NovalDAO();
        ArrayList<Noval> n = nDB.getNoval();*/
        request.setAttribute("n", n);
        //request.getRequestDispatcher("../admin/list.jsp").forward(request, response);
        request.getRequestDispatcher("home.jsp").forward(request, response);
        
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
        String name = request.getParameter("name");
        NovalDAO ndb = new NovalDAO();
        ArrayList<Noval> n = ndb.searchByName(name);
        request.setAttribute("n", n);
        request.getRequestDispatcher("../client/home.jsp").forward(request, response);
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
