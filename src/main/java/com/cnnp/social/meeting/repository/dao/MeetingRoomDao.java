package com.cnnp.social.meeting.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.meeting.repository.entity.TMeetingRoom;

@Transactional
public interface MeetingRoomDao extends CrudRepository<TMeetingRoom, Long> ,JpaSpecificationExecutor<TMeetingRoom>{
	
	@Query("select meetingroom from TMeetingRoom meetingroom ")
	public List<TMeetingRoom> findAllRoom();
	
	@Query("select meetingroom from TMeetingRoom meetingroom where  meetingroom.id = ?1 ")
	public TMeetingRoom findRoomByID(long id);
	
	@Query("select count(*) from TMeetingRoom meetingroom where  meetingroom.id = ?1 ")
	public int getCountrByID(long id);
	
	@Query("delete from TMeetingRoom meetingroom where  meetingroom.id = ?1")
	public void deleteItem(long id);


}
