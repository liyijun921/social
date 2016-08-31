package com.cnnp.social.news.repository.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the PB2_ATTACHMENTS database table.
 * 
 */
@Entity
@Table(name = "PB2_ATTACHMENTS")
public class TNews_Att{
	
	@Id
	private long id;
	private String version;
	private Date date_created;
	private String external_url;
	private String file_from;
	private String file_type;
	private String name;
	private String path;
	private String size_;
	private String temporary_;
	private String type;
	private String uploader;
	private String url;
	
	public TNews_Att() {
	}

	public long getid() {
		return this.id;
	}

	public void setid(long id) {
		this.id = id;
	}

	public String getExternal_url() {
		return this.external_url;
	}

	public void setExternal_url(String external_url) {
		this.external_url = external_url;
	}

	public String getversiond() {
		return this.version;
	}

	public void setversion(String version) {
		this.version = version;
	}

	public String getFile_from() {
		return this.file_from;
	}

	public void setFile_from(String file_from) {
		this.file_from = file_from;
	}

	public String getFile_type() {
		return this.file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSize_() {
		return this.size_;
	}

	public void setSize_(String size_) {
		this.size_ = size_;
	}

	public String getTemporary_() {
		return this.temporary_;
	}

	public void setTemporary_(String temporary_) {
		this.temporary_ = temporary_;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUploader() {
		return this.uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	
	public Date getDate_created() {
		return this.date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}