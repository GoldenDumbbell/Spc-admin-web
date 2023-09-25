/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Family;

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
import model.Users;

/**
 *
 * @author TADAR
 */
@WebServlet(name = "familyDetailsController", urlPatterns = {"/familyDetailsController"})
public class familyDetailsController extends HttpServlet {
    private  userDAO udao = new userDAO();
    List<Users> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
       String fID = request.getParameter("id");
       list.clear();
       list = udao.readFamily(fID);
       request.setAttribute("ID", fID);
       request.setAttribute("list", list);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/Family/familyDetails.jsp");
       rd.forward(request, response);
        } catch (IOException | ServletException e) {
            Logger.getLogger(familyViewController.class.getName()).log(Level.SEVERE, null, e);
        }

        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    } 
    
}
