package com.cnnp.social.supervision.repository.entity;

import javax.persistence.*;

import org.springframework.cache.annotation.Cacheable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the SUPERVISION database table.
 * 
 */
@Entity
@Table(name = "T_SUPERVISION")
public class TSupervision implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_Supervision")
	@SequenceGenerator(initialValue = 10000, name = "SQ_Supervision", sequenceName = "SQ_Supervision")
	private long id;

	private String accountablename;

	private String accountablesn;

	private String actualcompletetiontime;

	private String area;

	private String code;

	private String comments; 

	@Temporal(TemporalType.DATE)
	private Date estimatedcompletetiontime;

	private String name;

	private long pid;
	private String scope;
	private String responsibledeptcode;
	

	private String responsibledeptname;

	private String responsiblename;

	private String responsiblesn;

	private int importance;

	private String source;

	private int status;

	@Column(columnDefinition = "DATE DEFAULT SYSDATE",insertable=false) 
	@Temporal(TemporalType.DATE)
	private Date updatetime;

	private BigDecimal urgency;

	

	public TSupervision() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountablename() {
		return this.accountablename;
	}

	public void setAccountablename(String accountablename) {
		this.accountablename = accountablename;
	}

	public String getAccountablesn() {
		return this.accountablesn;
	}

	public void setAccountablesn(String accountablesn) {
		this.accountablesn = accountablesn;
	}

	public String getActualcompletetiontime() {
		return this.actualcompletetiontime;
	}

	public void setActualcompletetiontime(String actualcompletetiontime) {
		this.actualcompletetiontime = actualcompletetiontime;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getEstimatedcompletetiontime() {
		return this.estimatedcompletetiontime;
	}

	public void setEstimatedcompletetiontime(Date estimatedcompletetiontime) {
		this.estimatedcompletetiontime = estimatedcompletetiontime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPid() {
		return this.pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getResponsibledeptcode() {
		return this.responsibledeptcode;
	}

	public void setResponsibledeptcode(String responsibledeptcode) {
		this.responsibledeptcode = responsibledeptcode;
	}

	public String getResponsibledeptname() {
		return this.responsibledeptname;
	}

	public void setResponsibledeptname(String responsibledeptname) {
		this.responsibledeptname = responsibledeptname;
	}

	public String getResponsiblename() {
		return this.responsiblename;
	}

	public void setResponsiblename(String responsiblename) {
		this.responsiblename = responsiblename;
	}

	public String getResponsiblesn() {
		return this.responsiblesn;
	}

	public void setResponsiblesn(String responsiblesn) {
		this.responsiblesn = responsiblesn;
	}

	

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public BigDecimal getUrgency() {
		return this.urgency;
	}

	public void setUrgency(BigDecimal urgency) {
		this.urgency = urgency;
	}
	
	

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
	

}