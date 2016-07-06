package com.cnnp.social.schedule.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.schedule.repository.entity.TSchedulePeople;

@Transactional
public interface SchedulePeopleDao extends CrudRepository<TSchedulePeople, Long>{
	@Query("select People from TSchedulePeople People where People.scheduleid = ?1")
	public List<TSchedulePeople> find(Long scheduleId);	
	
	@Query("select People from TSchedulePeople People where People.userid = ?1")
	public List<TSchedulePeople> finduserid(String userid);
	
	@Query("select People from TSchedulePeople People where People.scheduleid = ?1 and People.userid = ?2")
	public TSchedulePeople finduseridone(Long scheduleId,String userid);
	
	@Query("select People from TSchedulePeople People where People.companyid = ?1 and People.peopletype = ?2")
	public List<TSchedulePeople> findcompany(String companyid,String peopletype);
	
	@Query("delete from TSchedulePeople People where People.scheduleid = ?1")
	public List<TSchedulePeople> deleteid(Long scheduleId);
}
