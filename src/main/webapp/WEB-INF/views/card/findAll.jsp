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
<div class="row text-end">
<a href="/card/createform?c_number=${d.c_number}">카드 추가</a>
</div>
<div class="row"></div>

<div class="row">

<div class="col-3">
<div class="row">
	<table>
		<tr>
			<th>카드사</th>
			<th>연결 은행</th>
			<th>결제일</th>
			<th>사용 총액</th>
			<th>카드항목보기</th>
		</tr>
		<c:forEach items="${dList}" var="d">
			<tr>
				<td>${d.cCompany}</td>
				<td>${d.a_bank}</td>
				<td>${d.d_day}</td>
				<td>${d.d_tAsset}</td>
				<td>
					<a href="/cardinfo/findAll?d_number=${d.d_number}">보기</a>
				</td>
			</tr>
		</c:forEach>	
	</table>
</div>
</div>
<div class="col-9">
	<div class="row text-end">
		<a href="cardinfo/craeteform?d_number${ciList.d_number}">내역 추가</a>
	</div>
	<table>
		<tr>
			<th>카드명</th>
			<th>카드별명</th>
			<th>카드정보</th>
			<th>사용액</th>
			<th>내역보기</th>
		</tr>
		<c:forEach items="${ciList}" var="ci">
			<tr>
				<td>${ci.di_name}</td>
				<td>${ci.di_nName}</td>
				<td>
					<a href="cardinfo/memo?d_number=${ci.d_number}&di_memo=${ci.di_memo}">보기</a>
				</td>
				<td>${ci.di_tAsset}</td>
				<td>
					<a href="cardcontents/findAll?di_number=${di_number}">조회</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<c:choose>
			<c:when test="${pDTO.page <= 1 }">
				[이전]&nbsp;;
			</c:when>
			<c:otherwise>
				<a href="/cardcontents/paging?page=${pDTO.page - 1}">[이전]</a>&nbps;
			</c:otherwise>	
		</c:choose>
		<c:forEach begin="${pDTO.startPage }" end="${pDTO.endPage }" var="i" step="1">
			<c:choose>
				<c:when test="${i eq pdDTO.page }">
					${i }
				</c:when>
				<c:otherwise>
					<a href="/cardcontents/paging?page=${i }">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:choose>
			<c:when test="${pDTO.page >= pDTO.maxPage}">
				[다음]
			</c:when>
			<c:otherwise>
				<a href="/cardcontents/paging?page=${pDTO.page+1 }">[다음]</a>
			</c:otherwise>
		</c:choose>
	</div>
</div>
</div>
</section>
</body>
</html>