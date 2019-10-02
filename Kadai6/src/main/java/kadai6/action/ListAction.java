package kadai6.action;

import java.sql.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import kadai6.dto.OmikujiBean;
import kadai6.form.DateForm;
import kadai6.service.ResultService;
/**
 * 入力された誕生日の過去半年の結果表示を行う為のアクションクラス
 *
 */
public class ListAction {

	@Resource
	@ActionForm
	protected DateForm dateForm;

	@Resource
	protected ResultService resultService;
/**
 * メソッド内で使用されるフィールド
 *
 * resulthalfYearAgo 半年前の占い日
 * today 		     今日の日付
 * birth　　　        誕生日
 *
 */
	public Date resuthalfYearAgo;
	public Date today;
	public Date birth;
	public Map<Date, OmikujiBean> resultMap;

	@Execute(validator = false)
	public String getList() {

		//Formに存在するString型のフィールドをDate型に変換
		today = Date.valueOf(dateForm.strToday);
		birth = Date.valueOf(dateForm.strBirthday);
		resuthalfYearAgo = Date.valueOf(dateForm.halfYearAgo);

		//ResultServiceから値を呼び出す
		//過去半年間の入力誕生日の占い結果を検索
		resultMap = resultService.birthdayresult(today, birth, resuthalfYearAgo);

		return "/list.jsp";

	}
}