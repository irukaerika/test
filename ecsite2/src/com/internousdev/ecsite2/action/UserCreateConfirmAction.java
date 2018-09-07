package com.internousdev.ecsite2.action;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{

		private String userId;
		private String password;
		private String userName;
		//管理者が使うとき
		private boolean adminFlg;
		public Map<String,Object> session;
		private String errorMessage;

		public String execute(){
			String result = SUCCESS;
			if(!(userId.equals(""))
					&&!(password.equals(""))
					&&!(userName.equals(""))){
						session.put("userId",userId);
						session.put("password",password);
						session.put("userName",userName);
						session.put("adminFlg", adminFlg);

			} else{
						setErrorMessage("未入力の項目があります。");
						result = ERROR;
			}
			return result;
		}

		public String getUserId(){
			return userId;
		}
		public void setUserId(String userId){
			this.userId = userId;
		}
		public String getPassword(){
			return password;
		}
		public void setPassword(String password){
			this.password = password;
		}
		public String getUserName(){
			return userName;
		}
		public void setUserName(String userName){
			this.userName = userName;
		}
		@Override
		public void setSession(Map<String,Object> session){
			this.session = session;
		}
		public String getErrorMessage(){
			return errorMessage;
		}
		public void setErrorMessage(String errorMessage){
			this.errorMessage = errorMessage;
		}
		public Map<String, Object> getSession() {
			return session;
		}

		public boolean getAdminFlg() {
			return adminFlg;
		}

		public void setAdminFlg(boolean adminFlg) {
			this.adminFlg = adminFlg;
		}

}