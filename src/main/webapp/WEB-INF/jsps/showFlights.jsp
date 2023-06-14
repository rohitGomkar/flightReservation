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
<h2>All flights</h2>
	<table border='1'>
		<tr>
			<th>FLIGHT NUMBER</th>
			<th>OPERATING AIRLINES</th>
			<th>DEPARTURE CITY</th>
			<th>ARRIVAL CITY</th>
			<th>ARRIVAL CITY</th>
			<th>DATE OF DEPARTURE</th>
			<th>ESTIMATED DEPARTURE TIME</th>
			<th>UPDATE</th>
			<th>DELETE</th>
		</tr>

		<c:forEach items="${findAll}" var="findAll">
			<tr>
				<td>${findAll.flightNumber}</td>
				<td>${findAll.operatingAirlines}</td>
				<td>${findAll.departureCity}</td>
				<td>${findAll.arrivalCity}</td>
				<td>${findAll.dateOfDeparture}</td>
				<td>${findAll.estimatedDepartureTime}</td>
				<td><a href="updateFlight?flightId=${findAll.id}">Update</a></td>
				<td><a href="deleteFlight?flightId=${findAll.id}">Delete</a></td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>