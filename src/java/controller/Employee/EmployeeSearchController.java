/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Employee;

import dao.employeeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employee;

/**
 *
 * @author TADAR
 */
@WebServlet(name = "EmployeeSearchController", urlPatterns = {"/EmployeeSearchController"})
public class EmployeeSearchController extends HttpServlet {
    private final employeeDAO dao = new employeeDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String search = request.getParameter("search");
        List<Employee> list1 = null ;
        list1 = dao.search(search); 
        request.setAttribute("list", list1);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/Employee/employeeView.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
