<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<div class="container">
	<div class="form-signin">
	<form class="form-signin" action="<c:url value='j_spring_security_check' />" method="post">
	<h2 class="form-signin-heading">동아리 관리 시스템</h2>
		<input type="text" class="form-control" placeholder="StudentID" name="j_username" required="" autofocus="" maxlength="10">
		<input type="password" class="form-control" placeholder="Password" name="j_password" required="">
		<button class="btn btn-primary btn-block" name="submit" type="submit" value="submit">로그인</button>
	</form>
	<a href="${pageContext.request.contextPath}/registerForm">
		<button class="btn btn-link btn-block">회원가입</button>
	</a>
	</div>
</div>
</body>
</html>