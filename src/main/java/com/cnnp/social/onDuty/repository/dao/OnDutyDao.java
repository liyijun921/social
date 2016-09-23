package com.cnnp.social.onDuty.repository.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.onDuty.repository.entity.TDuty;




@Transactional
public interface OnDutyDao extends CrudRepository<TDuty, Long> ,JpaSpecificationExecutor<TDuty>{
	
	@Query("select max(cast(id as float)) from TDuty ")
	public long findmaxid();
	
	@Query("select count(*) from TDuty ")
	public long countDuty();
	
	@Query("select count(*) from TDuty duty where duty.id = ?1")
	public long countDuty(Long id);
	
	@Query("select duty from TDuty duty where duty.id = ?1")
	public TDuty findByDutyId(Long id);
	
//	@Query("select duty from TDuty duty where  duty.id = ?1  and (duty.startdate BETWEEN to_date(?2, 'YYYY-MM-DD HH24:MI:SS') AND to_date(?3, 'YYYY-MM-DD HH24:MI:SS') OR duty.enddate BETWEEN to_date(?2, 'YYYY-MM-DD HH24:MI:SS') AND to_date(?3, 'YYYY-MM-DD HH24:MI:SS') OR to_date(?2, 'YYYY-MM-DD HH24:MI:SS') Between duty.startdate AND duty.enddate OR to_date(?3, 'YYYY-MM-DD HH24:MI:SS') BETWEEN duty.startdate AND duty.enddate) ")
//	public List<TDuty> finduser(long dutyId,String startdate,String enddate);
	
}
