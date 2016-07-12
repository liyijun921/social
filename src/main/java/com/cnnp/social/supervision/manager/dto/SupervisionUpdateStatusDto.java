package com.cnnp.social.supervision.manager.dto;

public class SupervisionUpdateStatusDto {
	private long id;
	private String reason;
	private String updateuserid;
	private String updateusername;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getUpdateuserid() {
		return updateuserid;
	}
	public void setUpdateuserid(String updateuserid) {
		this.updateuserid = updateuserid;
	}
	public String getUpdateusername() {
		return updateusername;
	}
	public void setUpdateusername(String updateusername) {
		this.updateusername = updateusername;
	}
	
}
