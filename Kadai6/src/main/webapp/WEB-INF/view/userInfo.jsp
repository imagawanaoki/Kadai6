<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>情報登録画面</title>
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
		<div class="a">
			<h2>お客様情報登録画面</h2>
		</div>
		<html:messages id="msg" message="false">
			<div class="errors">
				<bean:write name="msg" ignore="true" filter="false" />
			</div>
		</html:messages>
		<p class="a">以下の項目に必要事項を入力してください。</p>
	</div>

	<form name="userInfoForm" method="POST" action="/Kadai6/check/check/">

		<div align="center">
			<table class="meter" border="1">

				<tr>
					<th>氏名</th>
					<td><input type="text" name="name"><br></td>
				<tr>
					<!--　				同期通信で行う場合
			<li>住所1(都道府県):<html:text property="todouhuken" value ="${f:h(todouhuken)}" /></li>
			<li>住所2(市区町村):<html:text property="sikutyouson" value ="${f:h(sikutyouson)}"/></li>
			<li>住所3(町域名):<html:text property="tyouikimei" value ="${f:h(tyouikimei)}" /></li>
																								-->

					<!--Ajaxで表示を行う場合-->
				<tr>
					<th>郵便番号(〒0000000 7桁)</th>
					<td><input type="text" name="postalCode" id="postalCode" />
						<button id="ajax" type="button">住所検索</button></td>
				</tr>
				<tr>
					<th>住所1(都道府県)</th>
					<td><input type="text" name="todouhuken" id="todouhuken" /></td>
				</tr>
				<tr>
					<th>住所2(市区町村)</th>
					<td><input type="text" name="sikutyouson" id="sikutyouson" /></td>
				</tr>
				<tr>
					<th>住所3(町域名)</th>
					<td><input type="text" name="tyouikimei" id="tyouikimei" />
						<button id="abbb" type="button">郵便番号検索</button></td>
				</tr>
				<tr>
					<th>電話番号(ハイフン無し)</th>
					<td><input type="text" name="phoneNumber" /></td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><input type="text" name="mailAddress"></td>

				</tr>

			</table>

			<html:hidden property="strToday" value="${f:h(strToday)}" />
			<html:hidden property="birthday" value="${f:h(birthday)}" />
			<html:hidden property="unseiName" value="${f:h(unseiName)}" />
			<html:hidden property="negaigoto" value="${f:h(negaigoto)}" />
			<html:hidden property="akinai" value="${f:h(akinai)}" />
			<html:hidden property="gakumon" value="${f:h(gakumon)}" />
			<div>
				<button name="action" value="send" type="submit">会員登録画面へ進む</button>
				<button name="action" value="clear" type="button"
					class="clear-button">クリア</button>
			</div>
		</div>
	</form>
	<div align="center">
		<s:form action="/result/getOmikuji/">
			<html:hidden property="birthday" value="${f:h(birthday)}" />

			<button type="submit" value="return">結果画面へ戻る</button>
		</s:form>
	</div>

</body>
</html>