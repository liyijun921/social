package com.cnnp.social.collspace.repository.entity;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the REMARKINFO database table.
 * 
 */
@Entity
@Table(name = "REMARKINFO")
public class TCollspaceRemark{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; //评论ID
	
	private long collspaceid; //空间ID

	private long topicid;//主题ID

	private long createuserid;//创建人ID

	private String createusername;//创建人

	private Date createtime;//创建时间

	private Date updatetime;//更新时间

	private String description;//备注信息

	private String remarkname;//评论名

	private String isdelete;//图片名称


	public TCollspaceRemark() {
	}
	
	public long getid() {
		return this.id;
	}

	public void setid(long id) {
		this.id = id;
	}
	
	public long getCollspaceid() {
		return this.collspaceid;
	}

	public void setCollspaceid(long collspaceid) {
		this.collspaceid = collspaceid;
	}

	public long getTopicid() {
		return this.topicid;
	}

	public void setTopicid(long topicid) {
		this.topicid = topicid;
	}

	public long getCreateuserid() {
		return this.createuserid;
	}

	public void setCreateuserid(long createuserid) {
		this.createuserid = createuserid;
	}

	public String getCreateusername() {
		return this.createusername;
	}

	public void setCreateusername(String createusername) {
		this.createusername = createusername;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemarkname() {
		return this.remarkname;
	}

	public void setRemarkname(String remarkname) {
		this.remarkname = remarkname;
	}

	public String getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	
}