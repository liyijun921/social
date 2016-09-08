package com.cnnp.social.meeting.manager.dto;

public class MeetingRoomDto {
	
	private Long id; // room ID 
	private long location; // room location
	private long capacity; // room capacity
	private String status; // room status
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getLocation() {
		return location;
	}
	public void setLocation(long location) {
		this.location = location;
	}
	public long getCapacity() {
		return capacity;
	}
	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
