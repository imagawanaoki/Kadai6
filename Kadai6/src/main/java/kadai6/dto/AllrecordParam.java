package kadai6.dto;

import java.sql.Date;
/**
 * 過去半年のすべてのレコードを検索する際に使用する外部ファイルに値を埋め込むためのパラメータクラス
 */
public class AllrecordParam {

	public Date herfYearAgo;
	public Date today;
}
