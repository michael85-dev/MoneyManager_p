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
cash 항목의 메모와 정보 등을 볼 수 있으며 수정도 가능하게 설정
	<form action="/cash/update" method="post" enctype="multiport/form-data">
		s_number <input type="hidden" name="s_number" value="${sDTO.s_number}" readonly>
		c_number <input type="hidden" name="c_number" value="${sDTO.c_number}" readonly>
		s_cash 계좌명 <input type="text" name="s_cash">
		s_info 특이사항 <input type="text" name="s_info">
		s_memo 메모 <input type="text" name="s_memo">
		s_pName 첨부 <input type="file" name="s_photo">
		s_tAsset 초기 금액 <input type="text" name="s_tAsset">
		<input type="submit" value="생성">
	</form>

</section>
</body>
</html>