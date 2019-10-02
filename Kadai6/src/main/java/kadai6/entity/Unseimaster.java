package kadai6.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * UnseiMasterのエンティティクラス
 */
@Entity
public class Unseimaster extends Common {

	@Id

	//運勢コード
	public Integer unsei_id;

	//運勢名
	public String unsei_name;

	//おみくじエンティティとの結合
		@OneToMany(mappedBy = "unseiMaster")
		public List<Omikuji> omikujiList;


}
