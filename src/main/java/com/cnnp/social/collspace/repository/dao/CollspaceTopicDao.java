package com.cnnp.social.collspace.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.collspace.repository.entity.TCollspaceTopic;


@Transactional
public interface CollspaceTopicDao extends CrudRepository<TCollspaceTopic, Long> {
	@Query("select topic from TCollspaceTopic topic where topic.collspaceid = ?1")
	public List<TCollspaceTopic> find(Long collspaceid);
	@Query("select topic from TCollspaceTopic topic where topic.topicid = ?1")
	public List<TCollspaceTopic> findone(Long topicid);
	@Query("select max(cast(topicid as float)) from TCollspaceTopic ")
	public long findmaxid();
	@Query("select count(*) from TCollspaceTopic ")
	public long findid();
}
