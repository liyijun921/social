package com.cnnp.social.schedule.repository.entity;

import org.dozer.Mapping;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the COMPANYPEOPLES database table.
 * 
 */
@Entity
@Table(name = "COMPANYPEOPLES")
public class TSchedulePeople{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; //ID

	private String companyid;//公司ID

	private String scheduletype;//日程类型
	
	@Mapping(value="scheduleId")
	private long scheduleid;//日程类型
	
	private String userid;//用户id

	private String username;//用户名

	private String companyname;//开始日期

	private String peopletype;//备注

	@Temporal(TemporalType.DATE)
	private Date updatetime;
	private String collsaceid;//空间id
	@Temporal(TemporalType.DATE)
	private Date startdate;//开始日期
	@Temporal(TemporalType.DATE)
	private Date enddate;//结束日期
	public TSchedulePeople() {
	}

	public long getid() {
		return this.id;
	}

	public void setid(long id) {
		this.id = id;
	}

	public String getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	public long getScheduleid() {
		return scheduleid;
	}

	public void setScheduleid(long scheduleid) {
		this.scheduleid = scheduleid;
	}

	public String getScheduletype() {
		return this.scheduletype;
	}

	public void setScheduletype(String scheduletype) {
		this.scheduletype = scheduletype;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getPeopletype() {
		return this.peopletype;
	}

	public void setPeopletype(String peopletype) {
		this.peopletype = peopletype;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getCollsaceid() {
		return this.collsaceid;
	}

	public void setCollsaceid(String collsaceid) {
		this.collsaceid = collsaceid;
	}
	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
}