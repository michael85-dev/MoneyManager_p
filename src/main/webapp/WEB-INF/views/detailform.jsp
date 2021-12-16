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
	<form action="/client/detail" method="get">
		<input type="hidden" name="c_number" id="pw">
		비밀번호 확인 : <input type="password" name="c_password" placeholder="비밀번호 확인">
		<input type="button" value="비밀번호 확인" onClick="pwdCheck()">
	</form>
</section>
</body>
<script>
	function pwdCheck() {
		const pw = document.getElementById('pw').value;
		const pwDB = '${cDTO.c_password}';
		console.log('pw');
		console.log('pwDB');
		if (pw == pwDB) {
			update_form.submit();
		} else {
			alert('비밀번호가 다릅니다.');
		}
	}
</script>
</html>