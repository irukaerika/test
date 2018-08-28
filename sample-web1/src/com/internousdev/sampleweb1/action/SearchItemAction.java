package com.internousdev.sampleweb1.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb1.dao.MCategoryDAO;
import com.internousdev.sampleweb1.dao.ProductInfoDAO;
import com.internousdev.sampleweb1.dto.MCategoryDTO;
import com.internousdev.sampleweb1.dto.PaginationDTO;
import com.internousdev.sampleweb1.dto.ProductInfoDTO;
import com.internousdev.sampleweb1.util.InputChecker;
import com.internousdev.sampleweb1.util.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class SearchItemAction extends ActionSupport implements SessionAware{
	private String categoryId;
	private String keywords;
	private String pageNo;
	private List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
	private List<String> keywordsErrorMessageList = new ArrayList<String>();
	private List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
	private Map<String, Object> session;
	public String execute(){
		String result = ERROR;

		InputChecker inputChecker = new InputChecker();
		if(keywords == null){
			keywords="";
		}
		keywordsErrorMessageList = inputChecker.doCheck("検索ワード", keywords, 0, 16, true, true, true, true, false, true, true);

		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		switch (categoryId){
		case"1":
			productinfoDTOList = productInfoDAO.getProductInfoListAll(key)
		}

	}

}
