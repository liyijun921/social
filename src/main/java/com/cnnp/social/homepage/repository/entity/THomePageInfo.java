package com.cnnp.social.homepage.repository.entity;

import javax.persistence.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the HP_HOMEPAGEINFO database table.
 * 
 */
@Entity
@Table(name = "HP_HOMEPAGEINFO")
public class THomePageInfo{
	@Id
	private long id; //ID
	private String name;//日程标题
	private String hptype;//日程类型
	private String webtype;//日程类型
	private String styleid;//用户id
	private String status;//用户名	
	private String description;//备注
	private String url;//责任人		
	private String createuserid;//创建用户ID	
	private String createusername;//创建用户名	
	@Temporal(TemporalType.DATE)
	private Date updatetime;//创建时间	
	private long parentid; //ID
	
	private long priority;//优先级
	
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "hpid")
	private List<THomePageAdmin> admin = new ArrayList<THomePageAdmin>();
	
	public THomePageInfo() {
	}

	public long getid() {
		return this.id;
	}

	public void setid(long id) {
		this.id = id;
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

	public String getHptype() {
		return this.hptype;
	}

	public void setHptype(String hptype) {
		this.hptype = hptype;
	}
	public String getWebtype() {
		return this.webtype;
	}

	public void setWebtype(String webtype) {
		this.webtype = webtype;
	}
	public String getStyleid() {
		return this.styleid;
	}

	public void setStyleid(String styleid) {
		this.styleid = styleid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
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
	public long getParentid() {
		return this.parentid;
	}

	public void setParentid(long parentid) {
		this.parentid = parentid;
	}

	public long getPriority() {
		return priority;
	}

	public void setPriority(long priority) {
		this.priority = priority;
	}
	
	
}