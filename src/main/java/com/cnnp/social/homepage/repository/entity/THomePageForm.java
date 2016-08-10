package com.cnnp.social.homepage.repository.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the HP_FORM database table.
 * 
 */
@Entity
@Table(name = "HP_FORM")
public class THomePageForm{
	@Id
	private long id; //ID
	private long hpid; //ID
	private String name;//日程标题
	private String status;//用户名	
	private String description;//备注
	private String width;//责任人		
	private String createuserid;//创建用户ID	
	private String createusername;//创建用户名	
	@Temporal(TemporalType.DATE)
	private Date updatetime;//创建时间	
	private String top_color;
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "formid")
	private List<THomePageFormIn> formin = new ArrayList<THomePageFormIn>();
	
	public THomePageForm() {
	}

	public long getid() {
		return this.id;
	}

	public void setid(long id) {
		this.id = id;
	}
	//public long getColumnid() {
	//	return this.columnid;
	//}

	//public void setColumnid(long columnid) {
	//	this.columnid = columnid;
	//}
	public long getHpid() {
		return this.hpid;
	}

	public void setHpid(long hpid) {
		this.hpid = hpid;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreateuserid() {
		return this.createuserid;
	}

	public void setCreateuserid(String createuserid) {
		this.createuserid = createuserid;
	}

	public String getCreateusername() {
		return this.createusername;
	}

	public void setCreateusername(String createusername) {
		this.createusername = createusername;
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
	public String getWidth() {
		return this.width;
	}

	public void setWidth(String width) {
		this.width = width;
	}
	public String getTop_color() {
		return this.top_color;
	}

	public void setTop_color(String top_color) {
		this.top_color = top_color;
	}
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public List<THomePageFormIn> getFormin() {
		return this.formin;
	}

	public void setFormin(List<THomePageFormIn> formin) {
		this.formin = formin;
	}
}