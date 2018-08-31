package com.internousdev.sampleweb1.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserAction extends ActionSupport implements SessionAware{
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private List<String> sexList = new ArrayList<String>();
	private String email;
	private String userId;
	private String password;
	private static final String MALE = "男性";
	private static fainal String FEMALE = "女性";
	private String defaultSexValue = MALE;
	private String categoryId;
	private Map<String, Object> session;
	public String execute(){
		String result = ERROR;

		session.remove("familyNameErrorMessageList");
		session.remove("firstNameErrorMessageList");
		session.remove("famimyNameKanaErrorMessageList");
		session.remove("firstNameKanaErrorMessageList");
		session.remove("emailErrorMessageList");
		session.remove("telNumberErrorMessageList");
		session.remove("userAddressErrorMessageList");

		session.put("familyName", familyName);
		session.put("firstName", firstName);
		session.put("familyNameKana", familyNameKana);
		session.put("firstNameKana", firstNameKana);

		if(sex==null){

		}

	}

}
