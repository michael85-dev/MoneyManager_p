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
<title>MoneyManager</title>
</head>
<body>
<header>

</header>
<section>
	<%-- <table class="table table-dark">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>닉네임</th>
			<th>이메일</th>
			<th>사진</th>
		</tr>
		<tr>
			<td>${cDTO.c_id}</td>
			<td>${cDTO.c_name}</td>
		</tr>
	</table> --%>
	<div class="row">
		개인 정보
	</div>
	<div class="row text-end">
		<form action="/client/updateform" method="get">
			<input type="hidden" name="c_number" value="${cDTO.c_number}">
			<input type="button" value="수정" onclick="update()">
		</form>
	</div>
	<div>
		<c:choose>
			<c:when test="${sessionScope.loginId eq ??}">
				<input type="text" name="c_number" value="${cDTO.c_number}" readonly>
			</c:when>
			<c:otherwise>
				<input type="hidden" name="c_number" value="${cDTO.c_number}" readonly>
			</c:otherwise>
		</c:choose>
		아이디 : <input type="text" name="c_id" value="${cDTO.c_id}" readonly>
		비밀번호 : <input type="password" name="c_password" id="pw" readonly>
		이름 : <input type="text" name="c_name" readonly>
		닉네임 : <input type="text" name="c_nickname" readonly>
		이메일 : <input type="text" name="c_email" value="${cDTO.c_email}"><!-- @<input type="text" id="domain"><select id="email_check" onchange="emailSelect()">
				<option selected>선택하세요</option>
				<option value="naver.com">naver.com</option>
				<option value="gmail.com">gmail.com</option>
				<option value="hanmail.net">hanmail.net</option>
				<option value="daum.net">daum.net</option>
			</select> -->
		사진(이모티콘?) : <input type="file"> 
		<div class="text-middle">
			<button onclick="findAll()">목록으</button>
		</div>
	</div>
</section>
</body>
<script>
	function emailSelect() { //이메일 선택하면 입력해주는 함
		const email_check = document.getElementById('email_check').value;
		const email = document.getElementById('domain');
		domain.value = email_check;
	}
	
	function update() {
		form_update.submit();/* ?? */	
	}
	
	function findAll() {
		
	}
</script>
</html>