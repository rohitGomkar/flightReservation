<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DISPLAY DETAILS</title>
</head>
<body>
		FLIGHT NUMBER:${flight.flightNumber}<br>
	    OPERATING AIRLINES:${flight.operatingAirlines}<br>
		DEPARTURE CITY:${flight.departureCity}<br>
		ARRIVAL CITY:${flight.arrivalCity}<br>
		DEPARTURE DATE:${flight.dateOfDeparture}<br>
		
		<form action="confirmReservation" method ="post">
		<h2>passenger Details</h2>
		<pre>
		FIRST NAME<input type="text" name="firstName">
		LAST NAME<input type="text" name="lastName">
		MIDDLE NAME<input type="text" name="middleName">
		EMAIL ID<input type="text" name="email">
		PHONE<input type="text" name="phone">
		<input type="hidden" name="flightId" value="${flight.id}">
		</pre>
		
		
        <input type="submit" value="complete reservation"><br>
		</form>
</body>
</html>