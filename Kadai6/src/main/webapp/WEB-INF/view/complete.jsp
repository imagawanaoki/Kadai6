<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了画面</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="/Kadai6/js/postalcode.js"></script>
<script type="text/javascript" src="/Kadai6/js/jquery.js"></script>
<link rel="stylesheet" href="/Kadai6/css/style.css" />

</head>
<body class="colar"
	style="background-image: url(${pageContext.request.contextPath}/img/kado.png);
			background-repeat: no-repeat;">
	<div class="you">
		<img src=http://localhost:8080/Kadai6/img/4.png>
	</div>
	<div class="c">
		<div align="center">
			<h2>
				メールを送信しました<span style="color: red">！</span>
			</h2>

		<div class="e">
		<s:form action="/result/getOmikuji/">
			<html:hidden property="birthday" value="${f:h(birthday)}" />
			<input type="submit" value="結果画面へ戻る" />
		</s:form>
		<br>

	<a href="/Kadai6/birthday/inputBirthday/">トップへ戻る</a>
	</div>
	</div>
</div>

</body>
</html>