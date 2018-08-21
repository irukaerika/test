package com.internousdev.ecsite2.action;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.ItemDetailsDAO;
import com.internousdev.ecsite2.dto.ItemDetailsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDetailsAction extends ActionSupport implements SessionAware{
	private String id;
	private String itemName;
	private String itemPrice;
	private String itemStock;
	ItemDetailsDAO itemDetailsDAO = new ItemDetailsDAO();
	ItemDetailsDTO itemDetailsDTO = new ItemDetailsDTO();

	public Map<String, Object> session;
	public String execute() {
		String result = ERROR;
		ItemDetailsDAO itemDetailsDAO = new ItemDetailsDAO();
		ItemDetailsDTO itemDetailsDTO = new ItemDetailsDTO();
		itemDetailsDTO = itemDetailsDAO.getItemDetailsInfo(id);

		session.put("id", itemDetailsDTO.getId());
		session.put("itemName", itemDetailsDTO.getItemName());
		session.put("itemPrice", itemDetailsDTO.getItemPrice());
		session.put("itemStock", itemDetailsDTO.getItemStock());

			result = SUCCESS;
		return result;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

