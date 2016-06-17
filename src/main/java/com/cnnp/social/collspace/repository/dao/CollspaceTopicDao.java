package com.cnnp.social.collspace.repository.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.collspace.repository.entity.TCollspaceTopic;


@Transactional
public interface CollspaceTopicDao extends CrudRepository<TCollspaceTopic, Long> {
	@Query("select topic from TCollspaceTopic topic where topic.collspaceid = ?1")
	TCollspaceTopic find(Long collspaceid);
	//public List<TSupervision> search()

}
