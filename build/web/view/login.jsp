<%-- 
    Document   : login
    Created on : Feb 17, 2023, 3:26:40 PM
    Author     : Admin
--%>

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
            <br>
                                         <style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 5px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-sizing: border-box;
}
input[type=password], select {
  width: 100%;
  padding: 12px 20px;
  margin: 5px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 5px;
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
    <br></br>
        <main>
            <form id="login_form" class="form_class" action="LoginController" method="POST">
            <div class="form_div">
           <label>Account:</label> <input  type ="text" name="tentaikhoan" value="admin" required=""></br>
            
           <label>Password:</label><input id="pass" type ="password" name="matkhau" value="123" required=""></br>
            ${errorLogin}</br>
             <input type="submit" name="action" value="Login"/>
            
            </div>
        </form>
        </main>
    </body>
</html>
