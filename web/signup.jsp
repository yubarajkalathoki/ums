<%-- 
    Document   : signup
    Created on : Jul 17, 2018, 7:48:36 AM
    Author     : Yubaraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Signup Page!</h1>
        <form method="get" action="./SignupServlet">
            First Name: <input type="text" name="fn">
            Last Name: <input type="text" name="ln">
            Username: <input type="text" name="un">
            Password: <input type="password" name="pw">
            <input type="submit" value="Signup">
        </form>
    </body>
</html>
