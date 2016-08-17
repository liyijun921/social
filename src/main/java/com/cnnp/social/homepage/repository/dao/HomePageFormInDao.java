package com.cnnp.social.homepage.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.homepage.repository.entity.THomePageFormIn;




@Transactional
public interface HomePageFormInDao extends CrudRepository<THomePageFormIn, Long> ,JpaSpecificationExecutor<THomePageFormIn>{
	@Query("select hp from THomePageFormIn hp where hp.id = ?1")
	public THomePageFormIn findOne(Long id);
	@Query("select hp from THomePageFormIn hp where hp.formid = ?1")
	public List<THomePageFormIn> find(Long formid);
	@Query("select max(cast(id as float)) from THomePageFormIn ")
	public long findmaxid();
	@Query("select count(*) from THomePageFormIn ")
	public long findid();
}
