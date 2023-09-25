/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Bundle;

import dao.bundleDAO;
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
import model.Bundle;


/**
 *
 * @author TADAR
 */
@WebServlet(name = "bundleUpdateController", urlPatterns = {"/bundleUpdateController"})
public class bundleUpdateController extends HttpServlet {


    
    bundleDAO dao = new bundleDAO();
    private List<Bundle> list = new ArrayList<Bundle>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Bundle b = new Bundle();
        String bundleID = request.getParameter("id");
        b = dao.detail(bundleID);
        request.setAttribute("bundle", b);
        dao.update(b);
        list.clear();
        list = dao.read();
        request.setAttribute("list", list);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/Bundle/bundleUpdate.jsp");
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
        Bundle b = new Bundle();
          String bundleID = request.getParameter("bundleID");
          int price = Integer.parseInt(request.getParameter("price"));
        b = new Bundle(bundleID, price);
        request.setAttribute("bundle", b);
        dao.update(b);
        list.clear();
        list = dao.read();
        request.setAttribute("list", list);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/Bundle/bundle.jsp");
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
}
