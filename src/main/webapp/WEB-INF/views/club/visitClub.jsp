<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div id="contents">
	<h1>동아리 조회</h1>
		<table class="table table-responsive">
		<tr>
		<th>동아리명</th>
		<th colspan="3">설명</th>
		<th>카테고리</th>
		<th>생성날짜</th>
		</tr>
		<tr>
		<td>${thisclub.club_name }</td>
		<td colspan="3">${thisclub.club_information }</td>
		<td>
			<c:choose>
   				<c:when test="${thisclub.club_category == 1}">ART</c:when>
				<c:when test="${thisclub.club_category == 2}">SPORTS</c:when>
				<c:when test="${thisclub.club_category == 3}">MUSIC</c:when>
				<c:when test="${thisclub.club_category == 4}">TRAVEL</c:when>
				<c:when test="${thisclub.club_category == 5}">SOCIAL</c:when>
				<c:when test="${thisclub.club_category == 6}">VOLUNTEER</c:when>
				<c:when test="${thisclub.club_category == 7}">STUDY</c:when>
			</c:choose>
		</td>
		<td>${thisclub.created_date }</td>
		</tr>
		</table>
		
		<h2>임원 목록 </h2>
		
		<table class="table table-responsive">
		<tr>
		<th>이름</th>
		<th>학번</th>
		<th>학과</th>
		<th>전화번호</th>
		<th>메일</th>
		<th>직책</th>
		</tr>
		
		<c:forEach var="student" items="${studentslist}">
		<tr>
			<td>${student.name }</td>
			<td>${student.studentID }</td>
			<td>${student.department }</td>
			<td>${student.cellphone }</td>
			<td>${student.email } </td>
			<td>
				<c:forEach var="gradetest" items="${joinedlist}">
					<c:if test="${student.studentID == gradetest.studentID}" >
   						<c:choose>
							<c:when test="${gradetest.member_grade == 2}">총무</c:when>
							<c:when test="${gradetest.member_grade == 3}">부회장</c:when>
							<c:when test="${gradetest.member_grade == 4}">회장</c:when>
						</c:choose>
   					</c:if>
				</c:forEach>
			</td>
		</tr>
		
		
		</c:forEach>
		
		
		</table>
	
	</div>

</body>
</html>