<%-- 
    Document   : buyerRenterView
    Created on : 21-Mar-2017, 15:24:57
    Author     : sawan_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Propery Web App</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        
        
        
        <c:forEach var="b" items="${estateAgentList}">
            <h2 style="color:#003d5d; text-align: center">My account - welcome ${b.getName()}</h2>    
        </c:forEach>
            <br>
            <br>
            <div style="text-align: center">
            <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#enterNewProperty">Enter New Property</button>
            <a class="btn btn-info" href="userLogout.htm">Log out</a>
            <div id="enterNewProperty" class="collapse">
                <br>
                <p>To save a new property record you will have to insert a good number of information about the property.</p>
               <form method="post" action="ownersList.htm" name="getOwners">
                   <br>
                   <button type="submit" class="btn btn-default">Ok</button>
                   
               </form>
                    
                   
    
            </div>
            
            
            </div>
            
        
    </body>
</html>
