<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page isELIgnored="false"%>

<!-- おみくじ結果を画面表示 -->
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<title>Insert title here</title>
</head>
<body class="colar"
style="background-image: url(${pageContext.request.contextPath}/img/kado.png);
			background-repeat: no-repeat;">

	<div align="center">
		<div class="margin">
			<h2>おみくじ結果</h2>
		</div>

		<div class="table-scroll">
			<div align="center">

				<table class="size" border="1">
					<tr>
						<th>運勢</th>
						<td>${f:h(omikujiBean.unseiName)}</td>
					</tr>
					<tr>
						<th>願い事</th>
						<td>${f:h(omikujiBean.negaigoto)}</td>
					</tr>
					<tr>
						<th>商い</th>
						<td>${f:h(omikujiBean.akinai)}</td>
					</tr>
					<tr>
						<th>学問</th>
						<td>${f:h(omikujiBean.gakumon)}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div align="center">
		<div class="a">
			<s:form action="/rate/getRate/" method="POST">
				<html:hidden property="strBirthday" value="${f:h(birthday)}" />
				<html:hidden property="strToday" value="${f:h(strToday)}" />
				<html:hidden property="halfYearAgo" value="${f:h(harfYearAgo)}" />
				<input type="submit" value="本日の占い結果と全体の占い結果の割合を表示する">
			</s:form>

			<s:form action="/list/getList/">
				<html:hidden property="strToday" value="${f:h(strToday)}" />
				<html:hidden property="strBirthday" value="${f:h(birthday)}" />
				<html:hidden property="halfYearAgo" value="${f:h(harfYearAgo)}" />
				<input type="submit" value="誕生日の結果リストを表示" />
			</s:form>

			<s:form action="/send/index/" method="POST">

				<html:hidden property="strToday" value="${f:h(strToday)}" />
				<html:hidden property="birthday" value="${f:h(birthday)}" />
				<html:hidden property="unseiName" value="${f:h(omikujiBean.unseiName)}" />
				<html:hidden property="negaigoto" value="${f:h(omikujiBean.negaigoto)}" />
				<html:hidden property="akinai" value="${f:h(omikujiBean.akinai)}" />
				<html:hidden property="gakumon" value="${f:h(omikujiBean.gakumon)}" />

				<input type="submit" value="結果を送信する" />
			</s:form>
			<a href="/Kadai6/birthday/inputBirthday/">トップへ戻る</a>
		</div>
	</div>
</body>
</html:html>