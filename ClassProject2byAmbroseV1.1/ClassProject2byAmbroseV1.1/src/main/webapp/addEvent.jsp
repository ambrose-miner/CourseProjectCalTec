<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Fill in Event Details</h2>
	<form action = "eventController" method ="post">
		<input type="hidden" name="userAction" value="addEvent"/>
		<label>Day</label>
		<input type="text" name="day"/><br/>
		<label>Time</label>
		<input type="text" name="time"/><br/>
		<label>Location</label>
		<input type="text" name="location"/><br/>
		<input type=submit value= "Create Event"/>
	</form>
	<a href="index.jsp">Back</a>
	<a href="viewAllEvent.jsp">View Events</a>
</body>
</html>