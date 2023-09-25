<%-- 
    Document   : familyOwner
    Created on : Jun 24, 2023, 9:19:55 PM
    Author     : TADAR
--%>


<%@page import="model.Users"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.History"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="assets/img/logo.png"/>
   <title>ADMIN WEB APPLICATION</title>
        <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    </head>
    <body><div id="wrapper">
         <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="adjust-nav">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">
                        <img src="assets/img/logo.png"/>
                    </a>
                    
                </div>
              
             
            </div>
        </div>
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                
                    <li>
                        <a href="HomeController" ><i class="fa fa-desktop "></i>Home</a>
                    </li>
                    
                    
                   
                   
                </ul>
                            </div>

        </nav>
                         <style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #214761;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}
label{
    left: 0px;
}

</style>

             <div id="page-wrapper" >
            <div id="page-inner">
                
               
               <div style="height: 250px; width: 100%; overflow-y:auto;">
        <table class="fl-table">
        
            <thead>
                <tr>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Full Name</th>
                    <th>IdentityN0</th>
                    <th>Acction</th>
                  
                </tr>
            </thead>
            
            <tbody>
                        

                <%
                    List<Users> ds = (ArrayList<Users>) request.getAttribute("list");
                    String id = (String) request.getAttribute("id");
                 %>

                <%
                    for (Users x : ds) {
                %>
                <tr>
                    <td>
                        <%=x.getEmail()%>
                    </td>
                    <td>
                       <%=x.getPhoneNumber()%>
                    </td>
                    <td>
                      <%=x.getFullName()%>
                    </td>
                    
                    <td>
                        <%=x.getIdentityNumber()%>
                    </td>
                    <td>
                        <a href="ownerSetController?userID=<%=x.getUserID()%>&familyID=<%=id%>">SET</a>    
                    </td>
                   
                    
                </tr>
                <%
                    }
                %> 
                       
                            
            </tbody>
            
             </table>
               </div>
                
        </main>
        
        </div>
    </div>
             </div>
            </body>
</html>
