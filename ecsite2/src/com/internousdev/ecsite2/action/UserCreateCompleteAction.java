package com.internousdev.ecsite2.action;
import java.sql.SQLException;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.internousdev.ecsite2.dao.UserCreateCompleteDAO;
import com.internousdev.ecsite2.dto.LoginDTO;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{

		private String loginId;
		private String loginPassword;
		private String userName;
		private boolean adminFlg;
		public Map<String, Object> session;
		private UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();
		private LoginDTO loginDTO = new LoginDTO();

		public String execute() throws SQLException{
			userCreateCompleteDAO.createUser(session.get("loginId").toString(),
							session.get("loginPassword").toString(),
							session.get("userName").toString(),adminFlg);

			String result = SUCCESS;
			 return result;
		 }
		public LoginDTO getLoginDTO(){
			return loginDTO;
		}
		public void setLoginDTO(LoginDTO loginDTO){
			this.loginDTO = loginDTO;
		}
		public String getLoginId(){
			return loginId;
		}
		public void setLoginId(String loginId){
			this.loginId = loginId;
		}
		public String getLoginPassword(){
			return loginPassword;
		}
		public void setLoginPassword(String loginPassword){
			this.loginPassword = loginPassword;
		}
		public String getUserName(){
			return userName;
		}
		public void setUserName(String userName){
			this.userName = userName;
		}
		public boolean getAdminFlg(){
			return adminFlg;
		}
		public void setAdminFlg(boolean adminFlg){
			this.adminFlg = adminFlg;
		}
		@Override
		public void setSession(Map<String,Object> session){
			this.session = session;
		}
}
