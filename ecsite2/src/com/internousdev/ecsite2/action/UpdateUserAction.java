package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.UserDetailsDAO;
import com.internousdev.ecsite2.dto.UserDetailsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateUserAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	 UserDetailsDAO userDetailsDAO = new UserDetailsDAO();
	UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
	private String updateFlg;
	private String message;

	private String id;
	private String userId;
	private String password;
	private String userName;


	public String execute() throws SQLException{

		String result = ERROR;
			 if(updateFlg.equals("1")){
						update();
			}
			result = SUCCESS;
			return result;
		}

			public void update() throws SQLException{
				int res = userDetailsDAO.updateUserDetails(userId,
						password,
						userName,
						id);

				System.out.println(userId);
				System.out.println(password);

//							session.put("userId",userId);
//							session.put("password",password);
//							session.put("userName",userName);
//				}
				if(res>0){
                       setMessage("更新しました");
				} else {
					setMessage("更新に失敗しました");
				}

				/*session.put("userId", userId);
				session.put("password", password);
				session.put("userName", userName);
				int res = userDetailsDAO.updateUserDetails(session.get("userId").toString(),
						session.get("password").toString(),
						session.get("userName").toString(),
						session.get("id").toString());



				if(res > 0){
					setMessage("更新しました。");
				} else if(res == 0){
					setMessage("更新に失敗しました。");
				}*/

			}
			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getUserId() {
				return userId;
			}

			public void setUserId(String userId) {
				this.userId = userId;
			}

			public String getPassword() {
				return password;
			}

			public void setPassword(String password) {
				this.password = password;
			}

			public String getUserName() {
				return userName;
			}

			public void setUserName(String userName) {
				this.userName = userName;
			}

			public UserDetailsDTO getUserDetailsDTO() {
				return userDetailsDTO;
			}
				public void setUpdateFlg(String updateFlg) {
					this.updateFlg = updateFlg;
					}
				public String getUpdateFlg(){
					return updateFlg;
				}
				public String getMessage(){
					return message;
				}
				public void setMessage(String message){
					this.message = message;
				}
		@Override
			public void setSession(Map<String, Object> session) {
				this.session = session;
			}
			public Map<String, Object> getSession() {
				return session;
			}

			public void setUserDetailsDTO(UserDetailsDTO userDetailsDTO) {
				this.userDetailsDTO = userDetailsDTO;
			}
			public UserDetailsDAO getUserDetailsDAO() {
				return userDetailsDAO;
			}
			public void setUserDetailsDAO(UserDetailsDAO userDetailsDAO) {
				this.userDetailsDAO = userDetailsDAO;
			}


	}