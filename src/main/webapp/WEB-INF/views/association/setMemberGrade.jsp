<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div id="contents">
	<h1>동연 회원 수정</h1>
		<form action="${pageContext.request.contextPath}/association/modifyMemberGrade" method="post">
			<table class="table">
				
					<tr>
						<td>이름</td>
						<td>${student.name }</td>
					</tr>
					<tr>
						<td>학번</td>
						<td><input name="studentID" value= "${student.studentID }"></td>
					</tr>
					<tr>
						<td>학과</td>
						<td>${student.department }</td>
					</tr>
					<tr>
						<td>직책</td>
						<td>
						<select name="association">
								<!-- 			1:회장, 2:부회장, 3:총무,4:기획부장, 5:시설부장, 6:서기, 7:일반 동연 회원   -->
								<c:choose>
									<c:when test="${student.association==1}">
									<option value="1" selected>회장</option>
									</c:when>
									<c:otherwise><option value="1">회장</option></c:otherwise> 
								</c:choose>
								<c:choose>
									<c:when test="${student.association==2 }">
									<option value="2" selected>부회장</option>
									</c:when>
									<c:otherwise><option value="2">부회장</option></c:otherwise>
								</c:choose>
								
								<c:choose>
									<c:when test="${student.association==3 }">
									<option value="3" selected>총무</option>
									</c:when>
									<c:otherwise><option value="3">총무</option></c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${student.association==4 }">
									<option value="4" selected>기획부장</option>
									</c:when>
									<c:otherwise><option value="4">기획부장</option></c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${student.association==5 }">
									<option value="5" selected>시설부장</option>
									</c:when>
									<c:otherwise><option value="5">시설부장</option></c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${student.association==6 }">
									<option value="6" selected>서기</option>
									</c:when>
									<c:otherwise><option value="6">서기</option></c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${student.association==7 }">
									<option value="7" selected>회원</option>
									</c:when>
									<c:otherwise><option value="7">회원</option></c:otherwise>
								</c:choose>
								<option value="0">non-member</option>
								</select>
								</td>
					</tr>

				

			</table>
			<input type="submit" value="수정" /> <input type="reset" value="reset" />
		</form>
	</div>
</body>
</html>