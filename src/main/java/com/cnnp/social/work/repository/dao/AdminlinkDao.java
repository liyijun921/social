package com.cnnp.social.work.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.work.repository.entity.TAdminLink;



@Transactional
public interface AdminlinkDao extends CrudRepository<TAdminLink, Long> ,JpaSpecificationExecutor<TAdminLink>{
	@Query("select admin from TAdminLink admin where admin.id = ?1")
	public TAdminLink findOne(Long id);
	@Query("select admin from TAdminLink admin")
	public List<TAdminLink> find();
}
