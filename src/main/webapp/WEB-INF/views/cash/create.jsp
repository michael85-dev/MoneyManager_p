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
	<form action="/cash/create" method="post" enctype="Multipart/form-data">
		<input type="hidden" name="c_number" value="${cDTO.c_number}">
		s_cash 현금명 <input type="text" name="s_cash">
		s_info 정보 <input type="text" name="s_info">
		s_memo 메모 <textarea name="s_memo" rows="5"></textarea>
		s_photo <input type="file" name="s_photo">
		s_tAsset 초기자금 <input type="text" name="s_tAsset">
		<input type="submit" value="생성">
	</form>
</section>
</body>
</html>