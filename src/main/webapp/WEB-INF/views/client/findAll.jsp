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
<title>MoneyManager</title>
</head>
<body>
<header>

</header>
<section>
	<div class="row">
		<table class="talle table-dark"> <!-- 항목은 다 보여주고 항목을 선택하면 해당 값에 대해서 보ㅗ여 -->
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>닉네임</th>
				<th>이메일</th>
				<th>사진</th>
				<th>상세조회</th>
				<th>삭제</th>
			</tr>
			<c:forEach items="${cList}" var="c">
				<tr>
					<td>${cList.c_id}</td>
					<td>--</td>
					<td>${cList.c_name}</td>
					<td>${cList.c_nickname}</td>
					<td>${cList.c_email}</td>
					<td>${cList.c_photoname}</td>
					<td>
						<a href="/client/detail?c_number=${c.c_number}">상세조회</a>
					</td>
					<td>
						<a href="/client/delete">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		<c:choose>
			<c:when test="${pDTO.page <= 1 }">
				[이전]&nbsp;;
			</c:when>
			<c:otherwise>
				<a href="/client/paging?page=${pDTO.page - 1}">이전]]</a>&nbps;
			</c:otherwise>	
		</c:choose>
		
		<c:forEach begin="${pDTO.startPage }" end="${pDTO.endPage }" var="i" step="1">
			<c:choose>
				<c:when test="${i eq pDTO.page }">
					${i }
				</c:when>
				<c:otherwise>
					<a href="/client/paging?page=${i }">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:choose>
			<c:when test="${pDTO.page >= pDTO.maxPage}">
				[다음]
			</c:when>
			<c:otherwise>
				<a href="/client/paging?page=${pDTO.page+1 }">[다음]</a>
			</c:otherwise>
		</c:choose>
	</div>
	
</section>
</body>
</html>