<%-- 
    Document   : newjspownersList
    Created on : 25-Mar-2017, 21:38:28
    Author     : sawan_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Select Property Owner</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        
        <h1 style="color:#006381; text-align: center">Please insert details for the new property</h1>
        <div style="color:#006381; text-align: center">
            <form name="form" action="newProperty.htm" method="POST">
                <div class="form-group">
                    <h4 style="color:#006381; text-align: center">Select property owner for the new property</h4>
                    <select name="owners">
                        <c:forEach var="b" items="${propertyOwnersList}">
                            <option value="${b.getPropertyOwnerId()}">${b.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group" style="margin-left: 300px; margin-right: 300px">
                    <label for="property_title">Title:</label>
                    <input type="text" class="form-control" name="property_title" placeholder="Enter a title for the property">
                </div>
                
                <div class="form-group" style="margin-left: 300px; margin-right: 300px">
                    <label for="property_desc">Description:</label>
                    <input type="text" class="form-control" name="property_desc" placeholder="Enter a description for the property" >
                </div>
                
                <div class="form-group" style="margin-left: 300px; margin-right: 300px">
                    <label for="property_type">Property Type:</label>
                    <input type="text" class="form-control" name="property_type" placeholder="e.g. flat, house">
                </div>
                <div class="form-group" style="margin-left: 300px; margin-right: 300px">
                    <label for="property_address">Property Address:</label>
                    <input type="text" class="form-control" name="property_address" placeholder="">
                </div>
                <div class="form-group" style="margin-left: 300px; margin-right: 300px">
                    <label for="property_postcode">Property Postcode:</label>
                    <input type="text" class="form-control" name="property_postcode" placeholder="">
                </div>
                <div class="form-group" style="margin-left: 300px; margin-right: 300px">
                    <label for="property_bedroom_count">Bedroom Count:</label>
                    <input type="number" class="form-control" name="property_bedroom_count" placeholder="numbers between 0-9">
                </div>
                <div class="form-group" style="margin-left: 300px; margin-right: 300px">
                    <label for="property_bathroom_count">Bathroom Count:</label>
                    <input type="number" class="form-control" name="property_bathroom_count" placeholder="numbers between 0-9">
                </div>
                <div class="form-group" style="margin-left: 300px; margin-right: 300px">
                    <label for="property_furnishing">Furnishing Status:</label>
                    <input type="text" class="form-control" name="property_furnishing" placeholder="e.g. furnished, unfurnihsed">
                </div>
                <div class="form-group" style="margin-left: 300px; margin-right: 300px">
                    <label for="garage_availability">Garage Available:</label><br>
                    <select name="garage_availability">
                        <option>yes</option>
                        <option>no</option>
                    </select>
                </div>
                <div class="form-group" style="margin-left: 300px; margin-right: 300px">
                    <label for="garden_availability">Garden Available:</label><br>
                    <select name="garden_availability">
                        <option>yes</option>
                        <option>no</option>
                    </select>
                </div>
                <div class="form-group" style="margin-left: 300px; margin-right: 300px">
                    <label for="parking_availability">Parking Available:</label><br>
                    <select name="parking_availability">
                        <option>yes</option>
                        <option>no</option>
                    </select>
                </div>
                <div class="form-group" style="margin-left: 300px; margin-right: 300px">
                    <label for="property_size">Size:</label>
                    <input type="number" class="form-control" name="property_size" placeholder="in square metres">
                </div>
                <div class="form-group" style="margin-left: 300px; margin-right: 300px">
                    <label for="ad_type">Advertisement Type:</label>
                    <input type="text" class="form-control" name="ad_type" placeholder="e.g. for sale, for rent">
                </div>
                <div class="form-group" style="margin-left: 300px; margin-right: 300px">
                    <label for="property_price">Price:</label>
                    <input type="number" class="form-control" name="property_price" placeholder="in whole numbers e.g. £400, £1500">
                </div>

                <button type="submit" class="btn btn-default">Next</button>
            </form>
        </div>

    </body>
</html>
