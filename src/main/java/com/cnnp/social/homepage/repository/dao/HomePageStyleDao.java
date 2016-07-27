package com.cnnp.social.homepage.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.homepage.repository.entity.THomePageStyle;



@Transactional
public interface HomePageStyleDao extends CrudRepository<THomePageStyle, Long> ,JpaSpecificationExecutor<THomePageStyle>{
	@Query("select hp from THomePageStyle hp where hp.id = ?1")
	public THomePageStyle findOne(Long id);
	@Query("select hp from THomePageStyle hp where hp.hpid = ?1")
	public List<THomePageStyle> find(Long hpid);
	@Query("select max(cast(id as float)) from THomePageStyle ")
	public long findmaxid();
}
