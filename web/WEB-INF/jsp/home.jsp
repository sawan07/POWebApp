<%-- 
    Document   : home
    Created on : 21-Mar-2017, 01:01:13
    Author     : sawan_000
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Propery Web App</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1 style="color: chartreuse; text-align: center">The Property Site </>
            <!--<div class="container">-->
            </br>
            </br>
            <div>
            <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#mymodallogin">Buyer/Renter Login</button>

            <!-- Modal -->
            <div class="modal fade" id="mymodallogin" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content" >
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Login to your buyer/renter account</h4>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="verifyUser.htm" name="Login">
                                <div class="form-group">
                                    <label for="email">Username:</label>
                                    <input type="text" class="form-control" name="username" placeholder="Enter username">
                                </div>
                                <div class="form-group">
                                    <label for="pwd">Password:</label>
                                    <input type="password" class="form-control" name="password" placeholder="Enter password">
                                </div>
                                <div class="checkbox">
                                    <label><input type="checkbox"> Remember me</label>
                                </div>
                                <button type="submit" class="btn btn-default">Submit</button>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>
            
            <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myAgentlogin">Estate Agent Login</button>

            <!-- Modal -->
            <div class="modal fade" id="myAgentlogin" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content" >
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Login to your agent account</h4>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="verifyAgent.htm" name="Login">
                                <div class="form-group">
                                    <label for="email">Username:</label>
                                    <input type="text" class="form-control" name="agent_username" placeholder="Enter username">
                                </div>
                                <div class="form-group">
                                    <label for="pwd">Password:</label>
                                    <input type="password" class="form-control" name="agent_password" placeholder="Enter password">
                                </div>
                                <div class="checkbox">
                                    <label><input type="checkbox"> Remember me</label>
                                </div>
                                <button type="submit" class="btn btn-default">Submit</button>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>
            
            <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myOwnerlogin">Property Owner Login</button>

            <!-- Modal -->
            <div class="modal fade" id="myOwnerlogin" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content" >
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Login to your owner account</h4>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="verifyOwner.htm" name="Login">
                                <div class="form-group">
                                    <label for="email">Username:</label>
                                    <input type="text" class="form-control" name="owner_username" placeholder="Enter username">
                                </div>
                                <div class="form-group">
                                    <label for="pwd">Password:</label>
                                    <input type="password" class="form-control" name="owner_password" placeholder="Enter password">
                                </div>
                                <div class="checkbox">
                                    <label><input type="checkbox"> Remember me</label>
                                </div>
                                <button type="submit" class="btn btn-default">Submit</button>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>
            
            <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#mymodalregister">Register</button>
            <div class="modal fade" id="mymodalregister" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Register</h4>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="registerUser.htm" name="Login">
                                <div class="form-group">
                                    <label for="name">Name:</label>
                                    <input type="text" class="form-control" name="name" placeholder="Enter full name">
                                </div>
                                <div class="form-group">
                                    <label for="email">Email:</label>
                                    <input type="email" class="form-control" name="email" placeholder="Enter email">
                                </div>
                                <div class="form-group">
                                    <label for="buyer_renter_uname">Username:</label>
                                    <input type="text" class="form-control" name="buyer_renter_uname" placeholder="Enter username">
                                </div>
                                <div class="form-group">
                                    <label for="date">Age:</label>
                                 
                                    <input type="number" class="form-control" name="date" placeholder="Enter Date of Birth"  >
                                </div>
                                <div class="form-group">
                                    <label for="address">Address:</label>
                                    <input type="text" class="form-control" name="address" placeholder="Enter address">
                                </div>
                                <div class="form-group">
                                    <label for="gender">Gender:</label>
                                    </br>
                                    <select name="gender">
                                        <option>Male</option>
                                        <option>Female</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="telephone">Contact Number:</label>
                                    <input type="number" class="form-control" name="telephone" placeholder="Enter your Phone Number">
                                </div>
                                <div class="form-group">
                                    <label for="password">Password:</label>
                                    <input type="text" class="form-control" name="password" placeholder="Enter your Password">
                                </div>
                                <div class="checkbox">
                                    <label><input type="checkbox"> Remember me</label>
                                </div>
                                <button type="submit" class="btn btn-default">Submit</button>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>
            </div>
            
            

    </body>
</html>
