<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns ="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec = "http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
<meta  charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<div th:if ="${param.error}">
invalid username or password</div>
<div th:if ="${param.logout}">
you have successfully logged out</div>
<form th: action ="/FamilyTree/tree" method ="post">

<div><label>User Name : <input type ="text" name="username"/></label></div>
<div><label>User Password : <input type ="password" name="password"/></label></div>
<div><input type ="submit" name="Sign In"/></div>


</form>
</body>

</html>