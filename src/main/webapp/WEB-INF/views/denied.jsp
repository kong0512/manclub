<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<div class="container">
	<h1><p class="text-center">Unauthorized Access !!</p></h1>
	<hr /> 
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>    
	
	<p class="text-center text-danger"><strong>로그인을 실패하였습니다. 다시 시도하여 주시기 바랍니다.</strong></p> 
	<p class="text-center text-warning"><em>원인 : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</em></p>
	
	<p class="text-center"><a  href="${contextPath }/login">로그인 페이지로 돌아가기</a></p>
</div>
</body>

</html>