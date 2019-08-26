package kadai6.entity;

import org.seasar.extension.jdbc.name.PropertyName;

import kadai6.entity.OmikujiNames._OmikujiNames;

/**
 * UnseiMasterエンティティのNamesクラス
 */
public class UnseiMasterNames {
	public static PropertyName<Integer> unsei_id() {
        return new PropertyName<Integer>("unsei_id");
    }

    public static PropertyName<String> unsei_name() {
        return new PropertyName<String>("unsei_name");
    }

    public static _OmikujiNames omikujiList() {
        return new _OmikujiNames("omikujiList");
    }


    public static class _UnseiMasterNames extends PropertyName<Unseimaster> {

        /**
         * インスタンスを構築します。
         */
        public  _UnseiMasterNames() {

        }

        /**
         * インスタンスを構築します。
         *
         * @param name 名前
         */
        public _UnseiMasterNames(final String name) {
            super(name);
        }

        /**
         * インスタンスを構築します。
         *
         * @param parent 親
         * @param name 名前
         */
        public _UnseiMasterNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        public PropertyName<Integer> unsei_id() {
            return new PropertyName<Integer>(this,"unsei_id");
        }

        public  PropertyName<String> unsei_name() {
            return new PropertyName<String>(this,"unsei_name");
        }

        public  _OmikujiNames omikujiList() {
            return new _OmikujiNames(this,"omikujiList");
        }
    }

}

