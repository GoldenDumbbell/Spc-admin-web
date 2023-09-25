/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.spotDAO;
import dao.unverifyDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TADAR
 */
@WebServlet(name = "HomeController", urlPatterns = {"/HomeController"})
public class HomeController extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    unverifyDAO dao = new unverifyDAO();
    spotDAO sdao = new spotDAO();
    int noUnverify = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
        noUnverify = dao.noUnverify();
        int no = sdao.NoSpot();
        int noCar = sdao.NoAvailable();

            request.setAttribute("noUnverify", Integer.toString(noUnverify));
            request.setAttribute("noSpot", Integer.toString(no));
            request.setAttribute("noCar", Integer.toString(noCar));
            
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/admin.jsp");
        rd.forward(request, response);
        } catch (IOException | ServletException e) {
            Logger.getLogger(HomeController.class.getName()).log(Level.ALL.SEVERE, null, e);
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
        try {
        noUnverify = dao.noUnverify();

            request.setAttribute("noUnverify", Integer.toString(noUnverify));
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/admin.jsp");
        rd.forward(request, response);
        } catch (IOException | ServletException e) {
            Logger.getLogger(HomeController.class.getName()).log(Level.ALL.SEVERE, null, e);
        }
    }

}
