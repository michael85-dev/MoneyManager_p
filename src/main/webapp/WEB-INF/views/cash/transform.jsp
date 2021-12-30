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
선택할 수 있게 만들고 그 선택에 따라 하단에 해당 항목을 불러 오기
1. 계좌 & 계좌
2. 현금 & 계좌
3. 카드 & 계좌 (?)
<div class="text-end">
	<a href="/atransferform?c_number=${aList.c_number}">계좌에서 계좌로</a>
	<a href="/stransferform?c_number=${sList.c_number}">현금에서 계좌로<a>
	<a href="/dtransferform?c_number=${dList.c_number}">카드 선결제</a>
</div>
<div>
	<c:choose>
		<c:when test="">
			<form>
				<select id="atos1">
					<c:forEach items="${a4}" var="4">
						<option value="${4.ai_name}">${4.ai_name}</option>
					</c:forEach>
				</select>
				<input type="text" id="send">
				<input type="text" name="ai_pAsset">
			</form>
			
			<form>
				<select id="stoa1">
					<c:forEach items="${s1}" var="1">
						<option value="${1.si_name}">${1.si_name}</option>
					</c:forEach>
				</select>
				<input type="text" id="send">
				<input type="text" name="si_pAsset">
			</form>
		</c:when>
		<c:otherwise>
			<form>
				<select id="stoa2">
					<c:forEach items="${s1}" var="1">
						<option value="${1.si_name}">${1.si_name}</option>
					</c:forEach>
				</select>
				<input type="text" id="send">
				<input type="text" name="si_pAsset">
			</form>
			
			<form>
				<select id="atos2">
					<c:forEach items="${a4}" var="4">
						<option value="${4.ai_name}">${4.ai_name}</option>
					</c:forEach>
				</select>
				<input type="text" id="send">
				<input type="text" name="ai_pAsset">
			</form>
		</c:otherwise>
	</c:choose>
</div>
</section>
</body>
</html>