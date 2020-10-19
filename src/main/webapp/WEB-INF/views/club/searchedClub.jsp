<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


</head>
<body>
	<div id="contents">
	<h1>���Ƹ� ���  </h1>
		<table class="table" >
		<tr>
			<th>ī�װ�</th>
			<th>���Ƹ� �̸�</th>
			<th>���Ƹ� ����</th>
			<th>������¥</th>
			<th>��ȸ</th>
			<th>���</th>
		</tr>
		<c:forEach var="club" items="${searchedList}">
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
			<td><a href="/manclub/club/retrieveClub/${club.clubID}" >
					<button class="btn btn-default btn-sm">��ȸ</button>
				</a>
			</td>
			<td><a href="/manclub/club/askToJoinClub/2013319333/${club.clubID}" >
					<button class="btn btn-success btn-sm">�Ժν�û</button>
				</a>
			</td>
		</tr>
		</c:forEach>
		</table>
	</div>

</body>
</html>