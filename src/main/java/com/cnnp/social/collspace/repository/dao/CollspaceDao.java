package com.cnnp.social.collspace.repository.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.collspace.repository.entity.TCollspace;


@Transactional
public interface CollspaceDao extends CrudRepository<TCollspace, Long> {
	@Query("select collspace from TCollspace collspace where collspace.collspaceid = ?1")
	TCollspace find(Long collspaceid);
	//public List<TSupervision> search()

}
