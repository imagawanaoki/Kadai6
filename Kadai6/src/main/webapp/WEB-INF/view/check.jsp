<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="/Kadai6/js/postalcode.js"></script>
<script type="text/javascript" src="/Kadai6/js/jquery.js"></script>
<link rel="stylesheet" href="/Kadai6/css/style.css" />
</head>

<body class="colar">

	<div align="center">
		<div class="c">
			以下の内容で登録します。よろしいですか？<br>
			<table class="meter" border="1">
				<tr>
					<th>お名前</th>
					<td>${f:h(name)}<br></td>
				</tr>
				<tr>
					<th>郵便番号</th>
					<td>${f:h(postalCode)}<br></td>
				</tr>
				<tr>
					<th>住所</th>
					<td>${f:h(address)}<br></td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td>${f:h(phoneNumber)}<br></td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td>${f:h(mailAddress)}<br></td>
				</tr>
			</table>
		</div>
	</div>
	<s:form action="/check/sendMail/" method="POST">

		<html:hidden property="name" value="${f:h(name)}" />
		<html:hidden property="postalCode" value="${f:h(postalCode)}" />
		<html:hidden property="address" value="${f:h(address)}" />
		<html:hidden property="phoneNumber" value="${f:h(phoneNumber)}" />
		<html:hidden property="mailAddress" value="${f:h(mailAddress)}" />

		<html:hidden property="strToday" value="${f:h(strToday)}" />
		<html:hidden property="birthday" value="${f:h(birthday)}" />
		<html:hidden property="unseiName" value="${f:h(unseiName)}" />
		<html:hidden property="negaigoto" value="${f:h(negaigoto)}" />
		<html:hidden property="akinai" value="${f:h(akinai)}" />
		<html:hidden property="gakumon" value="${f:h(gakumon)}" />
		<div align="center">
			<div class="line">
				<button name="submit">

					<span style="color: blue">送信</span>

				</button>
			</div>
		</div>
	</s:form>

	<s:form action="/check/back/" method="POST">

		<html:hidden property="name" value="${f:h(name)}" />
		<html:hidden property="postalCode" value="${f:h(postalCode)}" />
		<html:hidden property="todouhuken" value="${f:h(todouhuken)}" />
		<html:hidden property="sikutyouson" value="${f:h(sikutyouson)}" />
		<html:hidden property="tyouikimei" value="${f:h(tyouikimei)}" />
		<html:hidden property="phoneNumber" value="${f:h(phoneNumber)}" />
		<html:hidden property="mailAddress" value="${f:h(mailAddress)}" />
		<html:hidden property="strToday" value="${f:h(strToday)}" />
		<html:hidden property="birthday" value="${f:h(birthday)}" />
		<html:hidden property="unseiName" value="${f:h(unseiName)}" />
		<html:hidden property="negaigoto" value="${f:h(negaigoto)}" />
		<html:hidden property="akinai" value="${f:h(akinai)}" />
		<html:hidden property="gakumon" value="${f:h(gakumon)}" />
		<div align="center">
			<div class="line">
				<button name="submit">戻る</button>
			</div>
		</div>
	</s:form>

</body>
</html>
