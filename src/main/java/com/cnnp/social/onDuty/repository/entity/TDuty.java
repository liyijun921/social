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
	private long userid; // 用户ID
	private String username; // 用户姓名
	private String responsibledepartment;// 部门
	private String companyid;// 公司	
	@Temporal(TemporalType.DATE)
	private Date startdate;// 开始时间	
	@Temporal(TemporalType.DATE)
	private Date enddate;// 结束时间
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

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
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
