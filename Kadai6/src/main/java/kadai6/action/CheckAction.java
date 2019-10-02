package kadai6.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.RequestUtil;
import org.seasar.struts.util.ResponseUtil;

import com.fasterxml.jackson.databind.ObjectMapper;

import kadai6.dto.PrefecturesBean;
import kadai6.entity.Prefectures;
import kadai6.form.UserInfoForm;
import kadai6.service.PrefecturesService;

public class CheckAction {

	// メソッド内で使われるフィールド
	// prefecturesBeanList	サブウィンドウに住所もしくは郵便番号を表示させる時に使用するリスト
	// postalCode、address、phoneNumber、確認画面で表示する郵便番号、住所、電話番号、

	//おみくじの結果を格納しているBeanとユーザー情報が格納されているFormをDIする。

	@ActionForm
	@Resource
	protected UserInfoForm userInfoForm;

	@Resource
	protected PrefecturesService prefecturesService;

	@Execute(validator = false)
	public String back() {
		return "/userInfo.jsp";
	}

	public List<PrefecturesBean> prefecturesBeanList;
	public String postalCode;
	public String address;
	public String todouhuken;
	public String sikutyouson;
	public String tyouikimei;
	public String phoneNumber;

	/**
	 * 入力情報の確認メソッド
	 *
	 * @return	/check.jsp 入力情報確認画面
	 */
	@SuppressWarnings("unused")
	@Execute(validator = true, input = "/userInfo.jsp")
	public String check() {

		String name = userInfoForm.name;
		String postal = userInfoForm.postalCode;
		String todo = userInfoForm.todouhuken;
		String siku = userInfoForm.sikutyouson;
		String tyou = userInfoForm.tyouikimei;
		String add = userInfoForm.address;
		String phone = userInfoForm.phoneNumber;
		String mail = userInfoForm.mailAddress;

		//UserInfo.jspから送られた情報が入っているFormから値を取り出す

		// 入力情報の確認メソッド(郵便番号、住所の各項目、電話番号に作用)
		//未入力の場合、「未登録」と表示されるように代入

		if (postal == null || postal.isEmpty()) {
			postalCode = "未登録";
		} else {
			postalCode = postal;
		}

		if (todo == null || todo.isEmpty()) {
			address = "未登録";
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(todo);
			sb.append(siku);
			sb.append(tyou);
			address = sb.toString();
		}

		if (phone == null || phone.isEmpty()) {
			phoneNumber = "未登録";
		} else {
			phoneNumber = phone;
		}

		return "/check.jsp";

	}

	/**
	 * 郵便番号から住所の検索を非同期通信で行うメソッド
	 *
	 * @return　null 非同期通信であるため
	 */
	@Execute(validator = false)
	public String searchPostalCode() {

		//formに入力された郵便番号を取得
		String postal = userInfoForm.postalCode;

		try {
			//郵便番号が入力された際に住所を検索
			if (postal != null && !postal.isEmpty()) {

				List<Prefectures> prefectures = prefecturesService.allAddressFindByPostalCode(postal);

				//検索したリストの一番最初の要素を取り出す。複数ある場合でも一番最初にかいてあるものだけをひょうじしている
				//Prefectures pre = prefectures.get(0);

				//ヘッダ設定
				//レスポンスを取得
				HttpServletResponse response = ResponseUtil.getResponse();
				response.setContentType("application/json;charset=UTF-8"); //JSON形式, UTF-8

				//Jsonの形に書き換える
				ObjectMapper mapper = new ObjectMapper();
				String json = mapper.writeValueAsString(prefectures);

				//pwオブジェクト
				PrintWriter pw = new PrintWriter(response.getOutputStream());

				//出力
				pw.print(json);

				//ディレクトリに出力
				pw.flush();

				//クローズ
				pw.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 *郵便番号から住所を検索した結果、複数件取得した場合にサブウィンドウを表示するメソッド
	 *
	 * @return　/Kadai6/subcommand.jsp サブコマンド を表示するJSP
	 */
	@Execute(validator = false)
	public String addressSubWindow() {

		//リクエストを取得し、そのリクエストを使ってパラメータから住所を取得(都道府県名,市区町村名,番地以降:・・・という風になっている)
		HttpServletRequest httpServletRequest = RequestUtil.getRequest();
		String paramList = httpServletRequest.getParameter("data");

		//「：」ごとに区切り、塊を抽出
		String[] strPostalList = paramList.split(":");

		//画面に表示させるためにリストを作成
		prefecturesBeanList = new ArrayList<>();

		//配列から塊を一つずつ取り出すループ
		for (String strPostal : strPostalList) {

			//都道府県名、市区町村名、番地以降に区切る
			String[] strPostals = strPostal.split(",");

			//PostalBean型変数を作成し、それに分割した項目をセットし最後にリストに追加
			PrefecturesBean prefecturesBean = new PrefecturesBean();
			prefecturesBean.setTodouhuken(strPostals[0]);
			prefecturesBean.setSikutyouson(strPostals[1]);
			prefecturesBean.setTyouikimei(strPostals[2]);
			prefecturesBeanList.add(prefecturesBean);
		}

		return "/addressSubWindow.jsp";
	}

	/**
	 * サブウィンドウで選択した住所を表示するメソッド
	 *
	 * return　null　非同期通信で値を取得するため
	 */
	@Execute(validator = false)
	public String subWindow() {
		try {
			//リクエストを取得し、そのリクエストを使ってパラメータから住所を取得し都道府県名、市区町村名、番地以降に分割
			HttpServletRequest httpServletRequest = RequestUtil.getRequest();
			String address = httpServletRequest.getParameter("address");
			String[] addresses = address.split(",");

			//Prefectures型の変数を作成し、それに都道府県名、市区町村名、番地以降を登録
			Prefectures prefectures = new Prefectures();
			prefectures.todouhuken = addresses[0];
			prefectures.sikutyouson = addresses[1];
			prefectures.tyouikimei = addresses[2];

			//レスポンスを取得し、jsonファイルをセット、書き込む用のPrintWriterも取得
			HttpServletResponse response = ResponseUtil.getResponse();
			//ヘッダ設定
			response.setContentType("application/json;charset=UTF-8"); //JSON形式, UTF-8

			//Jsonの形に書き換える
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(prefectures);

			//pwオブジェクト
			PrintWriter pw = new PrintWriter(response.getOutputStream());

			//出力
			pw.print(json);

			//ディレクトリに出力
			pw.flush();

			//クローズ
			pw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 住所から郵便番号を非同期で取得するメソッド
	 *
	 * @return　null 非同期通信で値を返しているため
	 */
	@Execute(validator = false)
	public String findAddress() {
		try {
			String todouhuken = userInfoForm.todouhuken;
			String sikutyouson = userInfoForm.sikutyouson;
			String tyouikimei = userInfoForm.tyouikimei;

			//「が」、「の」の種類の配列と置き換え文字の配列を作成
			Character[] gaList = { 'が', 'ガ', 'ヶ', 'ケ' };
			Character[] noList = { 'の', 'ノ', '乃', '之', '野' };
			Character[] escape = { '¥', '$' };

			//市区町村名と番地以降の住所に対して「が」系統と「の」系統が含まれているかを確認し検索用の市区町村名と町域名を作成
			String sikutyousonSearcher = prefecturesService.checkCharacterSikutyouson(gaList, noList, sikutyouson,
					escape[0], escape[1]);

			String tyouikimeiSearcher = prefecturesService.checkCharacterIntyouikimei(gaList, noList, tyouikimei,
					escape[0], escape[1]);

			//検索結果を格納するリストを作成
			List<Prefectures> prefecturesList = new ArrayList<>();
			int i = 6;

			do {
				if (tyouikimeiSearcher.length() > i) {
					tyouikimeiSearcher = tyouikimeiSearcher.substring(0, i);
				}

				prefecturesList.addAll(prefecturesService.postalCodeFindByAddresses(todouhuken, sikutyousonSearcher,
						tyouikimeiSearcher));
				i--;

			} while (prefecturesList.size() == 0 && 1 != 0);

			//検索でヒットが一件もない時の再検索
			if (prefecturesList.size() <= 0) {

				tyouikimeiSearcher = "場合";
				prefecturesList.addAll(prefecturesService.postalCodeFindByAddresses(todouhuken, sikutyousonSearcher,
						tyouikimeiSearcher));

			}

			//郵便番号を7桁に調節
			for (Prefectures prefectures : prefecturesList) {
				prefectures.postalcode = prefecturesService.postalCodeLength(prefectures.postalcode);
			}

			//検索したリストの一番最初の要素を取り出す。複数ある場合でも一番最初にかいてあるものだけをひょうじしている
			//List<Prefectures> prefecturesList = prefecturesService.postalCodeFindByAddresses(todouhuken, sikutyouson, tyouikimei);

			//レスポンスを取得し、jsonファイルをセット、書き込む用のPrintWriterも取得
			HttpServletResponse response = ResponseUtil.getResponse();
			response.setContentType("application/json;charset=UTF-8");

			PrintWriter pw = new PrintWriter(response.getOutputStream());

			//jsonファイルに書き込むためのObjectMapperを作成し書き込み
			ObjectMapper objectMapper = new ObjectMapper();

			pw.println(objectMapper.writeValueAsString(prefecturesList));

			pw.flush();

			pw.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
		//nullを返すことで非同期通信にする
		return null;
	}

	/**
	 * メールを入力されたアドレスに送信するメソッド
	 * @return
	 */
	@Execute(validator = false)
	public String sendMail() {

		//Formから入力されたメールアドレスを取得
		String mailAddress = userInfoForm.mailAddress;

		Properties property = new Properties();

		property.put("mail.smtp.host", "smtp.gmail.com");

		// 送信先のメールアドレスを変数に格納
		String to = mailAddress;
		String from = "server@seasar.com";
		String host = "192.168.1.1";

		boolean debug = Boolean.valueOf(true).booleanValue();

		//メール送信のためのプロパティを設定
		Properties properties = new Properties();
		properties.put("mail.debug", host);
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		//デバッグ設定を行う
		if(debug) {
			properties.put("mail.debug", Boolean.valueOf(debug));
		}

		//メール送信のためのセッションを取得する
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("naoki.imagawa@bananadream.co.jp", "inny1891");
			}
		});

		session.setDebug(debug);


		try {
			//メールを送信するための各種設定
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));//送信元メールアドレスを設定
			InternetAddress[] address = {new InternetAddress(to)};
			message.setRecipients(Message.RecipientType.TO, address);//送信先メールアドレスを設定
			message.setSubject("占い結果", "ISO-2022-JP");//メール件名を設定
			message.setSentDate(new Date());//メール送信日を設定
			message.setText(prefecturesService.mailText(), "ISO-2022-JP");//メール本文を設定

			Transport.send(message);

		} catch(MessagingException e) {
			e.printStackTrace();
		}

		return "/complete.jsp";

	}
}
