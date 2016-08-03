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
public class News_AttDto {
    private String title;
    private String subTitle;
    private String author;
    private String priority;
    private String show_way;
    private String attach_content_id;
    private String article_id;
    private String audit_date;
    private String auditor_id;
    private String auditor_name;
    private String author_name;
    private String author_id;
    private String content;
    private String date_created;
    private String image_url;
    private String last_updated;
    private String main_attach_id;
    private String message_id;
    private String news_field;
    private String news_topic;
    private int access_count;
    private String publish_date;
    private String status;
    private String valid_date;
    private String valid_day;
    private String reminder_id;    
    private int id;
    private List<AttachmentsDto> attachments ;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public List<AttachmentsDto> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<AttachmentsDto> attachments) {
        this.attachments = attachments;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getshow_way() {
        return show_way;
    }

    public void setshow_way(String show_way) {
        this.show_way = show_way;
    }
    public String getattach_content_id() {
        return attach_content_id;
    }

    public void setattach_content_id(String attach_content_id) {
        this.attach_content_id = attach_content_id;
    }
    public String getarticle_id() {
        return article_id;
    }

    public void setarticle_id(String article_id) {
        this.article_id = article_id;
    }
    public String getaudit_date() {
        return audit_date;
    }

    public void setaudit_date(String audit_date) {
        this.audit_date = audit_date;
    }
    public String getauditor_id() {
        return auditor_id;
    }

    public void setauditor_id(String auditor_id) {
        this.auditor_id = auditor_id;
    }
    public String getauditor_name() {
        return auditor_name;
    }

    public void setauditor_name(String auditor_name) {
        this.auditor_name = auditor_name;
    }
    public String getauthor_name() {
        return author_name;
    }

    public void setauthor_name(String author_name) {
        this.author_name = author_name;
    }
    public String getauthor_id() {
        return author_id;
    }

    public void setauthor_id(String author_id) {
        this.author_id = author_id;
    }
    public String getcontent() {
        return content;
    }

    public void setcontent(String content) {
        this.content = content;
    }
    public String getimage_url() {
        return image_url;
    }

    public void setimage_url(String image_url) {
        this.image_url = image_url;
    }
    public String getdate_created() {
        return date_created;
    }

    public void setdate_created(String date_created) {
        this.date_created = date_created;
    }
    public String getlast_updated() {
        return last_updated;
    }

    public void setlast_updated(String last_updated) {
        this.last_updated = last_updated;
    }
    public String getmain_attach_id() {
        return main_attach_id;
    }

    public void setmain_attach_id(String main_attach_id) {
        this.main_attach_id = main_attach_id;
    }
    public String getmessage_id() {
        return message_id;
    }

    public void setmessage_id(String message_id) {
        this.message_id = message_id;
    }
    public String getnews_field() {
        return news_field;
    }

    public void setnews_field(String news_field) {
        this.news_field = news_field;
    }
    public String getnews_topic() {
        return news_topic;
    }

    public void setnews_topic(String news_topic) {
        this.news_topic = news_topic;
    }
    public int getaccess_count() {
        return access_count;
    }

    public void setaccess_count(int access_count) {
        this.access_count = access_count;
    }
    public String getpublish_date() {
        return publish_date;
    }

    public void setpublish_date(String publish_date) {
        this.publish_date = publish_date;
    }
    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }
    public String getvalid_date() {
        return valid_date;
    }

    public void setvalid_date(String valid_date) {
        this.valid_date = valid_date;
    }
    public String getvalid_day() {
        return valid_day;
    }

    public void setvalid_day(String valid_day) {
        this.valid_day = valid_day;
    }
    public String getreminder_id() {
        return reminder_id;
    }

    public void setreminder_id(String reminder_id) {
        this.reminder_id = reminder_id;
    }
   
}
