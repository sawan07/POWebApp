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


        <c:forEach var="b" items="${buyerRenterList}">
            <h2 style="color:#003d5d; text-align: center">My account - welcome ${b.getName()}</h2>    
        </c:forEach>

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

            <form method="post" action="searchProperty.htm" name="searchProperty">
                <div class="form-group" style="margin-left: 300px; margin-right: 300px">

                    <input type="text" class="form-control" name="searchPropertyInput" placeholder="Search for a place or property type">
                </div>


                <button type="submit" class="btn btn-default">Search</button>
            </form>
        </div>
        <br>
        <br>
        <div style= "padding:20px; margin-top:30px; height:1500px;">
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
                    <th>Make an offer</th>


                </tr>
            </thead>

            <tbody>
                <c:forEach var="b" items="${property}">
                    <tr>
                        <td>
                            <img src="${b.getImages()}" width="200" height="200" >
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
                        <td>
                            <a data-id="${b.getIdpropertyPosts()}" title="Make an offer" class="open-putOffer" href="#putOffer">
                        <input   id="property_id" value="Make Offer"/></a>
<!--                            <button  type="button" class="btn btn-info btn-lg announce" data-toggle="modal" data-target="#putOffer">Make an offer</button>-->
                            <script>
//                                

                                $(document).on("click", ".open-putOffer", function (e) {
                                    e.preventDefault();
                                    var _self = $(this);
                                    var propertyid = _self.data('id');
                                    $("#propertyidval").val(propertyid);
                                    $(_self.attr('href')).modal('show');
                                });

                            </script>



                            <div class="modal fade" id="putOffer" role="dialog">
                                <div class="modal-dialog">

                                    <!-- Modal content-->
                                    <div class="modal-content" >
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Make an offer for this property.</h4>
                                        </div>
                                        <div class="modal-body">
                                            <form method="post" action="saveOffer.htm" name="makeOffer">

                                                <input type="text"  id="propertyidval" name="propertyidval" value=""/>

                                                <div class="form-group">
                                                    <label for="email">Currency:</label>
                                                    <select name="Currency">
                                                        <option>GBP</option>
                                                        <option>USD</option>
                                                        <option>EUR</option>
                                                        <option>AUD</option>
                                                        <option>CAD</option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label for="offerAmount">Amount:</label>
                                                    <input type="number" class="form-control" name="offerAmount" placeholder="Enter an amount">
                                                </div>

                                                <button type="submit" class="btn btn-default">Send Offer</button>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>

                                </div>
                            </div>



                            <!--</form>-->
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
    </form>





</body>
</html>
