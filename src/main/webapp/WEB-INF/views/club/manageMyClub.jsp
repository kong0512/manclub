<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script>
		function change(studentID,clubID,val) {
			if(val==0){
				var returnValue = confirm(studentID+"님을 정말 퇴부하겠습니까?");
				if(returnValue)
					location.replace("${pageContext.request.contextPath}/club/changeRole/"+studentID+"/"+clubID+"/"+val);
			}
			else if(val==4){
				var returnValue = confirm("회장을 선택하였습니다. "+studentID+"님에게 회장직을 위임 하시겠습니까?");
				if(returnValue)
					location.replace("${pageContext.request.contextPath}/club/changeRole/"+studentID+"/"+clubID+"/"+val);	
			}
			else
				location.replace("${pageContext.request.contextPath}/club/changeRole/"+studentID+"/"+clubID+"/"+val);
			
		}
		
	</script>
</head>
<body>
	<div id="contents">
	<h1>${clubname } 관리</h1>
		<h4>입부신청 목록</h4>
		<table class="table">
			<tr>
				<th>이름</th>
				<th>학번</th>
				<th>학과</th>
				<th>비고</th>
			</tr>
			<c:forEach var="students" items="${studentslist}">
				<c:forEach var="joinedlist" items="${joinedlist}">
					<c:if
						test="${joinedlist.member_grade == 0 && joinedlist.studentID == students.studentID}">
						<tr>
							<td>${students.name }</td>
							<td>${students.studentID }</td>
							<td>${students.department }</td>
							<td><a
								href="/manclub/club/acceptMember/${students.studentID}/${joinedlist.clubID}">승인</a>
								/ <a
								href="/manclub/club/declineMember/${students.studentID}/${joinedlist.clubID}">거절</a>
							</td>
						</tr>
					</c:if>
				</c:forEach>
			</c:forEach>
		</table>

		<h4>동아리 부원</h4>
		<table class="table">
			<tr>
				<th>이름</th>
				<th>학번</th>
				<th>학과</th>
				<th>등급</th>
				<th>비고</th>
			</tr>
			<c:forEach var="students" items="${studentslist}">
				<c:forEach var="joinedlist" items="${joinedlist}">
					<c:if
						test="${joinedlist.member_grade > 0 && joinedlist.studentID == students.studentID}">
						<tr>
							<td>${students.name }</td>
							<td>${students.studentID }</td>
							<td>${students.department }</td>
							<td>
							<c:choose>
								<c:when test="${joinedlist.member_grade == 1}">회원</c:when>
								<c:when test="${joinedlist.member_grade == 2}">총무</c:when>
								<c:when test="${joinedlist.member_grade == 3}">부회장</c:when>
								<c:when test="${joinedlist.member_grade == 4}">회장</c:when>
							</c:choose>
							</td>
							<td>
								<form name=change_grade>
									<SELECT id="combo"
										onChange="change(${students.studentID},${joinedlist.clubID},this.value);">
										<OPTION value="0"
											<c:if test="${joinedlist.member_grade==0}"> selected="selected" </c:if>>퇴부</OPTION>
										<OPTION value="1"
											<c:if test="${joinedlist.member_grade==1}"> selected="selected" </c:if>>회원</OPTION>
										<OPTION value="2"
											<c:if test="${joinedlist.member_grade==2}"> selected="selected" </c:if>>총무</OPTION>
										<OPTION value="3"
											<c:if test="${joinedlist.member_grade==3}"> selected="selected" </c:if>>부회장</OPTION>
										<OPTION value="4"
											<c:if test="${joinedlist.member_grade==4}"> selected="selected" </c:if>>회장</OPTION>
									</SELECT>
								</form>
							</td>

						</tr>
					</c:if>
				</c:forEach>
			</c:forEach>
		</table>
	</div>
</body>
</html>