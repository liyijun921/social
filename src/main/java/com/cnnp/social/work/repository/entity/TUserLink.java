package com.cnnp.social.work.repository.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the W_USER_LINK database table.
 * 
 */
@Entity
@Table(name = "W_USER_LINK")
public class TUserLink{
	
	@Id
	private long id; //ID

	private long linkid;//日程标题

	private String orderid;//日程类型

	private String userid;//备注

	
	public TUserLink() {
	}

	public long getid() {
		return this.id;
	}

	public void setid(long id) {
		this.id = id;
	}

	public long getLinkid() {
		return this.linkid;
	}

	public void setLinkid(long linkid) {
		this.linkid = linkid;
	}

	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}