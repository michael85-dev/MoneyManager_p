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
cardcontents.detail (선택한 결제 사항의 상세내역 확인)

	<form action="/cardcontents/update?dc_number=${dcDTO.dc_number}" method="post" enctype="Multipart/form-data">
		dc_number <input type="hidden" name="dc_number" value="${dcDTO.dc_number}" readonly>
		di_number <input type="hidden" name="di_number" value="${dcDTO.di_number}" readonly>
		di_name  <input type="text" name="di_name" value="${dcDTO.di_name}" readonly>
		dc_name <input type="text" name="dc_name" value="${dcDTO.dc_name}">
		dc_pAsset <input type="text" name="dc_pAsset" value="${dcDTO.dc_pAsset}">
		dc_info <input type="text" name="dc_info" value="${dcDTO.dc_info}">
		dc_memo <textarea name="dc_memo" rows="5"></textarea>
		<input type="submit" value="수정">
		<button id="back" onclick="back()">돌아가기</button>
	</form>

</body>
</html>