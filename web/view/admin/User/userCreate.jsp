<%-- 
    Document   : userCreate
    Created on : May 10, 2023, 5:16:24 PM
    Author     : TADAR
--%>
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
    <body>
        
        <main>
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
            
            
            <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <a href="EmployeeViewController" method="GET"><i class="fa fa-table "></i>Employee Account Table</a>
                    </li>
                    <li >
                        <a href="UserviewController" method="GET"><i class="fa fa-table "></i>Customer Account Table</a>
                    </li>
                    <li>
                        <a href="CarViewController" method="GET"><i class="fa fa-table "></i>Customer Car Table</a>
                    </li>
                    <li>
                        <a href="UserviewController" ><i class="fa fa-backward "></i>Back</a>
                    </li>
                </ul>
                            </div>
        
            </nav>

        
            <div id="page-wrapper" >
            <div id="page-inner">       
            <form action="UserCreateController" method="POST">
            <div class="form_div">
            <div class="row">
                    <div class="col-lg-12 ">
                        <div class="alert alert-info">
         
            <label>Email:</label><input type="text" name="email" required=""/><br>${errorEmail}${errorEmailEx}</br>
            <label>Phone:</label> <input type="text" name="phone" required=""/><br> ${errorPhone}${errorPhoneEx}</br>
            <label>Full Name:</label> <input  type="text" name="fullname" required=""/></br>
            <label>Password:</label> <input type="text" name="pass" required=""/> </br>
            <label>Identity Number:</label> <input  type="text" name="identity" required=""/> </br>
        
            <input type="submit" name="action" value="Create"/>
            
            </div>
            </div>
            </div>
            </div>
        </form>
        
        
        </div>
        </div>
        </div>
                    

        </main>
    </body>
</html>