package com.cnnp.social.homepage.manager.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class HomePageAdminDto {
	private long id; //ID
	private long hpid; //ID
	private long columnid; //ID
	private String admintype;//日程类型
	private String userid;//创建用户ID	
	private String username;//创建用户名	
	@Temporal(TemporalType.DATE)
	private Date updatetime;//创建时间	
	
	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
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
		return admintype;
	}

	public void setType(String admintype) {
		this.admintype = admintype;
	}

	public long getHpid() {
		return hpid;
	}

	public void setHpid(long hpid) {
		this.hpid = hpid;
	}
	public long getColumnid() {
		return columnid;
	}

	public void setColumnid(long columnid) {
		this.columnid = columnid;
	}
	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
}
