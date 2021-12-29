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
<div class="row">
	<div class="col-2">
		아이콘
	</div>
	<div class="col-10 text-end">
		${sessionScope.cNum eq a.c_number}
		<a href="/client/detail?c_number=${a.c_number}">조회</a>
	</div>
</div>
<header>

</header>
<section>
<div class="row">
	<div>
	</div>
	<div class="text-end">
		 <button class="btn btn-primary" onclick="location.href='./account/createform'">계좌 생성</button>
	</div>
</div>
<div class="row"> <!-- list 생성 -->

	<div class="col-3">
		<div class="row">
		</div>
		계좌 목록
		<div>
			<table>
				<tr>
					<th>은행</th>
					<th>총 잔액</th>
					<th>상세</th>
				</tr>
				<tr>
					<c:forEach items="${aList}" var="a">
						<td>
							<a href="/account/detail?a_number=${a.a_number}">${a.a_bank}</a>
						</td> <!-- 은행에 등록된 계좌들 전부 불러오게 링크 넣기 -->
						<td>${a.a_tAsset}</td>
						<td>
							<a href="/account/detail?a_number=${a.a_number}">상세</a>
						</td>
					</c:forEach>
				</tr>
			</table>
		</div>
	</div>
	<div class="col-9">
		<<div class="row text-end">
			<a href="/accountInfo/createform?a_number=${a.a_number}">내역 추가</a> <!-- 이렇게 하면은 과연 선택한 은행 정보가 그대로 들어오나? -->
		</div>
		계좌 항목들
		<div>
			<table>
				<tr>
					<th>계좌명</th>
					<th>계좌별창</th>
					<th>잔액</th>
					<th>내역보기</th>
					<th>정보 보기</th>
				</tr>
				<tr>
					<c:forEach items="${aiList}" var="ai">
						<td>${a.ai_name}</td>
						<td>${a.ai_nName}</td>
						<td>${a.ai_tAsset}</td>
						<td>
							<a href="/accountinfo/findAll?a_number=${a.a_number}">보기</a>
						</td>
						<td>
							<a href="/accountinfo/detail?ai_number=${a.ai_number}">보기</a>
						</td>				
					</c:forEach>
				</tr>
			</table>
		</div>
	</div>
</div>
</section>

</body>
</html>