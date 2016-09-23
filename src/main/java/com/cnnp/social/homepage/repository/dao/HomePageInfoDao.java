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
	@Query("select hp from THomePageInfo hp where STATUS = '1' and hptype <>'0' and priority = ?1 order by updatetime desc ")
	public List<THomePageInfo> findparentid(Long priority);
	@Query("select hp from THomePageInfo hp where STATUS = '1' and hptype='0' and rownum =1 ")
	public THomePageInfo findStartHP();
	
	@Query("UPDATE THomePageInfo set STATUS='0' where STATUS ='1' and hptype='0'")
	public THomePageInfo updataStatus();
	@Query("select count(*) from THomePageInfo ")
	public long findid();
	
	@Query("select priority from THomePageInfo hp group by priority order by priority desc ")
	public List<Long> findpriority();
	
	@Query("select hp from THomePageInfo hp where STATUS = '1' and hptype ='0' and priority = ?1 order by updatetime desc ")
	public List<THomePageInfo> findcompany(Long priority);
}
