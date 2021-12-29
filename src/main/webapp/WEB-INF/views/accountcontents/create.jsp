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
	<form action="/accountcontents/create?ai_number=${aiDTO.ai_number}" method="post" enctype="Multipart/form-data">
		ai_number <input type="hidden" name="ai_number" value="${aiDTO.ai_number}">
	    ac_name <input type="text" name="ac_name">
	    ac_memo <input type="text" name="ac_memo">
	    ac_pName <input type=file" name="ac_photo">
	    ac_pAsset <input type="text" name="ac_pAsset">
	    <input type="submit" value="저장">
	</form>
</section>
</body>
</html>