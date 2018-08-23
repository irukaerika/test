package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.ItemDetailsDAO;
import com.internousdev.ecsite2.dto.ItemDetailsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteItemAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private ItemDetailsDAO itemDetailsDAO = new ItemDetailsDAO();
	private ItemDetailsDTO itemDetailsDTO = new ItemDetailsDTO();
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

				int res = itemDetailsDAO.itemDetailsDelete(session.get("id").toString());

				if(res > 0){
					itemDetailsDTO = null;
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

			public void setItemDetailsDTO(ItemDetailsDTO itemDetailsDTO) {
				this.itemDetailsDTO = itemDetailsDTO;
			}
			public ItemDetailsDAO getUserDetailsDAO() {
				return itemDetailsDAO;
			}
			public void setItemDetailsDAO(ItemDetailsDAO itemDetailsDAO) {
				this.itemDetailsDAO = itemDetailsDAO;
			}
			public ItemDetailsDTO getUserDetailsDTO() {
				return itemDetailsDTO;
			}
	}