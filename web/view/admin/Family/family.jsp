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
                <%  
                 List<Family> ds = (ArrayList<Family>) request.getAttribute("list");
                  userDAO dao = new userDAO();
                %>
                    
                <form action="familySearchController" method="GET">
        <input type="text" name="search" value="" required=""/><input type="submit" name="action" value="Search"/>
                    </form>
                <div style="height: 250px; width: 100%; overflow-y:auto;">
                <table class="fl-table">
                    <thead>
                <tr>
                    <th>FamilyID</th>
                    <th>Family Name</th>
                    <th>Apartment Block</th>
                    <th>Owner</th>
                    <th>Action</th>

                  
                </tr>
            </thead>
            <tbody>
                <%
                    for (Family f : ds) {
                            String name = "None Owner";
                            name = (dao.detailsOwner(f.getFamilyID()).getFullName());
                            if (name == null){
                                name  = "None Owner";
                            }
                        
                %>
                <tr>
                    <td>
                        <%=(f.getFamilyID())%>
                    </td>
                    <td>
                        <%=(f.getFamilyName())%>
                    </td>
                    <td>
                        <%=(f.getAblockID().getAblockName())%>
                    </td>
                    <td>
                        <%=(name)%>
                    </td>
                    
                    <% 
                       if(name.equals("None Owner")){
                    %>
                    <td>
                         <a href="ownerAddController?id=<%=f.getFamilyID()%>">Add Owner</a>
                    </td>
                    <%
                        }else{
                    %>
                    <td>
                        <a href="familyDetailsController?id=<%=f.getFamilyID()%>">Detail</a>
                    </td>
                    <%
                    }
                    %>
                    
                    
                    
                    
                </tr>
                
            <%
              }
                %>
            </tbody>
                
                </table>
                </div>
            <form action="familyViewController" method="GET">
            <input type="submit" name="action" value="Refresh"/>
                    </form>
            </div>
            
            </div>
            
    </body>
</html>
