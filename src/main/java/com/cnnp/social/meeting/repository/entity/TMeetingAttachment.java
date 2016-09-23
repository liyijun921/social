package com.cnnp.social.meeting.repository.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.dozer.Mapping;

@Entity
@Table(name = "MEETING_ATTACHMENT")
public class TMeetingAttachment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // attachment id
	private long userid; // 用户
	@Temporal(TemporalType.DATE)
	private Date createdate; // 
	private String path;// attachment path
	@Temporal(TemporalType.DATE)
	private Date updatedate;// 更新时间
	@Mapping(value="meetingid")
	private Long meetingid;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public Long getMeetingid() {
		return meetingid;
	}
	public void setMeetingid(Long meetingid) {
		this.meetingid = meetingid;
	}
	
	

}
