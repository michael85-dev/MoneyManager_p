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
<h2>cardcontents create</h2>

<header>

</header>
<section>
	<form action="/cardcontents/create?di_number=${diDTO.di_number}" method="post" enctype="Multipart/form-data">
		해당 항목에 대해서 어떻게 분류를 할 것이니지에 대해서 추가로 생각해야 할 것으로 보
		
		di_number <input type="hidden" name="di_number" value="${diDTO.di_number}" readonly>
		di_named <input type="text" name="di_name" value="${diDTO.di_name}" readonly> <!-- 카드 이름 가지고 오기 --> 
		<select> 이걸로 bank를 선택하게 해서 해당 값을 집어 넣는거로 할까...............</select>

		dc_name <input type="text" name="dc_name">
		dc_memo <textarea name="dc_memo" rows="5"></textarea>
		dc_photo <input type="text" name="dc_photo">
		
<%-- 		<select id="card" onchange="card()">
			<option disabled>선택</option>
			<c:forEach items="${diDTO}" var="di">

				<option value="a_bank">${di.d_card}</option>
			</c:forEach>
		</select> 해당 값을 2개다 INput으로 해서 HIDDen으로 하고 VALue 값을 가지고... 이프문으로 통해서 id가 맞는 곳에 넣어주는 방식으로 하는 것도 괜찮을꺼 같다.
 --%>	
 		dc_tAsset 

		<select id="aCheck" onchange="asset()">
			<option disabled>선택</option>
			<option value="+">수입</option>
			<option value="-">지출</option>
		</select>
		dc_pAsset <input type="text" name="dc_pAsset" id="asset">		
	</form>

</section>
</body>
<script>
	function asset() {
		const asset = document.getElementById('asset').value; // input의 pAsset의 값을 가지고 옴.
		const check = document.getElementById('aCheck').value;
		
		if (check < 0) {
			asset = -1 * asset;
		} else {
			asset = 1 * asset;
		}
	}
</script>
</html>