package com.cnnp.social.supervision.repository.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the T_SUPERVISION_UPDATESTATUS database table.
 * 
 */
@Entity
@Table(name="T_SUPERVISION_UPDATESTATUS")
public class TSupervisionUpdatestatus  {

	@Id
	@SequenceGenerator(name="T_SUPERVISION_UPDATESTATUS_ID_GENERATOR", sequenceName="SQ_SUPERVISION_UPDATESTATUS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_SUPERVISION_UPDATESTATUS_ID_GENERATOR")
	private long id;

	private int operatetype;

	private String reason;

	@Column(name="SUPERVISION_ID")
	private long supervisionId;
	@Column(columnDefinition = "DATE DEFAULT SYSDATE",insertable=false) 
	@Temporal(TemporalType.DATE)
	private Date updatetime;

	private String updateuserid;

	private String updateusername;

	public TSupervisionUpdatestatus() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getOperatetype() {
		return this.operatetype;
	}

	public void setOperatetype(int operatetype) {
		this.operatetype = operatetype;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public long getSupervisionId() {
		return this.supervisionId;
	}

	public void setSupervisionId(long supervisionId) {
		this.supervisionId = supervisionId;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getUpdateuserid() {
		return this.updateuserid;
	}

	public void setUpdateuserid(String updateuserid) {
		this.updateuserid = updateuserid;
	}

	public String getUpdateusername() {
		return this.updateusername;
	}

	public void setUpdateusername(String updateusername) {
		this.updateusername = updateusername;
	}

}