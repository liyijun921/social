package com.cnnp.social.onDuty.repository.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the HP_ADMIN database table.
 * 
 */
@Entity
@Table(name = "DUTY")
public class TDuty{
	
	@Id
	private long id; // 值班ID 
	private long createuserid; // 用户ID
	private String createusername; // 用户姓名
	private String responsibledepartment;// 部门
	private String companyid;// 公司	
	@Temporal(TemporalType.DATE)
	private Date updatetime;// 创建or更新时间	
	private String description;// 备注
	
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "dutyid")
	private List<TDutyUser> user = new ArrayList<TDutyUser>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCreateuserid() {
		return createuserid;
	}

	public void setCreateuserid(long createuserid) {
		this.createuserid = createuserid;
	}

	public String getCreateusername() {
		return createusername;
	}

	public void setCreateusername(String createusername) {
		this.createusername = createusername;
	}

	public String getResponsibledepartment() {
		return responsibledepartment;
	}

	public void setResponsibledepartment(String responsibledepartment) {
		this.responsibledepartment = responsibledepartment;
	}

	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<TDutyUser> getUser() {
		return user;
	}

	public void setUser(List<TDutyUser> user) {
		this.user = user;
	}
	
	

	
	
}
