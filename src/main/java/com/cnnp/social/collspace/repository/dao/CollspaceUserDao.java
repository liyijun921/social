package com.cnnp.social.collspace.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.collspace.repository.entity.TCollspaceUser;

@Transactional
public interface CollspaceUserDao extends CrudRepository<TCollspaceUser, String> {
	//public List<TCollspaceUser> search()
	@Query("from TCollspaceUser Collspace where Collspace.userid = ?1")
	public List<TCollspaceUser> find(String userid);
	
	@Query("from TCollspaceUser Collspace where Collspace.userid = ?1 and type = ?2")
	public List<TCollspaceUser> find(String userid,String type);
	
	@Query("from TCollspaceUser Collspace where Collspace.collspaceid = ?1 and type = ?2")
	public List<TCollspaceUser> findmember(long collspaceid,String type);
	
	@Query("select user from TCollspaceUser user where user.userid = ?1 and user.collspaceid = ?2")
	public TCollspaceUser findmemberup(String userid,long collspaceid);
	
	@Query("from TCollspaceUser Collspace where Collspace.collspaceid = ?1")
	public List<TCollspaceUser> findmember(long collspaceid);
	@Query("from TCollspaceUser Collspace where Collspace.id = ?1")
	public TCollspaceUser findid(long id);
	@Query("select max(cast(id as float)) from TCollspaceUser ")
	public long findmaxid();
	@Query("select count(*) from TCollspaceUser ")
	public long findid();
}
