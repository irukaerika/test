package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.UserListDAO;
import com.internousdev.ecsite2.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private UserListDAO userListDAO = new UserListDAO();
	private ArrayList<UserListDTO> userList = new ArrayList<UserListDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException{

			if(deleteFlg == null){

				userList = userListDAO.getUserListInfo();

			} else if(deleteFlg.equals("1")){
						delete();
			}
			String result = SUCCESS;
			return result;
		}
			public void delete() throws SQLException{

				int res = userListDAO.userHistoryDelete();

				if(res > 0){
					userList = null;
					setMessage("商品情報を正しく削除しました。");
				} else if(res == 0){
					setMessage("商品情報の削除に失敗しました。");
				}

			}

				public void setDeleteFlg(String deleteFlg) {
					this.deleteFlg = deleteFlg;

					}
				public String getDeleteFlg(){
					return deleteFlg;
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
			public ArrayList<UserListDTO> getUserListDTO() {
				return userList;
			}
			}