<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm</title>
</head>
<body>
	<h2>Your ticket is confirmed.....</h2>
	Flight Details
	<Table>
		<tr>
			<td>Passenger FirstName</td>
			<td>${firstName}</td>
		</tr>
		<tr>
			<td>Passenger LastName</td>
			<td>${lastName}</td>
		</tr>
		<tr>
			<td>Passenger MiddleName</td>
			<td>${middleName}</td>
		</tr>
		<tr>
			<td>Passenger email</td>
			<td>${email}</td>
		</tr>
		<tr>
			<td>Passenger Phone</td>
			<td>${phone}</td>
		</tr>
		<tr>
			<td>Passenger Operating AirLines</td>
			<td>${operatingAirLines}</td>
		</tr>
		<tr>
			<td>Passenger Departure City</td>
			<td>${departureCity}</td>
		</tr>
		<tr>
			<td>Passenger Arrival City</td>
			<td>${arrivalCiy}</td>
		</tr>
		<tr>
			<td>Passenger Estimated Departure Time</td>
			<td>${estimatedDepartureTime}</td>
		</tr>
	</Table>
</body>
</html>