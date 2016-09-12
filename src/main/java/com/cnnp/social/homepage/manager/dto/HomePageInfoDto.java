package com.cnnp.social.homepage.manager.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cnnp.social.homepage.repository.entity.THomePageAdmin;

public class HomePageInfoDto {
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
	private List<THomePageAdmin> admin = new ArrayList<THomePageAdmin>();
	private long parentid; //ID
	private long priority;// 排序优先级
	
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

	public String getCreateuserid() {
		return createuserid;
	}

	public void setCreateuserid(String createuserid) {
		this.createuserid = createuserid;
	}

	public String getCreateusername() {
		return createusername;
	}

	public void setCreateusername(String createusername) {
		this.createusername = createusername;
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

	public String getStyleid() {
		return styleid;
	}

	public void setStyleid(String styleid) {
		this.styleid = styleid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public List<THomePageAdmin> getAdmin() {
		return admin;
	}

	public void setAdmin(List<THomePageAdmin> admin) {
		this.admin = admin;
	}
	public long getParentid() {
		return parentid;
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
