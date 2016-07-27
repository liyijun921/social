package com.cnnp.social.homepage.repository.entity;

import javax.persistence.*;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the HP_ADMIN database table.
 * 
 */
@Entity
@Table(name = "HP_ADMIN")
public class THomePageAdmin{
	
	@Id
	private long id; //ID
	private long hpid; //ID
	private long columnid; //ID
	private String admintype;//日程类型
	private String userid;//创建用户ID	
	private String username;//创建用户名	
	@Temporal(TemporalType.DATE)
	private Date updatetime;//创建时间	
	
	
	public THomePageAdmin() {
	}

	public long getid() {
		return this.id;
	}

	public void setid(long id) {
		this.id = id;
	}


	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getType() {
		return this.admintype;
	}

	public void setType(String admintype) {
		this.admintype = admintype;
	}

	public long getHpid() {
		return this.hpid;
	}

	public void setHpid(long hpid) {
		this.hpid = hpid;
	}
	
	public long getColumnid() {
		return this.columnid;
	}

	public void setColumnid(long columnid) {
		this.columnid = columnid;
	}
	
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

}