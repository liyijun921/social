package com.cnnp.social.collspace.repository.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.dozer.Mapping;

/**
 * The persistent class for the COLLSPACEUSERINFO database table.
 * 
 */
@Entity
@Table(name = "COLLSPACEUSERINFO")
public class TCollspaceUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;//是否删除
	private long collspaceid; //空间ID
	private String userid;//用户id
	private String username;//用户名
	private String type;//用户类型
	
	public TCollspaceUser() {
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public long getCollspaceid() {
		return this.collspaceid;
	}

	public void setCollspaceid(long collspaceid) {
		this.collspaceid = collspaceid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

}