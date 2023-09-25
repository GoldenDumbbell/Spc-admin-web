<%-- 
    Document   : admin.jsp
    Created on : Mar 19, 2023, 10:08:14 PM
    Author     : sun
--%>


<%@page import="model.Admin"%>
<%@page import="model.Car"%>
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
        <%String i = (String) request.getAttribute("noUnverify");%>
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
        </div>
        <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                
                    <li class="active-link">
                        <a><i class="fa fa-desktop "></i>Dashboard</a>
                    </li>
                    <li>
                        <a href="LogoutController" method="GET">Log Out</a>
                    </li>
                   
                </ul>
                            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    <div class="col-lg-12">
                     <h2>ADMIN DASHBOARD</h2>   
                    </div>
                </div>              
                 <!-- /. ROW  -->
                  <hr />
                <div class="row">
                    <div class="col-lg-12 ">
                        <div class="alert alert-info">
                            
                            <strong>Welcome!</strong>
                        </div>
                       
                    </div>
                    </div>
                  <!-- /. ROW  --> 
       <div class="row text-center pad-top">
                 
                                
                                
                  
                      <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
                      <div class="div-square">
                           <a href="UserWalletViewController" method="GET">
 <i class="fa fa-money fa-5x" ></i>
            <h4>User Wallet Management</h4>
                      </a>
                      </div>     
                  </div>
                       <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
                      <div class="div-square">
                           <a href="PaymentController" method="GET">
 <i class="fa fa-dollar fa-5x" ></i>
            <h4>Payment History</h4>
                      </a>
                      </div>     
                  </div>
           <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
                      <div class="div-square">
                           <a href="bundleController" method="GET">
 <i class="fa fa-gift fa-5x" ></i>
            <h4>Bundle management</h4>
                      </a>
                      </div>     
                  </div>
                      
                      
                         </div>
                   </div>
            </div>
    
    </body>
    
    
</html>
