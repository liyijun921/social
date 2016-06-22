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
	private String collspaceid; //空间ID
	@Mapping(value="userid")
	private String userid;//用户id
	private String username;//用户名
	private String type;//用户类型
	private String isdelete;//是否删除
	
	

	public TCollspaceUser() {
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCollspaceid() {
		return this.collspaceid;
	}

	public void setCollspaceid(String collspaceid) {
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

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

}