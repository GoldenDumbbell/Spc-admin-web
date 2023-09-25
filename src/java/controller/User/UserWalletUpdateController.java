/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.User;

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
import model.Users;

/**
 *
 * @author TADAR
 */
@WebServlet(name = "UserWalletUpdateController", urlPatterns = {"/UserWalletUpdateController"})
public class UserWalletUpdateController extends HttpServlet {

    userDAO dao = new userDAO();  List<Users> list = new ArrayList<>();

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Users u = new Users();
        String userID = request.getParameter("id");
        u = dao.detailsWaller(userID);
        request.setAttribute("user", u);
        dao.updateWallet(u);
        list.clear();
        list = dao.readWallet();
        request.setAttribute("list", list);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/User/userWalletUpdate.jsp");
        rd.forward(request, response);
        
  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Users u = new Users();
        String email = request.getParameter("email");
        String wallet = request.getParameter("wallet");
        u = new Users(email, wallet);
        dao.updateWallet(u);
        list.clear();
        list = dao.readWallet();
        request.setAttribute("list", list);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/User/userWallet.jsp");
        rd.forward(request, response);
        
     
    }
}
