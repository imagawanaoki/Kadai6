package kadai6.entity;
import java.sql.Date;

import org.seasar.extension.jdbc.name.PropertyName;

import kadai6.entity.OmikujiNames._OmikujiNames;

/**
 * ResultエンティティのNamesクラス
 */

public class ResultNames {
	public static PropertyName<Date> uranai_date() {
        return new PropertyName<Date>("uranai_date");
    }

    public static PropertyName<Date> birthday() {
        return new PropertyName<Date>("birthday");
    }

    public static _OmikujiNames omikuji() {
        return new _OmikujiNames("omikuji");
    }

    public static _OmikujiNames omikuji_id() {
        return new _OmikujiNames("omikuji_id");
    }


    public static class _ResultNames extends PropertyName<Result> {

        /**
         * インスタンスを構築します。
         */
        public _ResultNames() {
        }

        /**
         * インスタンスを構築します。
         *
         * @param name
         *            名前
         */
        public _ResultNames(final String name) {
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
        public _ResultNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        public PropertyName<Date> uranai_date() {
            return new PropertyName<Date>(this,"uranai_date");
        }

        public PropertyName<Date> birthday() {
            return new PropertyName<Date>(this,"birthday");
        }

        public _OmikujiNames omikuji() {
            return new _OmikujiNames(this,"omikuji");
        }

        public _OmikujiNames omikuji_id() {
            return new _OmikujiNames(this,"omikuji_id");
        }

        /**
         * employeeのプロパティ名を返します。
         *
         * @return employeeのプロパティ名
         */
        public _OmikujiNames omikujiNames() {
            return new _OmikujiNames(this, "omikujiNames");
        }
    }

}

