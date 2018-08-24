package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.UserDetailsDAO;
import com.internousdev.ecsite2.dto.UserDetailsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteUserDetailsAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private UserDetailsDAO userDetailsDAO = new UserDetailsDAO();
	private UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
	private String deleteFlg;
	private String message;
	private String errorMessage;


	public String execute() throws SQLException{

		String result = ERROR;
			 if(deleteFlg.equals("1")){
						delete();
			}
			result = SUCCESS;
			return result;
		}

			public void delete() throws SQLException{

				int res = userDetailsDAO.userDetailsDelete(session.get("loginId").toString());

				if(res > 0){
					userDetailsDTO = null;
					setMessage("削除しました。");
				} else if(res == 0){
					setMessage("削除に失敗しました。");
				}

			}

				public void setDeleteFlg(String deleteFlg) {
					this.deleteFlg = deleteFlg;
					}
				public String getDeleteFlg(){
					return deleteFlg;
				}
				public String getErrorMessage() {
					return errorMessage;
				}
				public void setErrorMessage(String errorMessage) {
					this.errorMessage = errorMessage;
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
			public UserDetailsDTO getUserDetailsDTO() {
				return userDetailsDTO;
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