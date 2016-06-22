package com.cnnp.social.collspace.manager.dto;


public class CollspaceUserDto {
	private String collspaceid; //空间ID
	private String userid;//用户id
	private String username;//用户名
	private String type;//用户类型
	private String isdelete;//是否删除
	private CollspaceDto latestspace;//最新执行情况
	
	public String getCollspaceid() {
		return collspaceid;
	}
	public void setCollspaceid(String collspaceid) {
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
	public String getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}
	
	public CollspaceDto getLatestSpace() {
		return latestspace;
	}

	public void setLatestSpace(CollspaceDto latestspace) {
		this.latestspace = latestspace;
	}
}
