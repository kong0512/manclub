<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div id="contents">
	<h1>동아리연합회관리</h1>
	<hr/>
	<a href="addMember">
		<button type="button" class="btn btn-success" name="register">
			<span class="glyphicon glyphicon-plus"> 회원 추가</span>
		</button>
	</a>
		<table class="table">
		<tr>
			<th>이름</th>
			<th>학번</th>
			<th>학과</th>
			<th>직책</th>
			<th>비고</th>
		</tr>
		<c:forEach var="students" items="${studentslist}">
		<tr>
			<td>${students.name }</td>
			<td>${students.studentID }</td>
			<td>
			<c:choose>
				<c:when test="${students.department == 1}">ICE</c:when>
				<c:when test="${students.department == 2}">EEE</c:when>
				<c:when test="${students.department == 3}">CE</c:when>
				<c:when test="${students.department == 4}">SCE</c:when>
				<c:when test="${students.department == 5}">SD</c:when>
				<c:otherwise>N/A</c:otherwise>
			</c:choose>
			</td>
			<td>
			<c:choose>
				<c:when test="${students.association == 1}">회장</c:when>
				<c:when test="${students.association == 2}">부회장</c:when>
				<c:when test="${students.association == 3}">총무</c:when>
				<c:when test="${students.association == 4}">기획부장</c:when>
				<c:when test="${students.association == 5}">시설부장</c:when>
				<c:when test="${students.association == 6}">서기</c:when>
				<c:when test="${students.association == 7}">회원</c:when>
				<c:otherwise>N/A</c:otherwise>
			</c:choose>
			</td>
			<td><a href="setMemberGrade/${students.studentID }">
					<button class="btn btn-default btn-sm">수정</button>
				</a>
			</td>
		</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>