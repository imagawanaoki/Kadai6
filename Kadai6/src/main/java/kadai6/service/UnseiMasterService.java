package kadai6.service;

import kadai6.dto.UnseiBean;
import kadai6.entity.Unseimaster;

/**
 * UnseiMsterエンティティに対する操作を格納するクラス
 *
 */
public class UnseiMasterService extends AbstractService<Unseimaster>{

		//運勢名の取得等運勢に関する処理を行う

	/**
	 * 運勢コードから運勢名を取得するメソッド
	 * @param unsei_id	運勢コード
	 * @param unsei_name 運勢名
	 * @return unseiBean	運勢コードと運勢名が入ったDTO
	 */
	public UnseiBean findByUnseiId(int unsei_id, String unsei_name) {

		//運勢コードから運勢名を検索し、エンティティ型の変数に格納

		 Unseimaster unsei = jdbcManager
				 .from(Unseimaster.class)
				 .eager(unsei_name)
				.id(unsei_id)
				.getSingleResult();

		//運勢コードと運勢名格納してreturnする

		UnseiBean unseiBean = new UnseiBean();
		unseiBean.setUnsei_id(unsei.unsei_id);
		unseiBean.setUnsei_name(unsei.unsei_name);


		return unseiBean;
	}


}

