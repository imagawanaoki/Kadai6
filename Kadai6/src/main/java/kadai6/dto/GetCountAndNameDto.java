package kadai6.dto;
/**
 * 外部ファイルで検索した結果を受け取るDTO
 */
public class GetCountAndNameDto {

	public Integer count;
	public String unsei_name;


	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getUnsei_name() {
		return unsei_name;
	}
	public void setUnsei_name(String unsei_name) {
		this.unsei_name = unsei_name;
	}

}
