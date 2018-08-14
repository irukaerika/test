package com.internousdev.ecsite2.dto;

public class UserListDTO {
	public String id;
	public String userId;
	public String password;
	public String userName;

	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId = userId;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
}