<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Zumba Class Schedule</title>
</head>
<body>
<h2>All Event Details</h2>

<table border="1">
	<tr>
		<th></th>
		<th>event ID</th>
		<th>Day</th>
		<th>Time</th>
		<th>Location</th>
		
	</tr>
	<core:forEach items="${sessionScope.listAllEvent}" var="event">
		<tr>
			<td>
				<form action="eventController" method="post">
				<input type=submit value= "View Details"/>
				<input type="hidden" name="EID" value="${event.getEID()}"/>
				<input type="hidden" name="userAction" value="viewSpecificEvent"/>
				</form>
			</td>
			<td><core:out value="${event.getEID()}"></core:out> </td>
			<td><core:out value="${event.getDay()}"></core:out> </td>
			<td><core:out value="${event.getTime()}"></core:out> </td>
			<td><core:out value="${event.getLocation()}"></core:out> </td>
		</tr>
	</core:forEach>
</table>
<br/>
<a href="addEvent.jsp">Schedule an Event</a>
<a href="index.jsp">Back</a>
</body>
</html>