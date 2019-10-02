<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>選択画面</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript" src="/Kadai6/js/select.js"></script>
<link rel="stylesheet" href="/Kadai6/css/style.css" />
</head>
<body>

	<s:form action="/check/selectPostalCodeBySubWindow/" method="POST">

		<c:forEach var="prefectures" items="${prefecturesBeanList}">
			<html:radio property="postalCode" styleId="postalCode"
				value="${prefectures.postalCode}" />
			${prefectures.postalCode}：${prefectures.addressDetail}<br>
		</c:forEach>
		<button type="button" id="selectPostalCodeBySubWindow">決定</button>
	</s:form>
</body>
</html>
