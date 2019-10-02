package kadai6.dto;


import javax.persistence.Id;

public class PrefecturesBean {

	@Id
	//ID
	public int id;

	//郵便番号
	public String postalCode;

	//都道府県
	public String todouhuken;

	//市区町村
	public String sikutyouson;

	//町域名
	public String tyouikimei;

	//住所
	public String address;

	//検索用住所
	private String addressName;

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getTodouhuken() {
		return todouhuken;
	}

	public void setTodouhuken(String todouhuken) {
		this.todouhuken = todouhuken;
	}

	public String getSikutyouson() {
		return sikutyouson;
	}

	public void setSikutyouson(String sikutyouson) {
		this.sikutyouson = sikutyouson;
	}

	public String getTyouikimei() {
		return tyouikimei;
	}

	public void setTyouikimei(String tyouikimei) {
		this.tyouikimei = tyouikimei;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

