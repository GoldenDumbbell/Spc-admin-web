<%-- 
    Document   : history
    Created on : May 9, 2023, 4:36:11 PM
    Author     : TADAR
--%>

<%@page import="model.Users"%>
<%@page import="model.Car"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.History"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   <link rel="shortcut icon" href="assets/img/logo.png"/>
   <title>ADMIN WEB APPLICATION</title>
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
                        <a href="EmployeeViewController" method="GET"><i class="fa fa-table "></i>Employee Account Table</a>
                    </li>
                    <li>
                        <a href="UserviewController" method="GET"><i class="fa fa-table "></i>Customer Account Table</a>
                    </li>
                    <li class="active-link">
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
                <form action="CarSearchController" method="GET">
        <input type="text" name="search" value/><input type="submit" name="action" value="Search"/>
                    </form>
                
                <main>
                                   <div style="height: 300px; width: 100%; overflow-y:auto;">

    <table class="fl-table">
            <thead>
                <tr>
                    <th>CarName</th>
                    <th>CarPlate</th>
                    <th>CarColr</th>
                    <th>Family</th>
                    <th>Verify State 1</th>
                    <th>Verify State 2</th>
                    <th>Action </th>
                    
                </tr>
            </thead>
            <tbody>
                <%
                    List<Car> ds = (ArrayList<Car>) request.getAttribute("list");
                %>

                <%
                    for (Car x : ds) {
                %>
                <tr>
                    <td>
                        <%=x.getCarName()%>
                    </td>
                    <td>
                       <%=x.getCarPlate()%>
                    </td>
                    <td>
                        <%=x.getCarColor()%>
                    </td>
                    <% 
            String userName;
                if (x.getUserId() == null) {
              userName = "No Owner";
            }else{
               userName = x.getUserId().getEmail();
            }
                 %>
                    <td>
                       <%=(userName)%>
                    </td>
                    <td>
                       <%=(x.isVerifyState1())%>
                    </td>
                    <td>
                       <%=x.isVerifyState2()%>
                    </td>
                    <td>
                        <a href="CarDeleteController?id=<%=x.getCarID()%>">Delete</a>
                        <a href="CarUpdateController?id=<%=x.getCarID()%>">Update</a>
                    </td>
 
                </tr>
                <%
                    }
                %> 
            </tbody>
        </table>
                                   </div>
            </main>
    </main>

            
                <form action="CarViewController" method="GET">
            <input type="submit" name="action" value="Refresh"/>
                    </form>
            
    </div>
    </body>
</html>
