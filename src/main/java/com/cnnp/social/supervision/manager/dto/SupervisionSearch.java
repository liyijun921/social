package com.cnnp.social.supervision.manager.dto;

public class SupervisionSearch {
	private String responsibleSN; //责任人员工号
	private String accountableSN; //责任领导员工号
	private String searchBeginDate; //督办计划完成日期 - 开始日期
	private String searchEndDate;//督办计划完成日期 - 完成日期
	private String areaCode;//督办领域
	private String source;//督办来源
	private String scope;//督办范围
	public String getResponsibleSN() {
		return responsibleSN;
	}
	public void setResponsibleSN(String responsibleSN) {
		this.responsibleSN = responsibleSN;
	}
	public String getAccountableSN() {
		return accountableSN;
	}
	public void setAccountableSN(String accountableSN) {
		this.accountableSN = accountableSN;
	}
	public String getSearchBeginDate() {
		return searchBeginDate;
	}
	public void setSearchBeginDate(String searchBeginDate) {
		this.searchBeginDate = searchBeginDate;
	}
	public String getSearchEndDate() {
		return searchEndDate;
	}
	public void setSearchEndDate(String searchEndDate) {
		this.searchEndDate = searchEndDate;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	
	
}
