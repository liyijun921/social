package com.cnnp.social.supervision.manager.dto;

import org.dozer.Mapping;

import java.util.Date;

public class SupervisionDto {
	private long id; //督办ID
	private String code;//督办编号
	private long pid;//上级督办ID
	private String pcode;//上级督办编号
	private String pname;//上级督办名称
	private String name;//督办名称
	private String source;//督办来源编码
	private String source_name;//督办来源名称
	private String area;//督办领域编码
	private String area_name;//督办领域名称
	private int status;//督办状态
	private int importance;//重要程度
	private int urgency;//紧急程度
	private String scope;//督办范围
	@Mapping(value = "estimatedcompletetiontime")
	private Date estimatedcompletetiontime;//预计完成日期
	private Date actualcompletetiontime;//实际完成日期
	private String accountablesn;//责任领导员工号
	private String accountablename;//责任领导姓名
	private String responsiblesn;//责任人员工号
	private String responsiblename;//责任人姓名
	private String responsibledeptcode;//责任部门编号
	private String responsibledeptname;//责任部门名称
	private String comments;//备注
	
	private SupervisionTraceDto latestTrace;//最新执行情况
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

	public int getUrgency() {
		return urgency;
	}

	public void setUrgency(int urgency) {
		this.urgency = urgency;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	

	public Date getEstimatedcompletetiontime() {
		return estimatedcompletetiontime;
	}

	public void setEstimatedcompletetiontime(Date estimatedcompletetiontime) {
		this.estimatedcompletetiontime = estimatedcompletetiontime;
	}

	public Date getActualcompletetiontime() {
		return actualcompletetiontime;
	}

	public void setActualcompletetiontime(Date actualcompletetiontime) {
		this.actualcompletetiontime = actualcompletetiontime;
	}

	public String getAccountablesn() {
		return accountablesn;
	}

	public void setAccountablesn(String accountablesn) {
		this.accountablesn = accountablesn;
	}

	public String getAccountablename() {
		return accountablename;
	}

	public void setAccountablename(String accountablename) {
		this.accountablename = accountablename;
	}

	public String getResponsiblesn() {
		return responsiblesn;
	}

	public void setResponsiblesn(String responsiblesn) {
		this.responsiblesn = responsiblesn;
	}

	public String getResponsiblename() {
		return responsiblename;
	}

	public void setResponsiblename(String responsiblename) {
		this.responsiblename = responsiblename;
	}

	public String getResponsibledeptcode() {
		return responsibledeptcode;
	}

	public void setResponsibledeptcode(String responsibledeptcode) {
		this.responsibledeptcode = responsibledeptcode;
	}

	public String getResponsibledeptname() {
		return responsibledeptname;
	}

	public void setResponsibledeptname(String responsibledeptname) {
		this.responsibledeptname = responsibledeptname;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public SupervisionTraceDto getLatestTrace() {
		return latestTrace;
	}

	public void setLatestTrace(SupervisionTraceDto latestTrace) {
		this.latestTrace = latestTrace;
	}

	public String getSource_name() {
		return source_name;
	}

	public void setSource_name(String source_name) {
		this.source_name = source_name;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	
	
	
}
