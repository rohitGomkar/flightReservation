<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
	<h2>Search here....</h2>
	<form action="searchFlightPage" method="post">
	<pre>
	FROM<input type="text" name="from" /> 
	TO<input type="text" name="to" />
	DEAPARTURE DATE<input type="text" name="departureDate" />
	<input type="submit" value="search">
	</pre>
	</form>
</body>
</html>