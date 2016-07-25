package com.cnnp.social.homepage.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.homepage.repository.entity.THomePageAdmin;
import com.cnnp.social.homepage.repository.entity.THomePageInfo;



@Transactional
public interface HomePageAdminDao extends CrudRepository<THomePageAdmin, Long> ,JpaSpecificationExecutor<THomePageAdmin>{
	@Query("select hp from THomePageAdmin hp where hp.hpid = ?1 and hp.admintype = ?2")
	public List<THomePageAdmin> findadmin(Long hpid,String type);
	@Query("select hp from THomePageAdmin hp where hp.hpid = ?1 and columnid = ?2 and hp.admintype = ?3")
	public List<THomePageAdmin> findadmin(Long hpid,long columnid,String type);
	@Query("select hp from THomePageAdmin hp where hp.userid = ?1")
	public List<THomePageAdmin> find(String userid);
	@Query("delete from THomePageAdmin hp where hp.hpid = ?1 and hp.admintype = ?2")
	public List<THomePageAdmin> deladmin(Long hpid,String type);
	@Query("delete from THomePageAdmin hp where hp.hpid = ?1 and columnid = ?2 and hp.admintype = ?3")
	public List<THomePageAdmin> deladmin(Long hpid,long columnid,String type);
	@Query("select max(cast(id as float)) from THomePageAdmin ")
	public long findmaxid();
}
