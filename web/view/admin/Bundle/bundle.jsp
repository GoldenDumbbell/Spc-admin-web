<%-- 
    Document   : bundle
    Created on : Sep 12, 2023, 10:38:09 PM
    Author     : TADAR
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Bundle"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
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
                    <li  class="active-link" >
                        <a href="HistoryController" ><i class="fa fa-history "></i> History </a>
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
                
          
                
                                    <div style="height:200px; width: 100%; overflow-y:auto;">
                <%
                    List<Bundle> ds = (ArrayList<Bundle>) request.getAttribute("list");
                %>
    <table class="fl-table">
        
            <thead>
                <tr>
                    <th>Normal</th>
                    <th>Price </th>
                    <th>Action</th>
                  
                </tr>
            </thead>
            <tbody>


                <%
                    for (Bundle x : ds) {
                         String str =x.getBundleID();
                        char firstChar = str.charAt(0);
                        if(firstChar == 'A' ){
                %>
                <tr>
                    
                    <td>
                       <%=(x.getBundleName())%>
                    </td>
                    <td>
                        <%=(x.getPrice())%>
                    </td>
                    <td>
                         <a href="bundleUpdateController?id=<%=x.getBundleID()%>">Update</a>
                    </td>
                   
                    
                </tr>
                <%
                    } 
                }
                %> 
                      </div>

            </tbody>
        </table>
                                   </div>
                      <div style="height:200px; width: 100%; overflow-y:auto;">
                      <table class="fl-table">
                          
        
            <thead>
                <tr>
                    <th>With Spot</th>
                    <th>Price </th>
                    <th>Action</th>
                  
                </tr>
            </thead>
            <tbody>


                <%
                    for (Bundle x : ds) {
                        String str =x.getBundleID();
                        char firstChar = str.charAt(0);
                        if(firstChar == 'B' ){ 
                %>
                <tr>
                    
                    <td>
                       <%=(x.getBundleName())%>
                    </td>
                    <td>
                        <%=(x.getPrice())%>
                    </td>
                    <td>
                         <a href="bundleUpdateController?id=<%=x.getBundleID()%>">Update</a>
                    </td>
                   
                    
                </tr>
                <%
                   }  
                }
                %> 
                      </div>

            </tbody>
        </table>
                                   </div>
           <form action="bundleController" method="GET">
       <input type="submit" name="action" value="Reset"/>
                    </form>           
          </div>
    </div>

           
    </body>
</html>
