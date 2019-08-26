package kadai6.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Resultテーブルのエンティティクラス
 */

@Entity
public class Result extends Common{

	//占い日(主キー)
		@Id
		public Date uranai_date;

		//誕生日(主キー)
		@Id
		public Date birthday;

		//おみくじコード
		public Integer omikuji_id;

		//おみくじエンティティとの結合
		@ManyToOne
		@JoinColumn(name = "OMIKUJI_ID", referencedColumnName = "OMIKUJI_ID")
		public Omikuji omikuji;
	}


