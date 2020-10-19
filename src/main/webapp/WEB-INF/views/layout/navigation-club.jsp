<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row row-offcanvas row-offcanvas-right">
	<div class="col-xs-6 col-sm-3 col-md-3 sidebar-offcanvas" id="sidebar" role="navigation">
		<div class="list-group">
		<c:choose>
			<c:when test="${sidebar == 'listClubs'}">
			<a href="${pageContext.request.contextPath}/club/listClubs" class="list-group-item active">동아리 목록</a>
			</c:when>
			<c:otherwise>
			<a href="${pageContext.request.contextPath}/club/listClubs" class="list-group-item">동아리 목록</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${sidebar == 'createClub'}">
			<a href="${pageContext.request.contextPath}/club/createClub" class="list-group-item active">동아리 생성</a>
			</c:when>
			<c:otherwise>
			<a href="${pageContext.request.contextPath}/club/createClub" class="list-group-item">동아리 생성</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${sidebar == 'myClubs'}">
			<a href="${pageContext.request.contextPath}/club/myClubs" class="list-group-item active">내 동아리</a>
			</c:when>
			<c:otherwise>
			<a href="${pageContext.request.contextPath}/club/myClubs" class="list-group-item">내 동아리</a>
			</c:otherwise>
		</c:choose>
		</div>
	</div><!--/span-->
	<div class="col-xs-12 col-sm-9 col-md-9">