package com.internousdev.ecsite2.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemDAO;
import com.internousdev.ecsite2.dao.LoginDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.internousdev.ecsite2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;
public class LoginAction extends ActionSupport implements SessionAware{
		private String loginId;
		private String loginPassword;
		private boolean adminFlg;
		private boolean loginFlg;
		private Map<String,Object>session;
		private LoginDAO loginDAO = new LoginDAO();
		private LoginDTO loginDTO = new LoginDTO();
		private BuyItemDAO buyItemDAO = new BuyItemDAO();

		public String execute(){
			String result = ERROR;
			loginDTO = loginDAO.getLoginUserInfo(loginId,loginPassword);
			session.put("loginUser",loginDTO);

				if(((LoginDTO)session.get("loginUser")).getAdminFlg()){
					result = SUCCESS;
				} else if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
						result = "login";

				BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
				session.put("loginId",loginDTO.getLoginId());
				session.put("id", buyItemDTO.getId());
				session.put("itemName", buyItemDTO.getItemName());
				session.put("itemPrice", buyItemDTO.getItemPrice());

				return result;
			}
			return result;
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
		@Override
		public void setSession(Map<String, Object>session){
			this.session = session;
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
		public boolean getLoginFlg() {
			return loginFlg;
		}
		public void setLoginFlg(boolean loginFlg) {
			this.loginFlg = loginFlg;
		}
}
