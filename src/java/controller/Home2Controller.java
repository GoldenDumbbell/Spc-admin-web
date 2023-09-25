package controller;

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
@WebServlet(name = "Home2Controller", urlPatterns = {"/Home2Controller"})
public class Home2Controller extends HttpServlet {


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
        
        try {
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/admin2.jsp");
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
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/admin2.jsp");
        rd.forward(request, response);
        } catch (IOException | ServletException e) {
            Logger.getLogger(HomeController.class.getName()).log(Level.ALL.SEVERE, null, e);
        }
    }

}
