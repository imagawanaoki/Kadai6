<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

     <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<title>- Path -</title>
</head>
<body class="colar"
	style="background-image: url(${pageContext.request.contextPath}/img/flame.png);
			background-repeat: no-repeat;">

				<!-- ヘッダーの表示 -->
<div align = "center">
<div class ="margin">
<h2>入力された誕生日の過去半年の結果表示</h2>
</div>
</div>
<div align="center">
<table class="rate" border = "1">


<tr>
<th>占い日</th><th>運勢</th><th>学問</th><th>願い事</th><th>商い</th>
</tr>

<c:forEach var="result" items="${resultMap}">

<tr>
<td>${result.key}</td>
<td>${result.value.unseiName}</td>
<td>${result.value.negaigoto}</td>
<td>${result.value.gakumon}</td>
<td>${result.value.akinai}</td>

</tr>

</c:forEach>

</table>
</div>
		<!-- 誕生日入力画面に遷移 -->
		<div class="a">
			<div align ="center">
<s:form action="/result/getOmikuji/"><html:hidden property="birthday" value = "${f:h(strBirthday)}"/>
<input type = "submit" value="おみくじ結果画面に戻る" /></s:form>

<a href = "/Kadai6/birthday/inputBirthday/">トップへ戻る</a>

</div>
</div>


</body>
</html>