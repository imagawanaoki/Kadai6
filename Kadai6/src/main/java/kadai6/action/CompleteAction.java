package kadai6.action;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import kadai6.form.CheckForm;

public class CompleteAction {

	//userInfo.jspで入力された値とおみくじ結果が格納されたCheckFormをDI

	@ActionForm
	@Resource
	protected CheckForm checkForm;


	@Execute(validator= false)
	public String complete() {

		//おみくじの結果と入力された情報が格納されたFormから値を受け取る

		String to = checkForm.strToday;
		String b = checkForm.birthday;
		String u = checkForm.unseiName;
		String n = checkForm.negaigoto;
		String a = checkForm.akinai;
		String g = checkForm.gakumon;

		String name = checkForm.name;
		String postal =checkForm.postalCode;
		String todo = checkForm.todouhuken;
		String siku = checkForm.sikutyouson;
		String tyou = checkForm.tyouikimei;
		String add = checkForm.address;
		String phone = checkForm.phoneNumber;
		String mail = checkForm.mailAddress;

		//メールで送信する処理が必要


		return "/complete.jsp";
	}
}
