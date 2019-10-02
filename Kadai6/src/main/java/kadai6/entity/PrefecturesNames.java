package kadai6.entity;


	import org.seasar.extension.jdbc.name.PropertyName;


	/**
		 * PrefecturesエンティティのNamesクラス
		 *
		 */
	public class PrefecturesNames {

			/**
			 * idのプロパティ名を返すメソッド
			 *
			 * @return	idのプロパティ名
			 */
			public static PropertyName<Integer> id(){

				return new PropertyName<Integer>("id");
			}

			/**
			 * postalCodeのプロパティ名を返すメソッド
			 *
			 * @return	postalCodeのプロパティ名
			 */
			public static PropertyName<String> postalcode(){

				return new PropertyName<String>("postalcode");
			}

			/**
			 * todouhukenのプロパティ名を返すメソッド
			 *
			 * @return	todouhukenのプロパティ名
			 */
			public static PropertyName<String> todouhuken(){
				return new PropertyName<String>("todouhuken");
			}

			/**
			 * sikutyousonのプロパティ名を返すメソッド
			 *
			 * @return	sikutyousonのプロパティ名
			 */
			public static PropertyName<String> sikutyouson(){
				return new PropertyName<String>("sikutyouson");
			}

			/**
			 * addressのプロパティ名を返すメソッド
			 *
			 * @return	addressのプロパティ名
			 */
			public static PropertyName<String> tyouikimei(){
				return new PropertyName<String>("tyouikimei");
			}

			/**
			 * sikutyousonEscaperのプロパティ名を返すメソッド
			 *検索用の市区町村名
			 * @return	cityEscaperのプロパティ名
			 */
			public static PropertyName<String> sikutyousonSearcher(){
				return new PropertyName<String>("sikutyousonSearcher");
			}

			/**
			 * tyouikimeiEscaperのプロパティ名を返すメソッド
			 *検索用の町域名
			 * @return	tyouikimeiEscaperのプロパティ名
			 */
			public static PropertyName<String> tyoukimeiSearcher(){
				return new PropertyName<String>("tyouikimeiSearcher");
			}

			/**
			 * インスタンス構築とプロパティ名を返却のクラス
			 *
			 */
			public static class _AddressNames extends PropertyName<Prefectures>{


				public _AddressNames() {

				}

				/**
				 * @param name		名前
				 */
				public _AddressNames(final String name) {
					super(name);
				}

				/**
				 * インスタンスを構築します
				 * @param parent	親
				 * @param name		名前
				 */
				public _AddressNames(final PropertyName<?> parent, final String name) {
					super(parent, name);
				}

				/**
				 * idのプロパティ名を返すメソッド
				 * @return	idのプロパティ名
				 */
				public PropertyName<Integer> id(){
					return new PropertyName<Integer>(this, "id");
				}

				/**
				 * postalCodeのプロパティ名を返すメソッド
				 *
				 * @return	postalCodeのプロパティ名
				 */
				public PropertyName<String> postalcode(){
					return new PropertyName<String>(this, "postalcode");
				}

				/**
				 * todouhukenのプロパティ名を返すメソッド
				 *
				 * @return	todouhukenのプロパティ名
				 */
				public PropertyName<String> todouhuken(){
					return new PropertyName<String>(this, "todouhuken");
				}

				/**
				 * sikutyousonのプロパティ名を返すメソッド
				 *
				 * @return	sikutyousonのプロパティ名
				 */
				public PropertyName<String> sikutyouson(){
					return new PropertyName<String>(this, "sikutyouson");
				}

				/**
				 * tyouikimeiのプロパティ名を返すメソッド
				 *
				 * @return	tyouikimeiのプロパティ名
				 */
				public PropertyName<String> tyouikimei(){
					return new PropertyName<String>(this, "tyouikimei");
				}

				/**
				 * sikutyousonEscaperのプロパティ名を返すメソッド
				 *検索用の市区町村名
				 * @return	sikutyousonEscaperのプロパティ名
				 */
				public PropertyName<String> sikutyousonSearcher(){
					return new PropertyName<String>(this, "sikutyousonSearcher");
				}

				/**
				 * tyouikimeiEscaperのプロパティ名を返すメソッド
				 *検索用の町域名
				 * @return	tyouikimeiEscaperのプロパティ名
				 */
				public PropertyName<String> tyouikimeiSearcher(){
					return new PropertyName<String>(this, "tyouikimeiSearcher");
				}

		}

	}

