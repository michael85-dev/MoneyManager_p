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
	<div class="row">
		<a href="/cardcontents/createform=${dcDTO.di_number}">내역 추가</a>
	</div>
	<table>
		<tr>
			<th>카드 명</th>
			<th>내역</th>
			<th>금액</th>
			<th>메모</th>
			<th>보기</th>
		</tr>
		<c:forEach items="${dcDTO}" var="d">
			<tr>
				<td>${d.d_card}</td>
				<td>${d.dc_name}</td>
				<td>${d.dc_pAsset}</td>
				<td>${d.dc_memo}</td>
				<td>
					<a href="/cardcontents/detail?dc_number=${dc_number}">보기</a>
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
</section>
</body>
</html>