package com.cnnp.social.meeting.manager.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class MeetingInputDto {
	
	private Long id; // meeting ID 
	private Long roomid; // room ID
	private String topic; // topic
	private String department;// 部门
	private String startdate;// 开始时间	
	private String enddate;// 结束时间
	private String area;// area
	private String chairman; //主持人
	private String scope;
	private String referencepeople; //与会人员
	private String otherpeople; //外部参会人员
	private String content;
	private Long userid;
	
	private List<MeetingAttachmentDto> attchment = new ArrayList<MeetingAttachmentDto>();
	

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoomid() {
		return roomid;
	}

	public void setRoomid(Long roomid) {
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

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
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

	public List<MeetingAttachmentDto> getAttchment() {
		return attchment;
	}

	public void setAttchment(List<MeetingAttachmentDto> attchment) {
		this.attchment = attchment;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}
	

}
