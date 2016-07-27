package com.cnnp.social.homepage.repository.entity;

import javax.persistence.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the HP_COLUMN database table.
 * 
 */
@Entity
@Table(name = "HP_COLUMN")
public class THomePageColumn{
	@Id
	private long id; //ID
	private long hpid; //ID
	private String name;//日程标题
	private String type;//日程类型
	private String status;//用户名	
	private String description;//备注		
	private String createuserid;//创建用户ID	
	private String createusername;//创建用户名	
	@Temporal(TemporalType.DATE)
	private Date updatetime;//创建时间	
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "columnid")
	private List<THomePageAdmin> admin = new ArrayList<THomePageAdmin>();
	
	public THomePageColumn() {
	}

	public long getid() {
		return this.id;
	}

	public void setid(long id) {
		this.id = id;
	}
	public long getHpid() {
		return this.hpid;
	}

	public void setHpid(long hpid) {
		this.hpid = hpid;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreateuserid() {
		return this.createuserid;
	}

	public void setCreateuserid(String createuserid) {
		this.createuserid = createuserid;
	}

	public String getCreateusername() {
		return this.createusername;
	}

	public void setCreateusername(String createusername) {
		this.createusername = createusername;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public List<THomePageAdmin> getAdmin() {
		return this.admin;
	}

	public void setAdmin(List<THomePageAdmin> admin) {
		this.admin = admin;
	}
}