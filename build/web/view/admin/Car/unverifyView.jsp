
<%@page import="model.Car"%>
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
      <div id="page-wrapper" >
            <div id="page-inner">
               <div style="height: 250px; width: 100%; overflow-y:auto;">
    <table class="fl-table" >
            <thead>
                <tr>
                    <th>CarName</th>
                    <th>CarPlate</th>
                    <th>CarColor</th>
                    <th>Paper Front</th>
                    <th>Paper Back</th>
                    <th>Action</th>
                    
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
                    <td>
                        <img src="<%=x.getCarPaperFront()%>" height="50" width="50">
                    </td>
                    <td>
                        <img src="<%=x.getCarPaperBack()%>" height="50" width="50">
                    </td>
                    <td>
                        <a href="CarVerifyController?id=<%=x.getCarID()%>"> Verify </a>
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
    </body>
</html>
