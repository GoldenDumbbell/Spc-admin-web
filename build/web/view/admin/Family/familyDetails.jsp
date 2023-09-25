<%-- 
    Document   : familyDetails
    Created on : Jun 24, 2023, 3:41:38 PM
    Author     : TADAR
--%>

<%@page import="model.Users"%>
<%-- 
    Document   : family
    Created on : Jun 24, 2023, 2:36:00 PM
    Author     : TADAR
--%>

<%@page import="dao.userDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Family"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="assets/img/logo.png"/>
   <title>ADMIN WEB APPLICATION</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    
	<!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    </head>
    <body>
        <div id="wrapper">
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
        
        <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                
                    <li>
                        <a href="HomeController" ><i class="fa fa-desktop "></i>Home</a>
                    </li>
                    <li>
                        <a href="familyViewController" ><i class="fa fa-backward "></i>Back</a>
                    </li>
                    
                    
                </ul>
                            </div>

        </nav>
        <div id="page-wrapper" >
            <div id="page-inner">
                <%  
                 List<Users> ds = (ArrayList<Users>) request.getAttribute("list");
                  userDAO dao = new userDAO();
                  String fID = (String) request.getAttribute("ID");
                  fID.toUpperCase();
                %>
                <div class="col-lg-12 ">
                        <div class="alert alert-info">
                <h1> Family : <%=(fID)%> </h1>
                </div>
                </div>
                <table class="fl-table">
                    <thead>
                <tr>
                   
                    <th>User Name</th>
                    <th>Email</th>
                    <th>Phone Number </th>
                    <th>Role</th>
                    

                  
                </tr>
            </thead>
            <tbody>
                <%
                    for (Users u : ds) {
                        String name;
                        if (u.isRole()){
                            name = "Owner";
                        }else
                        {
                           name = "Member";
                            
                        }
                        
                %>
                <tr>
                    <td>
                        <%=(u.getFullName())%>
                    </td>
                    <td>
                        <%=(u.getEmail())%>
                    </td>
                    <td>
                        <%=(u.getPhoneNumber())%>
                    </td>
                    
                    <td>
                        <%=(name)%>
                    </td>
                   
                </tr>
                
            <%
              }
                %>
            </tbody>
                
                </table>
            </div>
            </div>
    </body>
</html>
