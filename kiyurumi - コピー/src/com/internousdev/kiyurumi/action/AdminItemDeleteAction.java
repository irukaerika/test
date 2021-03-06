package com.internousdev.kiyurumi.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.kiyurumi.dao.ProductInfoDAO;
import com.internousdev.kiyurumi.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminItemDeleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private Collection<String> checkList;
	private String id;
	private String productId;
	private String productName;
	private String productNameKana;
	private String productDescription;
	private String categoryId;
	private String price;
	private String imageFilePath;
	private String imageFileName;
	private String birthDate;
	private String birthPlace;
	private String status;
	private Date updateDate;
	private Date registDate;

	List<ProductInfoDTO> productInfoDTOList=new ArrayList<ProductInfoDTO>();

	public String execute(){
		String result=SUCCESS;
		ProductInfoDAO productInfoDAO=new ProductInfoDAO();
		int count=0;

		//checkされないままボタンが押されたら、のエラーメッセージ//
		List<String> checkListErrorMessageList=new ArrayList<String>();

		if(checkList==null){
			checkListErrorMessageList.add("チェックされていません。");
			session.put("checkListErrorMessageList",checkListErrorMessageList);
			productInfoDTOList = productInfoDAO.itemAllList();
			Iterator<ProductInfoDTO> iterator = productInfoDTOList.iterator();
			if (!(iterator.hasNext())) { // 次のデータがある場合true
				productInfoDTOList = null;
			}
			session.put("productInfoDTOList", productInfoDTOList);
			return SUCCESS;
		}

		//checkされていたときの削除処理//
		for(String id:checkList){
			count += productInfoDAO.itemDelete(Integer.parseInt(id));
		}
		if(count<=0){
			checkListErrorMessageList.add("チェックされていません。");
			session.put("checkListErrorMessageList",checkListErrorMessageList);
			result = SUCCESS;
		} else {
			result = SUCCESS;
		}

		session.remove("checkListErrorMessageList");

			// List型のProductInfoDTOにArrayListで生成したインスタンスを格納
		productInfoDTOList = productInfoDAO.itemAllList();
		Iterator<ProductInfoDTO> iterator = productInfoDTOList.iterator();
		if (!(iterator.hasNext())) { // 次のデータがある場合true
			productInfoDTOList = null;
		}
		session.put("productInfoDTOList", productInfoDTOList);
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Collection<String> getCheckList() {
		return checkList;
	}

	public void setCheckList(Collection<String> checkList) {
		this.checkList = checkList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductNameKana() {
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public List<ProductInfoDTO> getProductInfoDTOList() {
		return productInfoDTOList;
	}

	public void setProductInfoDTOList(List<ProductInfoDTO> productInfoDTOList) {
		this.productInfoDTOList = productInfoDTOList;
	}

}