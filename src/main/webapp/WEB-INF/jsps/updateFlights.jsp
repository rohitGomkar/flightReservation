<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Update all Customer Here...</h2>
	<form action="updateFlightsData" method="post">
		<pre>
		Flight Number<input type="text" name="flightNumber" value="${flights.flightNumber}"/>
		Operating Airlines<input type="text" name="operatingAirlines" value="${flights.operatingAirlines}"/>
		Departure City<input type="text" name="departureCity" value="${flights.departureCity}"/>
		Arrival City<input type="text" name="arrivalCity" value="${flights.arrivalCity}"/>
		Date Of Departure<input type="text" name="dateOfDeparture" value="${flights.dateOfDeparture}"/>

		<input type="submit" value="update"/>
	</pre>
	</form>
</body>
</html>