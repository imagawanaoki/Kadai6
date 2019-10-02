package kadai6.form;

import org.seasar.struts.annotation.DateType;
import org.seasar.struts.annotation.Mask;
import org.seasar.struts.annotation.Required;
/**
 * 誕生日のみのアクションフォーム(入力チェックも行う)
 */
public class BirthdayForm {

	//誕生日の入力チェック
	@Required
	@DateType(datePattern = "yyyy-MM-dd")
	@Mask(mask = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$")
	public String birthday;

}
