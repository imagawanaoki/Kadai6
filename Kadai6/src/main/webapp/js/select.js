
//ラジオボタンを用いて住所を選択させる
$(function(){
	$('#subWindow').on('click', function(){
		$.ajax({
			url:'subWindow/',
			type:'POST',
			dataType:'json',
			data:{
				//ラジオボタンで選択されたものが正しく渡すためcheckedを使用する
				'address':$('#address:checked').val()
			}
		})

		.done(function(data){
			//メインウィンドウの各idの部分に取得した値を登録
			window.opener.document.getElementById('todouhuken').value
			=data.todouhuken;
			window.opener.document.getElementById('sikutyouson').value
			=data.sikutyouson;
			window.opener.document.getElementById('tyouikimei').value
			=data.tyouikimei;

			//サブウィンドウを閉じる
			window.close();
		})

		.fail(function(data){
		})
	})
})

//複数件ある郵便番号から１件選ぶ非同期通信
$(function(){
	$('#selectPostalCodeBySubWindow').on('click', function(){
		$.ajax({
			url:'selectPostalCodeBySubWindow/',
			type:'POST',
			dataType:'json',
			data:{
				'postalCode':$('#postalCode:checked').val()
			}
		})

		.done(function(data){
			//メインウィンドウに選択した郵便番号を登録し、サブウィンドウを閉じる
			window.opener.document.getElementById('postalCode').value = data;
			window.close();
		})

		.fail(function(data){
		})
	})
})
