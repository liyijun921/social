package com.cnnp.social.homepage.manager.dto;



public class HomePageIDNameDto {
	private long id; //ID
	private String name;//日程标题	
	private String hptype; //ID
	private String webtype;
	private String url;
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
	public String getWebtype() {
		return webtype;
	}

	public void setWebtype(String webtype) {
		this.webtype = webtype;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
