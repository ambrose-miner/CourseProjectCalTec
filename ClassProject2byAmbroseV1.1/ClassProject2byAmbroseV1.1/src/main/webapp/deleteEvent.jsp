<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	<form action = "eventController" method = "post"> 
			
			<label>Enter Event ID</label><br/>
			<input type="number" name="EID"/><br/>
			<input type=submit value= "Cancel Event "/><br/>
			<input type="hidden" name="userAction" value="deleteEvent"/>
	</form>
	<a href="index.jsp">Back</a>
</body>
</html>