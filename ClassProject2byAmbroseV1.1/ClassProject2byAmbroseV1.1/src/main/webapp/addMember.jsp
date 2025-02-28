<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>

	<h2>Fill in Member Details</h2>
	<form action = "memberController" method = "post"> 
		<input type="hidden" name="userAction" value="addMember"/>
		<label>Member First Name</label>
		<input type="text" name="f_name"/><br/>
		<label>Member Last Name</label>
		<input type="text" name="l_name"/><br/>
		<label>Member email</label>
		<input type="text" name="email"/><br/>
		<input type=submit value= "Create new Member"/>
	</form>
	<a href="viewAllMember.jsp">View Members</a>
	<a href="index.jsp">Back</a>
</body>
</html>