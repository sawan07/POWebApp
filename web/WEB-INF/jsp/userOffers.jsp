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
                            <th>Update offer</th>
                            <th>Delete offer</th>


                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="b" items="${user_offers}">
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
                                        <a data-id="${b.getIdoffer()}" title="Update offer" class="open-putOffer" href="#putOffer">
                                        <input   id="offer_id" value="Make Offer"/></a>
                                    <!--                            <button  type="button" class="btn btn-info btn-lg announce" data-toggle="modal" data-target="#putOffer">Make an offer</button>-->
                                    <script>
        //                                

                                        $(document).on("click", ".open-putOffer", function (e) {
                                            e.preventDefault();
                                            var _self = $(this);
                                            var offerid = _self.data('id');
                                            $("#offeridval").val(offerid);
                                            $(_self.attr('href')).modal('show');
                                        });

                                    </script>



                                    <div class="modal fade" id="putOffer" role="dialog">
                                        <div class="modal-dialog">

                                            <!-- Modal content-->
                                            <div class="modal-content" >
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Update offer for this property.</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <form method="post" action="editOffer.htm" name="makeOffer">

                                                        <input type="hidden"  id="offeridval" name="offeridval" value=""/>

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

                                                        <button type="submit" class="btn btn-default">Update Offer</button>
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
                                <td>
                                    
                                    
                                    
                                        <a data-id="${b.getIdoffer()}" title="Delete offer" class="deleteCurOffer" href="#deleteOffer">
                                            <input   id="offer_id" value="Delete Offer"/></a>
                                    <script>
                                          $(document).on("click", ".deleteCurOffer", function (e) {
                                            e.preventDefault();
                                            var _self = $(this);
                                            var offerid = _self.data('id');
                                            $("#offeridval2").val(offerid);
                                            $(_self.attr('href')).modal('show');
                                        });

                                    </script>
                                        <div class="modal fade" id="deleteOffer" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content" >
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Delete the offer</h4>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="deleteOffer.htm" name="DeleteOffer">
                                <input type="hidden"  id="offeridval2" name="offeridval2" value=""/>
                                <div class="form-group">
                                    
                                    <label for="email">Are you Sure?</label>
                                    
                                </div>
                                
                                <button type="submit" class="btn btn-default">Yes</button>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>
                                </td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            </div>

                </body>
                </html>
