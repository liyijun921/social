package com.cnnp.social.supervision.manager.dto;

import java.util.Date;

public class SupervisionTraceDto {
	private String supervisionid;//督办ID
	private String operatorsn;//督办执行人员工号
	private String operatorname;//督办执行人姓名
	private int rate;//督办进度百分比*100
	private String description;//督办执行情况描述
	private Date updatetime;//执行时间
	
	
	public String getSupervisionid() {
		return supervisionid;
	}
	public void setSupervisionid(String supervisionid) {
		this.supervisionid = supervisionid;
	}
	public String getOperatorsn() {
		return operatorsn;
	}
	public void setOperatorsn(String operatorsn) {
		this.operatorsn = operatorsn;
	}
	public String getOperatorname() {
		return operatorname;
	}
	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
	
	
}
