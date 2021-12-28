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
	<form action="/cashinfo/update?s_number=${siDTO.s_number}" method="post" enctype="Multipart/form-data">
		si_number <input type="hidden" name="si_number" value="${siDTO.si_number}" readonly>
	    s_cash <input type="text" name="s_cash" value="${siDTO.s_cash}">
	    s_number <input type="hidden" name="s_number" value="${siDTO.s_number}" readonly>
	    si_name <input type="text" name="si_name" value="${siDTO.si_name}">
		si_memo <textarea name="si_memo" rows="5"></textarea>
	    si_pName <input type="file" name="si_photo">
	    si_tAsset <input type="text" name="si_tAsset">
	
		<input type="submit" value="수정">
		<button id="back" onclick="back()">돌아가기</button>
	</form>
</section>
</body>
</html>