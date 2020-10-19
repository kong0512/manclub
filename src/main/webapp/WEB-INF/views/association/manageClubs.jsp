<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div id="contents">
	<h1>동아리 관리</h1>
	<hr/>
		<p class="lead"><span class="glyphicon glyphicon-stop"></span>  승인 요청 동아리</p>
		<table class="table table-responsive">
			<tr>
				<th>카테고리</th>
				<th>동아리 이름</th>
				<th>동아리 정보</th>
				<th>생성날짜</th>
				<th>조회</th>
				<th>비고</th>
			</tr>
			<c:forEach var="club" items="${askAcceptclubList}">
				<tr>
					<td>
						<c:forEach var="category" items="${categoryList}">
							<c:if test="${club.club_category == category.categoryID}" >
   								${category.category_name}
   							</c:if>
						</c:forEach>
					</td>
					<td>${club.club_name }</td>
					<td>${club.club_information }</td>
					<td>${club.created_date }</td>
					<td><a href="${pageContext.request.contextPath}/association/viewClub/${club.clubID}">
							<button type="button" class="btn btn-default btn-sm">조회</button>
						</a>
					</td>
					<td><a href="/manclub/association/manageClubs/accept/${club.clubID}" onclick="return confirm('${club.club_name}의 동아리 생성 요청을 승인하시겠습니까?')">
							<button type="button" class="btn btn-primary btn-sm">승인</button>
						</a>
						<a href="/manclub/association/manageClubs/decline/${club.clubID}" onclick="return confirm('${club.club_name}의 동아리 생성 요청을 거절하시겠습니까?')">
							<button type="button" class="btn btn-danger btn-sm">거절</button>
						</a>
						 
					</td>
				</tr>
			</c:forEach>
		</table>

		<p class="lead"><span class="glyphicon glyphicon-play"></span>  기존 동아리</p>
		<table class="table">
			<tr>
				<th>카테고리</th>
				<th>동아리 이름</th>
				<th>동아리 정보</th>
				<th>생성날짜</th>
				<th>조회</th>
				<th>비고</th>
			</tr>
			<c:forEach var="club" items="${AcceptedclubList}">
				<tr>
					<td>
						<c:forEach var="category" items="${categoryList}">
							<c:if test="${club.club_category == category.categoryID}" >
   								${category.category_name}
   							</c:if>
						</c:forEach>
					</td>
					<td>${club.club_name }</td>
					<td>${club.club_information }</td>
					<td>${club.created_date }</td>
					<td><a href="${pageContext.request.contextPath}/association/viewClub/${club.clubID}">
							<button type="button" class="btn btn-default btn-sm">조회</button>
						</a>
					</td>
					<td><a href="/manclub/association/manageClubs/decline/${club.clubID}" onclick="return confirm('${club.club_name} 동아리를 폐부하시겠습니까?')">
							<button type="button" class="btn btn-danger btn-sm">폐부</button>
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>