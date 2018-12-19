<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/vendor/jquery/jquery.min.js"></script>
    <script src="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="js/script.js"></script>
    
    <link rel="stylesheet" href="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/vendor/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/dist/css/sb-admin-2.css">
	<link rel="stylesheet" href="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/vendor/metisMenu/metisMenu.min.css" />
	<link rel="stylesheet" href="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/vendor/font-awesome/css/font-awesome.min.css" />
<title>Multi Layer Security Framework</title>
</head>
<body>
	<div class="container">
	<form action="LoginController" method="get">
        <div class="row">
        <h1 align="center">SQL INJECTION DEMO</h1>
            <div class="col-md-4 col-md-offset-4">
            <h5 align="center" style="color: red">${message}</h5>
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form">
                            <fieldset>
                                <div class="form-group">
                                <!-- pattern="^[a-zA-Z0-9~@#$^*()_+=[\]{}|\\,?:]*$" -->
                                    <input class="form-control" placeholder="User Name" name="email" id="email" pattern="^[a-zA-Z0-9~@$^*()_+[\]{}|\\,?:]*$" title="Please do not enter < > - = ' '' # . SPACE" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" pattern="^[a-zA-Z0-9~@$^*()_+[\]{}|\\,?:]*$" title="Please do not enter < > - = ' '' # . SPACE" autofocus>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <button type="submit" class="btn btn-lg btn-success btn-block" onclick="validateScript(document.getElementById('email').value)">Search</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        </form>
    </div>
</body>
</html>