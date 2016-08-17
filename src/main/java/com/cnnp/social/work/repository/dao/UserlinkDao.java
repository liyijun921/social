package com.cnnp.social.work.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.homepage.repository.entity.THomePageAdmin;
import com.cnnp.social.work.repository.entity.TUserLink;



@Transactional
public interface UserlinkDao extends CrudRepository<TUserLink, Long> ,JpaSpecificationExecutor<TUserLink>{
	@Query("select user from TUserLink user where user.id = ?1")
	public TUserLink findOne(Long id);
	@Query("select user from TUserLink user where user.userid = ?1")
	public List<TUserLink> find(String userid);
	@Query("select max(cast(id as float)) from TUserLink ")
	public long findmaxid();
	@Query("select count(*) from TUserLink ")
	public long findid();
	@Query("delete from TUserLink where userid = ?1")
	public void deluser(String userid);
}
