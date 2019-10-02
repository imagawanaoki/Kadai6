package kadai6.dto;
/**
 * 外部ファイルで検索した結果を受け取るDTO
 */
public class GetOmikujiResultDto {

	public String unsei_name;
	public String gakumon;
	public String negaigoto;
	public String akinai;
	public Integer unsei_id;


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
	public Integer getUnsei_id() {
		return unsei_id;
	}
	public void setUnsei_id(Integer unsei_id) {
		this.unsei_id = unsei_id;
	}
}
