package com.cnnp.social.meeting.repository.entity;

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
@Table(name = "MEETING")
public class TMeeting{
	
	@Id
	private Long id; // meeting ID 
	private long roomid; // room ID
	private String topic; // topic
	private String department;// 部门
	@Temporal(TemporalType.DATE)
	private Date startdate;// 开始时间	
	@Temporal(TemporalType.DATE)
	private Date enddate;// 结束时间
	private String area;// area
	private String chairman; //主持人
	private String scope;
	private String referencepeople; //与会人员
	private String otherpeople; //外部参会人员
	private String content;
	private Long userid;
	
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "meetingid")
	private List<TMeetingAttachment> attchment = new ArrayList<TMeetingAttachment>();
	
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getRoomid() {
		return roomid;
	}

	public void setRoomid(long roomid) {
		this.roomid = roomid;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getChairman() {
		return chairman;
	}

	public void setChairman(String chairman) {
		this.chairman = chairman;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getReferencepeople() {
		return referencepeople;
	}

	public void setReferencepeople(String referencepeople) {
		this.referencepeople = referencepeople;
	}

	public String getOtherpeople() {
		return otherpeople;
	}

	public void setOtherpeople(String otherpeople) {
		this.otherpeople = otherpeople;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<TMeetingAttachment> getAttchment() {
		return attchment;
	}

	public void setAttchment(List<TMeetingAttachment> attchment) {
		this.attchment = attchment;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	
}
