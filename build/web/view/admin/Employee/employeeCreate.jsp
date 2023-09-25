<%-- 
    Document   : userCreate
    Created on : May 10, 2023, 5:16:24 PM
    Author     : TADAR
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ApartmentBlock"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                
                    <li >
                        <a href="EmployeeViewController" method="GET"><i class="fa fa-table "></i>Employee Account Table</a>
                    </li>
                    <li >
                        <a href="UserviewController" method="GET"><i class="fa fa-table "></i>Customer Account Table</a>
                    </li>
                    <li>
                        <a href="CarViewController" method="GET"><i class="fa fa-table "></i>Customer Car Table</a>
                    </li>
                    <li>
                        <a href="EmployeeViewController" ><i class="fa fa-backward "></i>Back</a>
                    </li>
                   
                </ul>
                            </div>

        </nav>
            <div id="page-wrapper" >
            <div id="page-inner">
                
        
             <div class="form_div">
            <div class="row">
                    <div class="col-lg-12 ">
                        <div class="alert alert-info">
            <form action="EmployeeCreateController" method="POST">
            <label>Email:</label><input type="text" name="email" required=""/>${errorEmail}</br>
            <label>Fullname:</label> <input  type="text" name="fullname" required=""/></br>
            <label>Password:</label> <input type="text" name="pass" required=""/> </br>
            <label>Identity Number:</label> <input type="text" name="identityNumber" required=""/> </br>
            <label>Current apartment block :</label>
            <select name="AblockID">
                <c:forEach var="item" items="${listapartment}">
                    <option value="${item.getAblockID()}">${(item.getAblockName())}</option>
                </c:forEach>
            </select>
            <input type="submit" name="action" value="Create"/>
           
            </div>
            </div>
            </div>
            </div>
            
            
        </form>
                       

           
        
                </div>
            </div>
            </div>
        </div>
    </body>
</html>
