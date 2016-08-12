package com.cnnp.social.homepage.manager.dto;


public class HomePageArticlecatDto {
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
	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}

	public long getParent_id() {
		return parent_id;
	}

	public void setParent_id(long parent_id) {
		this.parent_id = parent_id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAuditor_ids() {
		return auditor_ids;
	}

	public void setAuditor_ids(String auditor_ids) {
		this.auditor_ids = auditor_ids;
	}

	public String getAuditor_names() {
		return auditor_names;
	}

	public void setAuditor_names(String auditor_names) {
		this.auditor_names = auditor_names;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
		
	public String getIs_build() {
		return is_build;
	}

	public void setIs_build(String is_build) {
		this.is_build = is_build;
	}
	public String getPre_view_name() {
		return pre_view_name;
	}

	public void setPre_view_name(String pre_view_name) {
		this.pre_view_name = pre_view_name;
	}
	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}
}
