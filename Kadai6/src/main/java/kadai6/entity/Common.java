package kadai6.entity;

import java.sql.Date;

import javax.persistence.MappedSuperclass;
@MappedSuperclass
/**
*各テーブルに共通するカラムの抽象クラスエンティティ
*
* @author i_imagawa
*
*/
public abstract class Common {

	//更新者
	public String update_user;

	//更新日
	public Date update_date;

	//作成者
	public String creater;

	//作成日
	public Date create_date;
}