<%-- 
    Document   : searchResult
    Created on : 26-Mar-2017, 18:14:56
    Author     : sawan_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search Result</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div style= "padding:20px; margin-top:30px; height:1500px;">
            <form name="form" action="searchProperty.htm" method="POST">
                <table border="1" cellpadding="10">
                    <thead>
                        <tr>
                            <th>Images</th>
                            <th>Title</th>
                            <th>Description</th>
                            <th>Property Type</th>
                            <th>Address</th>
                            <th>Postcode</th>
                            <th>Number of Bedroom</th>
                            <th>Number of Bathroom</th>
                            <th>Furnishing Status</th>
                            <th>Garage Availability</th>
                            <th>Garden Availability</th>
                            <th>Parking Availability</th>
                            <th>Size</th>
                            <th>Advertise Type</th>
                            <th>Price</th>
                            <th>Posting Date</th>
                            
                            
                        </tr>
                    </thead>
                
                    <tbody>
                    <c:forEach var="b" items="${property}">
                        <tr>
                            <td>
                                <img src="${b.getImages()}" style="width:304px;height:228px;">
                                </td>
                                <td>
                                    <c:out value="${b.getTitle()}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${b.getDescription()}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${b.getPropertyType()}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${b.getAddress()}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${b.getPostcode()}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${b.getBedroomCount()}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${b.getBathroomCount()}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${b.getFurnishingStatus()}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${b.getGarage()}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${b.getGarden()}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${b.getParking()}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${b.getSize()}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${b.getAdType()}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${b.getPrice()}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${b.getPostDate()}"></c:out>
                                </td>
                                

                                

                            </tr>
                        </c:forEach>
                </tbody>
                </table>
        
    </body>
</html>
