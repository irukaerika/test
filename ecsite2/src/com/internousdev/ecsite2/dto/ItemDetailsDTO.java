package com.internousdev.ecsite2.dto;

public class ItemDetailsDTO {
	private String id;
	private String itemName;
	private String itemPrice;
	private String itemStock;


	public String getId() {
		return id;
	}
	public void setItemId(String id) {
		this.id = id;
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
}