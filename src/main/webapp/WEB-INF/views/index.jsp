<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <!-- ref와 rel의 차이도 있음 조심해야함 -->
    <link rel="stylesheet" href="./css/bootstrap.css">
    <link rel="stylesheet" href="./css/toggle.css">
    <script src="./css/bootstrap.js"></script><!-- 어떻게 해야 제대로 링크로 적용이 가능할지 고안 필 -->
    
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
		<div class="col">
			<h2>메인페이지(index.jsp)</h2>
		</div>
		<div class="col text-end">
			<c:if test="${sessionScope.cNum eq '1'}">
				<button class="btn btn-outline-primary" onclick="location.href='./client/findAll'">회원목록조회</button>
			</c:if>
			<button class="btn btn-outline-primary" onclick="location.href='./joinform'">회원가입</button>
			<button class="btn btn-outline-primary" onclick="location.href='./loginform'">로그인</button>
		</div>
	</div>
<!-- 	
	<a href="/client/joinform">회원가입</a> 회원 가입 요청을 위한 페이지를 호출하는 메서
	<a href="/showlist">전체 목록 보기</a>
	<a href="/client/login">로그인</a>
 --><!-- semantic tag : 구분용 태그 -->
    <!-- 메뉴영역 -->
    <header>
 
    </header>
    <section>
    
    </section>
</body>
</html>