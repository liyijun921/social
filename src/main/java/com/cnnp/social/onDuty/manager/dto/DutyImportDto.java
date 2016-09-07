package com.cnnp.social.onDuty.manager.dto;

public class DutyImportDto {
	
	private long id;
	private long userid; // 用户ID
	private String username; // 用户姓名
	private String responsibledepartment;// 部门
	private String companyid;// 公司	
	private String startdate;// 开始时间	
	private String enddate;// 结束时间
	private String description;// 备注
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getResponsibledepartment() {
		return responsibledepartment;
	}
	public void setResponsibledepartment(String responsibledepartment) {
		this.responsibledepartment = responsibledepartment;
	}
	public String getCompanyid() {
		return companyid;
	}
	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
