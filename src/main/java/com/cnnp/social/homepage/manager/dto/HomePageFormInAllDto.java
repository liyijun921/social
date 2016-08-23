package com.cnnp.social.homepage.manager.dto;



public class HomePageFormInAllDto {
	
	private String SUBCARD_TYPE; //栏目id
	private String SUBCARD_ZH;//
	private String SUBCARD_INDEX;//
	private String METHOD;//用户id
	private String CONTENT_TYPE;//创建时间	
	private String SUBCARD_MORE_URL;//日程类型
	private String SUBCARD_ISMORE;//责任人
	private String URL;//日程类型
	private String PAYLOAD;//日程类型
	private String QueryString;//日程类型
	private String CODE;
	public String getSUBCARD_TYPE() {
		return SUBCARD_TYPE;
	}

	public void setSUBCARD_TYPE(String SUBCARD_TYPE) {
		this.SUBCARD_TYPE = SUBCARD_TYPE;
	}
	public String getSUBCARD_ZH() {
		return SUBCARD_ZH;
	}

	public void setSUBCARD_ZH(String SUBCARD_ZH) {
		this.SUBCARD_ZH = SUBCARD_ZH;
	}

	public String getSUBCARD_INDEX() {
		return SUBCARD_INDEX;
	}

	public void setSUBCARD_INDEX(String SUBCARD_INDEX) {
		this.SUBCARD_INDEX = SUBCARD_INDEX;
	}

	public String getMETHOD() {
		return METHOD;
	}

	public void setMETHOD(String METHOD) {
		this.METHOD = METHOD;
	}

	public String getCONTENT_TYPE() {
		return CONTENT_TYPE;
	}

	public void setCONTENT_TYPE(String CONTENT_TYPE) {
		this.CONTENT_TYPE = CONTENT_TYPE;
	}

	public String getSUBCARD_MORE_URL() {
		return this.SUBCARD_MORE_URL;
	}

	public void setSUBCARD_MORE_URL(String SUBCARD_MORE_URL) {
		this.SUBCARD_MORE_URL = SUBCARD_MORE_URL;
	}

	public String getSUBCARD_ISMORE() {
		return this.SUBCARD_ISMORE;
	}

	public void setSUBCARD_ISMORE(String SUBCARD_ISMORE) {
		this.SUBCARD_ISMORE = SUBCARD_ISMORE;
	}
	public String getURL() {
		return this.URL;
	}

	public void setURL(String URL) {
		this.URL = URL;
	}
	
	public String getPAYLOAD() {
		return PAYLOAD;
	}

	public void setPAYLOAD(String PAYLOAD) {
		this.PAYLOAD = PAYLOAD;
	}
	public String getQueryString() {
		return QueryString;
	}

	public void setQueryString(String QueryString) {
		this.QueryString = QueryString;
	}
	public String getCode() {
		return CODE;
	}

	public void setCode(String CODE) {
		this.CODE = CODE;
	}
}
