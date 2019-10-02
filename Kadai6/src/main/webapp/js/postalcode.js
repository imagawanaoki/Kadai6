

$(function(){
        // Ajax button click
        $('#ajax').on('click',function(event){		// #をつけるとid=ajax,[.]をつけるとclass＝ajaxとなる
        	var postalCode = $('#postalCode').val();
           　event.preventDefault(); // formを停止する
        	$.ajax({
                url:'http://localhost:8080/Kadai6/check/searchPostalCode?postalCode='+ postalCode, // Actionのパス
                dataType:'json',

            })

            // Ajaxリクエストが成功した時発動
            .done( function(data) {

        		if(data.length >= 2){
    				// 1件目の情報を登録する
        			var prefectures =
        				data[0].todouhuken+ ','
        				+ data[0].sikutyouson + ','
        				+ data[0].tyouikimei + ':';
    				var i = 1;

					 // 情報を全件連結させる(各番ごとに「:」で各項目ごとに「,」で区切る)
    				while(i < data.length){
    					prefectures =
    						prefectures
    						+ data[i].todouhuken + ','
    						+ data[i].sikutyouson + ','
    						+ data[i].tyouikimei;
    					i++;
    					// 番地等続きがある場合に「:」を挿入
    					if(i < data.length){
    						prefectures = prefectures + ':';
    					}
    				}
    				// 連結させた文字列をパラメータとし選択させるサブウィンドウを開くためのアクションメソッドに飛ぶ
    				window.open('http://localhost:8080/Kadai6/check/addressSubWindow?data='+prefectures);
    			}

    			// 検索結果が１件の場合
    			else if(data.length == 1){
    				// 値をセットする
    				$('#todouhuken').attr('value', data[0].todouhuken);
    				$('#sikutyouson').attr('value', data[0].sikutyouson);
    				$('#tyouikimei').attr('value', data[0].tyouikimei);
    				console.log(data);
    			}
    			// 検索結果が0件の場合
    			else {
    				alert("郵便番号が正しくありません。\n入力しなおしてください。");
    			}
    		})
    	     // Ajaxリクエストが失敗した時発動
            .fail( function(data){
                	alert("error");						// エラーメッセージととかかく
            			console.log(data);
            })

            	// Ajaxリクエストが成功・失敗どちらでも発動
            .always( function(data) {

            });
        });
});

// 住所から郵便番号を検索する
$(function(){
	$('#abbb').on('click', function(event){
	$.ajax({

			url:'/Kadai6/check/findAddress/',
			type:'POST',
			dataType:'json',
			data:{
				'todouhuken':$('#todouhuken').val(),
				'sikutyouson':$('#sikutyouson').val(),
				'tyouikimei':$('#tyouikimei').val()
			}

		})
		 // Ajaxリクエストが成功した時発動
		.done(function(data){
			//検索結果が複数の場合(掲載がないパターンや)
			if(data.length >= 2){

				//１件目の情報を登録しループカウンタを作成
				var sendData = data[0].postalcode + ',' + data[0].tyouikimei+ ':';
				var i = 1;

				/*
				 * 情報を全件連結させる(各番ごとに「:」で郵便番号と番地以降の間を「,」で区切る)
				 * ※URLに文字として登録するため(これをしないと各情報が[object, Object]という文字列になってしまう)
				 */
				while(i < data.length){
					sendData = sendData + data[i].postalcode + ',' + data[i].tyouikimei;
					i++;
					//続きがある場合に「:」を挿入
					if(i < data.length){
						sendData = sendData + ':';
					}
				}
				//連結させた文字列をパラメータとし選択させるサブウィンドウを開くためのアクションメソッドに飛ぶ
				window.open(encodeURI("/Kadai6/check/postalCodeSubWindow?data="+sendData));
			}

			//検索結果が１件の場合
			else if(data.length == 1){
				//郵便番号をセット
				$('#postalCode').attr('value', data[0].postalcode);
				console.log(data);
			}

			//検索結果が0件の場合
			else {
				alert("該当する住所が見つかりません。\n入力しなおしてください。");
			}
		})

		.fail(function(data){
			alert("該当する住所が見つかりません。\n入力しなおしてください。");
			 console.log(XMLHttpRequest.status);
			    console.log(textStatus);
			    console.log(errorThrown);
		});

	});
});