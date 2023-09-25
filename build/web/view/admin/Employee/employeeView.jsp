
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Employee"%>
<%@page import="dao.userDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    
    <body >
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
                    <li class="active-link">
                        <a><i class="fa fa-table " ></i>Employee Account Table</a>
                    </li>
                    <li>
                        <a href="UserviewController" method="GET"><i class="fa fa-table "></i>Customer Account Table</a>
                    </li>
                    <li>
                        <a href="CarViewController" method="GET"><i class="fa fa-table "></i>Customer Car Table</a>
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
                <form action="EmployeeSearchController" method="GET">
        <input class="field_class" type="text" name="search" value="" required=""/><input type="submit" name="action" value="Search"/>

                    </form>
                
                                   <div style="height: 240px; width: 100%; overflow-y:auto;">

        <table class="fl-table">
            <thead>
                <tr>
                    <th>Email</th>
                    <th>Full Name</th>
                    <th>Pass</th>
                    <th>Identity</th>
                    <th>Aparment block</th>
                    <th>Acction</th>
                  
                </tr>
            </thead>
            <tbody>
                <%
                    List<Employee> ds = (ArrayList<Employee>) request.getAttribute("list");
                   
                %>

                <%
                    for (Employee x : ds) {
                %>
                <tr>
                    
                    <td>
                        <%=(x.getEmail())%>
                    </td>
                    
                    <td>
                       <%=x.getFullName()%>
                    </td>
                    <td>
                        <%=x.getPassword()%>
                    </td>
                    <td>
                        <%=(x.getIdentityNumber())%>
                    </td>
                    <td>
                       <%=(x.getAblockID().getAblockName())%>
                    </td>
                     <td>
                        <a href="EmployeeUpdateController?id=<%=x.getEmail()%>">Update</a>
                        <a href="EmployeeDeleteController?id=<%=x.getEmail()%>">Delete</a>
                        
                    </td>
                   
                   
                    
                </tr>
                <%
                    }
                %> 
           </div>
            </tbody>
        </table>
                                   </div>
           <form action="EmployeeCreateController" method="GET">
            <input type="submit" name="action" value="Create"/>
             </form>
                <form action="EmployeeViewController" method="GET">
            <input type="submit" name="action" value="Refresh"/>
                    </form>
            </div>
    </div>

            
    </body>
</html>
