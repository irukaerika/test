package com.internousdev.ecsite2.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;
import java.sql.SQLException;
import com.internousdev.ecsite2.dao.ItemDetailsDAO;
import com.internousdev.ecsite2.dto.ItemDetailsDTO;

public class UpdateItemAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	ItemDetailsDAO itemDetailsDAO = new ItemDetailsDAO();
	ItemDetailsDTO itemDetailsDTO = new ItemDetailsDTO();
	private String updateFlg;
	private String message;

	private String itemName;
	private String itemPrice;
	private String itemStock;
	private String id;

	public String execute() throws SQLException{
		String result = ERROR;
		if(updateFlg.equals("1")){
			update();
		}
		result = SUCCESS;
		return result;
	}
		public void update() throws SQLException{
			int res = itemDetailsDAO.updateItemDetails(itemName, itemPrice, itemStock, id);
			if(res > 0){
				setMessage("更新しました");
			}else {
				setMessage("更新に失敗しました");
			}
		}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public ItemDetailsDAO getItemDetailsDAO() {
		return itemDetailsDAO;
	}
	public void setItemDetailsDAO(ItemDetailsDAO itemDetailsDAO) {
		this.itemDetailsDAO = itemDetailsDAO;
	}
	public ItemDetailsDTO getItemDetailsDTO() {
		return itemDetailsDTO;
	}
	public void setItemDetailsDTO(ItemDetailsDTO itemDetailsDTO) {
		this.itemDetailsDTO = itemDetailsDTO;
	}
	public String getUpdateFlg() {
		return updateFlg;
	}
	public void setUpdateFlg(String updateFlg) {
		this.updateFlg = updateFlg;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemStock() {
		return itemStock;
	}
	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}




}
