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
	private String source;//督办来源
	private String area;//督办领域
	private int status;//督办状态
	@Mapping(value = "slevel")
	private int level;//重要程度
	private int urgency;//紧急程度
	private String scope;//督办范围
	@Mapping(value = "estimatedcompletetiontime")
	private Date estimatedCompletetionTime;//预计完成日期
	private Date actualCompletetionTime;//实际完成日期
	private String accountableSN;//责任领导员工号
	private String accountableName;//责任领导姓名
	private String responsibleSN;//责任人员工号
	private String responsibleName;//责任人姓名
	private String responsibleDeptCode;//责任部门编号
	private String responsibleDeptName;//责任部门名称
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	public Date getEstimatedCompletetionTime() {
		return estimatedCompletetionTime;
	}

	public void setEstimatedCompletetionTime(Date estimatedCompletetionTime) {
		this.estimatedCompletetionTime = estimatedCompletetionTime;
	}

	public Date getActualCompletetionTime() {
		return actualCompletetionTime;
	}

	public void setActualCompletetionTime(Date actualCompletetionTime) {
		this.actualCompletetionTime = actualCompletetionTime;
	}

	public String getAccountableSN() {
		return accountableSN;
	}

	public void setAccountableSN(String accountableSN) {
		this.accountableSN = accountableSN;
	}

	public String getAccountableName() {
		return accountableName;
	}

	public void setAccountableName(String accountableName) {
		this.accountableName = accountableName;
	}

	public String getResponsibleSN() {
		return responsibleSN;
	}

	public void setResponsibleSN(String responsibleSN) {
		this.responsibleSN = responsibleSN;
	}

	public String getResponsibleName() {
		return responsibleName;
	}

	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}

	public String getResponsibleDeptCode() {
		return responsibleDeptCode;
	}

	public void setResponsibleDeptCode(String responsibleDeptCode) {
		this.responsibleDeptCode = responsibleDeptCode;
	}

	public String getResponsibleDeptName() {
		return responsibleDeptName;
	}

	public void setResponsibleDeptName(String responsibleDeptName) {
		this.responsibleDeptName = responsibleDeptName;
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
	
	
}
