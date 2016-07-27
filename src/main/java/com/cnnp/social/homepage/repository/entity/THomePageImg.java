package com.cnnp.social.homepage.repository.entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the HP_IMG database table.
 * 
 */
@Entity
@Table(name = "HP_IMG")
public class THomePageImg{
	@Id
	private long id; //ID
	private long styleid;//用户id
	@Temporal(TemporalType.DATE)
	private Date updatetime;//创建时间	
	private String imgname;//日程类型
	private String imgpath;//责任人
	
	public THomePageImg() {
	}

	public long getid() {
		return this.id;
	}

	public void setid(long id) {
		this.id = id;
	}
	public long getStyleid() {
		return this.styleid;
	}

	public void setStyleid(long styleid) {
		this.styleid = styleid;
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

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
}