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
	<form action="/cardinfo/update?d_number=${ciDTO.d_number}" method="post" enctype="Multiport/form-data">
		di_number <input type="hidden" name="di_number" value="${ciDTO.di_number}" readonly>
	    d_cCompany <input type="text" name="d_cCompany" value="${ciDTO.d_cCompany}">
	    d_number <input type="hidden" name="d_number" value="${ciDTO.d_number}" readonly>
	    
	    di_name <input type="text" name="di_name" value="${ciDTO.di_name}"> <!-- 카드 이름? -->
	    di_memo <textarea rows="5" name="di_memo"></textarea>
	    di_pName <input type="file" name="di_photo">
	    di_tAsset <input type="text" name="di_tAsset" value="${ciDTO.di_tAsset}">
   		<input type="submit" value="수정">
		<button id="back" onclick="back()">돌아가기</button>
	</form>
</section>
</body>
</html>