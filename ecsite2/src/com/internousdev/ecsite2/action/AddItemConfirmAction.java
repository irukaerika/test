package com.internousdev.ecsite2.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AddItemConfirmAction extends ActionSupport implements SessionAware{

		private String itemName;
		private String itemPrice;
		private String itemStock;
		public Map<String,Object> session;
		private String errorMassage;

		public String execute(){
			String result = SUCCESS;
				session.put("itemPrice",itemPrice);
				int intItemPrice = Integer.parseInt(session.get("itemPrice").toString());
				session.put("itemStock",itemStock);
				int intItemStock = Integer.parseInt(session.get("itemStock").toString());
				session.put("total_price",intItemPrice * intItemStock);
			if(!(itemName.equals(""))
					&&!(itemPrice.equals(""))
					&&!(itemStock.equals(""))){
						session.put("itemName",itemName);
						session.put("itemPrice",itemPrice);
						session.put("itemStock",itemStock);

			} else{
						setErrorMassage("未入力の項目があります。");
						result = ERROR;
			}
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
		public String getErrorMassage(){
			return errorMassage;
		}
		public void setErrorMassage(String errorMassage){
			this.errorMassage = errorMassage;
		}
}