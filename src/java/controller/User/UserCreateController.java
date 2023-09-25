/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.User;
import dao.ApartmentBlockDAO;
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
import model.ApartmentBlock;
import model.Users;

/**
 *
 * @author TADAR
 */
@WebServlet(name = "UserCreateController", urlPatterns = {"/UserCreateController"})
public class UserCreateController extends HttpServlet {

    private  ApartmentBlockDAO adao = new ApartmentBlockDAO();
    private  userDAO userdao = new userDAO();
    private java.util.List<ApartmentBlock> listaApartmentBlocks = new ArrayList<>();
     private java.util.List<Users> listUser = new ArrayList<>();
    public UserCreateController() {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/User/userCreate.jsp");
        rd.forward(request, response);
        listaApartmentBlocks = adao.read();
        request.setAttribute("listuser", listaApartmentBlocks);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");                
        String fullname = request.getParameter("fullname");
        String pass = request.getParameter("pass");
        String identity = request.getParameter("identity");
        
        
         boolean validation = true;
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        String regmail ="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        boolean ktmail = request.getParameter("email").matches(regmail);
        boolean kt = request.getParameter("phone").matches(reg);
        if (kt == false) {
            validation = false;
            request.setAttribute("errorPhone", "Please enter other Number.");
        }
        
        if (ktmail == false) {
            validation = false;
            request.setAttribute("errorEmail", "Pls enter email again.");
        }
        
       
         listUser = userdao.read();
         int userIDNo = 0;
         
         
         for (Users u : listUser) {
            if(userIDNo <= Integer.parseInt(u.getUserID())){
                userIDNo = Integer.parseInt(u.getUserID());
                userIDNo++;
            }
            if(u.getPhoneNumber().equals(phone)){
                validation = false;
                request.setAttribute("errorPhoneEx", "This phone number already been used!");
            }
            if(u.getEmail().equals(email)){
                 validation = false;
                request.setAttribute("errorEmailEx", "This Email already been used!");
            }
        }
           String userID = Integer.toString(userIDNo);
           
     
        if(validation){
             Users nu = new Users(userID, email, phone, fullname, pass, identity);
             userdao.create(nu);
             List<Users> list = userdao.read();
             request.setAttribute("list", list);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/User/userView.jsp");
            rd.forward(request, response);
             
        }else{
                        request.getRequestDispatcher("/view/admin/User/userCreate.jsp").forward(request, response);

        }
             
 
    }

}
