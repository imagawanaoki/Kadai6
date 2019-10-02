package kadai6.dto;

import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Minlength;
/**
 *  入力された情報を格納するDTO
 *
 * @author n_imagawa
 *
 */
public class UserInfoDto {

	//名前
	public String name;

	//郵便番号
	@Minlength(minlength = 7)
	@Maxlength(maxlength = 7)
	public String postalCode;

	//都道府県
	public String todouhuken;

	//市区町村
	public String sikutyouson;

	//町域名
	public String tyouikimei;

	//住所
	public String address;

	//電話番号
	public String phoneNumber;

	//メールアドレス
	public String mailAddress;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

}
