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
<header>

</header>
<section>
	<form action="/client/update" method="post" enctype="Multipart/form-data">
		<input type="hidden" name="c_number" value="${cDTO.c_number}" readonly>
		아이디 : <input type="text" name="c_id" value="${cDTO.c_id}" readonly>
		비밀번호 : <input type="password" name="c_password" id="pw">
		이름 : <input type="text" name="c_name" value="${cDTO.c_name}" readonly>
		닉네임 : <input type="text" name="c_nickname" value="${cDTO.c_nickname}">
		이메일 : <input type="text" name="c_email" value="${cDTO.c_email}">@<input type="text" id="domain" name="domain">
			<select id="email_check" onchange="emailSelect()">
				<option selected>선택하세요</option>
				<option value="naver.com">naver.com</option>
				<option value="gmail.com">gmail.com</option>
				<option value="hanmail.net">hanmail.net</option>
				<option value="daum.net">daum.net</option>
			</select><!-- 이렇게 하면 메일 앞에만 들어가는거 아닌가? -->
		사진 : <input type="file">
		<input type="button" value="수정" onclick="update()">
	</form>
</section>

</body>
<script>
	function emailSelect() {
		const email = document.getElementById('domain');
		const emailCheck = document.getElementById('email_check').value;
		domain.value = emailCheck;
		
		function update() {
			const pw = document.getElementById('pw');
			const pwDB = '${cDTO.c_password}';
			if (pw == pwDB) {
				update_form.submit();
			} else {
				alert('비밀번호가 틀립니다.');
			}
		}
	}
</script>
</html>