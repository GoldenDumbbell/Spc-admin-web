/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.adminDAO;
import dao.spotDAO;
import dao.unverifyDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;


/**
 *
 * @author sun
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    
    private final adminDAO dao = new adminDAO();
    private Admin admin;
    unverifyDAO udao = new unverifyDAO();
    int noUnverify = 0;
    spotDAO sdao = new spotDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tentaikhoan = request.getParameter("tentaikhoan");
        String matkhau = request.getParameter("matkhau");
        admin = dao.check(tentaikhoan, matkhau);
        if (admin != null) {
            HttpSession session = request.getSession();
            session.setAttribute("LOGIN_USER", admin);
             noUnverify = udao.noUnverify();
                 int no = sdao.NoSpot();
                 int noCar = sdao.NoAvailable();

            request.setAttribute("noUnverify", Integer.toString(noUnverify));
            request.setAttribute("noSpot", Integer.toString(no));
            request.setAttribute("noCar", Integer.toString(noCar));
            
            
            request.setAttribute("noUnverify", Integer.toString(noUnverify));
            if(admin.isRoleAdmin()){
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/admin.jsp");
                rd.forward(request, response);
            }else{
                 RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/admin2.jsp");
                rd.forward(request, response);
                  
            }
        }
            
         else {
            request.setAttribute("errorLogin", "Incorrect Acount or Password");
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        }
    }
}
