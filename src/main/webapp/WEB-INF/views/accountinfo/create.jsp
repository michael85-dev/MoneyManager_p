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
<div class="row text-end">
	${sessionScope.logId} <!-- 이렇게 로그인 아이디로 표시해야하는가? -->
</div>
<header>
	
</header>
<section>
	<form action="/accountInfo/create" method="post" enctype="Multipart/form-data">
		<input type="hidden" name="a_number" value="${a_number}">
		<input type="hidden" name="a_bank" value="${a_bank}">
		내역 : <input type="text" name="ai_name">
		<input type="text" name="ai_nName">
		정보 : <input type="text" name="ai_info">
		
		이율 : <input type="text" name="ai_iRate">

		<!-- 수입이냐수출이냐에 따라 타입이 선ㄴ택되게 해야할 것 같은데. 어떻게 해야하려나. -->
		초기자금 : <input type="text" name="ai_tAsset">
<!-- 		<select>
			<option selected>
			</option>
		</select><input type="text"> -->
		
<!-- 		<input type="text" name="ai_tAsset">
		<input type="text" name="ai_pAsset">
		<input type="text" name="ai_mAsset"> -->
		
		메모 : <textarea name="ai_memo" rows="5"></textarea>
		사진 : <input type="file" name="ai_pName">
		
	</form>
</section>
</body>
</html>