package kadai6.dto;

import java.sql.Date;

public class CommonBean {

		//更新者
		private String update_user;

		//更新日
		private Date update_date;

		//作成者
		private String creater;

		//作成日
		private Date create_date;


		public String getUpdate_user() {
			return update_user;
		}

		public void setUpdate_user(String update_user) {
			this.update_user = update_user;
		}

		public Date getUpdate_date() {
			return update_date;
		}

		public void setUpdate_date(Date update_date) {
			this.update_date = update_date;
		}

		public String getCreater() {
			return creater;
		}

		public void setCreater(String creater) {
			this.creater = creater;
		}

		public Date getCreate_date() {
			return create_date;
		}

		public void setCreate_date(Date create_date) {
			this.create_date = create_date;
		}

}
