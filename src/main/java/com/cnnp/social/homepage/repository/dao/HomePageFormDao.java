package com.cnnp.social.homepage.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


import com.cnnp.social.homepage.repository.entity.THomePageForm;




@Transactional
public interface HomePageFormDao extends CrudRepository<THomePageForm, Long> ,JpaSpecificationExecutor<THomePageForm>{
	@Query("select hp from THomePageForm hp where hp.id = ?1")
	public THomePageForm findOne(Long id);
	@Query("select hp from THomePageForm hp where hp.hpid = ?1")
	public List<THomePageForm> find(Long hpid);
	@Query("select max(cast(id as float)) from THomePageForm ")
	public long findmaxid();
	@Query("select count(*) from THomePageForm ")
	public long findid();
}
