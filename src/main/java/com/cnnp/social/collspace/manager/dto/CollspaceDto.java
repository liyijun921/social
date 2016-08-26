package com.cnnp.social.collspace.manager.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cnnp.social.collspace.repository.entity.TCollspaceUser;

public class CollspaceDto {
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
	private List<TCollspaceUser> user;
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

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getCollsystem() {
		return collsystem;
	}

	public void setCollsystem(String collsystem) {
		this.collsystem = collsystem;
	}
	
	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	public String getContactid() {
		return contactid;
	}

	public void setContactid(String contactid) {
		this.contactid = contactid;
	}
	public String getContactname() {
		return contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
	public String getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}
	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public List<TCollspaceUser> getUser() {
		return user;
	}

	public void setUser(List<TCollspaceUser> user) {
		this.user = user;
	}
}

