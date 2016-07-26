package com.cnnp.social.homepage.repository.entity;

import javax.persistence.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the HP_STYLE database table.
 * 
 */
@Entity
@Table(name = "HP_STYLE")
public class THomePageStyle{
	
	@Id
	private long id; //ID
	private long hpid; //ID
	private String name;//日程标题
	private String status;//用户名	
	private String description;//备注
	private String createuserid;//创建用户ID	
	private String createusername;//创建用户名	
	@Temporal(TemporalType.DATE)
	private Date updatetime;//创建时间	
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "styleid")
	private List<THomePageImg> img = new ArrayList<THomePageImg>();
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "styleid")
	private List<THomePageStyleOrder> order = new ArrayList<THomePageStyleOrder>();
	
	public THomePageStyle() {
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
	public List<THomePageImg> getImg() {
		return this.img;
	}

	public void setImg(List<THomePageImg> img) {
		this.img = img;
	}
	
	public List<THomePageStyleOrder> getOrder() {
		return this.order;
	}

	public void setOrder(List<THomePageStyleOrder> order) {
		this.order = order;
	}

}