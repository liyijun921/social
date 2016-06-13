package com.cnnp.social.supervision.repository.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.dozer.Mapping;

/**
 * The persistent class for the T_SUPERVISION_TRACE database table.
 * 
 */
@Entity
@Table(name = "T_SUPERVISION_TRACE")
public class TSupervisionTrace {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String operatorname;

	private String operatorsn;

	private int rate;
	@Mapping(value="supervisionID")
	private long supervisionid;
	private String description;

	@Temporal(TemporalType.DATE)
	private Date updatetime;

	public TSupervisionTrace() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOperatorname() {
		return this.operatorname;
	}

	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}

	public String getOperatorsn() {
		return this.operatorsn;
	}

	public void setOperatorsn(String operatorsn) {
		this.operatorsn = operatorsn;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public long getSupervisionid() {
		return supervisionid;
	}

	public void setSupervisionid(long supervisionid) {
		this.supervisionid = supervisionid;
	}

}