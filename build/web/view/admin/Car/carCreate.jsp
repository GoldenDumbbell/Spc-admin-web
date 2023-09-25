<%-- 
    Document   : carCreate
    Created on : May 11, 2023, 4:31:54 PM
    Author     : TADAR
--%>



<%@page import="model.Users"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
                        <a href="HomeController" ><i class="fa fa-desktop "></i>Home</a>
                    </li>
                    <li>
                        <a href="CarViewController" ><i class="fa fa-backward "></i>Back</a>
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
               
        
    <form  action="CarCreateController" method="POST">
       <div class="form_div">
            <div class="row">
                    <div class="col-lg-12 ">
                        <div class="alert alert-info">
        
        <label>  Car Name: </label> <input  type="text" name="name" required=""/></br>
        <label>  Car Plate:</label> <input type="text" name="plate" required=""/></br>
        <label>  Car Color:</label> <input type="text" name="color" required=""/></br>
        <%
             List<Users> listuser = (ArrayList<Users>) request.getAttribute("listuser");
           %>
          <label>User</label> <select name="email">
                <option value = "NULL"></option>
                <c:forEach var="item" items="${listuser}">
                    <option value="${item.getUserID()}">${item.getEmail()}</option>
                </c:forEach>
            </select>
          </div>
          </div>
          </div>
          </div>
            <input type="submit" name="action" value="Create"/></br>
        </form>
           </div>
           </div>
    </body>
</html>
