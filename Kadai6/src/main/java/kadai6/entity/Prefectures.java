package kadai6.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

	@Entity
	public class Prefectures {


			@Id
			//そのファイルのid
			public int id;
	 		//郵便番号
			public String postalcode;

			//都道府県
			public String todouhuken;

			//市区町村
			public String sikutyouson;

			//町域名
			public String tyouikimei;
		}


