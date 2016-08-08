package com.cnnp.social.homepage.manager.dto;



public class HomePageIDNameDto {
	private long id; //ID
	private String name;//日程标题	
	private String hptype; //ID
	
	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getHptype() {
		return hptype;
	}

	public void setHptype(String hptype) {
		this.hptype = hptype;
	}
}
