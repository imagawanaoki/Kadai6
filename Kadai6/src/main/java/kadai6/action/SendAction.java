package kadai6.action;

import java.util.List;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import kadai6.dto.PrefecturesBean;
import kadai6.form.FortuneForm;
import kadai6.service.PrefecturesService;

public class SendAction {

	//個人情報入力画面から送られてくるアクションフォーム fortuneFormをDI
	@Resource
	@ActionForm
	protected FortuneForm fortuneForm;

	//郵便番号から住所、またはその逆を非同期通信で検索するためのPrefecturesServiceをDI
	@Resource
	protected PrefecturesService prefecturesService;

	// メソッド内で使われるフィールド
	// prefecturesBeanList	サブウィンドウに住所もしくは郵便番号を表示させる時に使用するリスト
	// postalCode、address、phoneNumber、確認画面で表示する郵便番号、住所、電話番号、メールアドレス

	public List<PrefecturesBean> prefecturesBeaList;
	public String postalCode;
	public String address;
	public String phoneNumber;
	public String todouhuken;
	public String sikutyouson;
	public String tyouikimei;

	@Execute(validator = false)
	public String index() {

		String u = fortuneForm.unseiName;
		String n = fortuneForm.negaigoto;
		String a = fortuneForm.akinai;
		String g = fortuneForm.gakumon;

			return "/userInfo.jsp";
		}
}
