package kadai6.form;

import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Minlength;
/**
 * check.jspからcomplete．Actionに情報を送るためのフォーム
 *
 * @author n_imagawa
 *
 */
public class CheckForm {
	public String strToday;

	public String birthday;

	//運勢名
	public String unseiName;

	//願い事
	public String negaigoto;

	//商い
	public String akinai;

	//学問
	public String gakumon;

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

}
