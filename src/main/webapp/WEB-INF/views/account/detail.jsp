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
	<div class="row">
		<div class="col-6">
		
		</div>
		<div class="col-6 text-end">
			<a href="">정보조회</a>
			<a href="">로그아웃</a>
		</div>
	</div>
	<div class="row">
	
	</div>
</header>
<section>
	<div>
		은행 정보
	</div>
	<div>
		<form action="/account/update" method="post" enctype="Multipart/form-data">
			<input type="hidden" name="a_number" value="${aDTO.a_number}" readonly>
			<input type="hidden" name="c_number" value="${aDTO.c_number}" readonly>
			은행명 : <input type="text" name="a_bank" value="${aDTO.a_bank}">
			은행 정보 : <input type="text" name="a_info" value="${aDTO.a_info}">
			메모 : <textarea name="a_memo" rows="5"></textarea>
			사진 : <input type="file" name="a_photo">
			<button class="" onclick="location.href='./account/update?a_number=${aDTO.a_number}'">수정</button>
			<button class="" onclick="location.href='./account/findAll'">확인</button>
			
		</form>
		
		
	</div>
	
	
</section>

</body>
</html>