<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row row-offcanvas row-offcanvas-right">
	<div class="col-xs-6 col-sm-3 col-md-3 sidebar-offcanvas" id="sidebar" role="navigation">
		<div class="list-group">
		<c:choose>
			<c:when test="${sidebar == 'manageAssociation'}">
				<a href="${pageContext.request.contextPath}/association/manageAssociation" class="list-group-item active">동연 관리</a>
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath}/association/manageAssociation" class="list-group-item">동연 관리</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${sidebar == 'manageClubs'}">
				<a href="${pageContext.request.contextPath}/association/manageClubs" class="list-group-item active">동아리 관리</a>
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath}/association/manageClubs" class="list-group-item">동아리 관리</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${sidebar == 'voting'}">
				<a href="${pageContext.request.contextPath}/association/voting" class="list-group-item active">투표</a>
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath}/association/voting" class="list-group-item">투표</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${sidebar == 'facilities'}">
				<a href="${pageContext.request.contextPath}/association/facilities" class="list-group-item active">시설물</a>
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath}/association/facilities" class="list-group-item">시설물</a>
			</c:otherwise>
		</c:choose>
		</div>
	</div><!--/span-->
	<div class="col-xs-12 col-sm-9 col-md-9">