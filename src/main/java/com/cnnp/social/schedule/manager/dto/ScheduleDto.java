package com.cnnp.social.schedule.manager.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ScheduleDto {
	private Long id; //ID

	private String title;//日程标题

	private String scheduletype;//日程类型

	private String userid;//用户id

	private String username;//用户名
	//@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date startdate;//开始日期

	private String description;//备注

	private String scope;//范围
	//@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date enddate;//结束日期

	private String starttime;//开始时间
	
	private String endtime;//结束时间
	
	private String address;//地点
	
	private String content;//内容

	private String responsible;//责任人
	
	private String responsibledepartment;//责任部门
	
	private String sourcelink;//来源链接
	
	private String createuserid;//创建用户ID
	
	private String createusername;//创建用户名
	
	private Date createtime;//创建时间
	
	private String other;//其他
	private String type;//其他
	private String collsaceid;//空间id
	
	private SchedulePeopleDto people;//最新执行情况
	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	
	public String getResponsibledepartment() {
		return responsibledepartment;
	}

	public void setResponsibledepartment(String responsibledepartment) {
		this.responsibledepartment = responsibledepartment;
	}
	
	public String getSourcelink() {
		return sourcelink;
	}

	public void setSourcelink(String sourcelink) {
		this.sourcelink = sourcelink;
	}
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getType() {
		return type;
	}
 
	public void setType(String type) {
		this.type = type;
	}
	public String getCollsaceid() {
		return this.collsaceid;
	}

	public void setCollsaceid(String collsaceid) {
		this.collsaceid = collsaceid;
	}
	
	public SchedulePeopleDto getPeople() {
		return people;
	}
	public void setPeople(SchedulePeopleDto people) {
		this.people = people;
	}
	
}
