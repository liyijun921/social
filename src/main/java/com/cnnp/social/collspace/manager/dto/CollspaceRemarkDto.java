package com.cnnp.social.collspace.manager.dto;

import org.dozer.Mapping;

import java.util.Date;

public class CollspaceRemarkDto {
	private long id; //评论ID
	private long collspaceid; //空间ID
	private long topicid;//主题ID
	private long createuserid;//创建人ID
	private String createusername;//创建人
	private Date createtime;//创建时间
	private Date updatetime;//更新时间
	private String description;//备注信息
	private String remarkname;//主题名
	private String isdelete;//是否删除

	public long getid() {
		return id;
	}

	public void setid(long id) {
		this.id = id;
	}

	public long getCollspaceid() {
		return collspaceid;
	}

	public void setCollspaceid(long collspaceid) {
		this.collspaceid = collspaceid;
	}

	public long getTopicid() {
		return topicid;
	}

	public void setTopicid(long topicid) {
		this.topicid = topicid;
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

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
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

	public String getRemarkname() {
		return remarkname;
	}

	public void setRemarkname(String remarkname) {
		this.remarkname = remarkname;
	}

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}
	
}
