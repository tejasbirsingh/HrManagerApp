<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Login</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
        <link rel="stylesheet" href="/css/login.css" />
    </head>
    <body>
        <div class="registration-form">
            <form id="form" method="POST" action="/login">
                <div class="text-center pb-2"><h2>HR Management App</h2></div>
                <div class="form-icon">
                    <span><i class="icon icon-user"></i></span>
                </div>
                <c:import url="./notification.jsp"></c:import>
                <div class="form-group">
                    <input type="text" class="form-control item" id="username" name="username" placeholder="Username" />
                    <div id="usernameError" class="invalid-feedback"></div>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control item" id="password" name="password" placeholder="Password" autocomplete="true" />
                    <div id="passwordError" class="invalid-feedback"></div>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-block create-account">Login</button>
                </div>
            </form>
            <div class="social-media"></div>
        </div>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <script src="/js/login.js"></script>
    </body>
</html>
