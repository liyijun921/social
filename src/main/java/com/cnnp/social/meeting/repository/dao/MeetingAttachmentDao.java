package com.cnnp.social.meeting.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.meeting.repository.entity.TMeetingAttachment;




@Transactional
public interface MeetingAttachmentDao extends CrudRepository<TMeetingAttachment, Long> ,JpaSpecificationExecutor<TMeetingAttachment>{
	
	@Query("select attachment from TMeetingAttachment attachment where attachment.meetingid = ?1")
	public List<TMeetingAttachment> findByMeetingID(Long id);
}
