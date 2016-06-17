package com.cnnp.social.collspace.repository.entity;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the COLLSPACE database table.
 * 
 */
@Entity
@Table(name = "COLLSPACEINFO")
public class TCollspace{
	
	@Id
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



	public TCollspace() {
	}

	public long getCollspaceid() {
		return this.collspaceid;
	}

	public void setCollspaceid(long collspaceid) {
		this.collspaceid = collspaceid;
	}

	public String getCollspacename() {
		return this.collspacename;
	}

	public void setCollspacename(String collspacename) {
		this.collspacename = collspacename;
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

	public String getScope() {
		return this.scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getImgname() {
		return this.imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	public String getImgpath() {
		return this.imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public long getMember() {
		return this.member;
	}

	public void setMember(long member) {
		this.member = member;
	}

}