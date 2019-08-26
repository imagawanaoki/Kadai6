package kadai6.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import kadai6.form.BirthdayForm;

/**
 * 入力された誕生日の入力チェックを行うアクション
 *
 */
public class BirthdayAction {

	//入力した誕生日のアクションフォーム
	@Resource
	@ActionForm
	protected BirthdayForm birthdayForm;

	@Resource
	protected HttpSession httpSession;

	/**
	 * 入力チェックを行う(入力失敗時は誕生日入力画面に戻る)
	 *
	 * @return	/birthday.jsp 誕生日入力画面
	 */

	@Execute(validator = false)
	public String inputBirthday() {
		return "/birthday.jsp";
	}


	/**
	 * 入力チェックを行う(入力が成功した場合、おみくじの結果表示画面に遷移)
	 *
	 * @return	/result.jsp	おみくじを引くメソッド
	 */

	@Execute(validator = true, input = "/birthday.jsp")
	public String inputResult() {
		return "/result/getOmikuji/";
	}
}
