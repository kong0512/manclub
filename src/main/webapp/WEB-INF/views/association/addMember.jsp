<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div id="contents">
	<h1>동연 회원 추가</h1>
		<table class="table">
		<tr>
			<th>이름</th>
			<th>학번</th>
			<th>학과</th>
			<th>직책</th>
			<th></th>
		</tr>
		<c:forEach var="students" items="${studentslist}">
		<tr>
			<td>${students.name }</td>
			<td>${students.studentID }</td>
			<td>${students.department }</td>
			<td>${students.association }</td>
			<td><a href="doAddMember/${students.studentID }" ><button class="btn btn-primary btn-sm">등록</button></a>
		</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>