package com.cnnp.social.work.manager.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class AdminlinkDto {
	private long id; //ID

	private String link;//日程标题

	private String icoa;//日程类型

	private String description;//备注

	public long getid() {
		return id;
	}

	public void setid(long id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getIcoa() {
		return icoa;
	}

	public void setIcoa(String icoa) {
		this.icoa = icoa;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
