package com.cnnp.social.homepage.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.homepage.repository.entity.THomePageInfo;



@Transactional
public interface HomePageInfoDao extends CrudRepository<THomePageInfo, Long> ,JpaSpecificationExecutor<THomePageInfo>{
	@Query("select hp from THomePageInfo hp where hp.id = ?1")
	public THomePageInfo findOne(Long id);
	@Query("select max(cast(id as float)) from THomePageInfo ")
	public long findmaxid();
	@Query("select hp from THomePageInfo hp where STATUS = '1' and PARENTID <>'0'")
	public List<THomePageInfo> findparentid();
	@Query("select hp from THomePageInfo hp where STATUS = '1' and PARENTID='0' and rownum =1 ")
	public THomePageInfo findStartHP();
}
