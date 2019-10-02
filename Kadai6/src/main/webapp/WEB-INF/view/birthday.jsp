<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<!-- 誕生日入力画面 -->
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" type="text/css" />
<title>誕生日入力画面</title>

</head>

<body class="colar"
	style="background-image: url(${pageContext.request.contextPath}/img/kado.png);
			background-repeat: no-repeat;">
	<div class="you">
		<img src=http://localhost:8080/Kadai6/img/mikosan.png>
	</div>
	<div align="center">
		<div class="margin">
<div class="d">
			<div class="font-size">
				<h1>
					お<span style="color: red">み</span>くじ
				</h1>

			</div>

		</div>
		<div align="center">

			<h3>
				あなたの運勢を占いましょう。<br /> 誕生日を入力してください <span class="sample2a">(例)2000-01-01
				</span>
			</h3>
		</div>
		<html:messages id="msg" message="false">
			<bean:write name="msg" ignore="true" filter="false" />
		</html:messages>
		<br>

		<s:form action="/birthday/inputResult/">
			<html:text property="birthday" />

			<input type="submit" value="おみくじを引く" />
		</s:form>
		<br>
		</div>
	</div>
</body>
</html:html>

