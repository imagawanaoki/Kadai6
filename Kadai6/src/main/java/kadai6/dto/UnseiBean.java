package kadai6.dto;
/**
 * 運勢テーブルのDTO
 * 各フィールドはsetter/getterメソッドを持つ
 *
 */
public class UnseiBean {

	//運勢名
	private String unsei_name;

	//運勢コード
	private Integer unsei_id;

	//占い日
	private Integer uranai_date;



	public Integer getUranai_date() {
		return uranai_date;
	}

	public void setUranai_date(Integer uranai_date) {
		this.uranai_date = uranai_date;
	}

	public Integer getUnsei_id() {
		return unsei_id;
	}

	public void setUnsei_id(Integer unsei_id) {
		this.unsei_id = unsei_id;
	}

	public String getUnsei_name() {
		return unsei_name;
	}

	public void setUnsei_name(String unsei_name) {
		this.unsei_name = unsei_name;
	}

}
