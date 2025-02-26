<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<h2>Delete Member Profile</h2>
	<form action = "memberController" method = "post"> 
			<label>Enter Member ID</label><br/>
			<input type="number" name="MID"/><br/>
			<input type=submit value= "Delete Member"/><br/>
			<input type="hidden" name="userAction" value="deleteMember"/>
	</form>
	<a href="index.jsp">Back</a>
</body>
</html>