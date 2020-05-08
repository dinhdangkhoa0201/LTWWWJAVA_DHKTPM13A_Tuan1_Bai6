<%@page import="java.util.List"%>
<%@page import="fit.se.dao.PersonDAO"%>
<%@page import="fit.se.beans.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>LTWWWJAVA_DHKTPM13A_TUAN01_DINHDANGKHOA_Bai6</title>
</head>

<body>
	<%
		PersonDAO personDAO = new PersonDAO();
		List<Person> people = personDAO.getPeople();
	%>
	<h1>Bài 6</h1>
	<p style="color: #f02;">Java Servlet – Thao tác với CSDL (có thể
		dùng JPA với OGM MongoDB hoặc kết nối trực tiếp vào MongoDB)</p>
	<span id="result" style="color: #0f0;">${message}</span>
	<form action="AddPerson" method="POST" name="addPerson">
		<table>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td>Country :</td>
				<td><input type="text" name="country" id="country"></td>
			</tr>
		</table>
		<button type="submit">Add Person</button>
		<br>
	</form>
	<div>
		<table id="data" style="align-items: center;">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Country</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="<%=people%>" var="person">
				<tr>
					<td><c:out value="${person.id}"></c:out></td>
					<td><c:out value="${person.name}"></c:out></td>
					<td><c:out value="${person.country}"></c:out></td>
					<td>
						
					</td>
					<td>
						<form action="DeletePerson" method="POST" name="deletePerson">
							<input type="hidden" name="idPerson" value="${person.id}" >
							<a href="#"><button type="submit">Delete</button></a>
						</form>
					</td>
					
				</tr>
			</c:forEach>
		</table>
	</div>
</body>

</html>