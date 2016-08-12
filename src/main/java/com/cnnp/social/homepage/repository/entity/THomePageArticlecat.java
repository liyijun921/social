package com.cnnp.social.homepage.repository.entity;

import javax.persistence.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the PB2_ARTICLECAT database table.
 * 
 */
@Entity
@Table(name = "PB2_ARTICLECAT")
public class THomePageArticlecat{
	@Id
	private long id; 
	private String version; 
	private String auditor_ids;
	private String auditor_names;
	private String status;
	private String description;
	private String is_build;
	private String name;
	private long parent_id;
	private String seq;
	private String pre_view_name;
	
	public THomePageArticlecat() {
	}

	public long getid() {
		return this.id;
	}

	public void setid(long id) {
		this.id = id;
	}
	public long getParent_id() {
		return this.parent_id;
	}

	public void setParent_id(long parent_id) {
		this.parent_id = parent_id;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAuditor_ids() {
		return this.auditor_ids;
	}

	public void setAuditor_ids(String auditor_ids) {
		this.auditor_ids = auditor_ids;
	}

	public String getAuditor_names() {
		return this.auditor_names;
	}

	public void setAuditor_names(String auditor_names) {
		this.auditor_names = auditor_names;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
		
	public String getIs_build() {
		return this.is_build;
	}

	public void setIs_build(String is_build) {
		this.is_build = is_build;
	}
	public String getPre_view_name() {
		return this.pre_view_name;
	}

	public void setPre_view_name(String pre_view_name) {
		this.pre_view_name = pre_view_name;
	}
	public String getSeq() {
		return this.seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}
}