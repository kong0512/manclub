<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div id="contents">
	<h1>동아리 생성</h1>
	<hr>
	<form class="form-horizonal" role="form" id="regiserClub" action="registerClub" method="post">
	<div class="form-group" style="max-width: 800px;">
		<label for="clubID" class="col-sm-2 control-label">ClubID</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="clubID" name="clubID" maxlength=10 placeholder="ClubID">
		</div>
	</div>
	<p>
	<div class="form-group" style="max-width: 800px;">	
		<label for="club_name" class="col-sm-2 control-label">동아리 이름</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="club_name" name="club_name" maxlength=20 placeholder="Club Name">
		</div>
	</div>
	<p>
	<div class="form-group" style="max-width: 800px;">
		<label for="club_information" class="col-sm-2 control-label">동아리 정보</label>
		<div class="col-sm-10">
			<textarea class="form-control" rows="10" id="club_information" name="club_information" maxlength=100 placeholder="Club Information" cols="50"></textarea>

		</div>
	</div>
	<p>
	<div class="form-group" style="max-width: 800px;">
		<label for="club_category" class="col-sm-2 control-label">동아리 카테고리</label>
		<div class="col-sm-10">
			<select class="form-control" name="club_category" id="club_category">
				<option value="0" selected>카테고리</option>
				<option value="1">ART</option>
				<option value="2">SPORTS</option>
				<option value="3">MUSIC</option>
				<option value="4">TRAVEL</option>
				<option value="5">SOCIAL</option>
				<option value="6">VOLUNTEER</option>
				<option value="7">STUDY</option>
			</select>
		</div>
	</div>
	<p>
	<div class="form-group" style="max-width: 800px;">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-plus"> 동아리생성</span></button>
		</div>
	</div>
	</form>
</div>


</body>
</html>
	