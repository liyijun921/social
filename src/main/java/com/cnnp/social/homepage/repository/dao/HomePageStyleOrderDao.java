package com.cnnp.social.homepage.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.homepage.repository.entity.THomePageStyleOrder;



@Transactional
public interface HomePageStyleOrderDao extends CrudRepository<THomePageStyleOrder, Long> ,JpaSpecificationExecutor<THomePageStyleOrder>{

	@Query("select hp from THomePageStyleOrder hp where hp.styleid = ?1")
	public List<THomePageStyleOrder> find(Long styleid);
	@Query("select hp from THomePageStyleOrder hp where hp.formid = ?1")
	public THomePageStyleOrder findform(Long formid);
	@Query("select max(cast(id as float)) from THomePageStyleOrder ")
	public long findmaxid();
}
