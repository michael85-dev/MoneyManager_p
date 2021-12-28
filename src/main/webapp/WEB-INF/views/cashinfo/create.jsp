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
cashinfo-create
<section>
	<form action="cashinfo/create?s_number=${sDTO.s_number}" method="post" enctype="Multipart/form-data">
		si_number : 자동
		s_cash 계좌명 <input type="text" name="s_cash" value="${sDTO.s_cash}">
		s_number <input type="hidden" name="s_number" value="${sDTO.s_number}" readonly>
		si_name 내역 <input type="text" name="si_name">
		si_nName
		si_memo 메모 <textarea name="si_memo" rows="5"></textarea>
		si_photo 첨부 <input type="file" name="si_photo">
		
		이걸 표현하는게 제일 어렵다고 생각되는데.
		<select id="aCheck">
			<option value="mAsset">-</option>
			<option value="pAsset">+</option>
		</select> 
		<input type="text" name="pAsset" id="asset" onblur="check()">
		si_pAsset
		si_mAsset
	</form>
</section>
</body>
<script>
	function check() {
		const aCheck = document.getElementById('aCheck').value;
		const asset = document.getElementById('asset');
		
		if (aCheck == mAsset) {
			asset.value = -1 * (asset.value);
		} else {
			asset.value = asset.value;
		}
		
	}
</script>
</html>