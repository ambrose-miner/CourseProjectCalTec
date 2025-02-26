<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Members</title>
</head>
<h2>View All Member Details</h2>

<table border="1">
	<tr>
		<th></th>
		<th>Member ID</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
	</tr>
	<core:forEach items="${sessionScope.listAllMember}" var="member">
		<tr>
			<td>
				<form action="memberController" method="post">
				<input type=submit value= "View Details"/>
				<input type="hidden" name="MID" value="${member.getMID()}"/>
				<input type="hidden" name="userAction" value="viewSpecificMember"/>
				</form>
			</td>
			<td><core:out value="${member.getMID()}"></core:out> </td>
			<td><core:out value="${member.getF_name()}"></core:out> </td>
			<td><core:out value="${member.getL_name()}"></core:out> </td>			
			<td><core:out value="${member.getEmail()}"></core:out> </td>
		</tr>
	</core:forEach>
</table>
<br/>
<a href="index.jsp">Back</a>
</body>
</html>