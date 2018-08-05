<%-- 
    Document   : editUser
    Created on : Aug 5, 2018, 8:27:56 AM
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
        <h1>Edit Page!</h1>
        <form method="post" action="./EditUserServlet">
            <input type="hidden" name="userId" value="${userDto.id}">
            First Name: <input type="text" name="fn" value="${userDto.firstName}">
            Last Name: <input type="text" name="ln" value="${userDto.lastName}">
            Username: <input type="text" name="un" value="${userDto.username}">
            <input type="submit" value="Edit">
        </form>
    </body>
</html>
