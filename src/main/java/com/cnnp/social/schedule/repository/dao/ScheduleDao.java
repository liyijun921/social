package com.cnnp.social.schedule.repository.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.schedule.repository.entity.TSchedule;


@Transactional
public interface ScheduleDao extends CrudRepository<TSchedule, Long> ,JpaSpecificationExecutor<TSchedule>{
	@Query("select schedule from TSchedule schedule where schedule.id = ?1")
	public TSchedule findOne(Long id);
	//public List<TSupervision> search()
	@Query("select schedule from TSchedule schedule where schedule.userid = ?1")
	public List<TSchedule> findall(String userid);
	@Query("select schedule from TSchedule schedule where schedule.collsaceid = ?1 and schedule.startdate> TO_DATE(?2, 'YYYY-MM-DD HH24:MI:SS') and schedule.startdate <  TO_DATE(?3, 'YYYY-MM-DD HH24:MI:SS') ")
	public List<TSchedule> findcolldate(String collsaceid,String startdate,String enddate);
	@Query("select schedule from TSchedule schedule where schedule.id = ?1 and schedule.startdate> TO_DATE(?2, 'YYYY-MM-DD HH24:MI:SS') and schedule.startdate <  TO_DATE(?3, 'YYYY-MM-DD HH24:MI:SS') ")
	public TSchedule finddate(Long id,String startdate,String enddate);
	@Query("select schedule from TSchedule schedule where (schedule.startdate BETWEEN  to_date(?1, 'YYYY-MM-DD HH24:MI:SS') AND to_date(?2, 'YYYY-MM-DD HH24:MI:SS') OR schedule.enddate BETWEEN  to_date(?1, 'YYYY-MM-DD HH24:MI:SS') AND to_date(?2, 'YYYY-MM-DD HH24:MI:SS') OR to_date(?1, 'YYYY-MM-DD HH24:MI:SS') Between schedule.startdate AND schedule.enddate OR to_date(?2, 'YYYY-MM-DD HH24:MI:SS') BETWEEN schedule.startdate AND schedule.enddate) ")
	public List<TSchedule> finddate(String startdate,String enddate);
	@Query("select max(cast(id as float)) from TSchedule ")
	public long findmaxid();
	@Query("select count(*) from TSchedule ")
	public long findid();
	@Query("select schedule from TSchedule schedule where schedule.id in (?1) and schedule.startdate> TO_DATE(?2, 'YYYY-MM-DD HH24:MI:SS') and schedule.startdate <  TO_DATE(?3, 'YYYY-MM-DD HH24:MI:SS') ")
	public  List<TSchedule> finddatetest(String idlist,String startdate,String enddate);
}
