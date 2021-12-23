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
cash는 현금성
cashinfo는 현금성의 상세 내역들로 구성

	<div class="row text-end">
		<a href="/cash/createform?c_number=${sList.c_number}">현금계좌 생성</a>
	</div>
	<div class="row text-end">
		<a href="/cashinfo/createform?s_number=${sList.s_number}">내역 생성</a>
	</div>
	<div class="row">
		<div class="col-3">
			<table>
				<tr>
					<th>현금명</th>
					<th>정보</th>
					<th>현 잔액</th>
					<th>내역보기</th>
					<th>속성확인</th>
					<th>삭제</th>
				</tr>
				<c:forEach items="${sList}" var="s">
					<tr>
						<td>${s.s_cash}</td>
						<td>${s.s_info}</td>
						<td>${s.s_tAsset}</td>
						<td>
							<a href="/cashinfo/findAll?s_number=${s.s_number}">내역보기</a>
						</td>
						<td>
							<a href="/cash/detail?s_number=${s.s_number}">보기</a>
						</td>
						<td>
							<a href="/cash/delete?s_number=${s.s_number}">삭제</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="col-9">
			<table>
				<tr>
					<th>현금 계좌명</th>
					<th>호칭</th>
					<th>수입액</th>
					<th>지출액</th>
					<th>상세보기</th>
				</tr>
				<c:forEach items="${siList}" var="si">
					<tr>
						<td>${si.si_name}</td>
						<td>${si.si_nName}</td>
						<td>${si.si_pAsset}</td>
						<td>${si.si_mAsset}</td>
						<td>
							<a href="/cashinfo?detail?si_number=${si.si_number}">보기</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</section>
</body>
</html>