<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<form action="/account/create" method="post">
		<!-- 고객 정보를 어떻게 가져와야하는가? 페이지화? --> <input type="hidden" name="c_number" value="${cDTO.c_number}">
		은행명 :  <input type="text" name="a_bank" id="bank" onblur="bCheck()"><span id="bCheck"></span>
		은행정보 : <input type="text" name="a_info">
		메모 : <textarea name="a_memo" rows="5"></textarea>
		초기금액 : <input type="text" name="a_tAsset">
		사진 : <input type="file" name="a_photo">
		<input type="submit" value="저장">
	</form>
</section>
</body>
<script>
	function bCheck() {
		const bank = document.getElementById('bank').value;
		const bLength = bank.length;
		if (bLength == 0) {
			bCheck.style.color = 'red';
			bCheck.innerHTML = '1자 이상 입력하세요.';
		} else {
			bCheck.style.color = 'green';
			bCheck.innerHTML = '사용가능합니다.';
		}
	}
</script>
</html>