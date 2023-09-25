
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
                    <li>
                        <a href="CarUnverifyViewController" ><i class="fa fa-backward "></i>Back</a>
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
                <div class="row text-center pad-top">
          <%Car c = (Car) request.getAttribute("car");%>
                    <form action="CarVerifyController?id=<%=c.getCarID()%>" method="POST">
            <div class="form_div">
           
            <div class="row">
                    <div class="col-lg-12 ">
                        <div class="alert alert-info">
                             <strong>Car Verify</strong>
                        </div>
                       
                    </div>
                    </div>
            <div class="row">
                    <div class="col-lg-12 ">
                        <div class="alert alert-info">
             <img src="<%=c.getCarPaperFront()%>" height="300" width="500"/> 
             <img  src="<%=c.getCarPaperBack()%>" height="300" width="500"/>
            </div>
                       
                    </div>
                    </div>
            <div class="row">
                    <div class="col-lg-12 ">
                        <div class="alert alert-info">
            <label>Car Name:</label> <input  class="field_class"  type="text" name="name" value="<%out.println(c.getCarName());%>" required=""/> </br>
            <label>Car Plate:</label> <input  class="field_class"  type="text" name="plate" value="<%out.println(c.getCarPlate());%>" required=""/> </br>
            <label>Car Color:</label> <input  class="field_class"  type="text" name="color" value="<%out.println(c.getCarColor());%>" required=""/> </br>
           
            </div>
                       
                    </div>
                    </div>
            </div>
         
            <input type="submit" name="action" value="Verify"/> 
        </form>
            <form action="CarVerifyDeniedController?id=<%=c.getCarID()%>" method="POST">
                <input type="submit" name="action" value="Denied"/>
                </from>
    </main>

            
            
    </div>
    </body>
</html>
