<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html >
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>ING ATM Application</title>
    </head>
    <body>
        <h2>ING ATM Application - User area</h2>

        <h4>${message}</h4>

        <br>

        <a href='<spring:url value="/signout"/>'>Logout</a>

    </body>
</html>