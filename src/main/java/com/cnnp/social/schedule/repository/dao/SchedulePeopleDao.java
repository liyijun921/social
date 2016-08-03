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
	@Query("select People from TSchedulePeople People where People.userid = ?1  and People.startdate> TO_DATE(?2, 'YYYY-MM-DD HH24:MI:SS') and People.startdate <  TO_DATE(?3, 'YYYY-MM-DD HH24:MI:SS')")
	public List<TSchedulePeople> finduserid(String userid,String startdate,String enddate );
	@Query("select People from TSchedulePeople People where People.userid = ?1  and People.startdate> TO_DATE(?2, 'YYYY-MM-DD HH24:MI:SS') and People.startdate <  TO_DATE(?3, 'YYYY-MM-DD HH24:MI:SS')")
	public TSchedulePeople finduserid1(String userid,String startdate,String enddate );
	@Query("select People from TSchedulePeople People where People.scheduleid = ?1 and People.userid = ?2")
	public TSchedulePeople finduseridone(Long scheduleId,String userid);
	
	@Query("select People from TSchedulePeople People where People.companyid = ?1 and People.peopletype = ?2")
	public List<TSchedulePeople> findcompany(String companyid,String peopletype);
	@Query("select People from TSchedulePeople People where People.companyid = ?1 and People.peopletype = ?2  and People.startdate> TO_DATE(?3, 'YYYY-MM-DD HH24:MI:SS') and People.startdate <  TO_DATE(?4, 'YYYY-MM-DD HH24:MI:SS')")
	public List<TSchedulePeople> findcompanydate(String companyid,String peopletype,String startdate,String enddate);
	@Query("select People from TSchedulePeople People where People.companyid = ?1  and People.startdate> TO_DATE(?2, 'YYYY-MM-DD HH24:MI:SS') and People.startdate <  TO_DATE(?3, 'YYYY-MM-DD HH24:MI:SS')")
	public List<TSchedulePeople> findcompany(String companyid,String startdate,String enddate);
	@Query("select People from TSchedulePeople People where People.companyid = ?1 and People.peopletype = ?2  and People.id in (select max(People.id) from TSchedulePeople People group by People.userid)")
	public List<TSchedulePeople> findcompanyuser(String companyid,String peopletype);

	@Query("select People from TSchedulePeople People where People.companyid = ?1")
	public List<TSchedulePeople> findcompany(String companyid);
	@Query("select People from TSchedulePeople People where People.companyid = ?1  and People.id in (select max(People.id) from TSchedulePeople People group by People.userid)")
	public List<TSchedulePeople> findcompanyuser(String companyid);
	@Query("select People from TSchedulePeople People where People.collsaceid = ?1  and People.id in (select max(People.id) from TSchedulePeople People group by People.userid)")
	public List<TSchedulePeople> findcolluser(String collid);
	@Query("delete from TSchedulePeople People where People.scheduleid = ?1")
	public List<TSchedulePeople> deleteid(Long scheduleId);
	
	@Query("select People from TSchedulePeople People where  People.userid = ?3  and (People.startdate BETWEEN to_date(?1, 'YYYY-MM-DD HH24:MI:SS') AND to_date(?2, 'YYYY-MM-DD HH24:MI:SS') OR People.enddate BETWEEN to_date(?1, 'YYYY-MM-DD HH24:MI:SS') AND to_date(?2, 'YYYY-MM-DD HH24:MI:SS') OR to_date(?1, 'YYYY-MM-DD HH24:MI:SS') Between People.startdate AND People.enddate OR to_date(?2, 'YYYY-MM-DD HH24:MI:SS') BETWEEN People.startdate AND People.enddate) ")
	public List<TSchedulePeople> finduser(String startdate,String enddate,String userid);
}
