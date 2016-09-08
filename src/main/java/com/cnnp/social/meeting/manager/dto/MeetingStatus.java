package com.cnnp.social.meeting.manager.dto;

import java.util.List;

public class MeetingStatus {
	

	private String Stauts;
	
	private List<MeetingDto> meetinglist;
	
	private String log;
	
	

	public String getStauts() {
		return Stauts;
	}

	public void setStauts(String stauts) {
		Stauts = stauts;
	}

	public List<MeetingDto> getMeetinglist() {
		return meetinglist;
	}

	public void setMeetinglist(List<MeetingDto> meetinglist) {
		this.meetinglist = meetinglist;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}
	
	
}
