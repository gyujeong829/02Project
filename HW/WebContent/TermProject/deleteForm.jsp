<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "my.model.*, my.dao.*, java.sql.*, my.util.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>무제 문서</title>
<link href="second.css" rel="stylesheet" type="text/css" /><link href="https://fonts.googleapis.com/css?family=Mr+Dafoe|Sacramento|Tangerine" rel="stylesheet"><link href="https://fonts.googleapis.com/css?family=Yeon+Sung" rel="stylesheet"><link href="https://fonts.googleapis.com/css?family=Gothic+A1|Nanum+Gothic|Noto+Serif+KR|Song+Myung|Stylish|Sunflower:300|Yeon+Sung" rel="stylesheet">
<link href="third.css" rel="stylesheet" type="text/css" />
<link href="fourth.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="page_background">
  <div id="login_spot">
    <div id="login_form">
    	<a href="deleteForm.jsp"><img src="images/login_4.png" width="45" height="15"/></a>
    	<a href="memberUpdate.html"><img src="images/login_5.png" width="40" height="15" /></a>
    	<a href="#"><img src="images/login_3.png" width="49" height="21" /></a>
    </div>
  </div>
  <div id="main_name" style="font-family: 'Tangerine', cursive; font-family: 'Mr Dafoe', cursive; font-family: Sacramento, cursive; font-size: 90px; text-align: center;">Happiness</div>
  <div id="page_line"></div>
  <div id="page_menu" style="font-family: 'Yeon Sung', cursive;">
  	<ul style="list-style-type: none; font-family: 'Yeon Sung', cursive; font-size: 18px;">
	<li style="display:inline">다이어리</li>
	<li style="display:inline"> 노트/필기 메모지</li>
	<li style="display:inline">파우치/케이스</li>
	</ul>
<div id="gongbaeg"></div>
   <div class="container">
		<p class="title" style="font-family: 'Song Myung', serif;
font-family: 'Yeon Sung', cursive;
font-family: 'Sunflower', sans-serif;
font-family: 'Nanum Gothic', sans-serif;
font-family: 'Stylish', sans-serif;
font-family: 'Gothic A1', sans-serif;
font-family: 'Noto Serif KR', sans-serif;">회원 탈퇴</p>
		<div class="form-area">
			<!-- ID, PWD --> 
			<form action="delete.jsp" method="post">
			<table>
				<tr>
					<td>
					<span>
					<% String userId = (String)session.getAttribute("UI"); %>
							<input type="text" id="id" name="id" class="input-text" value=<%=userId%> maxlength="20" onfocusout="validateId()">
						</span>
						<div id="id_alert" class="alert">필수 정보입니다.</div>
</td>
				</tr>
				<tr>
					<td>
						<span>
							<input type="password" id="password" name="password" class="input-text" placeholder="비밀번호" maxlength="20" onfocusout="validatePassword()">
						</span>
						<div id="password_alert" class="alert">필수 정보입니다.</div>
					</td>
				</tr>
				<tr>
					<td>
						<span>
							<input type="password" id="check_password" class="input-text" placeholder="비밀번호 재확인" maxlength="20" onfocusout="validatePassword()">
						</span>
						<div id="check_password_alert" class="alert">필수 정보입니다.</div>
					</td>
				</tr>
			</table>
			
			<!-- BASIC INFO -->
			<form id="form" name="form" method="post" action="delete.jsp">
              <p>
           		<input type="submit" value="탈퇴" class="btn-type-01"/>
           		 <script type="text/javascript"/>
			</p>
			</form>	
	   
	</div>
          </form>
	 </div>
		
		
</div>
</body>

<script type="text/javascript">
	
	function validateId() {
		var id = document.getElementById('id').value.trim();
		var alertEl = document.getElementById('id_alert');
		
		// 입력 여부 검증
		if (id.length == 0) {
			alertEl.innerHTML = '필수 정보입니다.';
			alertEl.style.display = 'block';
			
			return false;
		}
		
		// 길이 검증
		if (id.length < 5) {
			alertEl.innerHTML = '아이디는 5글자 이상 입력해주세요.';
			alertEl.style.display = 'block';
			
			return false;
		}
		
		// 대소문자, 숫자 입력 검증, if다음은 특수문자를 위한 것 
		if (!/^[A-Za-z0-9]*$/.test(id)) {
			alertEl.innerHTML = '아이디는 영문 대문자,소문자, 숫자만 입력 가능합니다.';
			alertEl.style.display = 'block';
			
			return false;
		}
		
		alertEl.style.display = 'none';
	}
	
	function validatePassword() {
		var password = document.getElementById('password').value.trim();
		var cPassword = document.getElementById('check_password').value.trim();
		var alertEl = document.getElementById('password_alert');
		var cAlertEl = document.getElementById('check_password_alert');
		
		// 비밀번호 입력 여부 검증
		if (password.length == 0) {
			alertEl.innerHTML = '필수 정보입니다.';
			alertEl.style.display = 'block';
			
			return false;
		}
		
		// 비밀번호 길이 검증
		if (password.length < 5) {
			alertEl.innerHTML = '비밀번호는 5글자 이상 입력해주세요.';
			alertEl.style.display = 'block';
			
			return false;
		}
		
		// 비밀번호 대소문자, 숫자 입력 검증
		if (!/^[A-Za-z0-9]*$/.test(password)) {
			alertEl.innerHTML = '비밀번호는 영문 대문자,소문자, 숫자만 입력 가능합니다.';
			alertEl.style.display = 'block';
			
			return false;
		}
		
		// 비밀번호 확인 입력 여부 검증
		if (cPassword.length == 0) {
			cAlertEl.innerHTML = '필수 정보입니다.';
			cAlertEl.style.display = 'block';
			
			return false;
		}
		
		// 비밀번호 확인 길이 검증
		if (cPassword.length < 5) {
			cAlertEl.innerHTML = '비밀번호는 5글자 이상 입력해주세요.';
			cAlertEl.style.display = 'block';
			
			return false;
		}
		
		// 비밀번호 확인 대소문자, 숫자 입력 검증
		if (!/^[A-Za-z0-9]*$/.test(cPassword)) {
			cAlertEl.innerHTML = '비밀번호는 영문 대문자,소문자, 숫자만 입력 가능합니다.';
			cAlertEl.style.display = 'block';
			
			return false;
		}
		
		// 비밀번호, 비밀번호 확인 검증
		if (password != cPassword) {
			cAlertEl.innerHTML = '비밀번호가 일치하지 않습니다.';
			cAlertEl.style.display = 'block';
			
			return false;
		}
		
		alertEl.style.display = 'none';
		cAlertEl.style.display = 'none';
	}
	
	function validateName() {
		var name = document.getElementById('name').value.trim();
		var alertEl = document.getElementById('name_alert');
		
		// 입력 여부 검증
		if (name.length == 0) {
			alertEl.innerHTML = '필수 정보입니다.';
			alertEl.style.display = 'block';
			
			return false;
		}
		
		alertEl.style.display = 'none';
	}
	
	function validateBirth() {
		var birthYear = document.getElementById('birth_year').value.trim();
		var birthDay = document.getElementById('birth_day').value.trim();
		var alertEl = document.getElementById('birth_alert');
		
		if (birthYear.length == 0) {
			alertEl.innerHTML = '태어난 년도 4자리를 입력해주세요.';
			alertEl.style.display = 'block';
			
			return false;
		}
		
		if (birthDay.length == 0) {
			alertEl.innerHTML = '태어난 일자를 입력해주세요.';
			alertEl.style.display = 'block';
			
			return false;
		}
		
		if (!/^[0-9]*$/.test(birthYear)) {
			birth_alert.innerHTML = '태어난 년도는 숫자만 입력 가능합니다.';
			birth_alert.style.display = 'block';
			
			return false;
		}
		
		if (!/^[0-9]*$/.test(birthDay)) {
			birth_alert.innerHTML = '태어난 일자는 숫자만 입력 가능합니다.';
			birth_alert.style.display = 'block';
			
			return false;
		}
		
		alertEl.style.display = 'none';
	}
</script>
</html>
  </div>
</div>
</body>
</html>
