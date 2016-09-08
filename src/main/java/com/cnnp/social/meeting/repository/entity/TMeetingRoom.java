package com.cnnp.social.meeting.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the MEETING_ROOM database table.
 * 
 */
@Entity
@Table(name = "MEETING_ROOM")
public class TMeetingRoom{
	
	
	@Id
	private long id; // room ID 
	private long location; // room location
	private long capacity; // room capacity
	private String status; // room status
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
