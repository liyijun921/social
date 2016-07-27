package com.cnnp.social.homepage.repository.entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the HP_STYLE_ORDER database table.
 * 
 */
@Entity
@Table(name = "HP_STYLE_ORDER")
public class THomePageStyleOrder{
	@Id
	private long id; //ID
	private long styleid; //ID
	private long orderid; //ID
	private long formid; //ID
	
	
	public THomePageStyleOrder() {
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
	
	public long getOrderid() {
		return this.orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public long getFormid() {
		return this.formid;
	}

	public void setFormid(long formid) {
		this.formid = formid;
	}

}