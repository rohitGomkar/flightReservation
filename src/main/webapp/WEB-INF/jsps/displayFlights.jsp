<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Flights</title>
</head>
<body>
	<h2>All flights</h2>
	<table border='1'>
		<tr>
			<th>FLIGHT NUMBER</th>
			<th>OPERATING AIRLINES</th>
			<th>DEPARTURE CITY</th>
			<th>ARRIVAL CITY</th>
			<th>DATE OF DEPARTURE</th>
			<th>ESTIMATED DEPARTURE TIME</th>
		</tr>

		<c:forEach items="${findFlights}" var="findFlights">
			<tr>
				<td>${findFlights.flightNumber}</td>
				<td>${findFlights.operatingAirlines}</td>
				<td>${findFlights.departureCity}</td>
				<td>${findFlights.arrivalCity}</td>
				<td>${findFlights.dateOfDeparture}</td>
				<td>${findFlights.estimatedDepartureTime}</td>
				<td><a href="selectFlight?flightId=${findFlights.id}">Select</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>