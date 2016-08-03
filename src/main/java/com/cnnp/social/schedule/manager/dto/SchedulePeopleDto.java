package com.cnnp.social.schedule.manager.dto;

import java.util.Date;

public class SchedulePeopleDto {
	private long id; //ID

	private String companyid;//公司ID

	private String scheduletype;//日程类型
	
	private long scheduleId;//日程类型
	
	private String userid;//用户id

	private String username;//用户名

	private String companyname;//开始日期

	private String peopletype;//备注
	   
	private Date updatetime;//执行时间
	private String collsaceid;//空间id
	private Date startdate;//开始日期
	private Date enddate;//结束日期
	public long getid() {
		return id;
	}

	public void setid(long id) {
		this.id = id;
	}

	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	public long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(long scheduleId) {
		this.scheduleId = scheduleId;
	}


	public String getScheduletype() {
		return scheduletype;
	}

	public void setScheduletype(String scheduletype) {
		this.scheduletype = scheduletype;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPeopletype() {
		return peopletype;
	}

	public void setPeopletype(String peopletype) {
		this.peopletype = peopletype;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public Date getUpdatetime() {
		return updatetime;
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
	
}
