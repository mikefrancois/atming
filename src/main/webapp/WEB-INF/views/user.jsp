<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>ING ATM Application</title>
</head>
<body>
<h2>ING ATM Application - User area</h2>
<hr />
<h3>User dashboard  </h3>
<logout logout-success-url="/login.html" />
<security:authorize access="isAuthenticated()">
    <b>Welcome! <security:authentication property="principal.username" /></b>
</security:authorize>
<br />
<security:authorize access="isAuthenticated()">
    <p access="isAuthenticated()">
        <a href="/ingatm/ui/user/cities">Get ING ATMs list</a>
    <p>
        <a href="/ingatm/ui">Logout</a>
    </p>
</security:authorize>
</body>
</html>



