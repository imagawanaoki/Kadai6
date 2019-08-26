package kadai6.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
/**
 * おみくじテーブルのエンティティクラス
 */
@Entity
public class Omikuji extends Common {

	//おみくじコード(主キー)
	@Id
	public Integer omikuji_id;

	//運勢コード
	public Integer unsei_id;

	//願い事
	public String negaigoto;

	//商い
	public String akinai;

	//学問
	public String gakumon;

	//結果エンティティとの結合
		@OneToMany(mappedBy = "omikuji")
		public List<Result> resultList;

		//運勢エンティティとの結合
		//結合していることにより、unseiMasterの情報が取れる
		@ManyToOne
		@JoinColumn(name = "UNSEI_ID", referencedColumnName = "UNSEI_ID")
		public Unseimaster unseiMaster;
}