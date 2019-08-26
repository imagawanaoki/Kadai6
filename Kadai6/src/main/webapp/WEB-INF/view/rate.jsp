<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<title>- AllBirthaday -</title>
</head>
<body class="colar"
	style="background-image: url(${pageContext.request.contextPath}/img/flame.png);
			background-repeat: no-repeat;">


		<h2>占い結果の割合表示</h2>

	<!-- 過去半年全体のおみくじ結果のあ割合表示 -->
	<table class="contain"border="1">
		<caption>半年間の運勢結果の割合</caption>
		<tr>
			<th>運勢</th>
			<td>割合</td>
		</tr>

		<c:forEach var="results" items="${unseiRateMap}">
			<tr>
				<th><c:out value="${results.key}"></c:out></th>
				<td><c:out value="${results.value}%"></c:out></td>
			</tr>
		</c:forEach>
	</table>


	<!-- 本日行った占い結果の割合表示-->
	<table class="contain" border="1">

		<caption>本日の運勢結果の割合</caption>
		<tr>
			<th>運勢</th>
			<td>割合</td>
		</tr>

		<c:forEach var="map" items="${TodayMap}">
			<tr>
				<th><c:out value="${map.key}"></c:out></th>
				<td><c:out value="${map.value}%"></c:out></td>
			</tr>
		</c:forEach>
	</table>

	<!-- 誕生日入力画面に遷移 -->
	<div class="button">
		<div class="padding">

			<a href="/Kadai6/birthday/inputBirthday/">入力画面に戻る</a>


			<s:form action="/result/getOmikuji/">
				<html:hidden property="birthday" value="${f:h(strBirthday)}" />
				<input type="submit" value="おみくじ結果画面に戻る" />
			</s:form>


		</div>
	</div>



</body>

</html>