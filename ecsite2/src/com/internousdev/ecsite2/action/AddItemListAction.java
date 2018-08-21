package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.AddItemListDAO;
import com.internousdev.ecsite2.dto.AddItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AddItemListAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private AddItemListDAO addItemListDAO = new AddItemListDAO();
	private ArrayList<AddItemListDTO> addItemListDTO = new ArrayList<AddItemListDTO>();
	private String deleteFlg;
	private String message;
	private String noAddItemMessage;


	public String getNoAddItemMessage() {
		return noAddItemMessage;
	}
	public void setNoAddItemMessage(String noAddItemMessage) {
		this.noAddItemMessage = noAddItemMessage;
	}
	public String execute() throws SQLException{

			if(deleteFlg == null){

				addItemListDTO = addItemListDAO.getAllItemListInfo();
				 if(addItemListDTO.isEmpty()){
						setNoAddItemMessage("商品一覧がありません。");
					}

			} else if(deleteFlg.equals("1")){
						delete();
			}
			String result = SUCCESS;
			return result;
		}
	public void delete() throws SQLException{

		int res = addItemListDAO.itemHistoryDelete();

		if(res > 0){
			addItemListDTO = null;
			setMessage("商品情報を正しく削除しました。");
		} else if(res == 0){
			setMessage("商品情報の削除に失敗しました。");
		}

	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public AddItemListDAO getAddItemListDAO() {
		return addItemListDAO;
	}
	public void setAddItemListDAO(AddItemListDAO addItemListDAO) {
		this.addItemListDAO = addItemListDAO;
	}
	public ArrayList<AddItemListDTO> getAddItemListDTO() {
		return addItemListDTO;
	}
	public void setAddItemListDTO(ArrayList<AddItemListDTO> addItemListDTO) {
		this.addItemListDTO = addItemListDTO;
	}
	public String getDeleteFlg() {
		return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}


			}