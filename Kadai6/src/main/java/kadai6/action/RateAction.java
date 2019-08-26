package kadai6.action;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import kadai6.form.DateForm;
import kadai6.service.ResultService;
/**
 * 過去半年の運勢結果の割合を求めるためのアクションクラス
 *
 */
public class RateAction {

	//割合を求めるために必要なActionForm
	@Resource
	@ActionForm
	public DateForm dateForm;

	//割合を求めるために必要な数を求めるためのResultService
	@Resource
	public ResultService resultService;

	/**
	 * メソッド内で使われるフィールド
	 * sixmonth		半年前の日付
	 * today		今日の日付
	 * count		過去半年間の全件数と運勢ごとの件数
	 * rate			割合
	 * bigDecimal	割合を変換したBigDecimal型変数
	 * Rate			四捨五入をした割合
	 * TodayMap		keyに運勢名、valueにその運勢の今日の割合を格納したマップ
	 * CountMap		keyに運勢名、valueにその件数を格納したマップ
	 * unseiRateMap	keyに運勢名、valueにその運勢の半年間の割合を格納したマップ
	*/

	public Date sixmonth;
	public Date today;

	public double count;
	public double rate;

	public BigDecimal bigDecimal;
	public BigDecimal Rate;

	public Map<String, BigDecimal> TodayMap;
	public Map<String, Long> CountMap;
	public Map<String, BigDecimal> unseiRateMap;

	/**
	 * 過去半年間と今日一日の各運勢の割合を計算し取得するメソッド
	 * @return	/rate.jsp	割合を表示させる画面
	 */
	@Execute(validator = false)
	public String getRate() {

		//過去半年間の各運勢の割合を格納するマップを作成
		unseiRateMap = new LinkedHashMap<>();

		//フォームから受け取った情報をDate型に変換
		sixmonth = Date.valueOf(dateForm.halfYearAgo);
		today = Date.valueOf(dateForm.strToday);

		//過去半年間の全件数と運勢ごとの件数を取得
		count = resultService.count(sixmonth, today);
		CountMap = resultService.unseiCode(sixmonth, today);

		//運勢ごとに割合を計算し、四捨五入したものをマップに格納
		for (String unsei_name : CountMap.keySet()) {

			rate = (CountMap.get(unsei_name) / count) * 100;
			bigDecimal = new BigDecimal(rate);

			//計算して出た値を四捨五入
			Rate = bigDecimal.setScale(1, RoundingMode.HALF_UP);

			//運勢名をkeyに割合をvalueに格納する
			unseiRateMap.put(unsei_name, Rate);

		}

		//今日の運勢の割合を格納するマップを作成したいため、　各運勢の件数を格納するマップを空にする
		CountMap.clear();

		//今日の各運勢の割合を格納するマップを作成
		TodayMap = new LinkedHashMap<>();

		//今日の全件数と運勢ごとの件数を取得
		count = resultService.Allrecord(today);
		CountMap = resultService.todayrecord(today);

		//運勢ごとに割合を計算し、四捨五入したものをマップに登録
		for (String unsei_name : CountMap.keySet()) {

			//運勢ごとに割合を計算
			rate = (CountMap.get(unsei_name) / count) * 100;
			bigDecimal = new BigDecimal(rate);

			//四捨五入を行う
			Rate = bigDecimal.setScale(1, RoundingMode.HALF_UP);

			//運勢名をkeyに四捨五入した値をvalueに格納
			TodayMap.put(unsei_name, Rate);
		}

		//各運勢の件数を格納するマップを空にする
		CountMap.clear();

		return "/rate.jsp";
	}

}
