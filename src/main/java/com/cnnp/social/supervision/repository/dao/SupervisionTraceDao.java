package com.cnnp.social.supervision.repository.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.supervision.repository.entity.TSupervisionTrace;

@Transactional
public interface SupervisionTraceDao extends CrudRepository<TSupervisionTrace, Long> {
	@Query("select trace from TSupervisionTrace trace where trace.supervisionid = ?1")
	TSupervisionTrace find(long supervisionID);

}
