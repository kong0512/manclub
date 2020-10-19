<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
$(document).ready(function() {
	$("#password").keyup(function(){
		$("#lblError").text("");
	});        
	$("#passwordConfirm").keyup(function(){
		if($("#password").val() !=$("#passwordConfirm").val()){
			$("#lblError").text("");
			$("#lblError").html("<p class=\"text-danger\"><strong>암호가 틀립니다.</strong></p>");   
		}
		else{
			$("#lblError").text("");
			$("#lblError").html("<p class=\"text-success\"><strong>암호가 맞습니다.</strong></p>");
		}
	});
});
</script>
</head>
<body>
<div class="contents">
<h1>회원 가입</h1>
	<form class="form-horizonal" role="form" id="registerForm" action="registerStudent" method="post">
	<div class="form-group" style="max-width: 640px;">
		<div class="col-sm-3"></div>
		<div class="col-sm-9">
			<p class="text-warning">* : <em>필수 입력 항목</em></p>
		</div>
	</div>
	<div class="form-group" style="max-width: 640px;">
		<label for="name" class="col-sm-3 control-label">*학생 이름</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" id="name" name="name" required placeholder="Name" maxlength="50">
		</div>
	</div>
	<div class="form-group" style="max-width: 640px;">	
		<label for="studentID" class="col-sm-3 control-label">*학생 ID</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" id="studentID" name="studentID" required placeholder="ID" maxlength="10">
		</div>
	</div>
	<div class="form-group" style="max-width: 640px;">
		<label for="password" class="col-sm-3 control-label">*비밀 번호</label>
		<div class="col-sm-9">
			<input type="password" class="form-control" id="password" name="password" required placeholder="Password" maxlength="20">
		</div>
	</div>
	<div class="form-group" style="max-width: 640px;">
		<label for="password" class="col-sm-3 control-label">*비밀 번호 확인</label>
		<div class="col-sm-9">
			<input type="password" class="form-control" id="passwordConfirm" required placeholder="Password Confirm" maxlength="20">
		</div>
	</div>
	<div class="form-group" style="max-width: 640px;">
		<div class="col-sm-offset-3 col-sm-9" id="lblError"> 암호를 확인하십시오. </div>
	</div>
	<div class="form-group" style="max-width: 640px;">
		<label for="name" class="col-sm-3 control-label">*학과</label>
		<div class="col-sm-9">
			<select class="form-control" name="department" id="department">
				<option value="0" selected>학과 선택</option>
				<option value="1">정보통신계열</option>
				<option value="2">전자전기공학</option>
				<option value="3">컴퓨터공학</option>
				<option value="4">반도체학과</option>
				<option value="5">소프트웨어학과</option>
			</select>
		</div>
	</div>
	<div class="form-group" style="max-width: 640px;">
		<label for="email" class="col-sm-3 control-label">이메일 주소</label>
		<div class="col-sm-9">
			<input type="email" class="form-control" id="email" name="email" placeholder="Email" maxlength="50">
		</div>
	</div>
	<div class="form-group" style="max-width: 640px;">
		<label for="cellphone" class="col-sm-3 control-label">전화 번호</label>
		<div class="col-sm-9">
			<input type="cellphone" class="form-control" id="cellphone" name="cellphone" placeholder="Cellphone" maxlength="20">
		</div>
	</div>
	<div class="form-group" style="max-width: 640px;">
		<div class="col-sm-offset-3 col-sm-9">
			<button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-plus"> 회원가입</span></button>
		</div>
	</div>
	</form>
</div>
</body>
</html>