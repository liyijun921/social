package com.cnnp.social.work.manager.dto;


public class UserlinkDto {
	private long id; //ID

	private long linkid;//日程标题

	private String orderid;//日程类型

	private String userid;//备注
	
	private String link;//日程标题

	private String icoa;//日程类型

	private String description;//备注
	public long getid() {
		return id;
	}

	public void setid(long id) {
		this.id = id;
	}

	public long getLinkid() {
		return linkid;
	}

	public void setLinkid(long linkid) {
		this.linkid = linkid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getIcoa() {
		return icoa;
	}

	public void setIcoa(String icoa) {
		this.icoa = icoa;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
