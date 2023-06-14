<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>save</title>
</head>
<body>
	<h2>Save user details here..</h2>
	<form action="saveUserData" method="post">
<pre>
	First Name<input type="text" name="firstName" />
	Last Name<input type="text" name="lastName" />
	Email Id<input type="text" name="email" />
	Password<input type="text" name="password" />
	<input type="submit" name="save">
</pre>
	</form>
</body>
</html>