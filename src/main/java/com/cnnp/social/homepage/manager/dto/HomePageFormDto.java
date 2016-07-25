package com.cnnp.social.homepage.manager.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cnnp.social.homepage.repository.entity.THomePageAdmin;
import com.cnnp.social.homepage.repository.entity.THomePageFormIn;


public class HomePageFormDto {
	private long id; //ID
	private long hpid; //ID
	private long columnid; //ID
	private String name;//日程标题
	private String styleid;//用户id
	private String status;//用户名	
	private String description;//备注
	private String width;//责任人		
	private String createuserid;//创建用户ID	
	private String createusername;//创建用户名	
	@Temporal(TemporalType.DATE)
	private Date updatetime;//创建时间	
	
	private List<THomePageFormIn> formin = new ArrayList<THomePageFormIn>();
	
	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}
	public long getHpid() {
		return hpid;
	}

	public void setHpid(long hpid) {
		this.hpid = hpid;
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

	public long getColumnid() {
		return columnid;
	}

	public void setColumnid(long columnid) {
		this.columnid = columnid;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}
	
	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public List<THomePageFormIn> getFormin() {
		return formin;
	}

	public void setFormin(List<THomePageFormIn> formin) {
		this.formin = formin;
	}
}
