package kadai6.action;

import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import kadai6.dto.OmikujiBean;
import kadai6.entity.Result;
import kadai6.form.BirthdayForm;
import kadai6.service.OmikujiService;
import kadai6.service.ResultService;
/**
 * おみくじの結果を取得しDBに登録
 * また、おみくじコードが0の時、同日・同誕生日でおみくじを引いていない場合は、おみくじテーブルの行数から乱数を生成し、おみくじコードを取得する
 *
 */
public class ResultAction {

	//入力した誕生日のアクションフォーム
	@Resource
	@ActionForm
	protected BirthdayForm birthdayForm;

	//過去におみくじを引いたか調べる処理と結果を登録する際に使用
	@Resource
	protected ResultService resultService;

	//おみくじの結果を獲得する際に用いる
	@Resource
	protected OmikujiService omikujiService;

	/**
	 * メソッド内で使われるフィールド
	 *
	 * birthday	フォームから送られた誕生日をDate型に変換したもの
	 * calendar		今日の日付と半年前の日付を取得するために使う変数
	 * today		今日の日付
	 * sixmonth		半年前の日付
	 * strToday     String型に変換された今日の日付
	 * harfyearago	String型に変換された半年前の日付
	 * omikuji_id	おみくじコード

	 */
	public Date birth;
	public Date sixMonth;
	public Date today;

	public Calendar calendar;

	public String strToday;
	public String harfYearAgo;

	public Integer omikuji_id;

	public OmikujiBean omikujiBean;

	/**
	 * おみくじの結果を取得するメソッド(割合画面とリスト画面から戻るときにも使用)
	 *
	 * @return	/Kadai6/omikuji.jsp	おみくじの結果を表示させる画面
	 */
	@Execute(validator = false)
	public String getOmikuji() {

		//入力された誕生日をdate型に変換をし、今日の日付を取得した上でDate型に変換をする
		birth = Date.valueOf(birthdayForm.birthday);
		calendar = Calendar.getInstance();
		today = new Date(calendar.getTime().getTime());

		//半年前の日付を取得
		calendar.add(Calendar.MONTH, -6);
		sixMonth = new Date(calendar.getTime().getTime());

		//今日の日付と半年前の日付をString型に変換
		strToday = today.toString();
		harfYearAgo = sixMonth.toString();

		//誕生日と今日の日付からおみくじコードを取得
		omikuji_id = resultService.CheckOmikuji(today,birth);

		/**
		 * おみくじコードが0の時、同日・同誕生日でおみくじを引いていない場合は、おみくじテーブルの行数から乱数を生成し、おみくじコードを取得する
		 * 同時にDBに登録も行う
		 * @return /result.jsp おみくじの結果を表示する画面
		 */
		if (omikuji_id == 0) {
			Random rand = new Random();
			omikuji_id = rand.nextInt((int) omikujiService.getCount());

			//テーブルに登録
			Result result  = new Result();

			result.uranai_date = today;
			result.birthday = birth;
			result.omikuji_id = omikuji_id;
			result.create_date = today;
			result.creater = "今川尚樹";
			result.update_date = today;
			result.update_user = "今川尚樹";
			resultService.insert(result);

		}

		//取得したおみくじコードからおみくじの結果を取得
	 omikujiBean = omikujiService.CheckOmikujiId(omikuji_id);
		return "/result.jsp";
	}

}
