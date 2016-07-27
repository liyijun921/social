package com.cnnp.social.homepage.manager.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cnnp.social.homepage.repository.entity.THomePageImg;
import com.cnnp.social.homepage.repository.entity.THomePageStyleOrder;


public class HomePageStyleDto {
	private long id; //ID
	private long hpid; //ID
	private String name;//日程标题
	private String status;//用户名	
	private String description;//备注
	private String createuserid;//创建用户ID	
	private String createusername;//创建用户名	
	@Temporal(TemporalType.DATE)
	private Date updatetime;//创建时间	
	private List<THomePageImg> img = new ArrayList<THomePageImg>();
	private List<THomePageStyleOrder> order = new ArrayList<THomePageStyleOrder>();
	
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
	
	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
	public List<THomePageImg> getImg() {
		return img;
	}

	public void setImg(List<THomePageImg> img) {
		this.img = img;
	}
	public List<THomePageStyleOrder> getOrder() {
		return order;
	}

	public void setOrder(List<THomePageStyleOrder> order) {
		this.order = order;
	}
}
