package com.internousdev.ecsite2.action;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.UserDetailsDAO;
import com.internousdev.ecsite2.dto.UserDetailsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDetailsAction extends ActionSupport implements SessionAware{
	private String id;
	private String loginId;
	private String password;
	private String userName;
	UserDetailsDAO userDetailsDAO = new UserDetailsDAO();
	UserDetailsDTO userDetailsDTO = new UserDetailsDTO();

	private Map<String, Object> session;
	public String execute() {
		String result = ERROR;
		UserDetailsDAO userDetailsDAO = new UserDetailsDAO();
		UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
		userDetailsDTO = userDetailsDAO.getItemDetailsInfo(id);

		session.put("id", userDetailsDTO.getId());
		session.put("userId", userDetailsDTO.getUserId());
		session.put("password", userDetailsDTO.getPassword());
		session.put("userName", userDetailsDTO.getUserName());

			result = SUCCESS;
		return result;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

