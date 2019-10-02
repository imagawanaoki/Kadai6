package kadai6.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import kadai6.dto.HalfYearResultDto;
import kadai6.dto.HalfYearResultParam;
import kadai6.dto.OmikujiBean;
import kadai6.entity.Omikuji;
/**
 * Omikujiエンティティに対する操作を格納するクラス
 *
 */
public class OmikujiService extends AbstractService<Omikuji> {

	/**
	 * おみくじテーブルからおみくじの結果を取得
	 *
	 * @param omikuji_id　おみくじ結果を検索する際に使用する条件
	 * @return omikuji おみくじの結果を格納
	 */
	public OmikujiBean CheckOmikujiId(Integer omikuji_id) {

		Omikuji result = jdbcManager
				.from(Omikuji.class)
				.innerJoin("Unseimaster")
				.id(omikuji_id)
				.getSingleResult();

		OmikujiBean omikuji = new OmikujiBean();

//結合したunseiMasterから運勢名を取得、omikujiエンティティから願い事、商い、学問を取得
		omikuji.setUnseiName(result.unseiMaster.unsei_name);
		omikuji.setNegaigoto(result.negaigoto);
		omikuji.setAkinai(result.akinai);
		omikuji.setGakumon(result.gakumon);

		return omikuji;

	}


	/**
	 * 過去半年間の入力誕生日の結果を取得するメソッド
	 *
	 * @param birthday		誕生日
	 * @param sixMonth		半年前の日付
	 * @param today			今日の日付
	 * @return result.size()  過去半年間の入力誕生日の結果が格納されたリスト
	 */

	public int harfYearResultListCount(Date birthday, Date sixMonth, Date today) {

		List<HalfYearResultDto> result = new ArrayList<>();

		//引数から値を格納
		HalfYearResultParam halfYearResultParam = new HalfYearResultParam();
		halfYearResultParam.birthday = birthday;
		halfYearResultParam.harfYearAgo = sixMonth;
		halfYearResultParam.today = today;

		//過去半年間の入力誕生日の結果を全て取得し格納
		result = jdbcManager
				.selectBySqlFile(
						HalfYearResultDto.class,
						"Kadai6/service/HarfYearResult.sql",halfYearResultParam
						)
				.getResultList();

		return result.size();
	}

}