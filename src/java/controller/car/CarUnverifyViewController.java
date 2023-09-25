/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.car;

import controller.History.HistoryController;
import dao.carDAO;
import dao.historyDAO;
import dao.unverifyDAO;
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
import model.Car;

/**
 *
 * @author TADAR
 */
@WebServlet(name = "CarUnverifyViewController", urlPatterns = {"/CarUnverifyViewController"})
public class CarUnverifyViewController extends HttpServlet {
     private final unverifyDAO dao = new unverifyDAO();
    private List<Car> list = new ArrayList<>();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        list = dao.readUnverify();
        request.setAttribute("list", list);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/Car/unverifyView.jsp");
        rd.forward(request, response);
        } catch (IOException | ServletException e) {
            Logger.getLogger(CarUnverifyViewController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
}
