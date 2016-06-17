package com.cnnp.social.collspace.manager.dto;

import org.dozer.Mapping;

import java.util.Date;

public class CollspaceDto {
	private long collspaceid; //空间ID
	private String collspacename;//空间名
	private long createuserid;//创建人ID
	private String createusername;//创建人
	private Date createtime;//创建时间
	private Date updatetime;//更新时间
	private String description;//备注信息
	private String scope;//公开范围
	private String imgname;//图片名称
	private String imgpath;//图片地址
	private long member;//成员数
	

	public long getCollspaceid() {
		return collspaceid;
	}

	public void setCollspaceid(long collspaceid) {
		this.collspaceid = collspaceid;
	}

	public String getCollspacename() {
		return collspacename;
	}

	public void setCollspacename(String collspacename) {
		this.collspacename = collspacename;
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

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public long getMember() {
		return member;
	}

	public void setMember(long member) {
		this.member = member;
	}

	
}
