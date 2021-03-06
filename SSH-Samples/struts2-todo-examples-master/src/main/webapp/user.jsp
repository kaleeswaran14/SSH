<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>RQ Admin</title>
        <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">

        <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
        <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

        <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

        <!-- Demo page code -->

        <style type="text/css">
            #line-chart {
                height:300px;
                width:800px;
                margin: 0px auto;
                margin-top: 1em;
            }
            .brand { font-family: georgia, serif; }
            .brand .first {
                color: #ccc;
                font-style: italic;
            }
            .brand .second {
                color: #fff;
                font-weight: bold;
            }
        </style>

        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <!-- Le fav and touch icons -->
        <link rel="shortcut icon" href="../assets/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
    </head>

    <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
    <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
    <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
    <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
    <!--[if (gt IE 9)|!(IE)]><!--> 
    <body class=""> 
        <!--<![endif]-->

        <div class="navbar">
            <div class="navbar-inner">
                <ul class="nav pull-right">

                    <li><a href="#" class="hidden-phone visible-tablet visible-desktop" role="button">Settings</a></li>
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i> Kaleeswaran
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="#">My Account</a></li>
                            <li class="divider"></li>
                            <li><a tabindex="-1" class="visible-phone" href="#">Settings</a></li>
                            <li class="divider visible-phone"></li>
                            <li><a tabindex="-1" href="sign-in.html">Logout</a></li>
                        </ul>
                    </li>

                </ul>
                <a class="brand" href="index.html"><span class="first">RQ</span> <span class="second">Corporation</span></a>
            </div>
        </div>




        <div class="sidebar-nav">
            <a href="index.html" class="nav-header"><i class="icon-dashboard"></i>Dashboard<span class="label label-info">+3</span></a>
            <!--         <ul id="dashboard-menu" class="nav nav-list collapse in">
                        <li><a href="index.html">Home</a></li>
                        <li ><a href="users.html">Sample List</a></li>
                        <li ><a href="user.html">Sample Item</a></li>
                        <li ><a href="media.html">Media</a></li>
                        <li ><a href="calendar.html">Calendar</a></li>
                        
                    </ul> -->

            <a href="listCustomerAction" class="nav-header"><i class="icon-briefcase"></i>Account</a>
            <!--         <ul id="accounts-menu" class="nav nav-list collapse">
                        <li ><a href="sign-in.html">Sign In</a></li>
                        <li ><a href="sign-up.html">Sign Up</a></li>
                        <li ><a href="reset-password.html">Reset Password</a></li>
                    </ul> -->

            <!-- <a href="#error-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-exclamation-sign"></i>Error Pages <i class="icon-chevron-up"></i></a>
            <ul id="error-menu" class="nav nav-list collapse">
                <li ><a href="403.html">403 page</a></li>
                <li ><a href="404.html">404 page</a></li>
                <li ><a href="500.html">500 page</a></li>
                <li ><a href="503.html">503 page</a></li>
            </ul>
    
            <a href="#legal-menu" class="nav-header" data-toggle="collapse"><i class="icon-legal"></i>Legal</a>
            <ul id="legal-menu" class="nav nav-list collapse">
                <li ><a href="privacy-policy.html">Privacy Policy</a></li>
                <li ><a href="terms-and-conditions.html">Terms and Conditions</a></li>
            </ul>
    
            <a href="help.html" class="nav-header" ><i class="icon-question-sign"></i>Help</a>
            <a href="faq.html" class="nav-header" ><i class="icon-comment"></i>Faq</a> -->
        </div>



        <div class="content">

            <div class="header">
                <h1 class="page-title">Add User</h1>
                <!--<h1 class="page-title">Edit User</h1>-->
            </div>

            <ul class="breadcrumb">
                <li><a href="index.html">Home</a> <span class="divider">/</span></li>
                <li><a href="users.html">Users</a> <span class="divider">/</span></li>
                <li class="active">User</li>
            </ul>

            <div class="container-fluid">
                <div class="row-fluid">

                    <div class="btn-toolbar">
                        <div class="btn-group">
                        </div>
                    </div>
                    <div class="well">
                        <!--    <ul class="nav nav-tabs">
                              <li class="active"><a href="#home" data-toggle="tab">Profile</a></li>
                              <li><a href="#profile" data-toggle="tab">Password</a></li>
                            </ul>-->
                        <div id="myTabContent" class="tab-content">
                            <div class="tab-pane active in" id="home">
                                <!--<form id="tab" action="addCustomerAction">-->
                                <s:form action="addCustomerAction" theme="simple" cssClass="form-horizontal">
                                    
                                        <s:hidden name="customer.uid" theme="simple"/>
                                        <div class="control-group">
                                            <label class="control-label" for="inputEmail">Name</label>
                                            <div class="controls">
                                                <s:textfield name="customer.name" label="Name" theme="simple"/>
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label" for="inputPassword">Phone Number</label>
                                            <div class="controls">
                                                <!--<input type="password" id="inputPassword" placeholder="Password">-->
                                                <s:textfield name="customer.address.phoneNumber" label="Phone" theme="simple"/>
                                            </div>
                                        </div>
                                            
                                            <div class="control-group">
                                            <label class="control-label" for="inputPassword">Street</label>
                                            <div class="controls">
                                                <s:textfield name="customer.address.street" label="Street" theme="simple"/>
                                            </div>
                                        </div>
                                            
                                            <div class="control-group">
                                            <label class="control-label" for="inputPassword">City</label>
                                            <div class="controls">
                                                <s:textfield name="customer.address.city" label="City" theme="simple"/>
                                            </div>
                                        </div>
                                            
                                            <div class="control-group">
                                            <label class="control-label" for="inputPassword">Country</label>
                                            <div class="controls">
                                                <s:textfield name="customer.address.country" label="Country" theme="simple"/>
                                            </div>
                                        </div>
                                            
<!--                                        <div class="control-group">
                                            <div class="controls">
                                                <label class="checkbox">
                                                    <input type="checkbox"> Remember me
                                                </label>
                                                <button type="submit" class="btn">Sign in</button>
                                            </div>
                                        </div>-->

<!--                                    <label>Username</label>
                                    <input type="text" value="jsmith" class="input-xlarge">
                                    <label>First Name</label>
                                    <input type="text" value="John" class="input-xlarge">
                                    <label>Last Name</label>
                                    <input type="text" value="Smith" class="input-xlarge">
                                    <label>Email</label>
                                    <input type="text" value="jsmith@yourcompany.com" class="input-xlarge">
                                    <label>Address</label>
                                    <textarea value="Smith" rows="3" class="input-xlarge">
2817 S 49th
Apt 314
San Jose, CA 95101
                                    </textarea>
                                    <label>Time Zone</label>
                                    <select name="DropDownTimezone" id="DropDownTimezone" class="input-xlarge">
                                        <option value="10.0">(GMT +10:00) Eastern Australia, Guam, Vladivostok</option>
                                        <option value="11.0">(GMT +11:00) Magadan, Solomon Islands, New Caledonia</option>
                                        <option value="12.0">(GMT +12:00) Auckland, Wellington, Fiji, Kamchatka</option>
                                    </select>-->
<!--                                    <button class="btn btn-primary"><i class="icon-save"></i> Save</button>
                                    <a href="#myModal" data-toggle="modal" class="btn">Delete</a>-->

<div class="control-group">
                                            <label class="control-label" for="inputPassword"></label>
                                            <div class="controls">
                                                <s:submit label="submit" theme="simple" cssClass="btn btn-primary"></s:submit>
                                            </div>
                                        </div>
                                    <!--</form>-->
                                </s:form>
                            </div>
                        </div>

                    </div>

                    <div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h3 id="myModalLabel">Delete Confirmation</h3>
                        </div>
                        <div class="modal-body">

                            <p class="error-text"><i class="icon-warning-sign modal-icon"></i>Are you sure you want to delete the user?</p>
                        </div>
                        <div class="modal-footer">
                            <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
                            <button class="btn btn-danger" data-dismiss="modal">Delete</button>
                        </div>
                    </div>



                    <footer>
                        <hr>

                        <!-- Purchase a site license to remove this link from the footer: http://www.Kaleeswaran.com/bootstrap-themes -->
                        <p class="pull-right">A <a href="http://www.Kaleeswaran.com/bootstrap-themes" target="_blank">Free Bootstrap Theme</a> by <a href="http://www.Kaleeswaran.com" target="_blank">Kaleeswaran</a></p>

                        <p>&copy; 2012 <a href="http://www.Kaleeswaran.com" target="_blank">Kaleeswaran</a></p>
                    </footer>

                </div>
            </div>
        </div>



        <script src="lib/bootstrap/js/bootstrap.js"></script>
        <script type="text/javascript">
            $("[rel=tooltip]").tooltip();
            $(function() {
                $('.demo-cancel-click').click(function() {
                    return false;
                });
            });
        </script>

    </body>
</html>


