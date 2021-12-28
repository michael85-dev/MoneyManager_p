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
상세 계좌 내역들. -> 이게모여서 accountInfo로 가고 그걸 account에서 선택시 보여줌.
<header>

</header>
<section>
<div class="text-end row">
	<a href="/accountcontents/createForm?ai_number=${ai_number}">내역 추가</a>
</div>
<div class="row">
	<div class="col-3">
		선택한 은앵
	</div>
	<div class="col-3">
		선택한계
	</div>
	<div class="col-6">
			
		ai 관련 정보들 선언이 필요 -> th
		ac 관련 정보들 썬언이 필요 -> td
		<table>
			<tr>
				<th>연결 계좌</th>
				<th>사용 내역</th>
				<th>출금 계좌</th>
				<th>금액</th>
				<th>증빙</th>
				<th>수정</th>
			</tr>
			<c:forEach items="acList" var="a">
				<tr> 진행 
					<td>${a.ac_number}</td>
					<td>${a.ac_use}</td> 사용계좌????? / useAcc랑 선택해야 하는데. 흠... List화를 시켜야 하나.
					<td>${a.ac_useAcc}</td>
					<td>${a.ac_pAsset}</td>
					<td>${a.ac_pName}</td>예를들어 입금, 출금 radio를 선택하게 하고 입금이냐 출금이냐를 구분하는 방식으로.. 
					<td>
						<a href="/accountcontents/update?ai_number=${acList.ai_number}">수정</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
	</div>
</div>
</section>

</body>
</html>