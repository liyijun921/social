package com.cnnp.social.news.repository.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the PB2_ARTICLE database table.
 * 
 */
@Entity
@Table(name = "PB2_ARTICLE")
public class TNews{
	
	@Id
	private long id; //ID
	private long version;
	private String article_id;
	private long attach_content_id;
	private Date audit_date;
	private String auditor_id;
	private String auditor_name;
	private String author;
	private String author_id;
	private String author_name;
	private Date back_date;
	private String brief;
	private String cat_id;
	private String channel;
	private String content;
	private Date date_created;
	private String image_url;
	private String is_remote;
	private String is_reported;
	private String is_top;
	private Date last_updated;
	private long main_attach_id;
	private String message_id;
	private String news_field;
	private String news_topic;
	private String org_name;
	private String org_number;
	private String priority;
	private Date publish_date;
	private String pure_content;
	private String reason;
	private String received_sites;
	private String reminder_id;
	private String report_url;
	private String send_site;
	private String sent_remote;
	private String show_way;
	private String status;
	private String template_id;
	private String title;
	private String sub_title;
	private String updater_id;
	private String updater_name;
	private String url;
	private Date valid_date;
	private Date valid_day;
	private String access_count;

	
	public TNews() {
	}

	public long getid() {
		return this.id;
	}

	public void setid(long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getversiond() {
		return this.version;
	}

	public void setversion(long version) {
		this.version = version;
	}

	public String getArticle_id() {
		return this.article_id;
	}

	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}

	public long getAttach_content_id() {
		return this.attach_content_id;
	}

	public void setAttach_content_id(long attach_content_id) {
		this.attach_content_id = attach_content_id;
	}

	public Date getAudit_date() {
		return this.audit_date;
	}

	public void setAudit_date(Date audit_date) {
		this.audit_date = audit_date;
	}

	public String getAuditor_id() {
		return this.auditor_id;
	}

	public void setAuditor_id(String auditor_id) {
		this.auditor_id = auditor_id;
	}

	public String getAuditor_name() {
		return this.auditor_name;
	}

	public void setAuditor_name(String auditor_name) {
		this.auditor_name = auditor_name;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor_id() {
		return this.author_id;
	}

	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}

	public String getAuthor_name() {
		return this.author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	
	public Date getBack_date() {
		return this.back_date;
	}

	public void setBack_date(Date back_date) {
		this.back_date = back_date;
	}
	
	public String getBrief() {
		return this.brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}
	
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getCat_id() {
		return this.cat_id;
	}

	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}
	
	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	public Date getDate_created() {
		return this.date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	
	public String getImage_url() {
		return this.image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getIs_remote() {
		return this.is_remote;
	}

	public void setIs_remote(String is_remote) {
		this.is_remote = is_remote;
	}
	public String getIs_reported() {
		return this.is_reported;
	}

	public void setIs_reported(String is_reported) {
		this.is_reported = is_reported;
	}
	public String getIs_top() {
		return this.is_top;
	}

	public void setIs_top(String is_top) {
		this.is_top = is_top;
	}
	public Date getLast_updated() {
		return this.last_updated;
	}

	public void setLast_updated(Date last_updated) {
		this.last_updated = last_updated;
	}
	public long getMain_attach_id() {
		return this.main_attach_id;
	}

	public void setMain_attach_id(long main_attach_id) {
		this.main_attach_id = main_attach_id;
	}
	public String getMessage_id() {
		return this.message_id;
	}

	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}
	public String getNews_field() {
		return this.news_field;
	}

	public void setNews_field(String news_field) {
		this.news_field = news_field;
	}
	public String getNews_topic() {
		return this.news_topic;
	}

	public void setNews_topic(String news_topic) {
		this.news_topic = news_topic;
	}
	public String getOrg_name() {
		return this.org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public String getOrg_number() {
		return this.org_number;
	}

	public void setOrg_number(String org_number) {
		this.org_number = org_number;
	}
	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	public Date getPublish_date() {
		return this.publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	public String getPure_contentd() {
		return this.pure_content;
	}

	public void setPure_content(String pure_content) {
		this.pure_content = pure_content;
	}
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getReceived_sites() {
		return this.received_sites;
	}

	public void setReceived_sites(String received_sites) {
		this.received_sites = received_sites;
	}
	public String getReminder_id() {
		return this.reminder_id;
	}

	public void setReminder_id(String reminder_id) {
		this.reminder_id = reminder_id;
	}
	public String getReport_url() {
		return this.report_url;
	}

	public void setReport_url(String report_url) {
		this.report_url = report_url;
	}
	public String getSend_site() {
		return this.send_site;
	}

	public void setSend_site(String send_site) {
		this.send_site = send_site;
	}
	public String getSent_remote() {
		return this.sent_remote;
	}

	public void setSent_remote(String sent_remote) {
		this.sent_remote = sent_remote;
	}
	public String getShow_way() {
		return this.show_way;
	}

	public void setShow_way(String show_way) {
		this.show_way = show_way;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getTemplate_id() {
		return this.template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getSub_title() {
		return this.sub_title;
	}

	public void setSub_title(String sub_title) {
		this.sub_title = sub_title;
	}
	public String getUpdater_id() {
		return this.updater_id;
	}

	public void setUpdater_id(String updater_id) {
		this.updater_id = updater_id;
	}
	public String getUpdater_name() {
		return this.updater_name;
	}

	public void setUpdater_name(String updater_name) {
		this.updater_name = updater_name;
	}
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public Date getValid_date() {
		return this.valid_date;
	}

	public void setValid_date(Date valid_date) {
		this.valid_date = valid_date;
	}
	public Date getvalid_dayd() {
		return this.valid_day;
	}

	public void setvalid_day(Date valid_day) {
		this.valid_day = valid_day;
	}
	public String getAccess_count() {
		return this.access_count;
	}

	public void setAccess_count(String access_count) {
		this.access_count = access_count;
	}
}