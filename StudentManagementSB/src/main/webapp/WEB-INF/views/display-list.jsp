<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DisplayList</title>
    <style>
        table {
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 5px;
        }
    </style>
</head>
<body>

	<h3>List of Registered Students</h3>
	<hr />
	<br>
	<table>
		<thead>
			<tr>
				<th>STUDENT ID</th>
				<th>FIRST NAME</th>
				<th>LAST NAME</th>
				<th>COURSE</th>
				<th>COUNTRY</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${StudentsList}" var="tempStudent">
					<tr>
						<td><c:out value="${tempStudent.studentId}" /></td>
						<td><c:out value="${tempStudent.firstName}" /></td>
						<td><c:out value="${tempStudent.lastName}" /></td>                         <!-- Here (name) is the property of Student class -->
						<td><c:out value="${tempStudent.course}" /></td>					<!-- this is case sensitive -->
						<td><c:out value="${tempStudent.country}" /></td>
					</tr>
				</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="/CollegeFest/home">Go to Home Page</a>
</body>
</html>