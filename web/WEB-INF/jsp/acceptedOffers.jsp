<%-- 
    Document   : userOffers
    Created on : 05-Apr-2017, 02:10:55
    Author     : sawan_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Propery Web App</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>




        <br>
        <br>
        <div style="text-align: center">

            <a class="btn btn-info" href="buyerRenterView.htm">Search for Property</a>
            <a class="btn btn-info" href="userOffers.htm">Current Offers</a>
            <a class="btn btn-info" href="acceptedOffers.htm">Accepted Offers</a>
            <a class="btn btn-info" href="userLogout.htm">Log out</a>
        </div>

        <br>
        <br>
        <br>
        <br>
        <div style="text-align: center">
            <div style= "padding:20px; margin-top:30px; height:1500px;">
                <table border="1" cellpadding="10">
                    <thead>
                        <tr>

                            <th>Date</th>
                            <th>Currency</th>
                            <th>Amount</th>
                            <th>Offer accepted on</th>
                            


                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="b" items="${user_accepted_offers}">
                            <tr>
                                <td>
                                    <c:out value="${b.getDate()}"></c:out>
                                    </td>
                                    <td>
                                    <c:out value="${b.getCurrency()}"></c:out>
                                    </td>
                                    <td>
                                    <c:out value="${b.getAmount()}"></c:out>
                                    </td>
                                    <td>
                                    <c:out value="${b.getApprovalDate()}"></c:out>
                                    </td>
                                    
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            </div>

                </body>
                </html>
