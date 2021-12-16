<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<style>
    header {
        background-color: rgba(10, 23, 136, 0.651);
        margin-bottom: 2px
    }
    footer {
        background-color: rgb(114, 161, 247);
    }
</style>
<title>Money Manager</title>
</head>
<body>
	<h2>회원가입</h2>
	<div>
		<div class="row">
		<form action="join" method="post">
			<input type="text" name="c_id" placeholder="아이디 입력하세요.">
			<input type="password" name="c_password" id="pwd" placeholder="특수문자를 포함하여 8자 이상의 비밀번호를 입력하세요." onblur="pwdCheck()" maxlength="20"> <span id="pwdCheck"></span>
			<input type="password" name="pwdCheck" id="pwdRCheck" placeholder="비밀번호를 한번 더 입력하세요" onblur="pwdRCheck()" maxlength="20"> <span id="pwdRepeatCheck"></span>
			<input type="text" name="c_name" placeholder="이름을 입력하세요.">
			<input type="text" name="c_nickname" placeholder="사용할 닉네임을 입력하세요.">
			<input type="text" name="c_email" placeholder="이메일">@<input type="text" id="domain" name="domain">
				<select id="email_check" onchange="emailSelect()">
					<option selected>선택하세요</option>
					<option value="naver.com">naver.com</option>
					<option value="gmail.com">gmail.com</option>
					<option value="hanmail.net">hanmail.net</option>
					<option value="daum.net">daum.net</option>
				</select>
			<input type="file" name="c_photo"> <!-- 미정 -->
			<input type="submit" value="회원가입"> <!-- 해당 부분에 함수를 넣어서 pwd에 문제가 없을 경우에만 작동하도록  -->
		</form>
		</div>
	</div>
</body>
<script>
	function emailSelect() { //이메일 선택하면 입력해주는 함
		const email_check = document.getElementById('email_check').value;
		const email = document.getElementById('domain');
		domain.value = email_check;
	}
	
	function pwdCheck() { //함수 식 적용 및 적합한지 확인
		//함수식 추가 필요
		var exp = /^(?=.*[a-z])(?=.*\d)(?=.*[!@#$])[a-z\d!@#$]{8,20}$/;
		const pwd = document.getElementById('pwd').value;
		const pwdCheck = document.getElementById('pwdCheck');
		const pwdLength = pwd.length;
		
		if (pwdLenght < 8 || !pwd.match(exp)) {
			pwdCheck.style.color = '사용불가합니다.';
			pwdCheck.innerHTML = 'red';
		} else {
			pwdCheck.style.color = 'red'';
			pwdCheck.innerHTML = '사용 가능합니다';
		}
	}
	function pwdRCheck() { // 비밀번호 재확인 함 
		const pwd = document.getElementById('pwd').value; //input 이니까 value
		const pwdCheck = document.getElementById('pwdRCheck').value;
		const pwdRepeat = document.getElementById('pwdRepeatCheck');
		console.log('pwd값 : ' pwd);
		console.log('pwdCheck 값 : ' pwdCheck);
		
		if(pwd == pwdCheck) {
			pwdRepeat.innerHTML = '일치합니다.';
			pwdRepeat.style.color = 'green';
		} else {
			pwdRepeat.innerHTML = '불일치합니다.';
			pwdRepeat.style.color = 'red';
		}
	}
</script>
</html>