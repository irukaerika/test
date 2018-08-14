package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.AddItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class AddItemCompleteAction extends ActionSupport implements SessionAware{

		private String itemName;
		private String itemPrice;
		private String itemStock;
		public Map<String, Object> session;
		private AddItemCompleteDAO addItemCompleteDAO = new AddItemCompleteDAO();

		public String execute() throws SQLException{
			addItemCompleteDAO.addItemInfo(
							session.get("itemName").toString(),
							Integer.parseInt(session.get("itemPrice").toString()),
							 Integer.parseInt(session.get("itemStock").toString()));


			String result = SUCCESS;
			 return result;
		 }
		public String getItemName(){
			return itemName;
		}
		public void setItemName(String itemName){
			this.itemName = itemName;
		}
		public String getItemPrice(){
			return itemPrice;
		}
		public void setItemPrice(String itemPrice){
			this.itemPrice = itemPrice;
		}
		public String getItemStock(){
			return itemStock;
		}
		public void setItemStock(String itemStock){
			this.itemStock = itemStock;
		}
		@Override
		public void setSession(Map<String,Object> session){
			this.session = session;
		}
}
