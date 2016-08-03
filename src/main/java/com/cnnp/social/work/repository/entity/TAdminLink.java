package com.cnnp.social.work.repository.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the W_ADMIN_LINK database table.
 * 
 */
@Entity
@Table(name = "W_ADMIN_LINK")
public class TAdminLink{
	
	@Id
	private long id; //ID

	private String link;//日程标题

	private String icoa;//日程类型

	private String description;//备注

	
	public TAdminLink() {
	}

	public long getid() {
		return this.id;
	}

	public void setid(long id) {
		this.id = id;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getIcoa() {
		return this.icoa;
	}

	public void setIcoa(String icoa) {
		this.icoa = icoa;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}