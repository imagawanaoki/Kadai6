package kadai6.dto;

import java.sql.Date;
/**
 * /**
 * OmikujiテーブルのDTO
 * 各フィールドはsetter/getterメソッドを持つ
 *
 */

public class OmikujiBean {

	//おみくじコード
	public int omikuji_id;

	//運勢名
	public String unseiName;

	//占い日
	public Date uranaiDate;

	//運勢コード
	public int unsei_id;

	//願い事
	public String negaigoto;

	//商い
	public String akinai;

	//学問
	public String gakumon;

	//行数
	public Integer count;

	public int getOmikuji_id() {
		return omikuji_id;
	}

	public void setOmikuji_id(int omikuji_id) {
		this.omikuji_id = omikuji_id;
	}

	public String getUnseiName() {
		return unseiName;
	}

	public void setUnseiName(String unseiName) {
		this.unseiName = unseiName;
	}

	public Date getUranaiDate() {
		return uranaiDate;
	}

	public void setUranaiDate(Date uranaiDate) {
		this.uranaiDate = uranaiDate;
	}

	public int getUnsei_id() {
		return unsei_id;
	}

	public void setUnsei_id(int unsei_id) {
		this.unsei_id = unsei_id;
	}

	public String getNegaigoto() {
		return negaigoto;
	}

	public void setNegaigoto(String negaigoto) {
		this.negaigoto = negaigoto;
	}

	public String getAkinai() {
		return akinai;
	}

	public void setAkinai(String akinai) {
		this.akinai = akinai;
	}

	public String getGakumon() {
		return gakumon;
	}

	public void setGakumon(String gakumon) {
		this.gakumon = gakumon;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}