package com.cnnp.social.homepage.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.homepage.repository.entity.THomePageColumn;




@Transactional
public interface HomePageColumnDao extends CrudRepository<THomePageColumn, Long> ,JpaSpecificationExecutor<THomePageColumn>{
	@Query("select hp from THomePageColumn hp ")
	public List<THomePageColumn> findall();
	@Query("select hp from THomePageColumn hp where hp.id = ?1")
	public THomePageColumn findone(Long id);
	@Query("select max(cast(id as float)) from THomePageColumn ")
	public long findmaxid();
}
