package com.cnnp.social.supervision.repository.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.supervision.repository.entity.TSupervisionUpdatestatus;
@Transactional
public interface SupervisionUpdateStatusDao extends CrudRepository<TSupervisionUpdatestatus, Long>,JpaSpecificationExecutor<TSupervisionUpdatestatus>{

}
