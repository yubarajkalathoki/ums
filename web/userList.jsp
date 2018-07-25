<%-- 
    Document   : userList
    Created on : Jul 20, 2018, 8:47:06 AM
    Author     : Yubaraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User Lists!</h1>
        <table border="1">
            <tr>
                <td>ID</td>
                <td>First Name</td>
                <td>Last Name</td>
                <td>Username</td>
            </tr>
            <c:forEach var="user" items="${userDtoListObj}">
                <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.username}</td>
            </tr>
            </c:forEach>
        </table>
        <h3>
            <a href="login.jsp">Go to Login Page</a>
        </h3>
    </body>
</html>
