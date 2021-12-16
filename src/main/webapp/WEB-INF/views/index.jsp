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
			<button class="btn btn-outline-primary" onclick="location.href='./client/findAll'">정보 조</button>
		</div>
	</div>
<!-- 	
	<a href="/client/joinform">회원가입</a> 회원 가입 요청을 위한 페이지를 호출하는 메서
	<a href="/showlist">전체 목록 보기</a>
	<a href="/client/login">로그인</a>
 --><!-- semantic tag : 구분용 태그 -->
    <!-- 메뉴영역 -->
    <header>
        <!-- py-3: 패딩을 y축으로 위아래 3px씩 -->
        <div class="container d-flex align-items-center py-3">
            <!-- data-bs-toggle="offcanvas" : 메뉴가 스르륵 나타나는 소석을 이야기 함 -->
            <!-- data-bs-target="#offcanvas" : offcanvas에서 보여줄 내용(id가 offcanvas로 지정된 요소를 보여주겠다.) -->
            <button class="btn" data-bs-toggle="offcanvas" data-bs-target="#offcanvas">
                <!-- svg : 벡터 그래픽 이미지 . 안깨지는게 장점 -->
                <!-- 햄버거 모양 이미지 -->
                <img src="../../images/menu.svg" alt="Er">
            </button>
            <!-- 옆에 추가창에 대한 내용 추가 -->
            <div class="offcanvas offcanvas-start" id="offcanvas">
                <div class="offcanvas-header">
                    <button class="btn-close" data-bs-dismiss="offcanvas">
                        <!-- 버튼 닫기 누르면 offcanvas를 닫는다 라는 의미 -->
                    </button>
                </div>
                <div class="offcanvas-body">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item" onclick="location.href='./account/create'">계좌 생성(Account create)</li>
                        <!-- <div>
                            <ul>
                                <li>나</li>
                                <a onclick="clickcr(this,'ctw.catlist','','',event);" id="category14" href="/PostList.naver?blogId=iskaid&amp;from=postList&amp;categoryNo=14&amp;parentCategoryNo=14 " class="itemfont cm-col1 _selectCurrentCategory _param(1000013777|13317|widget_category|14) on">취미</a>
                                <li>너</li>
                            </ul>
                        </div> -->
                        <!-- 원래 -->
                        <li class="list-group-item" onclick="location.href='./card/create'">카드 생성(Card create)</li>
                        <!-- 연습 -->
                        <!-- <li class="list-group-item">
                            <a onclick="skills()" id="skills-toggle" href="./Skills.html">Skills</a>
                        </li> -->
                        <li class="list-group-item toggle" onclick="location.href='./account/findAll'">가계부 등록(Money Manager)</li>
                        <!-- <button id="btn" src> -->
                        <li class="list-group-item" onclick="location.href='./contacts.html'">Contract</li>
                        <li class="list-group-item" onclick="location.href='./contacts.html'">Contract</li>
                        <li class="list-group-item" onclick="location.href='./contacts.html'">Contract</li>
                        <li class="list-group-item" onclick="location.href='./contacts.html'">Contract</li>
                    </ul>
                    <input type="text" class="form-control mb-2" placeholder="Search"> <!-- 내역 조회? -->
                    <!-- d-grid : 한줄에 채워서 표시 가능 -->
                    <div class="d-grid mb-2">
                        <button class="btn btn-outline-primary" onclick="location.href='./client/joinform'">Sign in</button>
                    </div>
                    <div class="d-grid">
                        <button class="btn btn-primary" onclick="location.href='./client/login'">Sign up</button>
                    </div>
                </div>
            </div>
            <!-- css에서 주어진 class 설정 -->
            <!-- 4개 메뉴에 대한 항목 -->
            <ul class="nav flex-grow-1">
                <li class="nav-item">
                    <a href="#" class="nav-link text-light" onclick="location.href='./account/create'">계좌 생성(Account create)</a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link text-light" onclick="location.href='./card/create'">카드 생성(Card create)</a>
                </li>
                <li class="nav-item">
                    <!-- 해당 페이지 내에서 특정 영역으로 이동할 때 
                    href 속성값에 id 값을 주면 해당링크가 제일 위에 존재함-->
                    <!-- ex: href="#projects -> section에 id=projects 명명되어있기에 적용 됨" -->
                    <!-- 토글을 위해 잠시 소거 -->
                    <a href="#" class="nav-link text-light" onclick="location.href='./projects.html'">Projects</a>
                    <!-- 토글 테스트 -->
                    <!-- <a href="#" class="nav-link text-light">
                        <label for="toggle_button" class="toggle_button">Projects</label>
                        <input type="checkbox" id="toggle_button">
                        <div id="toggle_contents">
                            11
                            <label for="toggle_button" class="close_button">X</label>
                        </div>

                    </a> -->
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link text-light" onclick="location.href='./contacts.html'">Contacts</a>
                </li>
                <li class="nav-item">
                	<a href="#" class="nav-link text-light" onclick="location.href='./????????'">?????</a> 
                </li>
                <li class="nav-item">
                	<a href="#" class="nav-link text-light" onclick="location.href='./????????'">?????</a> 
                </li>
                <li class="nav-item">
                	<a href="#" class="nav-link text-light" onclick="location.href='./????????'">?????</a> 
                </li>
                <li class="nav-item">
                	<a href="#" class="nav-link text-light" onclick="location.href='./????????'">?????</a> 
                </li>
            </ul>
            <!-- d-flex : 일자로 표현되게 해줌 -->
            <!-- 입력 및 가입 로그인 항목 -->
            <div class="d-flex">
                <input type="text" class="form-control" placeholder="Search">
                <button class="btn btn-link text-light text-decoration-none flex-shrink-0" onclick="location.href='./client/joinform'">Sign in</button>
                <!-- flex-shrink-0 : 아웃라인 찌그러지지않게 자동으로 맞춰주는 것.? -->
                <button class="btn btn-outline-light flex-shrink-0" onclick="location.href='./client/login'">Sign up</button>
            </div>

        </div>
        <div>

        </div>
    </header>
    
    <section>
    
    </section>
</body>
</html>