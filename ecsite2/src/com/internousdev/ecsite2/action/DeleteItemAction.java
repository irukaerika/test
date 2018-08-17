package com.internousdev.ecsite2.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
public class DeleteItemAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private String deleteFlg;

	if(deleteFlg == "2"){
		delete();
	}
	public void delete() throws SQLException{
		int res = deleteItemDAO.itemDelete();

	}

}
