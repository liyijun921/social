package com.cnnp.social.collspace.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.collspace.repository.entity.TCollspaceRemark;


@Transactional
public interface CollspaceRamarkDao extends CrudRepository<TCollspaceRemark, Long> {
	@Query("select remark from TCollspaceRemark remark where remark.id = ?1")
	TCollspaceRemark find(Long id);

	@Query("select remark from TCollspaceRemark remark where remark.topicid = ?1")
	public List<TCollspaceRemark> findtopic(Long topicid);
	@Query("select count(*) from TCollspaceRemark remark where remark.topicid = ?1")
	public long findcount(Long topicid);
	@Query("select remark from TCollspaceRemark remark where remark.collspaceid = ?1")
	public List<TCollspaceRemark> findcollspace(Long topicid);
}
