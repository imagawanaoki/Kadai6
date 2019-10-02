package kadai6.entity;

import org.seasar.extension.jdbc.name.PropertyName;

import kadai6.entity.ResultNames._ResultNames;
import kadai6.entity.UnseiMasterNames._UnseiMasterNames;
/**
 *　おみくじエンティティのNamesクラス
 */
public class OmikujiNames {

	public static PropertyName<Integer> omikuji_id() {
        return new PropertyName<Integer>("omikuji_id");
    }

    public static PropertyName<Integer> unsei_id() {
        return new PropertyName<Integer>("unsei_id");
    }
    public static PropertyName<String> negaigoto() {
        return new PropertyName<String>("negaigoto");
    }
    public static PropertyName<String> akinai() {
        return new PropertyName<String>("akinai");
    }
    public static PropertyName<String> gakumon() {
        return new PropertyName<String>("gakumon");
    }
    public static _UnseiMasterNames unseiMaster() {
        return new _UnseiMasterNames("unseiMaster");
    }
    public static _ResultNames resultList() {
        return new _ResultNames("resultList");
    }



    public static class _OmikujiNames extends PropertyName<Omikuji> {


    	public _OmikujiNames() {
        }

        /**
         * インスタンスを構築します。
         *
         * @param name
         *            名前
         */
        public _OmikujiNames(final String name) {
            super(name);
        }

        /**
         * インスタンスを構築します。
         *
         * @param parent
         *            親
         * @param name
         *            名前
         */
        public _OmikujiNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }


        public  PropertyName<Integer> omikuji_id() {
            return new PropertyName<Integer>(this,"omikuji_id");
        }

        public PropertyName<Integer> unsei_id() {
            return new PropertyName<Integer>(this,"unsei_id");
        }
        public PropertyName<String> negaigoto() {
            return new PropertyName<String>(this,"negaigoto");
        }
        public PropertyName<String> akinai() {
            return new PropertyName<String>(this,"akinai");
        }
        public PropertyName<String> gakumon() {
            return new PropertyName<String>(this,"gakumon");
        }
        public _UnseiMasterNames unseiMaster() {
            return new _UnseiMasterNames("unseiMaster");
        }
        public _ResultNames resultList() {
            return new _ResultNames(this,"resultList");
        }


    }
}

