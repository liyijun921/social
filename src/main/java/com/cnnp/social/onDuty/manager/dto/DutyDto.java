package com.cnnp.social.onDuty.manager.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class DutyDto {
	private Long dutyid;
	
	private String createusername;
	
	private Long createuserid;
	
	private String department;
	
	private String company;
	@Temporal(TemporalType.DATE)
	private Date updatetime;
	
	private String dutydescription;
	
	private List<UserDto> user = new ArrayList<UserDto>(); 
	
	

	public Long getDutyid() {
		return dutyid;
	}

	public void setDutyid(Long dutyid) {
		this.dutyid = dutyid;
	}

	public String getCreateusername() {
		return createusername;
	}

	public void setCreateusername(String createusername) {
		this.createusername = createusername;
	}

	public Long getCreateuserid() {
		return createuserid;
	}

	public void setCreateuserid(Long createuserid) {
		this.createuserid = createuserid;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getDutydescription() {
		return dutydescription;
	}

	public void setDutydescription(String dutydescription) {
		this.dutydescription = dutydescription;
	}

	public List<UserDto> getUser() {
		return user;
	}

	public void setUser(List<UserDto> user) {
		this.user = user;
	}
	
	

}
