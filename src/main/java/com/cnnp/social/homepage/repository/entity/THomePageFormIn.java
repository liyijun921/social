package com.cnnp.social.homepage.repository.entity;

import javax.persistence.*;

import com.cnnp.social.schedule.repository.entity.TSchedulePeople;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the HP_FORM_IN database table.
 * 
 */
@Entity
@Table(name = "HP_FORM_IN")
public class THomePageFormIn{
	@Id
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
	
	public THomePageFormIn() {
	}

	public long getid() {
		return this.id;
	}

	public void setid(long id) {
		this.id = id;
	}
	
	public long getHpid() {
		return this.hpid;
	}

	public void setHpid(long hpid) {
		this.hpid = hpid;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public long getFormid() {
		return this.formid;
	}

	public void setFormid(long formid) {
		this.formid = formid;
	}

	public String getStyleid() {
		return this.styleid;
	}

	public void setStyleid(String styleid) {
		this.styleid = styleid;
	}

	public String getForm_inid() {
		return this.form_inid;
	}

	public void setForm_inid(String form_inid) {
		this.form_inid = form_inid;
	}
	//public String getForm_inname() {
	//	return this.form_inname;
	//}

	//public void setForm_inname(String form_inname) {
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
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
}