package com.internousdev.sampleweb1.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb1.dao.CartInfoDAO;
import com.internousdev.sampleweb1.dao.McategoryDAO;
import com.internousdev.sampleweb1.dto.CartInfoDTO;
import com.internousdev.sampleweb1.dto.McategoryDTO;
import com.opensymphony.xwork2.ActionSupport;
public class CartAction extends ActionSupport implements SessionAware{
	private String categoryId;
	private String keywords;
	private List<MCategoryDTO> mCategoryDTOList = new ArrayList<Mcat>
}
