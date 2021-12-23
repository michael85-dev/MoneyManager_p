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
<h2>cardinfo create</h2>

<header>

</header>
<section>
	<form action="/cardinfo/create" method="post">
		d_cCompany <input type="hidden" name="d_number" value="${dDTO.d_number}" readonly>
		d_number <input type="hidden" name="d_cCompany" value="${dDTO.d_cCompany}" readonly>
		a_bank <input type="hidden" name="a_bank" value="${aDTO.a_bank}"> <!-- 선택할 수 있게 변경해야 할꺼 같은데.. --> 
		<select> 이걸로 bank를 선택하게 해서 해당 값을 집어 넣는거로 할까...............</select>
		di_name <input type="text" name="di_name">
		di_nName <input type="text" name="di_nName">
		di_info <input type="text" name="di_info">
		di_memo <textarea name="di_memo" rows="5"></textarea>
		di_pName <input type="text" name="di_photo">
		
		<select id="asset" onchange="asset()">
			<option disabled>선택</option>
			<c:forEach items="${aList}" var="a">

				<option value="a_bank">${a.a_bank}</option>
			</c:forEach>
		</select> 해당 값을 2개다 INput으로 해서 HIDDen으로 하고 VALue 값을 가지고... 이프문으로 통해서 id가 맞는 곳에 넣어주는 방식으로 하는 것도 괜찮을꺼 같다.
		di_tAsset 
		di_pAsset
		di_mAsset
		
	</form>

</section>
</body>
</html>