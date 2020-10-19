<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div id="contents">
	<h1>동아리 목록  </h1>
	<hr/>
	<div class="form-group" style="max-width: 550px;">
		<form method="post" action="searchedClub">
			<input class="col-sm-6" type="text" name="club_name" maxlength="25" required placeholder="동아리명으로 검색">
			<button class="col-sm-2 btn btn-link btn-sm" type="submit"><span class="glyphicon glyphicon-search"> 검색</span></button>	
		</form>
	</div>
		<table class="table" >
		<tr>
			<th>카테고리</th>
			<th>동아리 이름</th>
			<th>동아리 정보</th>
			<th>생성날짜</th>
			<th>조회</th>
			<th>비고</th>
		</tr>
		<c:forEach var="club" items="${clubList}">
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
			<td><a href="${pageContext.request.contextPath}/club/visitClub/${club.clubID}" >
					<button class="btn btn-default btn-sm">조회</button>
				</a>
			</td>
			<td><a href="${pageContext.request.contextPath}/club/askToJoinClub/${mystudentID}/${club.clubID}" >
					<button class="btn btn-success btn-sm">입부신청</button>
				</a>
			</td>
		</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>