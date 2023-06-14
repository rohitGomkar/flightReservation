<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Login for Admin</h2>
	<form action="verifyAdminLogin" method="post">

		<pre>
Email ID<input type="text" name="email">
Password<input type="password" name="password">
</pre>
		<input type="submit" value="login">
	</form>
	${msg}
</body>
</html>