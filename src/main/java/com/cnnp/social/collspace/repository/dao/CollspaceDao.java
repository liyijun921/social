package com.cnnp.social.collspace.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.collspace.repository.entity.TCollspace;



@Transactional
public interface CollspaceDao extends CrudRepository<TCollspace, String> {
	@Query("select collspace from TCollspace collspace where collspace.collspaceid = ?1")
	public TCollspace find(long collspaceid);
	@Query("select collspace from TCollspace collspace where collspace.createuserid = ?1")
	public List<TCollspace> findUser(String createuserid);
	@Query("select collspace from TCollspace collspace")
	public List<TCollspace> findOpen();
	@Query("select collspace from TCollspace collspace where collspace.collspaceid in( ?1)")
	public TCollspace findall(long collspaceid);
	@Query("select max(cast(collspaceid as float)) from TCollspace ")
	public long findmaxid();
	@Query("select count(*) from TCollspace ")
	public long findid();
}
