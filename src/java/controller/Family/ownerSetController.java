/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Family;

import dao.familyDAO;
import dao.userDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Family;
import model.Users;

/**
 *
 * @author TADAR
 */
@WebServlet(name = "ownerSetController", urlPatterns = {"/ownerSetController"})
public class ownerSetController extends HttpServlet {
    private final userDAO udao = new userDAO();
    private final familyDAO dao = new familyDAO();
    List<Family> listFamiy = new ArrayList<>();
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String familyID = request.getParameter("familyID");
        dao.addOwner(familyID, userID);
        listFamiy = dao.read();
        request.setAttribute("list", listFamiy);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/Family/family.jsp");
        rd.forward(request, response);
        
       
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
        
    }

}
