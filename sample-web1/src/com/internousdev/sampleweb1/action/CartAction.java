package com.internousdev.sampleweb1.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb1.dao.CartInfoDAO;
import com.internousdev.sampleweb1.dao.MCategoryDAO;
import com.internousdev.sampleweb1.dao.McategoryDAO;
import com.internousdev.sampleweb1.dto.CartInfoDTO;
import com.internousdev.sampleweb1.dto.McategoryDTO;
import com.opensymphony.xwork2.ActionSupport;
public class CartAction extends ActionSupport implements SessionAware{
	private String categoryId;
	private String keywords;
	private List<MCategoryDTO> mCategoryDTOList = new ArrayList<McategoryDTO>();
	private Map<String, Object> session;
	public String execute(){
		String result = ERROR;
		String userId = null;
		CartInfoDAO cartInfoDao = new CartInfoDAO();
		List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();
		if(session.containsKey("userId")){
			userId = String.calueOf(session.get("userId"));
		} else if (session.containsKey("tempUserId")){
			userId = String .valueOf(session.get("tempUserId"));
		}
		cartInfoDtoList = cartInfoDao.getCartInfoDtoList(userId);
		Iterator<CartInfoDTO> iterator = cartInfoDtoList.iterator();
		if(!(iterator.hasNext())){
			cartInfoDtoList = null;
		}
		session.put("cartInfoDtoList", cartInfoDtoList);

		int totalPrice = Integer.parseInt(String.valueOf(cartInfoDao.getTotalPrice(userId)));
		session.put("totalPrice", totalPrice);
		result = SUCCESS;

		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}
	return result;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public List<MCategoryDTO> getmCategoryDTOList() {
		return mCategoryDTOList;
	}
	public void setmCategoryDTOList(List<MCategoryDTO> mCategoryDTOList) {
		this.mCategoryDTOList = mCategoryDTOList;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
