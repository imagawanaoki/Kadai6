package kadai6.dto;
/**
 * 外部ファイルで検索した結果を受け取るDTO
 */
public class HalfYearResultDto {

	public String unsei_name;
	public String gakumon;
	public String negaigoto;
	public String akinai;
	public Integer uranai_date;


	public String getUnsei_name() {
		return unsei_name;
	}
	public void setUnsei_name(String unsei_name) {
		this.unsei_name = unsei_name;
	}
	public String getGakumon() {
		return gakumon;
	}
	public void setGakumon(String gakumon) {
		this.gakumon = gakumon;
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
	public Integer getUranai_date() {
		return uranai_date;
	}
	public void setUranai_date(Integer uranai_date) {
		this.uranai_date = uranai_date;
	}

}
