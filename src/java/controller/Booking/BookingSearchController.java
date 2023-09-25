/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Booking;

import dao.bookingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Booking;

/**
 *
 * @author TADAR
 */
@WebServlet(name = "BookingSearchController", urlPatterns = {"/BookingSearchController"})
public class BookingSearchController extends HttpServlet {

   private final bookingDAO dao = new bookingDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String search = request.getParameter("search");
        List<Booking> list = dao.Search(search);
        request.setAttribute("list", list);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/Booking/bookingList.jsp");
        rd.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  
}
