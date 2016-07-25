package com.cnnp.social.homepage.manager.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class HomePageFormInDto {
	private long id; //ID
	private long hpid; //ID
	private long formid; //ID
	private String name;//日程标题
	private String form_inid;//日程类型
	private String styleid;//用户id
	//private String form_inname;//责任人		
	@Temporal(TemporalType.DATE)
	private Date updatetime;//创建时间	
	private String imgname;//日程类型
	private String imgpath;//责任人
	private String code;//日程类型
	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}
	public long getHpid() {
		return hpid;
	}

	public void setHpid(long hpid) {
		this.hpid = hpid;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getFormid() {
		return formid;
	}

	public void setFormid(long formid) {
		this.formid = formid;
	}

	public String getStyleid() {
		return styleid;
	}

	public void setStyleid(String styleid) {
		this.styleid = styleid;
	}

	public String getForm_inid() {
		return form_inid;
	}

	public void setForm_inid(String form_inid) {
		this.form_inid = form_inid;
	}
	//public String getForm_inname() {
	//	return this.form_inname;
	//}

	//public void setForm_inname_1(String form_inname) {
	//	this.form_inname = form_inname;
	//}

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
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
}
