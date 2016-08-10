package com.cnnp.social.homepage.repository.entity;

import javax.persistence.*;

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
	private long columnid; //ID
	private long formid; //ID
	private String name;//日程标题
	private String form_inid;//日程类型
	private String styleid;//用户id		
	@Temporal(TemporalType.DATE)
	private Date updatetime;//创建时间	
	private String code;//日程类型
	private String more_url;
	private String ismore;
	private String url;
	private String content_type;
	private String method;
	private String payload;
	private String querystring;
	
	public THomePageFormIn() {
	}

	public long getid() {
		return this.id;
	}

	public void setid(long id) {
		this.id = id;
	}
	
	public long getColumnid() {
		return this.columnid;
	}

	public void setColumnid(long columnid) {
		this.columnid = columnid;
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

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getMore_url() {
		return this.more_url;
	}

	public void setMore_url(String more_url) {
		this.more_url = more_url;
	}
	public String getIsmore() {
		return this.ismore;
	}

	public void setIsmore(String ismore) {
		this.ismore = ismore;
	}
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public String getContent_type() {
		return this.content_type;
	}

	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}
	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	public String getPayload() {
		return this.payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}
	public String getQuerystring() {
		return this.querystring;
	}

	public void setQuerystring(String querystring) {
		this.querystring = querystring;
	}
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
}