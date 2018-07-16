<%-- 
    Document   : login
    Created on : Jul 11, 2018, 8:43:38 AM
    Author     : Yubaraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login Page!</h1>
        <form method="get" action="./LoginServlet">
        Username: <input type="text" name="un">
        Password: <input type="password" name="pw">
        <input type="submit" value="Login">
    </form>
    </body>
</html>
