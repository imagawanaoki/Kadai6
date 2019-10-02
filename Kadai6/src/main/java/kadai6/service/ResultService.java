package kadai6.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import kadai6.dto.GetCountAndNameParam;
import kadai6.dto.HalfYearAgo;
import kadai6.dto.HalfYearResultParam;
import kadai6.dto.OmikujiBean;
import kadai6.dto.TodayRecordParam;
import kadai6.entity.Result;

/**
 * Resultエンティティに対する操作を格納するクラス
 *
 */

public class ResultService extends AbstractService<Result> {

	/**
	 * 過去半年の全レコードを取得
	 *
	 * @param sixmonth 半年前の日付
	 * @param today　占い日
	 * @return　count　過去半年間の入力された誕生日の結果を格納
	 */

	public Long count(Date sixmonth,Date today) {

		//過去半年間の入力された誕生日の結果を全て取得しリストに格納
		Long count = jdbcManager.from(Result.class)
				.where("uranai_date >= ? AND uranai_date <= ?", sixmonth, today)
				.getCount();

		return count;
	}

	/**
	 * 過去半年の運勢コードと名前を紐づけて取得
	 * @param today 占い日
	 * @param sixmonth 半年前の日付
	 * @return map キーに運勢名、バリューに件数を登録したmapを返却
	 */
	//過去半年の運勢コードと名前を紐づけて取得
	public Map<String, Long> unseiCode(Date sixmonth, Date today) {

		//運勢名と件数を登録するマップをLinkedHashMap型で作成
		List<HalfYearAgo> harf = new ArrayList<>();
		Map<String, Long> map = new LinkedHashMap<>();

		//Actionメソッドから呼び出されるため引数に値を格納
		GetCountAndNameParam getCountAndNameParam = new GetCountAndNameParam();
		getCountAndNameParam.harfyearAgo = sixmonth;
		getCountAndNameParam.today = today;

		//過去半年間の運勢ごとの件数を取得
		harf = jdbcManager
				.selectBySqlFile(
						HalfYearAgo.class,
						"/service/GetCountAndName.sql",
						getCountAndNameParam)

				.getResultList();

		//件数をMapに格納
		for (HalfYearAgo result : harf) {

			//キーに運勢名、バリューに件数を登録
			map.put(result.unseiName, result.cnt);
		}
		return map;
	}

	/**
	 * //今日の1日分の行数全てを取得
	 * @param today 占い日
	 * @return record 今日１日分の行数を格納
	 */
	//今日の1日分の行数全てを取得
	public double Allrecord(Date today) {

		//今日の1日分の行数全てを取得
		double record = (double) jdbcManager.from(Result.class)
				.where("uranai_date >= ?", today)
				.getCount();

		return record;

	}

	/**
	 * 今日の運勢レコードを取得
	 * @param today　今日の日付
	 * @return countMap keyに運勢名、valueに件数を格納
	 */
	public Map<String, Long> todayrecord(Date today) {
		//運勢名と件数を登録するマップ作成
		Map<String, Long> countMap = new LinkedHashMap<>();
		List<HalfYearAgo> result = new ArrayList<>();

		//Actionメソッドから呼び出されるため引数の値を格納
		TodayRecordParam todayRecordParam = new TodayRecordParam();
		todayRecordParam.uranai_date = today;

		//外部SQLファイルを用いて今日一日の運勢ごとの件数を取得
		result = jdbcManager.selectBySqlFile(HalfYearAgo.class,
				"/service/TodayRecord.sql", todayRecordParam)
				.getResultList();

		//件数をMapに格納
		for (HalfYearAgo number : result) {

			//keyに運勢名、valueに件数を格納
			countMap.put(number.unseiName, number.cnt);
		}
		return countMap;
	}

	/**
	 * 誕生日が同じもののレコードを取得
	 * @param today 占い日
	 * @param birthday 誕生日
	 * @param harfYearAgo 半年前の日付
	 *@return resultMap おみくじの結果を格納しているMap
	 */

	public Map<Date, OmikujiBean> birthdayresult(Date today, Date birthday,Date harfYearAgo) {

		List<OmikujiBean> result = new ArrayList<>();
		Map<Date, OmikujiBean> resultMap = new LinkedHashMap<>();

		//Actionメソッドから呼び出されるため引数に値を格納
		HalfYearResultParam halfYearResultParam = new HalfYearResultParam();
		halfYearResultParam.today = today;
		halfYearResultParam.birthday = birthday;
		halfYearResultParam.harfYearAgo = harfYearAgo;
		//Tableに登録されている過去半年にでたおみくじの結果を誕生日を条件におみくじの結果を取得
		result = jdbcManager
				.selectBySqlFile(OmikujiBean.class,
						"/service/HarfYearResult.sql", halfYearResultParam)
				.getResultList();

		//おみくじ結果を格納するための拡張for文

		for (OmikujiBean omikujiBean : result) {

			//結合したunseiMasterから運勢名を取得、omikujiエンティティから願い事、商い、学問を取得


			resultMap.put(omikujiBean.uranaiDate, omikujiBean);

		}
		return resultMap;

	}

	/**
	 * 引いたか引いていないかを判定するメソッド
	 *
	 * @param today 占い日
	 * @param birthday 誕生日
	 * @return 0 DBにレコードが登録されていない場合に返却する値
	 * @return result.omikuji_id レコードが登録されている場合、omikuji_idを返却する
	 */
	public Integer CheckOmikuji(Date today, Date birthday) {

		Result result = jdbcManager
				.from(Result.class)
				.where("uranai_date = ? and birthday = ?", today, birthday)
				.getSingleResult();

		if (result != null) {

			return result.omikuji_id;
		} else {

			return 0;
		}
	}
}
