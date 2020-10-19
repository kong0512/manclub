<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div id="contents">
	<h1>내 동아리</h1>
	<hr/>
		<table class="table table-responsive">
		<tr>
		<th>카테고리</th>
		<th>동아리 이름</th>
		<th>동아리 정보</th>
		<th>생성날짜</th>
		<th>조회</th>
		<th>비고</th>
		</tr>
		
		<c:forEach var="club" items="${myclublist}">
		<tr>
			<td>
			<c:choose>
   				<c:when test="${club.club_category == 1}">ART</c:when>
				<c:when test="${club.club_category == 2}">SPORTS</c:when>
				<c:when test="${club.club_category == 3}">MUSIC</c:when>
				<c:when test="${club.club_category == 4}">TRAVEL</c:when>
				<c:when test="${club.club_category == 5}">SOCIAL</c:when>
				<c:when test="${club.club_category == 6}">VOLUNTEER</c:when>
				<c:when test="${club.club_category == 7}">STUDY</c:when>
			</c:choose>
			</td>
			<td>${club.club_name }</td>
			<td>${club.club_information }</td>
			<td>${club.created_date }</td>
			<td><a href="${pageContext.request.contextPath}/club/retrieveClub/${club.clubID}">
					<button class="btn btn-default btn-sm">조회</button>
				</a>
			</td>
			<td>
			<c:choose>
				<c:when test="${club.accepted}">
					<a href="${pageContext.request.contextPath}/club/manageClub/${club.clubID}">
					<button class="btn btn-primary btn-sm">관리</button>
					</a>
				</c:when>
				<c:otherwise>
					<button class="btn btn-danger btn-sm" disabled>미승인</button>
				</c:otherwise>
			</c:choose>
			</td>
		</tr>
		
		
		</c:forEach>
		
		
		</table>
	
	</div>

</body>
</html>