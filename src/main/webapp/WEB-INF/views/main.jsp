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
<div class="row">
	<div class="col-3">
	</div>
	<div class="col text-end">
		<c:if test="${sessionScope.cNum eq '1'}">
			<button class="btn btn-outline-primary" onclick="location.href='./client/findAll'">회원목록조회</button><!-- 관리자 -->
		</c:if>
		<button class="btn btn-outline-primary" onclick="location.href='./detailform'">개인정보조회</button>
		<button class="btn btn-outline-primary" onclick="location.href='./client/logout'">로그아웃</button>
	</div>
</div>
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
	 	            <li class="list-group-item" onclick="location.href='./findAll'">전체보기(Money Manager)</li>
	                <li class="list-group-item" onclick="location.href='./account/findAll?c_number=${cList.c_number}'">계좌 생성(Account create)</li>
	                <!-- <div>
	                    <ul>
	                        <li>나</li>
	                        <a onclick="clickcr(this,'ctw.catlist','','',event);" id="category14" href="/PostList.naver?blogId=iskaid&amp;from=postList&amp;categoryNo=14&amp;parentCategoryNo=14 " class="itemfont cm-col1 _selectCurrentCategory _param(1000013777|13317|widget_category|14) on">취미</a>
	                        <li>너</li>
	                    </ul>
	                </div> -->
	                <!-- 원래 -->
	                <li class="list-group-item" onclick="location.href='./card/findAll?c_number=${cList.c_number}'">카드 생성(Card create)</li>
	                <!-- 연습 -->
	                <!-- <li class="list-group-item">
	                    <a onclick="skills()" id="skills-toggle" href="./Skills.html">Skills</a>
	                </li> -->
	                <li class="list-group-item" onclick="location.href='./cash/findAll?c_number=${cList.c_number}'">현금 생성(Money Manager)</li>
	                <!-- <button id="btn" src> -->
	                <li class="list-group-item" onclick="location.href='./transform?c_number=${cList.c_number}'">이체하기</li>
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
	        	<a href="#" class="nav-link text-light" onclick="location.href='./transform?c_number=${cList.c_number}'">이체하기</a> 
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
	<div class="row">
		<div class="col-6">
			차트 (원형)
		</div>
		<div class="col-6">
			차트 (막대그래프)
		</div>
	</div>
	<div class="row">
		<div class="col-6">
			<div class="container d-flex align-items-center py-3">
				계인정보
				<table>
					<tr>
						<th>이름</th>
						<th>닉네임</th>
						<th>이메일</th>
						<th>수정</th>
					</tr>
					<tr>
						<td>${cList.c_name}</td>
						<td>${cList.c_nickname}</td>
						<td>${cList.c_email}</td>
						<td>
							<a href="/client/update=${cList.c_number}">수정</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="col-6">
			<div class="container d-flex align-items-center py-3">
				현금 관련 정보
				<table>
					<tr>
						<th>현금계좌</th>
						<th>잔액</th>
						<th>상세</th>
						<th>삭제</th>
					</tr>
					<c:forEach items="sList" var="s">
						<tr>
							<td>${s.s_cash}</td>
							<td>${s.s_tAsset}</td>
							<td>
								<a href="/cash/detail?c_number=${s.c_number}">보기</a>
							</td>
							<td>
								<a href="cash/delete?c_number =${s.c_number}">삭제</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div>
					<c:choose>
						<c:when test="${psDTO.page <= 1 }">
							[이전]&nbsp;;
						</c:when>
						<c:otherwise>
							<a href="/cash/paging?page=${psDTO.page - 1}&c_number=${cDTO.c_number}">[이전]</a>&nbps;
						</c:otherwise>	
					</c:choose>
					
					<c:forEach begin="${psDTO.startPage }" end="${psDTO.endPage }" var="i" step="1">
						<c:choose>
							<c:when test="${i eq psDTO.page }">
								${i }
							</c:when>
							<c:otherwise>
								<a href="/cash/paging?page=${i }&c_number=${cDTO.c_number}">${i }</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					
					<c:choose>
						<c:when test="${psDTO.page >= psDTO.maxPage}">
							[다음]
						</c:when>
						<c:otherwise>
							<a href="/cash/paging?page=${psDTO.page+1 }&c_number=${cDTO.c_number}">[다음]</a>
						</c:otherwise>
					</c:choose>
				</div>
				
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-6">
			<div class="container d-flex align-items-center py-3">
				계좌 관련 정보
				<table>
					<tr>
						<th>계좌정보</th>
						<th>총 잔액</th>
						<th>상세</th>
						<th>삭제</th>
					</tr>
					<c:forEach items="aList" var="a">
						<tr>
							<td>${a.a_bank}</td>
							<td>${a.a_tAsset}</td>
							<td>
								<a href="/account/detail?c_number=${a.c_number}">보기</a>
							</td>
							<td>
								<a href="/account/delete?c_number=${a.c_number}">삭제</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div>
					<c:choose>
						<c:when test="${paDTO.page <= 1 }">
							[이전]&nbsp;;
						</c:when>
						<c:otherwise>
							<a href="/account/paging?page=${paDTO.page - 1}&c_number=${cDTO.c_number}">[이전]</a>&nbps;
						</c:otherwise>	
					</c:choose>
					
					<c:forEach begin="${paDTO.startPage }" end="${paDTO.endPage }" var="i" step="1">
						<c:choose>
							<c:when test="${i eq paDTO.page }">
								${i }
							</c:when>
							<c:otherwise>
								<a href="/account/paging?page=${i }&c_number=${cDTO.c_number}">${i }</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					
					<c:choose>
						<c:when test="${paDTO.page >= paDTO.maxPage}">
							[다음]
						</c:when>
						<c:otherwise>
							<a href="/account/paging?page=${paDTO.page+1 }&c_number=${cDTO.c_number}">[다음]</a>
						</c:otherwise>
					</c:choose>
				</div>
				
			</div>
		</div>
		<div class="col-6">
			<div class="container d-flex align-items-center py-3">
				카드 관련 정보
				<table>
					<tr></tr>
					<c:forEach items="dList" var="d">
						<tr></tr>
					</c:forEach>
				</table>
				<div>
					<c:choose>
						<c:when test="${pdDTO.page <= 1 }">
							[이전]&nbsp;;
						</c:when>
						<c:otherwise>
							<a href="/card/paging?page=${pdDTO.page - 1}&c_number=${cDTO.c_number}">[이전]</a>&nbps;
						</c:otherwise>	
					</c:choose>
					
					<c:forEach begin="${pdDTO.startPage }" end="${pdDTO.endPage }" var="i" step="1">
						<c:choose>
							<c:when test="${i eq pdDTO.page }">
								${i }
							</c:when>
							<c:otherwise>
								<a href="/card/paging?page=${i }&c_number=${cDTO.c_number}">${i }</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					
					<c:choose>
						<c:when test="${pdDTO.page >= pdDTO.maxPage}">
							[다음]
						</c:when>
						<c:otherwise>
							<a href="/card/paging?page=${pdDTO.page+1 }&c_number=${cDTO.c_number}">[다음]</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
</section>
</body>
</html>