package com.cnnp.social.homepage.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.homepage.repository.entity.THomePageImg;

@Transactional
public interface HomePageImgDao extends CrudRepository<THomePageImg, Long> ,JpaSpecificationExecutor<THomePageImg>{
	@Query("select hp from THomePageImg hp where hp.styleid = ?1")
	public List<THomePageImg> find(Long styleid);
	@Query("select max(cast(id as float)) from THomePageImg ")
	public long findmaxid();
	@Query("select count(*) from THomePageImg ")
	public long findid();
}
