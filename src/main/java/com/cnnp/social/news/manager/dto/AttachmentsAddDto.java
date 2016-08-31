/*
 *
 * Copyright 2016 IBM or CNNP.
 * 
 */
package com.cnnp.social.news.manager.dto;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Damon on 16/5/31.
 */
public class AttachmentsAddDto {
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
  
    public String getFile_from() {
        return file_from;
    }

    public void setFile_from(String file_from) {
        this.file_from = file_from;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

	public String getSize_() {
		return size_;
	}

	public void setSize_(String size_) {
		this.size_ = size_;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	public String getExternal_url() {
		return external_url;
	}

	public void setExternal_url(String external_url) {
		this.external_url = external_url;
	}
	public String getTemporary_() {
		return this.temporary_;
	}

	public void setTemporary_(String temporary_) {
		this.temporary_ = temporary_;
	}
}
