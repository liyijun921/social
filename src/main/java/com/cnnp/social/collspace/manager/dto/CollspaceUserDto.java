package com.cnnp.social.collspace.manager.dto;


public class CollspaceUserDto {
	private long collspaceid; //空间ID
	private String userid;//用户id
	private String username;//用户名
	private String type;//用户类型
	private long id;
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public long getCollspaceid() {
		return collspaceid;
	}
	public void setCollspaceid(long collspaceid) {
		this.collspaceid = collspaceid;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
