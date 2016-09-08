package com.cnnp.social.meeting.repository.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.meeting.repository.entity.TMeeting;




@Transactional
public interface MeetingDao extends CrudRepository<TMeeting, Long> ,JpaSpecificationExecutor<TMeeting>{
	
	@Query("select max(cast(id as float)) from TMeeting ")
	public long findmaxid();
	
	@Query("select count(*) from TMeeting ")
	public long countMeeting();
	
	@Query("select meeting from TMeeting meeting where meeting.userid = ?1 ")
	public List<TMeeting> listMeeting(Long userid);
	
	@Query("select meeting from TMeeting meeting where meeting.userid = ?1 AND ((meeting.startdate BETWEEN ?2 AND ?3 ) OR (meeting.enddate BETWEEN ?2 AND ?3 ) OR (?2 Between meeting.startdate AND meeting.enddate) OR (?3 BETWEEN meeting.startdate AND meeting.enddate)) ")
	public List<TMeeting> listMeetingByDate(Long userid,Date startdate,Date enddate);
	
}
