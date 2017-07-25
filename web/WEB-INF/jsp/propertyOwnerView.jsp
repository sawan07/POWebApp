<%-- 
    Document   : propertyOwnerView
    Created on : 21-Mar-2017, 15:24:57
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

        <c:forEach var="b" items="${propertyOwnerList}">
            <h2 style="color:#003d5d; text-align: center">My account - welcome ${b.getName()}</h2>    
        </c:forEach>
        <br>
        <br>

        <div style="text-align: center">


            <a class="btn btn-info" href="ownerOffers.htm">Current Offers</a>

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

                            <th>Offer Date</th>
                            <th>Amount</th>
                            <th>Decision</th>



                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="b" items="${owner_offers}">
                            <tr>
                                <td>
                                    <c:out value="${b.getDate()}"></c:out>
                                    </td>
                                    <td>
                                    <c:out value="${b.getAmount()}"></c:out>
                                    </td>
                                    <td>
                                        <a data-id="${b.getIdoffer()}" data-id2="${b.getPropertyPostsID()}" title="Accept offer" class="acceptCurOffer" href="#acceptOffer">
                                        <input   id="offer_id" value="Accept Offer"/></a>
                                    <script>
                                        $(document).on("click", ".acceptCurOffer", function (e) {
                                            e.preventDefault();
                                            var _self = $(this);
                                            var offerid = _self.data('id');
                                            var propertyid = _self.data('id2');
                                            $("#offeridval").val(offerid);
                                            $("#propertyidval").val(propertyid);
                                            $(_self.attr('href')).modal('show');
                                        });

                                    </script>
                                    <div class="modal fade" id="acceptOffer" role="dialog">
                                        <div class="modal-dialog">

                                            <!-- Modal content-->
                                            <div class="modal-content" >
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Accept the offer</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <form method="post" action="acceptOffer.htm" name="AcceptOffer">
                                                        <input type="hidden"  id="offeridval" name="offeridval" value=""/>
                                                        <input type="hidden"  id="propertyidval" name="propertyidval" value=""/>
                                                        <input type="hidden"  id="offerdecision" name="offerdecision" value="1"/>
                                                        <div class="form-group">

                                                            <label for="email">Are you Sure you want to accept this offer?</label>

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

                                    <a data-id="${b.getIdoffer()}"  title="Reject offer" class="rejectCurOffer" href="#rejectOffer">
                                        <input   id="offer_id" value="Reject Offer"/></a>
                                    <script>
                                        $(document).on("click", ".rejectCurOffer", function (e) {
                                            e.preventDefault();
                                            var _self = $(this);
                                            var offerid = _self.data('id');
                                            $("#offeridval2").val(offerid);
                                            $(_self.attr('href')).modal('show');
                                        });

                                    </script>
                                    <div class="modal fade" id="rejectOffer" role="dialog">
                                        <div class="modal-dialog">

                                            <!-- Modal content-->
                                            <div class="modal-content" >
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Reject the offer</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <form method="post" action="rejectOffer.htm" name="RejectOffer">
                                                        <input type="hidden"  id="offeridval2" name="offeridval2" value=""/>
                                                        <input type="hidden"  id="offerdecision" name="offerdecision" value="2"/>
                                                        <div class="form-group">

                                                            <label for="email">Are you Sure you want to reject this offer?</label>

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
