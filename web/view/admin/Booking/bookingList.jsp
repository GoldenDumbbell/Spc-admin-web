<%-- 
    Document   : bookingList
    Created on : Jun 19, 2023, 12:41:57 AM
    Author     : TADAR
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Booking"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   <link rel="shortcut icon" href="assets/img/logo.png"/>
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
               
                
                <form action="BookingSearchController" method="GET">
        <input class="field_class" type="text" name="search" value="" required=""/><button>Search</button>
                    </form>
        </br>        
                
                    
    <table class="fl-table">
        <div id="table-wrapper">
            <thead>
                <tr>
                    <th>CarPlate</th>
                    <th>Car Color</th>
                    <th>Customer</th>
                    <th>Location</th>
                    <th>Time</th>
                    <th>Action</th>
                  
                </tr>
            </thead>
            <tbody>
                <%
                    List<Booking> ds = (ArrayList<Booking>) request.getAttribute("list");
                // Setting the pattern
                    SimpleDateFormat simpleformat = new SimpleDateFormat("MMMM dd /yyyy, hh:mm:ss");
                %>

                <%
                    for (Booking x : ds) {
                        
                %>
                <tr>
                    <td>
                       <%=(x.getCarPlate())%>
                    </td>
                    <td>
                       <%=(x.getCarColor())%>
                    </td>
                    <td>
                       <%=(x.getUserID().getFullName())%>
                    </td>
                    <td>
                       <%=(x.getSensorID().getSensorID())%>
                    </td>
                    <td>
                        <%=(simpleformat.format(x.getDate()))%>
                    </td>  
                    <td>
                        <a href="BookingDeleteController?id=<%=x.getBookingID()%>">Delete</a>
                      
                    </td>
                </tr>
                <%
                     
                }
                %> 
                     

            </tbody>
            </div>
        </table>
                      </div>
    </div>

           
    </body>
</html>

