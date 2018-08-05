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
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
                <th>Action</th>
            </tr>
            <c:forEach var="user" items="${userDtoListObj}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.username}</td>
                    <td>
                        <a href="
                           <c:url value="/DeleteUserServlet">
                               <c:param name="userId" value="${user.id}"/>
                           </c:url>">
                            <c:out value="Delete"/>
                        </a>
                        <a href="
                           <c:url value="/EditUserServlet">
                               <c:param name="userId" value="${user.id}"/>
                           </c:url>">
                            <c:out value="Edit"/>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <h3>
            <a href="login.jsp">Go to Login Page</a>
        </h3>
    </body>
</html>
