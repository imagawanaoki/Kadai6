package kadai6.service;

import static kadai6.entity.PrefecturesNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

import java.util.List;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;

import kadai6.entity.Prefectures;
import kadai6.form.UserInfoForm;

public class PrefecturesService extends AbstractService<Prefectures> {

	//個人情報のアクションフォームをDI
	@Resource
	@ActionForm
	public UserInfoForm userInfoForm;

	/**
	 * 	// テーブルにある郵便番号から住所を検索するメソッド
	 * @param postalCode   郵便番号
	 * @return postalList  検索された住所をListとして返す
	 * @return prefecturesList 　検索された郵便番号をListとして返す
	 */

	//郵便番号から住所を検索するメソッド
	public List<Prefectures> allAddressFindByPostalCode(String postalCode) {
		List<Prefectures> postalList = jdbcManager.from(Prefectures.class)
				.where(eq(postalcode(), postalCode))
				.orderBy(asc(id()))
				.getResultList();

		return postalList;
	}

	//住所から郵便番号を検索するメソッド

	public List<Prefectures> postalCodeFindByAddresses(String todouhuken, String sikutyouson, String tyouikimei) {
		List<Prefectures> prefecturesList = jdbcManager.from(Prefectures.class)
				.where(
						contains(todouhuken(), todouhuken),
						contains(sikutyouson(), sikutyouson),
						contains(tyouikimei(), tyouikimei))
				.getResultList();

		return prefecturesList;
	}

	//郵便番号の桁数を7桁にするメソッド
	public String postalCodeLength(String postalCode) {

		String code = postalCode;

		while (code.length() < 7) {
			StringBuilder sb = new StringBuilder();
			sb.append(0);
			sb.append(code);
			code = sb.toString();
		}
		return code;

	}


	//町域名に「が」系統と「の」系統が含まれているかを判定し、文字を置き換えるメソッド
	public String checkCharacterIntyouikimei(Character[] gaList, Character[] noList, String tyouikimei,
			Character escape¥, Character escape$) {

		//検索用の住所名に番地以降の住所をコピー
		String tyouikimeiSearcher = tyouikimei;

		//「が」系統の配列を回す
		for (Character ga : gaList) {

			//「が」が含まれているかを判定(「ガ、ヶ、ケ」も順に確認)
			if (tyouikimeiSearcher.contains(ga.toString())) {
				//文字の置き換え
				tyouikimeiSearcher = tyouikimeiSearcher.replace(ga, escape¥);
			}
		}

		//「の」系統の配列を回す
		for (Character no : noList) {

			//「の」が含まれているかを判定(「ノ、乃、之、野」も順に確認)
			if (tyouikimeiSearcher.contains(no.toString())) {
				//文字の置き換え
				tyouikimeiSearcher = tyouikimeiSearcher.replace(no, escape$);
			}
		}

		return tyouikimeiSearcher;
	}

	//市区町村名に「が」系統と「の」系統が含まれているかを判定し、文字を置き換えるメソッド
	public String checkCharacterSikutyouson(Character[] gaList, Character[] noList, String sikutyouson,
			Character escape¥, Character escape$) {

		//検索用の住所名に番地以降の住所をコピー
		String sikutyousonSearcher = sikutyouson;

		//「が」系統の配列を回す
		for (Character ga : gaList) {

			//「が」が含まれているかを判定(「ガ、ヶ、ケ」も順に確認)
			if (sikutyousonSearcher.contains(ga.toString())) {
				//文字の置き換え
				sikutyousonSearcher = sikutyousonSearcher.replace(ga, escape¥);
			}
		}

		//「の」系統の配列を回す
		for (Character no : noList) {

			//「の」が含まれているかを判定(「ノ、乃、之、野」も順に確認)
			if (sikutyousonSearcher.contains(no.toString())) {
				//文字の置き換え
				sikutyousonSearcher = sikutyousonSearcher.replace(no, escape$);
			}
		}

		return sikutyousonSearcher;
	}
	/**
	 *メールの本文を指定するメソッド
	 * @return
	 */
	public String mailText() {

		String strToday = userInfoForm.strToday;
		String strbirthday = userInfoForm.birthday;
		String unseiName = userInfoForm.unseiName;
		String negaigoto = userInfoForm.negaigoto;
		String akinai = userInfoForm.akinai;
		String gakumon = userInfoForm.gakumon;

		StringBuilder sb = new StringBuilder();
		sb.append("あなたのおみくじ結果はこちらになります。");
		sb.append("占い日:" + strToday);
		sb.append("誕生日:" + strbirthday);
		sb.append("運勢:" + unseiName);
		sb.append("願い事:" + negaigoto);
		sb.append("商い:" + akinai);
		sb.append("学業:" + gakumon);

		return sb.toString();

	}

}
