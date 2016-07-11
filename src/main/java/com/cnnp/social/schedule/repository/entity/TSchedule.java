package com.cnnp.social.schedule.repository.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the SCHEDULEINFO database table.
 * 
 */
@Entity
@Table(name = "SCHEDULEINFO")
public class TSchedule{
	
	@Id
	private long id; //ID

	private String title;//日程标题

	private String scheduletype;//日程类型

	private String userid;//用户id

	private String username;//用户名
	
	@Temporal(TemporalType.DATE)
	private Date startdate;//开始日期

	private String description;//备注

	private String scope;//范围
	
	@Temporal(TemporalType.DATE)
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
	
	@Temporal(TemporalType.DATE)
	private Date createtime;//创建时间
	
	private String other;//其他
	
	private String type;//类型
	private String collsaceid;//空间id
	
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "scheduleid")
	private List<TSchedulePeople> people = new ArrayList<TSchedulePeople>();
	
	public TSchedule() {
	}

	public long getid() {
		return this.id;
	}

	public void setid(long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getScope() {
		return this.scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	public String getResponsible() {
		return this.responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	
	public String getResponsibledepartment() {
		return this.responsibledepartment;
	}

	public void setResponsibledepartment(String responsibledepartment) {
		this.responsibledepartment = responsibledepartment;
	}
	
	public String getSourcelink() {
		return this.sourcelink;
	}

	public void setSourcelink(String sourcelink) {
		this.sourcelink = sourcelink;
	}
	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getType() {
		return this.type;
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
	public List<TSchedulePeople> getPeople() {
		return people;
	}

	public void setPeople(List<TSchedulePeople> people) {
		this.people = people;
	}
	
	
}