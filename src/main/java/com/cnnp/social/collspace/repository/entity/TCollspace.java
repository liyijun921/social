package com.cnnp.social.collspace.repository.entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

	private String createuserid;//创建人ID

	private String createusername;//创建人

	private Date createtime;//创建时间

	private Date updatetime;//更新时间

	private String description;//备注信息

	private String scope;//公开范围

	private String imgname;//图片名称

	private String imgpath;//图片地址
	
	private String member;//成员数
	
	private String collsystem;//协作空间制度
	
	private String responsibility;//协作空间职责
	private String contactid;//
	private String contactname;//
	private String departmentid;//
	private String departmentname;//
	
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "collspaceid")
	private List<TCollspaceUser> user = new ArrayList<TCollspaceUser>();
	
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

	public String getCollsystem() {
		return this.collsystem;
	}

	public void setCollsystem(String collsystem) {
		this.collsystem = collsystem;
	}
	
	public String getMember() {
		return this.member;
	}

	public void setMember(String member) {
		this.member = member;
	}
	
	public String getResponsibility() {
		return this.responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	public String getContactid() {
		return this.contactid;
	}

	public void setContactid(String contactid) {
		this.contactid = contactid;
	}
	public String getContactname() {
		return this.contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
	public String getDepartmentid() {
		return this.departmentid;
	}

	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}
	public String getDepartmentname() {
		return this.departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	
	public List<TCollspaceUser> getUser() {
		return this.user;
	}

	public void setUser(List<TCollspaceUser> user) {
		this.user = user;
	}
}