package com.internousdev.ecsite2.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import com.internousdev.ecsite2.dao.MyPageDAO;
import com.internousdev.ecsite2.dto.MyPageDTO;

public class MyPageAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private MyPageDAO myPageDAO = new MyPageDAO();
	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException{
		if(!session.containsKey("id")){
			return ERROR;
		}

		if(deleteFlg == null){
			String buy_item_id = session.get("id").toString();
			String buy_login_id = session.get("loginId").toString();
			myPageList = myPageDAO.getMyPageUserInfo(buy_item_id, buy_login_id);
		} else if(deleteFlg.equals("1")){
					delete();
		}
		String result = SUCCESS;
		return result;
	}
		public void delete() throws SQLException{
			String buy_item_id = session.get("id").toString();
			String buy_login_id = session.get("loginId").toString();

			int res = myPageDAO.buyItemHistoryDelete(buy_item_id, buy_login_id);

			if(res > 0){
				myPageList = null;
				setMessage("商品情報を正しく削除しました。");
			} else if(res == 0){
				setMessage("商品情報の削除に失敗しました。");
			}
		}
		public void setDeleteFlg(String deleteFlg) {
			this.deleteFlg = deleteFlg;

			}
			@Override
			public void setSession(Map<String, Object> session) {
				this.session = session;
			}
			public ArrayList<MyPageDTO> getMyPageList() {
				return this.myPageList;
			}
			public String getMessage() {
				return this.message;
			}
			public void setMessage(String message) {
				this.message = message;
			}
}