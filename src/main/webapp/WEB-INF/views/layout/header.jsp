<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/main/univclub">univ CLUB MANAGEMENT SYSTEM</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
			<c:choose>
				<c:when test="${navigation == 'main'}">
					<li class="active"><a href="${pageContext.request.contextPath}/main/univclub">공지사항</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageContext.request.contextPath}/main/univclub">공지사항</a></li>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${navigation == 'club'}">
					<li class="active"><a href="${pageContext.request.contextPath}/club/listClubs">동아리</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageContext.request.contextPath}/club/listClubs">동아리</a></li>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${navigation == 'association'}">
					<li class="active"><a href="${pageContext.request.contextPath}/association/manageAssociation">동아리 연합회</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageContext.request.contextPath}/association/manageAssociation">동아리 연합회</a></li>
				</c:otherwise>
			</c:choose>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/j_spring_security_logout">로그아웃</a></li>
			</ul>
		</div><!-- /.nav-collapse -->
	</div><!-- /.container -->
</div>