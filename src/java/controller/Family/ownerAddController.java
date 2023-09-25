/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Family;

import controller.History.HistoryController;
import dao.familyDAO;
import dao.userDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ownerAddController", urlPatterns = {"/ownerAddController"})
public class ownerAddController extends HttpServlet {

   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final familyDAO dao = new familyDAO();
    private final userDAO udao = new userDAO();
    List<Users> list = new ArrayList<>();
    List<Family> listFamiy = new ArrayList<>();
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        list.clear();
        list = dao.readOwner();
        request.setAttribute("list", list);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/Family/familyOwner.jsp");
        rd.forward(request, response);
        } catch (IOException | ServletException e) {
            Logger.getLogger(HistoryController.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       
        
    }

}
