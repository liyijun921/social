package com.cnnp.social.collspace.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.collspace.repository.entity.TCollspaceUser;

@Transactional
public interface CollspaceUserDao extends CrudRepository<TCollspaceUser, String> {
	//public List<TSupervision> search()
	@Query("from TCollspaceUser Collspace where Collspace.userid = ?1")
	public List<TCollspaceUser> find(String userid);
}
