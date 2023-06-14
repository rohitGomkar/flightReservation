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
<h2>Login here</h2>
<form action="saveUser" method="post">
<pre>
Email Id<input type="text" name="email">
Password<input type="password" name="password">
<input type="submit" value="login">
</pre>
</form>
${msg} 
</body>
</html>